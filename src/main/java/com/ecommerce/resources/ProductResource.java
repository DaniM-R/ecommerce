package com.ecommerce.resources;

import com.ecommerce.entities.Product;
import com.ecommerce.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    IProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @PostMapping("/saveProduct")
    public Product createProduct(@RequestBody Product product) { //anotação para especificar que o corpo da requisição deverá ser convertido para tipo User
        return productRepository.save(product);
    }

    @DeleteMapping
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
