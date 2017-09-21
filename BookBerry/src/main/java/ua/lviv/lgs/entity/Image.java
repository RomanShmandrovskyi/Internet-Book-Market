package ua.lviv.lgs.entity;

import javax.persistence.*;

/**
 * Created by sh-ro on 21.03.2017.
 */
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String imageWay;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Author author;

    public Image() {
    }

    public Image(String imageWay) {
        this.imageWay = imageWay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageWay() {
        return imageWay;
    }

    public void setImageWay(String imageWay) {
        this.imageWay = imageWay;
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
