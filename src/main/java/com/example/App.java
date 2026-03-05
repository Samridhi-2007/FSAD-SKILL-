package com.example;

import com.example.entity.Product;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT PRODUCTS
        Product p1 = new Product("Laptop","Dell Laptop",70000,10);
        Product p2 = new Product("Phone","Samsung Phone",30000,20);

        session.save(p1);
        session.save(p2);

        tx.commit();
        System.out.println("Products inserted");

        // RETRIEVE PRODUCT
        session.beginTransaction();
        Product product = session.get(Product.class,1);
        System.out.println("Retrieved: "+product.getName());

        // UPDATE PRODUCT
        product.setPrice(65000);
        session.update(product);
        session.getTransaction().commit();
        System.out.println("Product updated");

        // DELETE PRODUCT
        session.beginTransaction();
        Product deleteProduct = session.get(Product.class,2);
        session.delete(deleteProduct);
        session.getTransaction().commit();
        System.out.println("Product deleted");

        session.close();
    }
}