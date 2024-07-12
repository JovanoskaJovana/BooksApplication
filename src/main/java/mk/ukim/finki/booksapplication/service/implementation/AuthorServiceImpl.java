package mk.ukim.finki.booksapplication.service.implementation;

import mk.ukim.finki.booksapplication.model.Author;
import mk.ukim.finki.booksapplication.repository.AuthorRepository;
import mk.ukim.finki.booksapplication.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
