package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.AuthorDao;
import ua.lviv.lgs.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Author author) {
        entityManager.persist(author);
    }

    @Transactional
    public void edit(Author author) {
        entityManager.merge(author);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Author.class, id));
    }

    @Transactional
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return entityManager.createQuery("select a from Author a").getResultList();
    }
}
