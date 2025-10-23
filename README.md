# Password Validation Program

A Java-based password validation system with comprehensive rule checking and exception handling.

## Requirements

- Java 8 or higher
- No external dependencies

## Compilation

Create the bin directory for compiled classes:

```bash
mkdir bin
```

Compile all source files in order:

```bash
javac -d bin exception/*.java model/*.java rule/*.java service/*.java Main.java
```

Compile test files:

```bash
javac -cp bin -d bin PasswordValidatorTest.java
```

## Running the Application

Run the main application:

```bash
java -cp bin Main
```

Run the unit tests:

```bash
java -cp bin PasswordValidatorTest
```

## Validation Rules

The system implements 5 validation rules:

1. **Not Null** (Mandatory) - Password cannot be null
2. **Minimum Length** - Password must be longer than 8 characters
3. **Uppercase Letter** - Must contain at least one uppercase letter (A-Z)
4. **Lowercase Letter** - Must contain at least one lowercase letter (a-z)
5. **Number** - Must contain at least one digit (0-9)

### Validation Modes

**Strict Mode** - All 5 rules must pass. Returns a ValidationResult object with detailed error messages if validation fails.

**Easy Mode** - At least 3 of 5 rules must pass, but the not-null rule is mandatory. Returns a boolean value indicating if the password is acceptable.

## Usage

The PasswordValidator interface provides two methods:

**validate(String password)** - Performs strict validation and returns a ValidationResult containing validation status and any error messages.

**isPasswordOk(String password)** - Performs relaxed validation and returns true if the password meets minimum requirements (not null and at least 3 of 5 rules pass).

### Basic Usage Pattern

Create an instance of PasswordValidatorImpl and call the appropriate validation method. For strict validation, check if the result is valid and handle errors accordingly. For relaxed validation, simply check the boolean return value.

## Features

- Clean code architecture with separation of concerns
- Custom exception hierarchy for detailed error messages
- Strategy pattern for flexible rule implementation
- Parallel processing for performance optimization
- Comprehensive JavaDoc documentation
- Unit tests included