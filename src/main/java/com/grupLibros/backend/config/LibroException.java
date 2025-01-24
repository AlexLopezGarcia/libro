package com.grupLibros.backend.config;

public class LibroException extends Exception {

    public LibroException(String message) {
        super(message);
    }

    public LibroException(String message, Throwable cause) {
        super(message, cause);
    }

    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

}
