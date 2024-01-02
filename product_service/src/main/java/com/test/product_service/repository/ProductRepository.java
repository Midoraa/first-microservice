package com.test.product_service.repository;

import com.test.product_service.dto.ProductDTO;
import com.test.product_service.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
