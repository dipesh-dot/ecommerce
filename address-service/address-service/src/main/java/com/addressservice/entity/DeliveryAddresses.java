package com.addressservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "delivery_addresses")
public class DeliveryAddresses {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_addresses_seq_gen")
    @SequenceGenerator(name = "delivery_addresses_seq_gen", sequenceName = "delivery_addresses_seq", allocationSize = 1)
    private Long id;
    private String name;

}
