package com.phsabreu.dscommerce.services;

import com.phsabreu.dscommerce.dto.ProductDTO;
import com.phsabreu.dscommerce.entities.Product;
import com.phsabreu.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){

        Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);

        return dto;

    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){

        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));

    }
}
