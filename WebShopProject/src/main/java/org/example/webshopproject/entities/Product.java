package org.example.webshopproject.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "products")
public class Product {
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Product() {
    }
    public Product(Long id, String title, double price, String img ) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
