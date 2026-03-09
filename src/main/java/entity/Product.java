<<<<<<< HEAD
package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    // Change strategy here to AUTO / IDENTITY / SEQUENCE for testing
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    private double price;

    private int quantity;

    // Default Constructor
    public Product() {}

    // Parameterized Constructor
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
=======


package entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;
private double price;
private int quantity;
private String description;

public Product() {}

public Product(String name,double price,int quantity,String description){
this.name=name;
this.price=price;
this.quantity=quantity;
this.description=description;
}

public String toString(){
return id+" "+name+" "+price+" "+quantity+" "+description;
}

>>>>>>> 033a2cc (added skill3)
}