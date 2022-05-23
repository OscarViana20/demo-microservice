package com.example.ovs.microservice.services;

import com.example.ovs.microservice.entity.ProductEntity;

import java.util.Collection;

public interface IProductService {

    Collection<ProductEntity>  findAll();

    ProductEntity findByBarcode(String barcode);

    ProductEntity load(ProductEntity product);

    void deleteAllData();
}
