package GiorgiaFormicola.dao;


import GiorgiaFormicola.entities.Book;
import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.exceptions.ElementAlreadyInCatalogException;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class LibraryElementsDAO {
    private final EntityManager em;

    public LibraryElementsDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void save(LibraryElement element) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(element);
            transaction.commit();
            System.out.println(element.getClass().getSimpleName() + " successfully added to the catalog.");
        } catch (Exception e) { //Probabilmente non del tutto corretto come metodo ma intanto ci provo
            throw new ElementAlreadyInCatalogException(element.getCodeISBN());
        }
    }

    public LibraryElement findById(String id) {
        LibraryElement found = em.find(LibraryElement.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id, "Item");
        return found;
    }

    public void deleteById(String id) {
        LibraryElement found = this.findById(id);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The " + found.getClass().getSimpleName().toLowerCase() + " has been deleted successfully!");
    }

    public LibraryElement findByISBN(String codeISBN) {
        TypedQuery<LibraryElement> query = em.createQuery("SELECT e FROM LibraryElement e WHERE e.codeISBN = :codeISBN", LibraryElement.class);
        query.setParameter("codeISBN", codeISBN);
        LibraryElement found = query.getSingleResultOrNull();
        if (found == null) throw new NotFoundException(codeISBN);
        else return found;
    }

    public void deleteByISBN(String codeISBN) {
        try {
            LibraryElement found = this.findByISBN(codeISBN);
            EntityTransaction transaction = this.em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("The " + found.getClass().getSimpleName().toLowerCase() + " with ISBN code " + codeISBN + " has been deleted successfully!");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<LibraryElement> findByRealeaseYear(int year) {
        TypedQuery<LibraryElement> query = em.createQuery("SELECT e FROM LibraryElement e WHERE e.releaseYear = :year", LibraryElement.class);
        query.setParameter("year", year);
        List<LibraryElement> found = query.getResultList();
        if (found.isEmpty()) throw new NotFoundException(year);
        else return found;
    }

    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author ILIKE :author", Book.class);
        query.setParameter("author", author);
        List<Book> found = query.getResultList();
        if (found.isEmpty()) throw new NotFoundException(author, true);
        else return found;
    }

    ;


}
