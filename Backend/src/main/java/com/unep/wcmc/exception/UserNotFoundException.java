package com.unep.wcmc.exception;

/**
 * Throws when tries to get a non exist user
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3232081941194765193L;
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
