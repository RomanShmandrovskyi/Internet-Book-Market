package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Book book) {
        entityManager.persist(book);
    }

    @Transactional
    public void edit(Book book) {
        entityManager.merge(book);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Book.class, id));
    }

    @Transactional
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Transactional
    public List<Book> findAll() {
        return entityManager.createQuery("select b FROM Book b").getResultList();
    }

    @Transactional
    public List<Book> allBooksOfCurrentAuthor(int id) {
        return entityManager.createQuery("select b from Book b where b.author.id = :id").setParameter("id", id).getResultList();
    }

    @Transactional
    public List<Book> searchBook(String param) {
        return entityManager.createQuery("select b from Book b where name like '%"+param+"%'").getResultList();
    }

    @Transactional
    public List<Book> showAllBooksWithCurrentGenre(int id) {
        return entityManager.createQuery("select b from Book b where b.genre.id = :id").setParameter("id", id).getResultList();
    }
}
