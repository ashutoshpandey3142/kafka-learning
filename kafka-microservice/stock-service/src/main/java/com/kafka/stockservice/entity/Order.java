package com.kafka.stockservice.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_entity")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price")
    private String price;

}

