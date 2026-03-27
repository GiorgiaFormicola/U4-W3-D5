package GiorgiaFormicola.entities;

import GiorgiaFormicola.exceptions.InvalidCardNumberException;
import GiorgiaFormicola.exceptions.InvalidDateException;
import jakarta.persistence.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String surname;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "card_number", nullable = false, unique = true)
    private long cardNumber;

    //CONSTRUCTORS
    protected User() {
    }

    public User(String name, String surname, int year, int month, int day, String cardNumber) {
        this.name = name;
        this.surname = surname;

        //CHECK ON date
        try {
            this.birthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new InvalidDateException();
        }

        //CHECK ON card number
        try {
            this.cardNumber = Long.parseLong(cardNumber);
        } catch (NumberFormatException e) {
            throw new InvalidCardNumberException();
        }

    }

    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    //TO STRING

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
