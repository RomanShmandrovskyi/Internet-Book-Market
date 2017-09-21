package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    public void add(String name, String secondName, String email, String password, String phone) {
        User user = new User(name,secondName,email,password,phone);
        user.setRole("ROLE_USER");
        userDao.add(user);
}

    public void edit(int id, String name, String secondName, String email, String password, String phone, String homeAdress) {
        User user = userDao.findById(id);
        if (name != null && !name.equalsIgnoreCase("")) {
            user.setName(name);
        }
        if (secondName != null && !secondName.equalsIgnoreCase("")) {
            user.setSecondName(secondName);
        }
        if (email != null && !email.equalsIgnoreCase("")) {
            user.setEmail(email);
        }
        if (password != null && !password.equalsIgnoreCase("")) {
            user.setPassword(password);
        }
        if (phone != null && !phone.equalsIgnoreCase("")) {
            user.setPhone(phone);
        }
        if (homeAdress != null && !homeAdress.equalsIgnoreCase("")) {
            user.setHomeAdress(homeAdress);
        }
        userDao.edit(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDao.findByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Bad credentials");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
