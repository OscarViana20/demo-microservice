package com.example.ovs.microservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class ProductDto {

    @Id
    private Integer id;

    private String barcode;

    private Integer categoryId;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;
}
