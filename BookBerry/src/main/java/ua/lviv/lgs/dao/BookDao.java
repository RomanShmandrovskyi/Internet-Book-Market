package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void edit(Book book);
    void delete(int id);
    Book findById(int id);
    List<Book> findAll();
    List<Book> allBooksOfCurrentAuthor(int id);
    List<Book> searchBook(String param);
    List<Book> showAllBooksWithCurrentGenre(int id);
}
