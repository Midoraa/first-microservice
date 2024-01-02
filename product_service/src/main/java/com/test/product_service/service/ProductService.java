package com.test.product_service.service;

import com.test.product_service.dto.ProductDTO;
import com.test.product_service.entity.DataResponse;
import com.test.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAll();
}
