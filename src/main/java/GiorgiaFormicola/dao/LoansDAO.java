package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.Loan;
import GiorgiaFormicola.exceptions.AllLoansReturnedException;
import GiorgiaFormicola.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public void deleteById(String id) {
        Loan found = this.findById(id);
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("The loan to " + found.getUser().getName() + " " + found.getUser().getSurname() + " has been deleted successfully from database.");
    }

    public List<Loan> getNotReturnedLoans() {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.returnDate IS NULL AND l.expirationDate < CURRENT_DATE ", Loan.class);
        List<Loan> found = query.getResultList();
        if (found.isEmpty()) throw new AllLoansReturnedException();
        return found;
    }
}
