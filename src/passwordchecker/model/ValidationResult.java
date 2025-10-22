package passwordchecker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains validation status and error message
 */
public final class ValidationResult {

    private final boolean valid;
    private final List<String> errors;

    /**
     * to craete validation result instance
     *
     * @param valid validation passed or fail
     * @param errors error messages
     */
    private ValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = new ArrayList<>(errors);
    }

    /**
     * Successful result
     *
     * @return success
     */
    public static ValidationResult success() {
        return new ValidationResult(true, Collections.emptyList());
    }

    /**
     * Failure result
     *
     * @param errors List of error messages
     * @return failure
     */
    public static ValidationResult failure(List<String> errors) {
        return new ValidationResult(false, errors);
    }

    /**
     * Check the validation, if successful
     *
     * @return true if valid, false otherwise
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * List of error message
     *
     * @return list of error messages
     */
    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    @Override
    public String toString() {
        if (valid) {
            return "ValidResult";
        }
        return "ValidResult{valid=false, error=" + errors + "}";
    }
}
