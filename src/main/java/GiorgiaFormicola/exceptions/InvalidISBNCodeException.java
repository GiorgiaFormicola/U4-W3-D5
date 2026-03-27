package GiorgiaFormicola.exceptions;

public class InvalidISBNCodeException extends RuntimeException {
    public InvalidISBNCodeException(String codeISBN) {
        super("Code " + codeISBN + " not valid. The code must contain 13 numbers.");
    }
}
