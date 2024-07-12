package mk.ukim.finki.booksapplication.service;

import mk.ukim.finki.booksapplication.model.Review;
import mk.ukim.finki.booksapplication.model.Book;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    List<Review> listReviews();

    List<Review> listReviewsById(Long id);

    void saveReviews(int score, String description, Book book, LocalDateTime timestamp);

    List<Review> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to);
}
