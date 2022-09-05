package com.vishnu.productservice.service;

import com.vishnu.productservice.ddo.ProductRequest;
import com.vishnu.productservice.model.Product;
import com.vishnu.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public void createProduct(ProductRequest productRequest) {
        // Map request to model with builder
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        // Save object into database
        productRepository.save(product);

        // Logging
        log.info("Product {} is saved", product.getId());
    }
}
