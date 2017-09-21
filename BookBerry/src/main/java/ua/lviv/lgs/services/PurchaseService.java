package ua.lviv.lgs.services;


import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Purchase;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

public interface PurchaseService {
    void add(Purchase purchase);
    void edit(Purchase purchase);
    void delete(int id);
    Purchase findById(int id);

    List<Purchase> findAll();
    List<Purchase> findAllUserPurchase(String login);
    void buyBooks(HttpSession httpSession, Principal principal);
    List<Book> deleteFromBasket(Integer id, HttpSession httpSession, List<Book> bookList);
    List<Purchase> findAllUserPurchasesById(int id);
    int calculatePurchaseSum(List<Book> bookList);
    void deleteAllPurchasesFromCurrentUser(int id);
}
