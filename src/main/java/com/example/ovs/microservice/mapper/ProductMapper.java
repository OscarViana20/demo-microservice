package com.example.ovs.microservice.mapper;

import com.example.ovs.microservice.dto.ProductDto;
import com.example.ovs.microservice.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductDto entityToDto(ProductEntity productEntity);

    ProductEntity dtoToEntity(ProductDto productDto);
}
