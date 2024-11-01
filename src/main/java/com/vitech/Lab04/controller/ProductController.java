package com.vitech.Lab04.controller;


import com.vitech.Lab04.entity.Product;
import com.vitech.Lab04.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(service.save(product));
    }




    @GetMapping("/products")
    public CompletableFuture<?> getAll(){

        try {
            CompletableFuture<List<Product>> products = service.getAllProducts();
            return CompletableFuture.completedFuture(products);

        }catch (Exception e){
            return  CompletableFuture.completedFuture(ResponseEntity.notFound());
        }

        //return ResponseEntity.ok().body((List<Product>) service.getAllProducts());
    }

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAll(){
//
//        return ResponseEntity.ok().body((List<Product>) service.getAllProducts());
//    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return ResponseEntity.ok().body(service.delete(id));
    }

    @PutMapping("updateProduct/{id}")
    public ResponseEntity<Product> updateById(@PathVariable int id , @RequestBody Product product){
        return ResponseEntity.ok().body(service.update(id,product));
    }

    @GetMapping("/findCheapProduct/{price}")
    public ResponseEntity<List<Product>> findCheapProduct(@PathVariable double price){
        return ResponseEntity.ok().body(service.findCheapProduct(price));
    }


}
