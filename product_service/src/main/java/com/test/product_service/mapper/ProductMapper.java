package com.test.product_service.mapper;

import com.test.product_service.dto.ProductDTO;
import com.test.product_service.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    //    Truyền dữ liệu từ Entity qua DTO
    public ProductDTO convertToDTO(ProductEntity productEntity) {

        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        return productDTO;
    }
    public Page<ProductDTO> convertToDTOPage(Page<ProductEntity> productEntityPage) {

        Page<ProductDTO> page = (Page<ProductDTO>) modelMapper.map(productEntityPage, ProductDTO.class);
        return page;
    }


    //      ngược lai
    public  ProductEntity convertToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        return productEntity;
    }
}
