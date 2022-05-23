package com.example.ovs.microservice.services.impl;

import com.example.ovs.microservice.entity.ProductEntity;
import com.example.ovs.microservice.repository.ProductJpaRepository;
import com.example.ovs.microservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    public Collection<ProductEntity> findAll() {
        return this.productJpaRepository.findAll();
    }

    @Override
    public ProductEntity findByBarcode(String barcode) {
        return this.productJpaRepository.findByBarcode(barcode);
    }

    @Override
    public ProductEntity load(ProductEntity product) {
        this.productJpaRepository.save(product);
        return this.productJpaRepository.findByBarcode(product.getBarcode());
    }

    @Override
    public void deleteAllData() {
        this.productJpaRepository.deleteAll();
    }
}
