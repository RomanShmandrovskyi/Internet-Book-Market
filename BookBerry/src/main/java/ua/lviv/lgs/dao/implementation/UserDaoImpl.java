package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.security.Principal;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Transactional
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public User findByLogin(String login) {
        return (User)entityManager.createQuery("select u from User u where u.email = :email or u.phone = :phone").setParameter("email", login).setParameter("phone", login).getSingleResult();
    }

    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
