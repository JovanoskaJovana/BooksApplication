package mk.ukim.finki.booksapplication.web.controller;


import lombok.AllArgsConstructor;
import mk.ukim.finki.booksapplication.model.Book;
import mk.ukim.finki.booksapplication.model.Review;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mk.ukim.finki.booksapplication.service.implementation.ReviewServiceImpl;
import mk.ukim.finki.booksapplication.service.implementation.BookServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class ReviewController {

    private final ReviewServiceImpl reviewService;
    private final BookServiceImpl bookService;

    @GetMapping("review/{id}")
    public String bookReviews(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        List<Review> reviewList = reviewService.listReviewsById(id);

        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("reviews", reviewList);
            return "bookReviews";
        }
        return "listBooks";
    }

    @PostMapping("review/{id}")
    public String formatTimeOnBookReviews(@PathVariable Long id,
                                          @RequestParam int score,
                                          @RequestParam String description,
                                          @RequestParam LocalDateTime time){
        Book book = bookService.findBookById(id);
        reviewService.saveReviews(score,description,book,time);
        return "add-review";
    }


    @PostMapping("/addReview/{id}")
    public String addReview(@PathVariable Long id,
                            @RequestParam int score,
                            @RequestParam String description,
                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime timestamp,
                            Model model){
        Book book = bookService.findBookById(id);
        if (book != null){
            reviewService.saveReviews(score,description,book,timestamp);
        }
        return "redirect:/books/review/" + id;
    }

    @GetMapping ("/addReview/{id}")
    public String addReviewForm(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        Review review = new Review();
        model.addAttribute("book", book);
        model.addAttribute("review", review);
        return "add-review";
    }


    @GetMapping("/filter")
    public String addProductToShoppingCart(@RequestParam(required = false) LocalDateTime from,
                                           @RequestParam(required = false) LocalDateTime to,
                                           Model model) {
        List<Review> reviews = reviewService.listReviews();
        model.addAttribute("reviews", reviews);
        return "filtered-reviews";
    }


    @PostMapping("/filter")
    public String filterShoppingCarts(@RequestParam LocalDateTime from,
                                      @RequestParam LocalDateTime to,
                                      Model model) {
        List<Review> filteredReviews = reviewService.filterByDateTimeBetween(from, to);
        model.addAttribute("reviews", filteredReviews);
        return "filtered-reviews";
    }
}
