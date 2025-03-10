package mk.ukim.finki.emt.library.lab1emt.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.emt.library.lab1emt.enumerations.Category;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    private String name;

    public String getName() {
        return name;
    }

    @Enumerated(EnumType.STRING)
    private Category category;

    public Category getCategory() {
        return category;
    }

    @ManyToOne
    private Author author;

    public Author getAuthor() {
        return author;
    }

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public Integer getAvailableCopies()
    {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies)
    {
        this.availableCopies = availableCopies;
    }
}

