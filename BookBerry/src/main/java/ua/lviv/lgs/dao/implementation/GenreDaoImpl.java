package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.GenreDao;
import ua.lviv.lgs.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GenreDaoImpl implements GenreDao{

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Genre genre) {
        entityManager.persist(genre);
    }

    @Transactional
    public void edit(Genre genre) {
        entityManager.merge(genre);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Genre.class, id));
    }

    @Transactional
    public Genre findById(int id) {
        return entityManager.find(Genre.class, id);
    }

    @Transactional
    public List<Genre> getAllGenres() {
        return entityManager.createQuery("select g from Genre g").getResultList();
    }
}
