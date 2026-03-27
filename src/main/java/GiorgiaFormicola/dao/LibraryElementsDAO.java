package GiorgiaFormicola.dao;


import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.exceptions.ElementAlreadyInCatalogException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibraryElementsDAO {
    private EntityManager em;

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
}
