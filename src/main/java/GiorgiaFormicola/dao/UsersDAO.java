package GiorgiaFormicola.dao;

import GiorgiaFormicola.entities.User;
import GiorgiaFormicola.exceptions.NotFoundException;
import GiorgiaFormicola.exceptions.UserAlreadyInDBException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UsersDAO {
    private final EntityManager em;

    public UsersDAO(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(user);
            transaction.commit();
            System.out.println(user.getName() + " " + user.getSurname() + " successfully added to the database.");
        } catch (Exception e) { //Probabilmente non del tutto corretto come metodo ma intanto ci provo
            throw new UserAlreadyInDBException(user.getCardNumber());
        }
    }

    public User findById(String id) {
        User found = em.find(User.class, UUID.fromString(id));
        if (found == null) throw new NotFoundException(id, "User");
        return found;
    }
}
