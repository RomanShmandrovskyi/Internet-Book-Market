package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Purchase;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PurchaseDao {
    void add(Purchase purchase);
    void edit(Purchase purchase);
    void delete(int id);
    Purchase findById(int id);

    List<Purchase> findAllPurch();
    List<Purchase> findAllUserPurch(String login);
    List<Purchase> findAllUserPurchById(int id);
}
