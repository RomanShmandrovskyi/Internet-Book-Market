package ua.lviv.lgs.dao.implementation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.dao.ImageDao;
import ua.lviv.lgs.entity.Image;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class ImageDaoImpl implements ImageDao {

    @PersistenceContext(unitName = "mainPersUnit")
    private EntityManager entityManager;

    @Transactional
    public void add(Image image) {
        entityManager.persist(image);
    }

    @Transactional
    public void edit(Image image) {
        entityManager.merge(image);
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Image.class, id));
    }

    @Transactional
    public Image findById(int id) {
        return entityManager.find(Image.class, id);
    }
}
