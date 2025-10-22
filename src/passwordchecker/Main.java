package passwordchecker;

import passwordchecker.model.ValidationResult;
import passwordchecker.service.PasswordValidator;
import passwordchecker.service.PasswordValidatorImpl;

import java.util.Arrays;
import java.util.List;

/**
 * Main class to show functionality of the program
 *
 */
public class Main {

    /**
     * Application starts
     *
     */
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidatorImpl();

        List<String> testPass = Arrays.asList(
                null, "pal", "Swapnil123", "SWAPNIL123", "SwapnilPal", "Swapnil123Pal", "pal12", "Swapn12"
        );

        //Test strict
        System.out.println("Test strict");
        for (String pass : testPass){
            testStrictValidation(validator, pass);
        }

        //Test easy
        System.out.println("Test easy");
        for (String pass : testPass){
            testEasyValidation(validator, pass);
        }

        //Test performance
        System.out.println("Test performance");
        testPerformance(validator);

    }

    /**
     * Function to pass all the rules
     *
     * @param validator to validate password
     * @param password to test the password
     */
    private static void testStrictValidation(PasswordValidator validator, String password) {
        String showPassword = password == null ? "null" : "  " + password + "  ";
        ValidationResult result = validator.validate(password);

        System.out.println("Password: " + showPassword);
        System.out.println("Valid: " + result.isValid());
        if (!result.isValid()) {
            System.out.println("Error: ");
            result.getErrors().forEach(error -> System.out.println(" --> " + error));
        }
    }

    /**
     * Function to validate with (3 of 5) rules
     *
     * @param validator to validate password
     * @param password to test the password
     */
    private static void testEasyValidation(PasswordValidator validator, String password) {
        String showPassword = password == null ? "null" : " { " + password + " } ";
        boolean isOk = validator.isPasswordOk(password);
        System.out.println("Password: " + showPassword + " --> " + (isOk ? " OK " : " Not OK "));
    }

    /**
     * Function to check performance optimization
     *
     * @param validator to validate password
     */
    private static void testPerformance(PasswordValidator validator) {
        List<String> testData = Arrays.asList(
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal",
                "Swap123", "Swapni1234", "1234567sW", "Test12",
                "Swap123", "qwertyt123", "Pal12345", "987Sa",
                "ercvfvnmc", "Swapni1234", "aswqp23f", "Test12",
                "Swap123", "Swapni1234", "PAL12345", "TestPal"
        );

        // Series process
        long startSeries = System.nanoTime();
        for (String abc : testData) {
            validator.validate(abc);
        }
        long endSeries = System.nanoTime();

        // Parallel process
        long startParallel = System.nanoTime();
        testData.forEach(validator::isPasswordOk);
        long endParallel = System.nanoTime();

        System.out.println("Series  process  time: " + (endSeries - startSeries));
        System.out.println("Parallel process time: " + (endParallel - startParallel));

    }
}
