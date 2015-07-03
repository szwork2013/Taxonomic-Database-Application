package com.unep.wcmc.exception;

/**
 * Throws whenever use tries to do an invalid operation over
 * passwords
 * 
 * @author Adriano Braga Alencar (adriano.alencar@integritas.com)
 *                               (adrianobragaalencar@gmail.com)
 *
 */
public final class InvalidPasswordException extends RuntimeException {
    
    private static final long serialVersionUID = 4502872009512055008L;

    public InvalidPasswordException(String message) {
        super(message);
    }
}
