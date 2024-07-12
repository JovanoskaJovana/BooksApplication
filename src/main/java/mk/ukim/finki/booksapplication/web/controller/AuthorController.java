package mk.ukim.finki.booksapplication.web.controller;


import lombok.AllArgsConstructor;
import mk.ukim.finki.booksapplication.service.implementation.AuthorServiceImpl;
import mk.ukim.finki.booksapplication.service.implementation.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorService;
    private final BookServiceImpl bookService;

    @PostMapping("/author")
    public String authorsPage(
            @RequestParam(name = "bookIsbn") String isbn,
            Model model
    ) {
        model.addAttribute("authors", authorService.listAuthors());
        model.addAttribute("books", bookService.listBooks());
        model.addAttribute("bookIsbn", isbn);
        return "authorList";
    }

}
