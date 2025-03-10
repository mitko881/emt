package mk.ukim.finki.emt.library.lab1emt.model;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    public Author() {
    }
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @ManyToOne
    private Country country;
}
