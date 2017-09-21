package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.entity.Author;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Genre;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class BookController {


    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public String openAddNewBook(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "addNewBook";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String addBook(@RequestParam("bookName") String name,
                          @RequestParam("bookPrice") int price,
                          @RequestParam("bookPageQual") int pageQuality,
                          @RequestParam("bookFormat") String format,
                          @RequestParam("bookQual") int bookQuality,
                          @RequestParam("bookLang") String language,
                          @RequestParam("bookProducer") String producer,
                          @RequestParam("bookDescr") String description,
                          @RequestParam("bookAuthor") int authorID,
                          @RequestParam("bookGenre") int genreID) {
        Author author = authorService.findById(authorID);
        Genre genre = genreService.findById(genreID);
        bookService.add(new Book(name, description, price, pageQuality, format, bookQuality, language, producer), author, genre);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/edit", method = RequestMethod.POST)
    public String editBook(@RequestParam("name") String name,
                           @RequestParam("price") int price,
                           @RequestParam("pQ") int pageQuality,
                           @RequestParam("format") String format,
                           @RequestParam("bQ") int bookQuality,
                           @RequestParam("lang") String language,
                           @RequestParam("producer") String producer,
                           @RequestParam("descr") String description,
                           @RequestParam("id") int id) {
        bookService.edit(id, name, description, price, pageQuality, format, bookQuality, language, producer);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findById(id);
        List<Author> authors = authorService.getAllAuthors();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        model.addAttribute("books", book);
        return "editBook";
    }

    @RequestMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/book/{id}")
    public String openBook(@PathVariable Integer id, Model model, Principal principal, HttpSession httpSession){
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("comments", commentService.findAllCommentsForBook(id));
        try{
            model.addAttribute("currentUser", userService.findByLogin(principal.getName()));
        }catch (NullPointerException e){
            e.getStackTrace();
        }
        httpSession.setAttribute("currentBook", bookService.findById(id));
        return "book";
    }
}
