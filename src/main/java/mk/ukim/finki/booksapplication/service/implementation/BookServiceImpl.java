package mk.ukim.finki.booksapplication.service.implementation;

import jakarta.transaction.Transactional;
import mk.ukim.finki.booksapplication.model.Author;
import mk.ukim.finki.booksapplication.model.Book;
import mk.ukim.finki.booksapplication.service.BookService;
import mk.ukim.finki.booksapplication.repository.AuthorRepository;
import mk.ukim.finki.booksapplication.repository.BookRepository;
import mk.ukim.finki.booksapplication.repository.BookStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
    }


    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional
    public void saveBook(String isbn, String title, String genre, int year, List<Author> authors, String bookStoreName, Long id) {
        if (id != null) {
            bookRepository.deleteById(id);
            bookRepository.save(new Book(isbn, title, genre, year, null, bookStoreRepository.findBookStoreByName(bookStoreName)));
            return;
        }
        bookRepository.save(new Book(isbn, title, genre, year, null, bookStoreRepository.findBookStoreByName(bookStoreName)));

    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book copyBook(Long id) {
        Book oldBook  = bookRepository.findById(id);
        Book copyBook = new Book();

        if (oldBook != null) {
            copyBook.setTitle("Copy of - " + oldBook.getTitle());
            copyBook.setIsbn(oldBook.getIsbn());
            copyBook.setBookStore(oldBook.getBookStore());
            copyBook.setYear(oldBook.getYear());
            copyBook.setGenre(oldBook.getGenre());
            copyBook.setId((long) (Math.random()*1000));
            bookRepository.save(copyBook);
        }
        return copyBook;
    }
}
