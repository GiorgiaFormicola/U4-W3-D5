package GiorgiaFormicola.entities;

import GiorgiaFormicola.exceptions.InvalidISBNCodeException;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "library_elements")
public abstract class LibraryElement {
    //ATTRIBUTES
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "ISBN_code", nullable = false, unique = true, length = 13)
    private String codeISBN;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @Column(name = "pages_number")
    private int numberOfPages;

    //CONSTRUCTORS
    protected LibraryElement() {
    }

    public LibraryElement(String codeISBN, String title, int releaseYear, int numberOfPages) {
        //CHECKS ON ISBN code
        try {
            long codeToNumber = Long.parseLong(codeISBN);
        } catch (NumberFormatException e) {
            throw new InvalidISBNCodeException(codeISBN);
        }
        if (codeISBN.length() != 13) {
            throw new InvalidISBNCodeException(codeISBN);
        } else {
            this.codeISBN = codeISBN;
        }
        this.title = title;
        this.releaseYear = releaseYear;
        this.numberOfPages = numberOfPages;
    }

    //GETTERS

    public UUID getId() {
        return id;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    //TO STRING
    @Override
    public String toString() {
        return "id=" + id +
                ", codeISBN='" + codeISBN + '\'' +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", numberOfPages=" + numberOfPages;
    }
}
