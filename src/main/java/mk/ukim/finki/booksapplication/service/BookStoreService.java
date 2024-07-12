package mk.ukim.finki.booksapplication.service;

import mk.ukim.finki.booksapplication.model.BookStore;

import java.util.List;


public interface BookStoreService {

    List<BookStore> listBookStores();

    BookStore findById(Long id);

}
