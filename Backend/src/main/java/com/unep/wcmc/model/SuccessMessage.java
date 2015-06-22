package com.unep.wcmc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain that represents a success response operation
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class SuccessMessage {

    @JsonProperty
    private final String success;

    public SuccessMessage() {
        success = "Success";
    }    
}
