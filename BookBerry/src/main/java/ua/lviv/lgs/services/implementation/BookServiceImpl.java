package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.entity.Author;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Genre;
import ua.lviv.lgs.services.BookService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void add(Book book, Author author, Genre genre) {
        book.setAuthor(author);
        book.setGenre(genre);
        bookDao.add(book);
    }

    @Override
    public void edit(int id, String name, String description, int price, int pageQuality, String format, int bookQuality, String language, String producer) {
        Book book = bookDao.findById(id);
        if(name != null && !name.equalsIgnoreCase("")){
            book.setName(name);
        }
        if(description != null && !description.equalsIgnoreCase("")){
            book.setDescription(description);
        }
        if(price != 0){
            book.setPrice(Math.abs(price));
        }
        if(pageQuality != 0){
            book.setPageQuality(Math.abs(pageQuality));
        }
        if(format != null && format.equalsIgnoreCase("")){
            book.setFormat(format);
        }
        if(bookQuality != 0 ){
            book.setBookQuality(Math.abs(bookQuality));
        }
        if(language != null && language.equalsIgnoreCase("")){
            book.setLanguage(language);
        }
        if(producer != null && producer.equalsIgnoreCase("")){
            book.setProducer(producer);
        }
        bookDao.edit(book);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> addToBasket(Integer id, HttpSession httpSession) {
        List<Book> bookList;
        if(httpSession.getAttribute("bookPurchase") != null){
            bookList = (List<Book>) httpSession.getAttribute("bookPurchase");
        }else{
            bookList = new ArrayList<>();
        }
        bookList.add(bookDao.findById(id));
        httpSession.setAttribute("bookPurchase", bookList);
        return bookList;
    }

    public void save(Book book){
        bookDao.edit(book);
    }

    @Override
    public List<Book> allBooksOfCurrentAuthor(int id) {
        return bookDao.allBooksOfCurrentAuthor(id);
    }

    @Override
    public List<Book> searchBook(String param) {
        return bookDao.searchBook(param);
    }

    @Override
    public List<Book> showAllBooksWithCurrentGenre(int id) {
        return bookDao.showAllBooksWithCurrentGenre(id);
    }
}
