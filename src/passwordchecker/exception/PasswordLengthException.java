package passwordchecker.exception;

/**
 * Exception for password length less than required
 */
public class PasswordLengthException extends PasswordValidationException {

    /**
     * Custructor for password less than minimum length
     *
     * @param minLength minimum length of the password
     */
    public PasswordLengthException(int minLength) {
        super("Pass must be at least " + minLength +" characters long");
    }
}
