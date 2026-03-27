package GiorgiaFormicola.exceptions;

public class UserAlreadyInDBException extends RuntimeException {
    public UserAlreadyInDBException(long cardNumber) {
        super("User with card number " + cardNumber + " already saved in the database.");
    }
}
