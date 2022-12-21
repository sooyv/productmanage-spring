package com.example.productmanager.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private long no;
    private String name;
    private int price;
    private int stock;
}
