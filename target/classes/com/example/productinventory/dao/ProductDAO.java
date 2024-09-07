package com.example.productinventory.dao;

import com.example.productinventory.model.Product;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Product product) {
        em.persist(product);
    }

    @Transactional
    public Product update(Product product) {
        return em.merge(product);
    }

    @Transactional
    public void delete(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Product find(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll(int start, int maxResults) {
        return em.createQuery("SELECT p FROM Product p", Product.class)
                 .setFirstResult(start)
                 .setMaxResults(maxResults)
                 .getResultList();
    }

    public List<Product> findByName(String name) {
        return em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class)
                 .setParameter("name", "%" + name + "%")
                 .getResultList();
    }

    public List<Product> findByCategory(String category) {
        return em.createQuery("SELECT p FROM Product p WHERE p.category = :category", Product.class)
                 .setParameter("category", category)
                 .getResultList();
    }
}
