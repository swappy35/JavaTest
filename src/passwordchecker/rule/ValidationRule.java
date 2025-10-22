package passwordchecker.rule;

import passwordchecker.exception.PasswordValidationException;

/**
 * Functional interface for password validation rule
 */
@FunctionalInterface
public interface ValidationRule {

    /**
     * Checks the password with the rule
     *
     * @param password input password to validate
     * @throws PasswordValidationException if validation fails
     */
    void validate(String password) throws PasswordValidationException;
}
