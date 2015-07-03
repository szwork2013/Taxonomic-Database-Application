package com.unep.wcmc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unep.wcmc.model.User;

/**
 * Domain that represents the login response within
 * generated token
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class TokenResponse {

    @JsonProperty
    private final String token;
    @JsonProperty
    private final User user;
    
    public TokenResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
