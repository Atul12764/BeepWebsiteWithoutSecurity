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
import com.checkbeep.model.OrderDetails;
import com.checkbeep.repository.OrderDetailsRepository;

@RestController
@RequestMapping("/api/v1")

public class OrderDetailsController {
	
	@Autowired
    private OrderDetailsRepository orderDetailsRepository;
	
	@GetMapping("/orderDetails")
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }
	
	@GetMapping("/oderDetails/{id}")
    public ResponseEntity<OrderDetails> getOrdersById(@PathVariable(value = "id") Long orderDetailsId)
        throws ResourceNotFoundException {
        OrderDetails orders = orderDetailsRepository.findById(orderDetailsId)
          .orElseThrow(() -> new ResourceNotFoundException("Order Details not found for this id :: " + orderDetailsId));
        return ResponseEntity.ok().body(orders);
    }
	
	@PostMapping("/orderDetails")
    public OrderDetails createOrderDetails(@Valid @RequestBody OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }
	
	@PutMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetails> updateOrderDetails(@PathVariable(value = "id") Long orderDetailsId,
         @Valid @RequestBody OrderDetails orderDetailsDetails) throws ResourceNotFoundException {
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("Orders Details not found for this id :: " + orderDetailsId));

        orderDetails.setProductPrice(orderDetailsDetails.getProductPrice());
        orderDetails.setProductQuantity(orderDetailsDetails.getProductQuantity());
        orderDetails.setSubtotal(orderDetailsDetails.getSubtotal());
       
        final OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);
        return ResponseEntity.ok(updatedOrderDetails);
    }
	
	@DeleteMapping("/orderDetails/{id}")
    public Map<String, Boolean> deleteOrderDetails(@PathVariable(value = "id") Long orderDetailsId)
         throws ResourceNotFoundException {
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
       .orElseThrow(() -> new ResourceNotFoundException("Order Details not found for this id :: " + orderDetailsId));

        orderDetailsRepository.delete(orderDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

	
	

}
