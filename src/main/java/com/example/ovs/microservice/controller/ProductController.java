package com.example.ovs.microservice.controller;

import com.example.ovs.microservice.controller.util.ResponseType;
import com.example.ovs.microservice.entity.ProductEntity;
import com.example.ovs.microservice.exception.MicroServiceException;
import com.example.ovs.microservice.repository.ProductJpaRepository;
import com.example.ovs.microservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final String MES = "mes";
    private static final String RESTYP = "restyp";

    @Autowired
    private IProductService productService;

    @GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ProductEntity> findAll(){
        return this.productService.findAll();
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<ProductEntity>> findAvailableProducts() {
        HttpHeaders responseHeaders = new HttpHeaders();
        Collection<ProductEntity> products = null;
        try {

            products = this.productService.findAll();
            responseHeaders.set(RESTYP, ResponseType.SUCCESS.toString());
        } catch (MicroServiceException e) {
            responseHeaders.set(RESTYP, ResponseType.ERROR.toString());
            responseHeaders.set(MES, e.getMessage());
        }
        return ResponseEntity.ok().headers(responseHeaders).body(products);
    }

    @GetMapping(value = "findByBarcode/{barcode}")
    public ProductEntity findByBarcode(@PathVariable final String barcode){
        return productService.findByBarcode(barcode);
    }

    @PostMapping(value = "/load")
    public ProductEntity load(@RequestBody final ProductEntity product) {
        return productService.load(product);
    }

    @DeleteMapping("/delete")
    public void delete() {
        this.productService.deleteAllData();
    }
}
