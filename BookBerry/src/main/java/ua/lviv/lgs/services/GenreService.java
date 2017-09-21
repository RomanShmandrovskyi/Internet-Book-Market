package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Genre;

import java.util.List;

public interface GenreService {
    void add(String janr);
    void edit(int id, String janr);
    void delete(int id);
    Genre findById(int id);
    List<Genre> getAllGenres();
}
