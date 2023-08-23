package com.phsabreu.dscommerce.Controllers;

import com.phsabreu.dscommerce.dto.ProductDTO;
import com.phsabreu.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    private ProductService service;


    @GetMapping(value = "/{id}")
        public ProductDTO findById(@PathVariable Long id){

        ProductDTO dto = service.findById(id);

        return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

}
