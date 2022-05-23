package com.example.ovs.microservice.exception;

public class MicroServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor with args.
     *
     * @param message The message
     * @param cause   The cause
     */
    public MicroServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with args. Personalize exception.
     *
     * @param message A message for exception
     */
    public MicroServiceException(String message) {
        super(message);
    }

    /**
     * Constructor with args.
     *
     * @param cause The cause
     */
    public MicroServiceException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     */
    public MicroServiceException() {
        super();
    }
}
