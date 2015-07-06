package com.unep.wcmc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain that represents a success response operation
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class SuccessResponse {

    @JsonProperty
    private final String success;

    public SuccessResponse() {
        this("success");
    }    
    
    public SuccessResponse(String success) {
    	this.success = success;
    }
}
