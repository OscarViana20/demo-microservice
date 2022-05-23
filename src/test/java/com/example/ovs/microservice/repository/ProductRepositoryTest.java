package com.example.ovs.microservice.repository;

import com.example.ovs.microservice.entity.ProductEntity;
import com.example.ovs.microservice.repository.ProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductJpaRepository repository;

    @Test
    public void testFindByName() {

        repository.save(new ProductEntity(10, "12312", 5, "nombre", "descripcion", 0.0, 10) );

        List<ProductEntity> products = repository.findAll();
        assertEquals(9, products.size());

        //assertThat(products).extracting(ProductEntity::getName).isEqualTo("Vaso IronMan Kids");

    }
}
