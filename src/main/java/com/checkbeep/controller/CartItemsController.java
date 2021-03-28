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
import com.checkbeep.model.CartItems;
import com.checkbeep.repository.CartItemsRepository;

@RestController
@RequestMapping("/api/v1")
public class CartItemsController {
	
	@Autowired
    private CartItemsRepository cartItemsRepository;
	
	@GetMapping("/cartItems")
    public List<CartItems> getAllAddress() {
        return cartItemsRepository.findAll();
    }
	
	@GetMapping("/cartItems/{id}")
    public ResponseEntity<CartItems> getAddressById(@PathVariable(value = "id") Long cartItemsId)
        throws ResourceNotFoundException {
        CartItems cartItems = cartItemsRepository.findById(cartItemsId)
          .orElseThrow(() -> new ResourceNotFoundException("Cart Items not found for this id :: " + cartItemsId));
        return ResponseEntity.ok().body(cartItems);
    }
	
	@PostMapping("/cartItems")
    public CartItems createCartItems(@Valid @RequestBody CartItems cartItems) {
        return cartItemsRepository.save(cartItems);
    }
	
	@PutMapping("/cartItems/{id}")
    public ResponseEntity<CartItems> updateCartItems(@PathVariable(value = "id") Long cartItemsId,
         @Valid @RequestBody CartItems cartItemsDetails) throws ResourceNotFoundException {
        CartItems cartItems = cartItemsRepository.findById(cartItemsId)
        .orElseThrow(() -> new ResourceNotFoundException("Cart Items not found for this id :: " + cartItemsId));

        cartItems.setSaved(cartItemsDetails.getSaved());
        cartItems.setQuantity(cartItemsDetails.getQuantity());
        cartItems.setAddedDate(cartItemsDetails.getAddedDate());
        cartItems.setPurchased(cartItemsDetails.getPurchased());
        
        final CartItems updatedCartItems = cartItemsRepository.save(cartItems);
        return ResponseEntity.ok(updatedCartItems);
    }
	
	@DeleteMapping("/cartItems/{id}")
    public Map<String, Boolean> deleteCartItems(@PathVariable(value = "id") Long cartItemsId)
         throws ResourceNotFoundException {
        CartItems cartItems= cartItemsRepository.findById(cartItemsId)
       .orElseThrow(() -> new ResourceNotFoundException("Cart Items not found for this id :: " + cartItemsId));

        cartItemsRepository.delete(cartItems);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	

}
