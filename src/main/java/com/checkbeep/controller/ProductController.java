package com.checkbeep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkbeep.exception.ResourceNotFoundException;
import com.checkbeep.model.Product;
import com.checkbeep.repository.ProductRepository;


@RestController
@RequestMapping("/api/v1")


public class ProductController {
	
	@Autowired
    private ProductRepository productRepository;
	
	@GetMapping("/product")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
	
	@GetMapping("/product/{id}")
    public ResponseEntity<Product> getCategoryById(@PathVariable(value = "id") Long productId)
        throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }
	
	@PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
	
	@PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
         @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		product.setProductName(productDetails.getProductName());
		product.setProductDescription(productDetails.getProductDescription());
		product.setPrice(productDetails.getPrice());
		product.setStockAvailable(productDetails.getStockAvailable());
		product.setImage(productDetails.getImage());
              
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
	
	@DeleteMapping("/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
         throws ResourceNotFoundException {
		Product product = productRepository.findById(productId)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	

	

}
