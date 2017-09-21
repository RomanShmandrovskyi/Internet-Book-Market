package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Author;
import java.util.List;

public interface AuthorService {
    void add(String name, String surname, String country, String description, java.sql.Date birthDate);
    void edit(int id, String name, String surname, String country, String description, java.sql.Date birthDate);
    void delete(int id);
    Author findById(int id);
    List<Author> getAllAuthors();
}
