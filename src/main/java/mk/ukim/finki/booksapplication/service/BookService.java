package mk.ukim.finki.booksapplication.service;

import mk.ukim.finki.booksapplication.model.Author;
import mk.ukim.finki.booksapplication.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();

    Book findBookByIsbn(String isbn);

    void saveBook(String isbn, String title, String genre, int year, List<Author> authors, String bookStore, Long id);

    void deleteBook(Long bookId);

    Book findBookById(Long id);

    Book copyBook(Long id);
}
