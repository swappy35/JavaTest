package passwordchecker.service;

import passwordchecker.model.ValidationResult;

/**
 * Interface for password validation service
 */
public interface PasswordValidator {
    /**
     * Validates a password against rules
     *
     * @param password to validate
     * @return validation result
     */
    ValidationResult validate(String password);

    /**
     * validation returns true/false
     * Password is OK if at least 3 of 5 conditions pass
     * but lowercase condition must be true always
     *
     * @param password to validate
     * @return true if password accepted, false otherwise
     */
    boolean isPasswordOk(String password);
}
