package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Author;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Genre;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BookService {

    void add(Book book, Author author, Genre genre);

    void edit(int id, String name, String description, int price, int pageQuality, String format, int bookQuality, String language, String producer);

    void delete(int id);

    Book findById(int id);

    List<Book> findAll();

    List<Book> addToBasket(Integer id, HttpSession httpSession);

    void save(Book book);

    List<Book> allBooksOfCurrentAuthor(int id);

    List<Book> searchBook(String param);

    List<Book> showAllBooksWithCurrentGenre(int id);
}
