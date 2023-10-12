package it.mds.sdk.connettoremds.conf;

import it.mds.sdk.connettoremds.crittografia.Crittografia;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrittoConf {

    @SneakyThrows
    @Bean
    public Crittografia crittografia() {
        return Crittografia.getInstanceInterconnessioneDefault();
    }
}
