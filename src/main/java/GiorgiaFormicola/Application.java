package GiorgiaFormicola;

import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.exceptions.InvalidISBNCodeException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_catalog_pu");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //TESTS LibraryElement CONSTRUCTOR
        try {
            LibraryElement libraryElement1 = new LibraryElement("3338814442221", "elemento1", 2012, 100);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }

        try {
            LibraryElement libraryElement2 = new LibraryElement("333", "elemento2", 2012, 100);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }

        try {
            LibraryElement libraryElement3 = new LibraryElement("ciao", "elemento3", 2012, 100);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Hello World!");
    }
}
