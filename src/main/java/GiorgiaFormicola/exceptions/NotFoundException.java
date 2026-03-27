package GiorgiaFormicola.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String id, String elementType) {
        super(elementType + " with id " + id + " not found in the database");
    }

    public NotFoundException(String codeISBN) {
        super("Item with ISBN code " + codeISBN + " not found in the catalog.");
    }

    public NotFoundException(int year) {
        super("No items published in " + year + " found in the catalog.");
    }

    public NotFoundException(String author, boolean aBoolean) {
        super("No books written by " + author.toUpperCase() + " found in the catalog.");
    }
}
