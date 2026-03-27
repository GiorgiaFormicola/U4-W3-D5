package GiorgiaFormicola.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id, String elementType) {
        super(elementType + " with id " + id + " not found in the database");
    }
}
