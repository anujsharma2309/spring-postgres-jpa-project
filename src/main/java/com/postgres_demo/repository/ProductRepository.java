package com.postgres_demo.repository;


import com.postgres_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query methods can be defined here

    @Query("select p from Product p where p.name = ?1")
    public List<Product> findByName(String name);

}
