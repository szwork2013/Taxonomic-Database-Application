package com.unep.wcmc.exception;

/**
 * Throws when tries to create a new user within
 * another user's sensitive data as email or 
 * username
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class UserAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5571283526796601573L;
    
    public UserAlreadyExistException(String message) {
        super(message);
    } 
}
