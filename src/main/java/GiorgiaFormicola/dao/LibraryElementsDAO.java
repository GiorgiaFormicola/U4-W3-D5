package GiorgiaFormicola.dao;


import GiorgiaFormicola.entities.LibraryElement;
import GiorgiaFormicola.exceptions.ElementAlreadyInCatalogException;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
        if (found == null) throw new NotFoundException(id, "Library element");
        return found;
    }
}
