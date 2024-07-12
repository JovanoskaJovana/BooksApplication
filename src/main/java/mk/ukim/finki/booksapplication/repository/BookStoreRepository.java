package mk.ukim.finki.booksapplication.repository;

import mk.ukim.finki.booksapplication.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

    public BookStore findBookStoreByName(String name);

}
