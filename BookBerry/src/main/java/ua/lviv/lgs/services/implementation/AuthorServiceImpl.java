package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.entity.Author;
import ua.lviv.lgs.services.AuthorService;

import java.util.Date;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void add(String name, String surname, String country, String description, java.sql.Date birthDate) {
        Author author = new Author(name,surname,country,description,birthDate);
        String date = birthDate.toGMTString().substring(0,11);
        author.setDate(date);
        authorDao.add(author);
    }

    @Override
    public void edit(int id, String name, String surname, String country, String description, java.sql.Date birthDate) {
        Author author = authorDao.findById(id);
        if(name != null && !name.equalsIgnoreCase("")){
            author.setName(name);
        }
        if(surname != null && !surname.equalsIgnoreCase("")){
            author.setSurname(surname);
        }
        if(country != null && !country.equalsIgnoreCase("")){
            author.setCountry(country);
        }
        if(description != null && description.equalsIgnoreCase("")){
            author.setDescription(description);
        }
        if(birthDate != null){
            author.setBirthDate(birthDate);
            String date = birthDate.toGMTString().substring(0,11);
            author.setDate(date);
        }
        authorDao.edit(author);
    }

    @Override
    public void delete(int id) {
        authorDao.delete(id);
    }

    @Override
    public Author findById(int id) {
        return authorDao.findById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }
}
