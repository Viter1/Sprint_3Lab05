package com.vitech.Lab04.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usa AUTO_INCREMENT en lugar de secuencia
    private Integer id;
    private String name;
    private double price;

}
