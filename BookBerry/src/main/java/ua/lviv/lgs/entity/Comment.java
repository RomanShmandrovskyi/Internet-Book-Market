package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(length = 500)
    private String comment;

    @Column
    private Date date;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(String comment, User user, Book book, Date date){
        this.comment = comment;
        this.user = user;
        this.book = book;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
