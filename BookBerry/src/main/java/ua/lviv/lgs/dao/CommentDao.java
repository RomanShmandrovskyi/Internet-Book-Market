package ua.lviv.lgs.dao;

import ua.lviv.lgs.entity.Comment;

import java.security.Principal;
import java.util.List;

public interface CommentDao {
    void add(Comment comment);
    void edit(Comment comment);
    void delete(int id);
    Comment findById(int id);
    List<Comment> allCommentsForBook(int bookId);
    List<Comment> allCommentsOfCurrentUserById(int id);
    List<Comment> allCommentsOfCurrentUserByLogin(String login);
}
