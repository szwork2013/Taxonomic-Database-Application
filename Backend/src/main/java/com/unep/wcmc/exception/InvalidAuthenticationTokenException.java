package com.unep.wcmc.exception;

/**
 * Throws whenever user has tried to get into the
 * system using invalid token
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class InvalidAuthenticationTokenException extends RuntimeException {

    private static final long serialVersionUID = 7491302398331504642L;
    
    public InvalidAuthenticationTokenException(String message) {
        super(message);
    }
}
