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
import com.checkbeep.model.ProductDetails;
import com.checkbeep.repository.ProductDetailsRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductDetailsController {
	
	@Autowired
    private ProductDetailsRepository productDetailsRepository;
	
	@GetMapping("/productDetails")
    public List<ProductDetails> getAllProductDetails() {
        return productDetailsRepository.findAll();
    }
	
	@GetMapping("/productDetails/{id}")
    public ResponseEntity<ProductDetails> getProductById(@PathVariable(value = "id") Long productDetailsId)
        throws ResourceNotFoundException {
		ProductDetails product = productDetailsRepository.findById(productDetailsId)
          .orElseThrow(() -> new ResourceNotFoundException("Product Details not found for this id :: " + productDetailsId));
        return ResponseEntity.ok().body(product);
    }
	
	@PostMapping("/productDetails")
    public ProductDetails createProductDetails(@Valid @RequestBody ProductDetails productDetails) {
        return productDetailsRepository.save(productDetails);
    }
	
	@PutMapping("/productDetails/{id}")
    public ResponseEntity<ProductDetails> updateProductDetails(@PathVariable(value = "id") Long productDetailsId,
         @Valid @RequestBody ProductDetails productDetailsDetails) throws ResourceNotFoundException {
		ProductDetails productDetails = productDetailsRepository.findById(productDetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("Product Details not found for this id :: " + productDetailsId));

		productDetails.setSize(productDetailsDetails.getSize());
		productDetails.setColour(productDetailsDetails.getColour());
		productDetails.setGender(productDetailsDetails.getGender());
		productDetails.setAgeGroup(productDetailsDetails.getAgeGroup());
        
       
        final ProductDetails updatedProductDetails = productDetailsRepository.save(productDetails);
        return ResponseEntity.ok(updatedProductDetails);
    }
	
	@DeleteMapping("/productDetails/{id}")
    public Map<String, Boolean> deleteProductDetails(@PathVariable(value = "id") Long productDetailsId)
         throws ResourceNotFoundException {
		ProductDetails productDetails = productDetailsRepository.findById(productDetailsId)
       .orElseThrow(() -> new ResourceNotFoundException("Product Details not found for this id :: " + productDetailsId));

		productDetailsRepository.delete(productDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	

}
