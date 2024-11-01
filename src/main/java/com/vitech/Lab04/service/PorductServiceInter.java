package com.vitech.Lab04.service;

import com.vitech.Lab04.entity.Product;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PorductServiceInter {

    public CompletableFuture<List<Product>> getAllProducts();
    public Product save(Product product);
    public String delete(int id);
    public Product update(int id , Product product);
    public List<Product>  findCheapProduct(double price);
}
