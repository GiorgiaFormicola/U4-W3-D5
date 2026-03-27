package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Loan;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LoansDAO {
    private final EntityManager em;

    public LoansDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("Loan to " + loan.getUser().getName() + " " + loan.getUser().getSurname() + " successfully started.");
    }

    public Loan findById(String id) {
        Loan found = em.find(Loan.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id, "Loan");
        return found;
    }
}
