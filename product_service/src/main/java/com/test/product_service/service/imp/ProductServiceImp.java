package com.test.product_service.service.imp;

import com.test.product_service.dto.ProductDTO;
import com.test.product_service.mapper.ProductMapper;
import com.test.product_service.repository.ProductRepository;
import com.test.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(productMapper::convertToDTO).toList();
    }
}
