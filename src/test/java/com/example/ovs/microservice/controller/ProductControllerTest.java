package com.example.ovs.microservice.controller;

import com.example.ovs.microservice.entity.ProductEntity;
import com.example.ovs.microservice.services.impl.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    void findAvailableProducts() {

        ProductEntity product1 = new ProductEntity(10, "12312", 5, "nombre", "descripcion", 0.0, 10);
        ProductEntity product2 = new ProductEntity(11, "12313", 5, "nombre", "descripcion", 0.0, 10);
        List<ProductEntity> products = Arrays.asList(product1, product2);

        when(productService.findAll()).thenReturn(products);

        // when
        Collection<ProductEntity> result = productController.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.iterator().next().getBarcode()).isEqualTo(product1.getBarcode());
    }

    @Test
    void findByName() {
    }

    @Test
    void load() {
    }
}