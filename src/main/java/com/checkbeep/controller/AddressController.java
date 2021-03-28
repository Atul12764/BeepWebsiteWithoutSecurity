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
import com.checkbeep.model.Address;
import com.checkbeep.repository.AddressRepository;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
	
	@Autowired
    private AddressRepository addressRepository;
	
	@GetMapping("/address")
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
	
	@GetMapping("/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId)
        throws ResourceNotFoundException {
        Address address = addressRepository.findById(addressId)
          .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));
        return ResponseEntity.ok().body(address);
    }
	
	@PostMapping("/address")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }
	
	@PutMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "id") Long addressId,
         @Valid @RequestBody Address addressDetails) throws ResourceNotFoundException {
        Address address = addressRepository.findById(addressId)
        .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

        address.setFullName(addressDetails.getFullName());
        address.setAddress(addressDetails.getAddress());
        address.setPostcode(addressDetails.getPostcode());
        address.setCity(addressDetails.getCity());
        address.setCountry(addressDetails.getCountry());
        address.setMobileNo(addressDetails.getMobileNo());
        address.setIsPermanent(addressDetails.getIsPermanent());
        final Address updatedAddress = addressRepository.save(address);
        return ResponseEntity.ok(updatedAddress);
    }
	
	@DeleteMapping("/address/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long addressId)
         throws ResourceNotFoundException {
        Address address= addressRepository.findById(addressId)
       .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

        addressRepository.delete(address);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
