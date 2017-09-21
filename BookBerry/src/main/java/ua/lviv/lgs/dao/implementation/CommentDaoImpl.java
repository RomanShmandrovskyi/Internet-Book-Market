package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.CommentDao;
import ua.lviv.lgs.entity.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.security.Principal;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Comment comment) {
        entityManager.persist(comment);
    }

    @Transactional
    public void edit(Comment comment) {
        entityManager.merge(comment);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Comment.class, id));
    }

    @Transactional
    public Comment findById(int id) {
        return entityManager.find(Comment.class, id);
    }

    @Transactional
    public List<Comment> allCommentsForBook(int bookId){
        return entityManager.createQuery("select c from Comment c where c.book.id = :id").setParameter("id", bookId).getResultList();
    }

    @Transactional
    public List<Comment> allCommentsOfCurrentUserById(int id) {
        return entityManager.createQuery("select c from Comment c where c.user.id = :id").setParameter("id", id).getResultList();
    }

    @Transactional
    public List<Comment> allCommentsOfCurrentUserByLogin(String login) {
        return entityManager.createQuery("select c from Comment c where c.user.email = :login").setParameter("login", login).getResultList();
    }
}
