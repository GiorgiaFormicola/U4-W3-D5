package GiorgiaFormicola;

import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.entities.Magazine;
import GiorgiaFormicola.enums.PeriodicityType;
import GiorgiaFormicola.exceptions.InvalidISBNCodeException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library_catalog_pu");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //TESTS LibraryElement CONSTRUCTOR (NOT ABSTRACT CLASS)
       /* try {
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
        }*/

        //TESTS Book CLASS
      /*  try {
            LibraryElement book1 = new Book("3338814442221", "book1", 2012, 100, "Dan Brown", GenreType.THRILLER);
            System.out.println(book1);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }

        try {
            LibraryElement book2 = new Book("ciao", "book1", 2012, 100, "Dan Brown", GenreType.THRILLER);
            System.out.println(book2);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }*/

        //TESTS Magazine CLASS
        try {
            LibraryElement magazine1 = new Magazine("3338814442221", "magazine1", 2012, 100, PeriodicityType.BIANNUAL);
            System.out.println(magazine1);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }

        try {
            LibraryElement magazine2 = new Magazine("ciao", "magazine1", 2012, 100, PeriodicityType.WEEKLY);
            System.out.println(magazine2);
        } catch (InvalidISBNCodeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Hello World!");
    }
}
