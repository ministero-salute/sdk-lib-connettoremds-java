package it.mds.sdk.connettoremds.gaf.rest;

public interface Authorizer<T> {

    void authorize(T entity);
}
