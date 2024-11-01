package com.vitech.Lab04.repository;

import com.vitech.Lab04.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepositoryInter extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT product FROM Product product where price < ?1")
    //Product findProductCheapestThan(@Param("price")double price);
    List<Product> findProductCheapestThan(double price);
}
