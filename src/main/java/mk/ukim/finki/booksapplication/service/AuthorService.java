package mk.ukim.finki.booksapplication.service;

import mk.ukim.finki.booksapplication.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> findById(Long id);
}
