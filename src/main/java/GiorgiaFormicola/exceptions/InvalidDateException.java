package GiorgiaFormicola.exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
        super("Impossible to create user, the entered date is not valid.");
    }
}
