package com.example.ovs.microservice.repository;

import com.example.ovs.microservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByBarcode(String barcode);
}
