package passwordchecker.exception;

/**
 * All password validation failure
 */
public abstract class PasswordValidationException extends Exception{

    /**
     * Custructor for specific message
     */
    public PasswordValidationException(String message) {
        super(message);
    }

}
