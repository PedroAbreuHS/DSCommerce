package com.phsabreu.dscommerce.repositories;

import com.phsabreu.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
