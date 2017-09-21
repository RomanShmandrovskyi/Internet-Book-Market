package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.dao.CommentDao;
import ua.lviv.lgs.dao.PurchaseDao;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Comment;
import ua.lviv.lgs.entity.Purchase;
import ua.lviv.lgs.services.PurchaseService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public void add(Purchase purchase) {
        purchaseDao.add(purchase);
    }

    @Override
    public void edit(Purchase purchase) {
        purchaseDao.edit(purchase);
    }

    @Override
    public void delete(int id) {
        purchaseDao.delete(id);
    }

    @Override
    public Purchase findById(int id) {
        return purchaseDao.findById(id);
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseDao.findAllPurch();
    }

    @Override
    public List<Purchase> findAllUserPurchase(String login) {
        return purchaseDao.findAllUserPurch(login);
    }

    @Override
    public void buyBooks(HttpSession httpSession, Principal principal) {
        Purchase purchase = new Purchase();
        List<Book> bookList = (List<Book>) httpSession.getAttribute("bookPurchase");

        int globPrice = 0;

        for (Book b : bookList) {
            globPrice += b.getPrice();
            Book book = bookDao.findById(b.getId());
            book.setBookQuality(book.getBookQuality() - 1);
            bookDao.edit(book);
        }

        purchase.setBookList(bookList);
        purchase.setUser(userDao.findByLogin(principal.getName()));
        purchase.setPurchaseSumm(globPrice);
        purchase.setDate(new java.util.Date());

        purchaseDao.add(purchase);
        bookList.removeAll(bookList);
    }

    @Override
    public List<Book> deleteFromBasket(Integer id, HttpSession httpSession, List<Book> bookList) {
        int index = 0;
        int ID;
        for (Book b : bookList) {
            ID = b.getId();
            if (ID == id) {
                index = bookList.indexOf(b);
            }
        }
        bookList.remove(index);
        return bookList;
    }

    @Override
    public List<Purchase> findAllUserPurchasesById(int id){
        return purchaseDao.findAllUserPurchById(id);
    }

    @Override
    public int calculatePurchaseSum(List<Book> bookList) {
        int sum = 0;
        for (Book book : bookList) {
            sum+=book.getPrice();
        }
        return sum;
    }

    @Override
    public void deleteAllPurchasesFromCurrentUser(int id) {
        List<Purchase> purchaseList = purchaseDao.findAllUserPurchById(id);
        if (purchaseList != null) {
            for (Purchase purchase : purchaseList) {
                purchaseDao.delete(purchase.getId());
            }
        }
    }
}
