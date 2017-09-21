package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Genre;

import java.util.List;

public interface GenreDao {
    void add(Genre genre);
    void edit(Genre genre);
    void delete(int id);
    Genre findById(int id);
    List<Genre> getAllGenres();
}
