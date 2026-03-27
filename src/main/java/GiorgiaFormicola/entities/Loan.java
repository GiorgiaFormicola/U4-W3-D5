package GiorgiaFormicola.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "loans")
public class Loan {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "expiration_date", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    //RELATION WITH User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //RELATION WITH LibraryElement
    @ManyToOne
    @JoinColumn(name = "loaned_element_id")
    private LibraryElement loanedElement;


    //CONSTRUCTORS
    protected Loan() {
    }

    public Loan(User user, LibraryElement loanedElement) {
        this.issueDate = LocalDate.now();
        this.expirationDate = this.issueDate.plusDays(30);
        this.user = user;
        this.loanedElement = loanedElement;
    }

    //GETTERS
    public UUID getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    //SETTERS
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public LibraryElement getLoanedElement() {
        return loanedElement;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Loan {" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", expirationDate=" + expirationDate +
                ", returnDate=" + returnDate +
                ", user= " + user +
                ", loanedElement= " + loanedElement +
                '}';
    }
}
