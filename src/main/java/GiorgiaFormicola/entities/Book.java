package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.GenreType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BOOK")
@Table(name = "books")
public class Book extends LibraryElement {
    //ATTTRIBUTES
    @Column(nullable = false, length = 50)
    private String author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private GenreType genre;

    //CONSTRUCTORS
    protected Book() {
    }

    public Book(String codeISBN, String title, int releaseYear, int numberOfPages, String author, GenreType genre) {
        super(codeISBN, title, releaseYear, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    //GETTERS
    public String getAuthor() {
        return author;
    }

    public GenreType getGenre() {
        return genre;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Book {" +
                super.toString() +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                '}';
    }
}
