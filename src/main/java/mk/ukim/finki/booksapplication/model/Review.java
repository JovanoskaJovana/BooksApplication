package mk.ukim.finki.booksapplication.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;
    private String description;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Review (int score, String description, Book book, LocalDateTime timestamp){
        this.score = score;
        this.description = description;
        this.book = book;
        this.timestamp = timestamp;
    }

    public Review() {
    }

}