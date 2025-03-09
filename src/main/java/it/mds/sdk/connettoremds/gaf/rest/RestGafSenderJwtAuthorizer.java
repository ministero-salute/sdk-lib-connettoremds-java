package it.mds.sdk.connettoremds.gaf.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@ConditionalOnProperty(name = "connettoreMds.rest.authorizer.type", havingValue = "JWT")
public class RestGafSenderJwtAuthorizer implements Authorizer<HttpHeaders> {

    static final String TOKEN_HEADER_FORMAT = "%s %s";

    private static final long THRESHOLD = 10000;

    @Value("${connettoreMds.rest.authorizer.token-issuer.url}")
    private String tokenIssuerUrl;
    @Value("${connettoreMds.rest.authorizer.token-issuer.grant_type}")
    private String grantType;
    @Value("${connettoreMds.rest.authorizer.token-issuer.username}")
    private String username;
    @Value("${connettoreMds.rest.authorizer.token-issuer.password}")
    private String password;
    @Value("${connettoreMds.rest.authorizer.token-issuer.client_id}")
    private String clientId;
    @Value("${connettoreMds.rest.authorizer.token-issuer.client_secret}")
    private String clientSecret;
    @Value("${connettoreMds.rest.authorizer.token-issuer.scope}")
    private String scope;

    private RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());


    @Override
    public void authorize(HttpHeaders entity) {

        TokenResponse token = getToken();
        entity.set(HttpHeaders.AUTHORIZATION, String.format(TOKEN_HEADER_FORMAT, StringUtils.capitalize(token.getTokenType()), token.getAccessToken()));
        entity.set("mds-client-id", UUID.randomUUID().toString());
    }


    private TokenResponse getToken() {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        addParam("grant_type", grantType, form);
        addParam("username", username, form);
        addParam("password", password, form);
        addParam("client_id", clientId, form);
        addParam("client_secret", clientSecret, form);
        addParam("scope", scope, form);

        return getToken(form);
    }

    private void addParam(String paramName, String paramValue, MultiValueMap<String, Object> form) {
        Optional.ofNullable(paramValue).filter(StringUtils::isNotBlank).ifPresent(v -> form.add(paramName, v));
    }

    private TokenResponse getToken(MultiValueMap<String, Object> form) {
        Objects.requireNonNull(form);
        TokenResponse token = newToken(form);
        return token;
    }


    /**
     * Calculates if token is expired
     *
     * @param token
     * @return
     */
    private boolean expired(TokenResponse token) {
        return token == null || (token.getExpiresAt() - System.currentTimeMillis() <= 0);
    }


    public TokenResponse newToken(MultiValueMap<String, Object> form) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, httpHeaders);

        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(tokenIssuerUrl, requestEntity, TokenResponse.class);

        TokenResponse token = Optional.ofNullable(response).map(HttpEntity::getBody).orElseThrow();

        return token;
    }


}
