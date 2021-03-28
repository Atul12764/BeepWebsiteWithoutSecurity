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
import com.checkbeep.model.Payment;
import com.checkbeep.repository.PaymentRepository;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
	

	@Autowired
    private PaymentRepository paymentRepository;
	
	@GetMapping("/payment")
    public List<Payment> getAllAddress() {
        return paymentRepository.findAll();
    }
	
	@GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getAddressById(@PathVariable(value = "id") Long paymentId)
        throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
          .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + paymentId));
        return ResponseEntity.ok().body(payment);
    }
	
	@PostMapping("/payment")
    public Payment createPayment(@Valid @RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }
	
	@PutMapping("/payment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable(value = "id") Long paymentId,
         @Valid @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
        Payment payment = paymentRepository.findById(paymentId)
        .orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + paymentId));

        payment.setPaymentMode(paymentDetails.getPaymentMode());
        payment.setPaymentDate(paymentDetails.getPaymentDate());
        payment.setAmount(paymentDetails.getAmount());
        final Payment updatedPayment = paymentRepository.save(payment);
        return ResponseEntity.ok(updatedPayment);
    }
	
	@DeleteMapping("/payment/{id}")
    public Map<String, Boolean> deletePayment(@PathVariable(value = "id") Long paymentId)
         throws ResourceNotFoundException {
        Payment payment= paymentRepository.findById(paymentId)
       .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + paymentId));

        paymentRepository.delete(payment);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	

}
