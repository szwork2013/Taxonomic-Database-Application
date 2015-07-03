package com.unep.wcmc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain that represents an error response operation
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class ErrorResponse {

    @JsonProperty
    private final String message;

    public ErrorResponse(String message) {
        this.message = message;
    }    
}
