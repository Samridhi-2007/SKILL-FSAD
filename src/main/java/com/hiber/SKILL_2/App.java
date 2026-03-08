package com.hiber.SKILL_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Product;

public class App {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // INSERT PRODUCT
        Product p1 = new Product("Laptop", "Gaming Laptop", 80000, 5);
        Product p2 = new Product("Mouse", "Wireless Mouse", 700, 20);

        session.save(p1);
        session.save(p2);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Products inserted successfully!");
    }
}