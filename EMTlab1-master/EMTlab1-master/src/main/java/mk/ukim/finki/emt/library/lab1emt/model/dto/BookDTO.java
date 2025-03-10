package mk.ukim.finki.emt.library.lab1emt.model.dto;

import mk.ukim.finki.emt.library.lab1emt.enumerations.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String name;
    private Category category;
    private Integer availableCopies;
}
