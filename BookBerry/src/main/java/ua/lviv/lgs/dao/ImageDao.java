package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Image;

public interface ImageDao {
    void add(Image image);
    void edit(Image image);
    void delete(int id);
    Image findById(int id);
}
