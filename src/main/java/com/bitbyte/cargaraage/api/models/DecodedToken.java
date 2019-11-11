package com.bitbyte.cargaraage.api.models;

public class DecodedToken {
    private final String header;
    private final String payload;
    private boolean validExpiration;
    private boolean validIssuer;
    private boolean authorized;

    public DecodedToken(String header, String payload) {
        this.header = header;
        this.payload = payload;
    }

    public String getHeader() {
        return header;
    }

    public String getPayload() {
        return payload;
    }

    public boolean isValidExpiration() {
        return validExpiration;
    }

    public void setValidExpiration(boolean validExpiration) {
        this.validExpiration = validExpiration;
    }

    public boolean isValidIssuer() {
        return validIssuer;
    }

    public void setValidIssuer(boolean validIssuer) {
        this.validIssuer = validIssuer;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
