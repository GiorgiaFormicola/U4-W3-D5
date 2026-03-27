package GiorgiaFormicola;

import GiorgiaFormicola.entities.Book;
import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.entities.Loan;
import GiorgiaFormicola.entities.User;
import GiorgiaFormicola.enums.GenreType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.DateTimeException;
import java.time.LocalDate;

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
       /* try {
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
        }*/


        //TESTS User CONSTRUCTOR
       /* try {
            User user1 = new User("Mario", "Rossi", 1980, 12, 3, "33333");
            System.out.println(user1);
        } catch (InvalidCardNumberException | InvalidDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user2 = new User("Mario", "Verdi", 1980, 5, 3, "ciao");
            System.out.println(user2);
        } catch (InvalidCardNumberException | InvalidDateException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user3 = new User("Mario", "Bianchi", 1980, 15, 3, "444");
            System.out.println(user3);
        } catch (InvalidCardNumberException | InvalidDateException e) {
            System.out.println(e.getMessage());
        }*/

        //TESTS Loan CONSTRUCTOR
        User user = new User("Mario", "Rossi", 1980, 12, 3, "33333");
        LibraryElement book = new Book("3338814442221", "book1", 2012, 100, "Dan Brown", GenreType.THRILLER);
        Loan loan = new Loan(user, book);
        System.out.println(loan);

        try {
            loan.setReturnDate(LocalDate.of(2026, 10, 5));
            System.out.println(loan.getReturnDate());
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            loan.setReturnDate(LocalDate.of(2026, 15, 5));
            System.out.println(loan.getReturnDate());
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Hello World!");
    }
}
