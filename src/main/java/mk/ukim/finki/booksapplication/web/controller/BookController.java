package mk.ukim.finki.booksapplication.web.controller;


import lombok.AllArgsConstructor;
import mk.ukim.finki.booksapplication.model.Book;
import mk.ukim.finki.booksapplication.service.implementation.AuthorServiceImpl;
import mk.ukim.finki.booksapplication.service.implementation.BookServiceImpl;
import mk.ukim.finki.booksapplication.service.implementation.BookStoreServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;
    private final BookStoreServiceImpl bookStore;


    @GetMapping("")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("authors", authorService.listAuthors());
        return "listBooks";
    }

    @PostMapping("/add")
    public String saveBook(
            @RequestParam String bookTitle,
            @RequestParam String isbn,
            @RequestParam String genre,
            @RequestParam int year,
            @RequestParam String bookStoreName,
            @RequestParam (required = false) Long id
    ){
        bookService.saveBook(isbn, bookTitle, genre, year, null, bookStoreName, id);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("bookStores", bookStore.listBookStores());
        return "add-book";
    }

    @RequestMapping("edit/{bookId}")
    public String editBook(@PathVariable Long bookId, Model model) {
        Book book = bookService.findBookById(bookId);
        if (book != null) {
            model.addAttribute("id", bookId);
            model.addAttribute("book", book);
            model.addAttribute("bookStores", bookStore.listBookStores());
            return "add-book";
        }

        model.addAttribute("error", String.format("Book with id %s doesnt exist", bookId));
        model.addAttribute("books", bookService.listBooks());
        return "listBooks";

    }

    @RequestMapping("delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("copy/{id}")
    public String copyBook(@PathVariable Long id) {
        bookService.copyBook(id);
        return "redirect:/books";
    }


}