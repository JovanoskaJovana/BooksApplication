package mk.ukim.finki.booksapplication.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.booksapplication.convertors.AuthorFullNameConverter;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    private Long id;
    @Convert(converter = AuthorFullNameConverter.class)
    private AuthorFullName fullName;
    @Column(length = 4000)
    private String biography;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @ManyToMany
    private List<Book> books;


    public Author(Long id, String name,String surname, String biography) {
        this.id = id;
        this.fullName = new AuthorFullName(name, surname);
        this.biography = biography;
    }

    public Author() {

    }

}
