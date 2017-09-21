package ua.lviv.lgs.services;

import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Comment;

import javax.swing.*;
import java.security.Principal;
import java.util.List;

public interface CommentService {
    void add(String comment);
    void edit(int id, String comment);
    void delete(int id);
    Comment findById(int id);

    List<Comment> findAllCommentsForBook(int bookId);

    void addComment(Principal principal, int bookID, String comment);

    void deleteAllCommentsFromCurrentUser(int id);
}
