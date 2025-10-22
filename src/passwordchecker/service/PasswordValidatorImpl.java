package passwordchecker.service;

import passwordchecker.exception.PasswordValidationException;
import passwordchecker.model.ValidationResult;
import passwordchecker.rule.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of PasswordValidator
 * Feature:
 *  All the rules must pass
 *  if 3 of the 5 rules pass but null should always pass
 *  optimising the performance using parallel processing
 *
 */
public class PasswordValidatorImpl implements PasswordValidator {

    private final List<ValidationRule> allRules;
    private final ValidationRule notNullRule;
    private final List<ValidationRule> optionalRules;
    private static final int MIN_LENGTH = 8;
    private static final int MIN_LENGTH_REQUIRES = 3;

    public PasswordValidatorImpl() {
        this.notNullRule = new NotNullRule();
        this.optionalRules = Arrays.asList(
                new MinimumLengthRule(MIN_LENGTH),
                new UppercaseRule(),
                new LowercaseRule(),
                new NumberRule()
        );
        this.allRules = new ArrayList<>();
        this.allRules.add(notNullRule);
        this.allRules.addAll(optionalRules);

    }

    /**
     * Validate password with all rules
     *
     * @param password to validate
     * @return validation result or any error
     */
    @Override
    public ValidationResult validate(String password) {
        List<String> errors =new ArrayList<>();
        for (ValidationRule rule : allRules) {
            try {
                rule.validate(password);
            } catch (PasswordValidationException e) {
                errors.add(e.getMessage());
            }
        }
        return errors.isEmpty() ? ValidationResult.success() : ValidationResult.failure(errors);

    }

    /**
     * Checks if password is accepted
     * Password OK if:
     *  not null
     *  3 of 5 condition pass
     * Optimised will parallel processing to improve performance
     *
     * @param password to validate
     * @return true if password, false otherwise
     */
    @Override
    public boolean isPasswordOk(String password) {
        try {
            notNullRule.validate(password);
        } catch (PasswordValidationException e) {
            return false;
        }
        long passedRules = optionalRules.parallelStream().filter(rule -> {
            try {
                rule.validate(password);
                return true;
            } catch (PasswordValidationException e) {
                return false;
            }
        }).count();
        return passedRules >= (MIN_LENGTH_REQUIRES - 1);
    }
}
