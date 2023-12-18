package com.orderservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_tb_seq_gen")
    @SequenceGenerator(name = "order_tb_seq_gen", sequenceName = "order_tb_seq", allocationSize = 1)
    private Long id;
    private Long userId;
    private Long productId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    private long quantity;
private double totalAmount;


}
