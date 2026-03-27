package GiorgiaFormicola.exceptions;

public class InvalidISBNCodeException extends RuntimeException {
    public InvalidISBNCodeException(String codeISBN) {
        super("Code ISBN " + codeISBN + " not valid. The code must be composed of 13 numbers.");
    }
}
