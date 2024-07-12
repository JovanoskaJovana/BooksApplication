package mk.ukim.finki.booksapplication.repository;

import mk.ukim.finki.booksapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findByIsbn(String isbn);

    public void deleteById(Long id);

    public Book findById(Long id);
}
