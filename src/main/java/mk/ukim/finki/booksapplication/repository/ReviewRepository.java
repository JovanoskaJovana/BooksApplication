package mk.ukim.finki.booksapplication.repository;

import mk.ukim.finki.booksapplication.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    public List<Review> findReviewsByBookId(Long bookId);

    List<Review> findAllByTimestampBetween(LocalDateTime from, LocalDateTime to);
}
