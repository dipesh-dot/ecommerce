package com.usermanagementservice.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_tb_seq_gen")
    @SequenceGenerator(name = "role_tb_seq_gen", sequenceName = "role_seq_gen",allocationSize = 1)
    private Long id;
    private String name;
    private boolean isActive;

}

