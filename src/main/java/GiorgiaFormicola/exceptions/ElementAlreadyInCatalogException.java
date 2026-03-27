package GiorgiaFormicola.exceptions;

public class ElementAlreadyInCatalogException extends RuntimeException {
    public ElementAlreadyInCatalogException(String codeISBN) {
        super("The element with ISBN code " + codeISBN + " is already present in the catalog.");
    }
}
