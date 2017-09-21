package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.BookService;
import ua.lviv.lgs.services.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession httpSession, Principal principal) {
        List<Book> bookList = bookService.findAll();
        List<Book> books = (List<Book>)httpSession.getAttribute("bookPurchase");
        try{
            User user = userService.findByLogin(principal.getName());
            model.addAttribute("currentUser", user);
        }catch (NullPointerException e){
            e.getStackTrace();
        }
        model.addAttribute("bInB", books);
        model.addAttribute("books", bookList);
        return "home";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("secondName") String secondName,
                               @RequestParam("password") String password,
                               @RequestParam("phone") String phone) {
        userService.add(name, secondName, email, password, phone);
        return "redirect:/";
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
