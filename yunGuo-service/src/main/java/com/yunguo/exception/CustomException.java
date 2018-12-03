package com.yunguo.exception;


/**
 * For HTTP 404 errros
 */
public class CustomException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3922223864716886856L;

	public CustomException() {
        super();
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}
