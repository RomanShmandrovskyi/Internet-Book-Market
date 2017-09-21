package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column
    private int price;

    @Column(nullable = false)
    private int pageQuality;

    @Column
    private String format;

    @Column(nullable = false)
    private int bookQuality;

    @Column(nullable = false)
    private String language;

    @Column
    private String producer;

    @ManyToMany
    @JoinTable(name = "book_purchase", joinColumns = @JoinColumn(name = "book_Id"), inverseJoinColumns = @JoinColumn(name = "purchase_Id"))
    private List<Purchase> purchaseList;

    @OneToMany(mappedBy = "book")
    private List<Comment> commentList;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Image> imageList;

    @ManyToOne
    private Genre genre;

    public Book() {
    }

    public Book(String name, String description, int price, int pageQuality, String format, int bookQuality, String language, String producer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pageQuality = pageQuality;
        this.format = format;
        this.bookQuality = bookQuality;
        this.language = language;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPageQuality() {
        return pageQuality;
    }

    public void setPageQuality(int pageQuality) {
        this.pageQuality = pageQuality;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getBookQuality() {
        return bookQuality;
    }

    public void setBookQuality(int bookQuality) {
        this.bookQuality = bookQuality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
