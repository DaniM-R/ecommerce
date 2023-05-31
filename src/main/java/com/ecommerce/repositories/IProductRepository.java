package com.ecommerce.repositories;

import com.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<Product, Long> {
}
