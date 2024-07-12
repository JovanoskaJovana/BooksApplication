package mk.ukim.finki.booksapplication.service.implementation;

import mk.ukim.finki.booksapplication.model.BookStore;
import mk.ukim.finki.booksapplication.service.BookStoreService;
import mk.ukim.finki.booksapplication.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> listBookStores() {
        return bookStoreRepository.findAll();
    }

    @Override
    public BookStore findById(Long id) {
        return bookStoreRepository.findById(id).orElse(null);
    }
}
