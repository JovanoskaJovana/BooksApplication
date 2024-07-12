package mk.ukim.finki.booksapplication.service.implementation;

import mk.ukim.finki.booksapplication.model.Book;
import mk.ukim.finki.booksapplication.model.Review;
import mk.ukim.finki.booksapplication.repository.ReviewRepository;
import mk.ukim.finki.booksapplication.service.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> listReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> listReviewsById(Long bookId) {
        return reviewRepository.findReviewsByBookId(bookId);
    }

    @Override
    public void saveReviews(int score, String description, Book book, LocalDateTime timestamp) {
        reviewRepository.save(new Review(score, description, book, timestamp));
    }

    @Override
    public List<Review> filterByDateTimeBetween(LocalDateTime from, LocalDateTime to) {
        return reviewRepository.findAllByTimestampBetween(from,to);
    }
}
