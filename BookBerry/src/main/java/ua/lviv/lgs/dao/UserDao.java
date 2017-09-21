package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserDao {
    void add(User user);
    void edit(User user);
    void delete(int id);
    User findById(int id);
    User findByLogin(String login);
    List<User> getAllUsers();
}
