package GiorgiaFormicola.entities;

import GiorgiaFormicola.enums.PeriodicityType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MAGAZINE")
@Table(name = "magazines")
public class Magazine extends LibraryElement {
    //ATTRIBUTES
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private PeriodicityType periodicity;

    //CONSTRUCTORS
    protected Magazine() {
    }

    public Magazine(String codeISBN, String title, int releaseYear, int numberOfPages, PeriodicityType periodicity) {
        super(codeISBN, title, releaseYear, numberOfPages);
        this.periodicity = periodicity;
    }

    //GETTERS
    public PeriodicityType getPeriodicity() {
        return periodicity;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Magazine {" +
                super.toString() +
                ", periodicity=" + periodicity +
                '}';
    }
}
