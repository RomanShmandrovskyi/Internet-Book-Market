package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.PurchaseDao;
import ua.lviv.lgs.entity.Purchase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Purchase purchase) {
        entityManager.persist(purchase);
    }

    @Transactional
    public void edit(Purchase purchase) {
        entityManager.merge(purchase);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Purchase.class, id));
    }

    @Transactional
    public Purchase findById(int id) {
        return entityManager.find(Purchase.class, id);
    }

    @Transactional
    public List<Purchase> findAllPurch() {
        return entityManager.createQuery("select p from Purchase p").getResultList();
    }

    @Transactional
    public List<Purchase> findAllUserPurch(String login) {
        return entityManager.createQuery("select p from Purchase p where p.user.email = :email or p.user.phone = :phone").setParameter("email", login).setParameter("phone", login).getResultList();
    }

    @Transactional
    public List<Purchase> findAllUserPurchById(int id) {
        return entityManager.createQuery("select p from Purchase p where p.user.id = :id").setParameter("id", id).getResultList();
    }
}
