package GiorgiaFormicola.exceptions;

public class InvalidCardNumberException extends RuntimeException {
    public InvalidCardNumberException() {
        super("Card invalid. The code must be composed of numbers.");
    }
}
