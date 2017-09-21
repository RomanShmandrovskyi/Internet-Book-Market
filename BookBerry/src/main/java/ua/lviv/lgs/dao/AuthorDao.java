package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Author;

import java.util.List;

public interface AuthorDao {
    void add(Author author);
    void edit(Author author);
    void delete(int id);
    Author findById(int id);
    List<Author> getAllAuthors();
}
