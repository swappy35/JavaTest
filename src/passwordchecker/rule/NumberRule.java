package passwordchecker.rule;

import passwordchecker.exception.PasswordLowercaseException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation rule to check at least one number
 */
public class NumberRule implements ValidationRule {

    /**
     * Validation rule to check at least one number
     *
     * @param password to validate
     * @throws PasswordValidationException if no number in the password
     */
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password == null || !password.chars().anyMatch(Character::isDigit)) {
            throw new PasswordLowercaseException();
        }
    }
}
