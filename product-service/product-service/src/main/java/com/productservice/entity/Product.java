package com.productservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_tb_seq_gen")
    @SequenceGenerator(name = "product_tb_seq_gen", sequenceName = "product_tb_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private double price;






}
