package ua.lviv.lgs.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(nullable = true)
    private int purchaseSumm;

    @Column(nullable = true)
    private Date date;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_purchase", joinColumns = @JoinColumn(name = "purchase_Id"), inverseJoinColumns = @JoinColumn(name = "book_Id"))
    private List<Book> bookList;

    public Purchase() {
    }

    public Purchase(int purchaseSumm, Date date) {
        this.purchaseSumm = purchaseSumm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseSumm() {
        return purchaseSumm;
    }

    public void setPurchaseSumm(int purchaseSumm) {
        this.purchaseSumm = purchaseSumm;
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
