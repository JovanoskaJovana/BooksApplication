package mk.ukim.finki.booksapplication.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {

    private String isbn;
    private String title;
    private String genre;
    private int year;

    @ManyToMany
    @JoinTable(
            name = "authors_id",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BookStore bookStore;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Book(String isbn, String title, String genre, int year, List<Author> authors, BookStore bookStore) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }

    public Book() {

    }

}