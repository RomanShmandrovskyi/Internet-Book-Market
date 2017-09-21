package ua.lviv.lgs.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.dao.BookDao;
import ua.lviv.lgs.dao.CommentDao;
import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.entity.Book;
import ua.lviv.lgs.entity.Comment;
import ua.lviv.lgs.entity.User;
import ua.lviv.lgs.services.CommentService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void add(String comm) {
        commentDao.add(new Comment(comm));
    }

    @Override
    public void edit(int id, String comm) {
        Comment comment = commentDao.findById(id);
        if(comm != null && !comm.equalsIgnoreCase("")){
            comment.setComment(comm);
        }
        commentDao.edit(comment);
    }

    @Override
    public void delete(int id) {
        commentDao.delete(id);
    }

    @Override
    public Comment findById(int id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findAllCommentsForBook(int bookId) {
        return commentDao.allCommentsForBook(bookId);
    }

    @Override
    public void addComment(Principal principal, int bookID, String comment) {
        commentDao.add(new Comment(comment, userDao.findByLogin(principal.getName()), bookDao.findById(bookID), new Date()));
    }

    @Override
    public void deleteAllCommentsFromCurrentUser(int id) {
        List<Comment> commentList = commentDao.allCommentsOfCurrentUserById(id);
        if(commentList != null){
            for (Comment comment : commentList) {
                commentDao.delete(comment.getId());
            }
        }
    }
}
