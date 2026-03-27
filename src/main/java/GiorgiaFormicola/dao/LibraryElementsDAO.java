package GiorgiaFormicola.dao;


import GiorgiaFormicola.entities.LibraryElement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibraryElementsDAO {
    private EntityManager em;

    public LibraryElementsDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void save(LibraryElement element) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(element);
        transaction.commit();
        System.out.println(element.getClass().getSimpleName() + " successfully added to the catalog.");
    }
}
