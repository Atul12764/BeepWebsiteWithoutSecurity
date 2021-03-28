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
import com.checkbeep.model.Category;
import com.checkbeep.repository.CategoryRepository;


@RestController
@RequestMapping("/api/v1")


public class CategoryController {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
	
	@GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId)
        throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
          .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));
        return ResponseEntity.ok().body(category);
    }
	
	@PostMapping("/category")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }
	
	@PutMapping("/category/{id}")
    public ResponseEntity<Category> updateDiscount(@PathVariable(value = "id") Long categoryId,
         @Valid @RequestBody Category categoryDetails) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

        category.setCategoryName(categoryDetails.getCategoryName());
        category.setCategoryImage(categoryDetails.getCategoryImage());
        category.setCategoryDescription(categoryDetails.getCategoryDescription());
        
       
       
        final Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }
	
	@DeleteMapping("/category/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId)
         throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId)
       .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + categoryId));

       categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
