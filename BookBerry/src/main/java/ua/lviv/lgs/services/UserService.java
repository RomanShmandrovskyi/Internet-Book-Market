package ua.lviv.lgs.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import ua.lviv.lgs.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
    void add(String name, String secondName, String email, String password, String phone);
    void edit(int id, String name, String secondName, String email, String password, String phone, String homeAdress);
    void delete(int id);
    User findById(int id);

    User findByLogin(String login);

    List<User> getAllUsers();
}
