package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.entity.*;
import ua.lviv.lgs.services.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class AdministratorController {

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

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public String allUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("allUsers", users);
        return "allUsers";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Principal principal) {
        purchaseService.deleteAllPurchasesFromCurrentUser(id);
        commentService.deleteAllCommentsFromCurrentUser(id);
        userService.delete(id);
        return "redirect:/allUsers";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@RequestParam("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("secondName") String secondName,
                           @RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone,
                           @RequestParam("homeAdress") String adr) {
        userService.edit(id, name, secondName, email, password, phone, adr);
        return "redirect:/allUsers";
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @RequestMapping(value = "/allUserPurchases/{id}", method = RequestMethod.GET)
    public String allUserPurchaseForAdmin(@PathVariable Integer id, Model model) {
        List<Purchase> purchaseList = purchaseService.findAllUserPurchasesById(id);
        model.addAttribute("allPurchases", purchaseList);
        return "allUserPurchases";
    }

    @RequestMapping(value = "/Administrator", method = RequestMethod.GET)
    public String cabinet(Model model) {
        List<User> users = userService.getAllUsers();
        List<Genre> genres = genreService.getAllGenres();
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("users", users);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "adminCabinet";
    }

    @RequestMapping(value = "/allAuthors", method = RequestMethod.GET)
    public String openAllAuthors(Model model) {
        List<Author> allAuthors = authorService.getAllAuthors();
        model.addAttribute("author", allAuthors);
        return "allAuthors";
    }

    @RequestMapping(value = "/newAuthor", method = RequestMethod.GET)
    public String openAddNewAuthor() {
        return "addNewAuthor";
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public String addAuthor(@RequestParam("authorName") String name,
                            @RequestParam("authorSurname") String surname,
                            @RequestParam("authorCountry") String country,
                            @RequestParam("authorDescription") String description,
                            @RequestParam("authorBirth") java.sql.Date birthDate) {
        authorService.add(name, surname, country, description, birthDate);
        return "redirect:/Administrator";
    }

    @RequestMapping(value = "/author/edit/{id}", method = RequestMethod.GET)
    public String openEditAuthor(@PathVariable Integer id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @RequestMapping(value = "/editAuthor", method = RequestMethod.POST)
    public String editAuthor(@RequestParam("id") Integer id,
                             @RequestParam("authorName") String name,
                             @RequestParam("authorSurname") String surname,
                             @RequestParam("authorCountry") String country,
                             @RequestParam("authorDescription") String description,
                             @RequestParam("authorBirth") java.sql.Date birth) {
        authorService.edit(id, name, surname, country, description, birth);
        return "redirect:/allAuthors";
    }

    @RequestMapping(value = "/newGenre", method = RequestMethod.GET)
    public String openAddNewGenre() {
        return "addGenre";
    }

    @RequestMapping(value = "/genre/add", method = RequestMethod.POST)
    public String addNewGenre(@RequestParam("genre") String genre) {
        genreService.add(genre);
        return "redirect:/Administrator";
    }

    @RequestMapping(value = "/delete/author/{id}", method = RequestMethod.GET)
    public String deleteAuthor(@PathVariable Integer id) {
        List<Book> bookList = bookService.allBooksOfCurrentAuthor(id);
        if (bookList != null) {
            for (Book book : bookList) {
                bookService.delete(book.getId());
            }
        }
        authorService.delete(id);
        return "redirect:/allAuthors";
    }

    @RequestMapping(value = "/genres/all")
    public String openAllGenres(Model model){
        model.addAttribute("genres", genreService.getAllGenres());
        return "allGenres";
    }

    @RequestMapping(value = "/books-from/{id}", method = RequestMethod.GET)
    public String openAllBooksFromCurrentGenre(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.showAllBooksWithCurrentGenre(id));
        return "booksInGenre";
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public String addCommentToCurrentBook(@RequestParam("id") Integer id, @RequestParam("bookComment") String comment, Principal principal){
        commentService.addComment(principal, id, comment);
        return "redirect:/book/"+id;
    }

    @RequestMapping(value = "/comment/delete/{id}")
    public String deleteMyComment(@PathVariable Integer id, HttpSession httpSession){
        Book book = (Book) httpSession.getAttribute("currentBook");
        commentService.delete(id);
        return "redirect:/book/"+book.getId();
    }
}
