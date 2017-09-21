package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Image;

public interface ImageService {

    void add(String img);
    void edit(int id, String img);
    void delete(int id);
    Image findById(int id);
}
