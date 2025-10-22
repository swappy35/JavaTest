package passwordchecker.rule;

import passwordchecker.exception.PasswordLengthException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation to check minimum password length
 */
public class MinimumLengthRule implements ValidationRule {
    private final int minLength;

    /**
     * Constructor a Minimum Length rule
     *
     * @param minLength the minimum required length
     */
    public MinimumLengthRule(int minLength) {
        this.minLength = minLength;
    }

    /**
     * Validates that password meets minimum length requirement
     *
     * @param password to validate
     * @throws PasswordValidationException if password is too short
     */
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password == null || password.length() <= minLength) {
            throw new PasswordLengthException(minLength);
        }
    }
}
