package com.vitech.Lab04.service.impl;

import com.vitech.Lab04.entity.Product;
import com.vitech.Lab04.repository.ProductRepositoryInter;
import com.vitech.Lab04.service.PorductServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService implements PorductServiceInter {

    @Autowired
    private ProductRepositoryInter repository;

    @Override
    @Async
    public CompletableFuture<List<Product>> getAllProducts(){
        List<Product> productList = repository.findAll();
        return CompletableFuture.completedFuture(productList);
    }

    @Override
    public Product save(Product product){
        return repository.save(product);
    }
    @Override
    public String delete(int id){
        repository.deleteById(id);
        return "Product " + id + " deleted successfully";
    }

    @Override
    public Product update(int id , Product product){
        Optional<Product> existingProduct = repository.findById(id);

        if (existingProduct.isPresent()){
            product.setId(id);
            return repository.save(product);
        }
        return null;
    }

    @Override
    public List<Product>  findCheapProduct(double price){
        return repository.findProductCheapestThan(price);
    }

}
