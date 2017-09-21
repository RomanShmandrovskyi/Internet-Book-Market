package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.GenreDao;
import ua.lviv.lgs.entity.Genre;
import ua.lviv.lgs.services.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public void add(String janr) {
        genreDao.add(new Genre(janr));
    }

    @Override
    public void edit(int id, String janr) {
        Genre genre = genreDao.findById(id);
        if(janr != null && !janr.equalsIgnoreCase("")){
            genre.setGenre(janr);
        }
        genreDao.edit(genre);
    }

    @Override
    public void delete(int id) {
        genreDao.delete(id);
    }

    @Override
    public Genre findById(int id) {
        return genreDao.findById(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAllGenres();
    }
}
