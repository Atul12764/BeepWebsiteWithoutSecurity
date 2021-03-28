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
import com.checkbeep.model.Discount;
import com.checkbeep.repository.DiscountRepository;


@RestController
@RequestMapping("/api/v1")

public class DiscountController {
	
	@Autowired
    private DiscountRepository discountRepository;
	
	@GetMapping("/discount")
    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }
	
	@GetMapping("/discount/{id}")
    public ResponseEntity<Discount> getOrdersById(@PathVariable(value = "id") Long discountId)
        throws ResourceNotFoundException {
        Discount discount = discountRepository.findById(discountId)
          .orElseThrow(() -> new ResourceNotFoundException("Discount not found for this id :: " + discountId));
        return ResponseEntity.ok().body(discount);
    }
	
	@PostMapping("/discount")
    public Discount createDiscount(@Valid @RequestBody Discount discount) {
        return discountRepository.save(discount);
    }
	
	@PutMapping("/discount/{id}")
    public ResponseEntity<Discount> updateDiscount(@PathVariable(value = "id") Long discountId,
         @Valid @RequestBody Discount discountDetails) throws ResourceNotFoundException {
        Discount discount = discountRepository.findById(discountId)
        .orElseThrow(() -> new ResourceNotFoundException("Discount not found for this id :: " + discountId));

        discount.setFullName(discountDetails.getFullName());
        discount.setDiscount(discountDetails.getDiscount());
        discount.setType(discountDetails.getType());
        discount.setDateOfCreation(discountDetails.getDateOfCreation());
        discount.setValidTillDate(discountDetails.getValidTillDate());
        discount.setQuantity(discountDetails.getQuantity());
       
       
        final Discount updatedDiscount = discountRepository.save(discount);
        return ResponseEntity.ok(updatedDiscount);
    }
	
	@DeleteMapping("/discount/{id}")
    public Map<String, Boolean> deleteDiscount(@PathVariable(value = "id") Long discountId)
         throws ResourceNotFoundException {
        Discount discount = discountRepository.findById(discountId)
       .orElseThrow(() -> new ResourceNotFoundException("Discount not found for this id :: " + discountId));

       discountRepository.delete(discount);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
