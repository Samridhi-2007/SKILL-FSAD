package com.hiber.SKILL3;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Product;
import util.HibernateUtil;

public class App {

public static void main(String[] args) {

Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

session.save(new Product("Laptop",80000,10,"Electronics"));
session.save(new Product("Mobile",30000,20,"Electronics"));
session.save(new Product("Keyboard",1500,50,"Accessories"));
session.save(new Product("Mouse",800,40,"Accessories"));
session.save(new Product("Monitor",12000,15,"Electronics"));
session.save(new Product("Speaker",2500,25,"Audio"));

tx.commit();


// Sorting by price ascending
Query<Product> q1 = session.createQuery("FROM Product ORDER BY price ASC",Product.class);
List<Product> list = q1.list();

System.out.println("Ascending Price");
list.forEach(System.out::println);


// Sorting by price descending
Query<Product> q2 = session.createQuery("FROM Product ORDER BY price DESC",Product.class);
q2.list().forEach(System.out::println);


// Pagination
Query<Product> q3 = session.createQuery("FROM Product",Product.class);
q3.setFirstResult(0);
q3.setMaxResults(3);

System.out.println("First 3 Products");
q3.list().forEach(System.out::println);


// Aggregate
Query<Long> q4 = session.createQuery("SELECT COUNT(*) FROM Product",Long.class);
System.out.println("Total Products = "+q4.uniqueResult());


// Min Max
Query<Object[]> q5 = session.createQuery("SELECT MIN(price),MAX(price) FROM Product",Object[].class);
Object[] res = q5.uniqueResult();

System.out.println("Min Price = "+res[0]);
System.out.println("Max Price = "+res[1]);


session.close();

}

}