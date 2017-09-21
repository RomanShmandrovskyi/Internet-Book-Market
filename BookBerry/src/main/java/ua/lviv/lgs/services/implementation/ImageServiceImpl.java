package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.ImageDao;
import ua.lviv.lgs.entity.Image;
import ua.lviv.lgs.services.ImageService;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageDao imageDao;

    @Override
    public void add(String img) {
        imageDao.add(new Image(img));
    }

    @Override
    public void edit(int id, String img) {
        Image image = imageDao.findById(id);
        if(img != null && !img.equalsIgnoreCase("")){
            image.setImageWay(img);
        }
        imageDao.edit(image);
    }

    @Override
    public void delete(int id) {
        imageDao.delete(id);
    }

    @Override
    public Image findById(int id) {
        return imageDao.findById(id);
    }
}
