package GiorgiaFormicola;

import GiorgiaFormicola.dao.LibraryElementsDAO;
import GiorgiaFormicola.dao.LoansDAO;
import GiorgiaFormicola.dao.UsersDAO;
import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.entities.Loan;
import GiorgiaFormicola.entities.User;
import GiorgiaFormicola.exceptions.NotFoundException;
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
        /*User user = new User("Mario", "Rossi", 1980, 12, 3, "33333");
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
        }*/

        //TESTS LibraryElementDAO
        /*LibraryElementsDAO elementsDAO = new LibraryElementsDAO(entityManager);
        try {
            LibraryElement book1 = new Book("3338814442221", "book1", 2012, 100, "Dan Brown", GenreType.THRILLER);
            LibraryElement magazine1 = new Magazine("3338814442223", "magazine1", 2012, 100, PeriodicityType.BIANNUAL);
            elementsDAO.save(book1);
            elementsDAO.save(magazine1);
        } catch (InvalidISBNCodeException | ElementAlreadyInCatalogException e) {
            System.out.println(e.getMessage());
        }

        //Try to catch error
        try {
            LibraryElement book1 = new Book("3338814442221", "book1", 2012, 100, "Dan Brown", GenreType.THRILLER);
            elementsDAO.save(book1);
        } catch (InvalidISBNCodeException | ElementAlreadyInCatalogException e) {
            System.out.println(e.getMessage());
        }*/

        //TESTS UsersDAO
       /* UsersDAO usersDAO = new UsersDAO(entityManager);
        try {
            User user1 = new User("Mario", "Rossi", 1980, 12, 3, "33333");
            User user2 = new User("Giulia", "Bianchi", 2000, 10, 5, "55");
            usersDAO.save(user1);
            usersDAO.save(user2);
        } catch (InvalidCardNumberException | InvalidDateException | UserAlreadyInDBException e) {
            System.out.println(e.getMessage());
        }

        //Try to catch error
        try {
            User user1 = new User("Mario", "Rossi", 1980, 12, 3, "33333");
            usersDAO.save(user1);
        } catch (InvalidCardNumberException | InvalidDateException | UserAlreadyInDBException e) {
            System.out.println(e.getMessage());
        }*/

        //TESTS LoanDAO
        UsersDAO usersDAO = new UsersDAO(entityManager);
        LibraryElementsDAO libraryElementsDAO = new LibraryElementsDAO(entityManager);
        LoansDAO loansDAO = new LoansDAO(entityManager);
        try {
            User userFromDB = usersDAO.findById("5d4bd202-2292-4508-b209-96a60aee095d");
            LibraryElement libraryElementFromDB = libraryElementsDAO.findById("437e9c10-3089-4124-a045-cf8281ddc55f");
            Loan loan = new Loan(userFromDB, libraryElementFromDB);
            loansDAO.save(loan);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Hello World!");
        entityManager.close();
        entityManagerFactory.close();
    }
}
