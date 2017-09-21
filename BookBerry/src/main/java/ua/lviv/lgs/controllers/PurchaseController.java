package ua.lviv.lgs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.services.BookService;
import ua.lviv.lgs.services.PurchaseService;
import ua.lviv.lgs.services.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/addToBasket/{id}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable Integer id, HttpSession httpSession) {
        httpSession.setAttribute("bookPurchase", bookService.addToBasket(id, httpSession));
        return "redirect:/";
    }

    @RequestMapping(value = "/makePurchase", method = RequestMethod.GET)
    public String purchase(HttpSession httpSession, Principal principal) {
        purchaseService.buyBooks(httpSession, principal);
        return "redirect:/";
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket(HttpSession httpSession, Model model) {
        List<Book> bookList = (List<Book>) httpSession.getAttribute("bookPurchase");
        model.addAttribute("purchaseSum", purchaseService.calculatePurchaseSum(bookList));
        model.addAttribute("book", bookList);
        return "basket";
    }

    @RequestMapping(value = "/deleteFromBasket/{id}", method = RequestMethod.GET)
    public String deleteFromBasket(@PathVariable Integer id, HttpSession httpSession, Model model) {
        List<Book> bookList = (List<Book>) httpSession.getAttribute("bookPurchase");
        model.addAttribute("book", bookList);
        purchaseService.deleteFromBasket(id, httpSession, bookList);
        return "redirect:/basket";
    }

    @RequestMapping(value = "/deletePurchase/{id}", method = RequestMethod.GET)
    public String deleteAllPurchasesFromUser(@PathVariable Integer id){
        purchaseService.delete(id);
        return "redirect:/allMyPurchases";
    }
}
