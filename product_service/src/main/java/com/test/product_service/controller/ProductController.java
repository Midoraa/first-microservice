package com.test.product_service.controller;

import com.test.product_service.dto.ProductDTO;
import com.test.product_service.entity.DataResponse;
import com.test.product_service.entity.ProductEntity;
import com.test.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductDTO> getAll(){
        return productService.getAll();
    }
}
