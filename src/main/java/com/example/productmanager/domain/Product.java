package com.example.productmanager.domain;

import lombok.*;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter
//@Builder
public class Product {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long no;
    public String name;
    public int price;
    public int stock;
}