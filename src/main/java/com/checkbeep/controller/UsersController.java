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
import com.checkbeep.model.Users;
import com.checkbeep.repository.UsersRepository;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
	
	@Autowired
    private UsersRepository usersRepository;
	
	@GetMapping("/users")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
	
	@GetMapping("/users/{id}")
    public ResponseEntity<Users> getOrdersById(@PathVariable(value = "id") Long usersId)
        throws ResourceNotFoundException {
        Users users = usersRepository.findById(usersId)
          .orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));
        return ResponseEntity.ok().body(users);
    }
	
	@PostMapping("/users")
    public Users createEmployee(@Valid @RequestBody Users employee) {
        return usersRepository.save(employee);
    }
	
	@PutMapping("/users/{id}")
    public ResponseEntity<Users> updateEmployee(@PathVariable(value = "id") Long usersId,
         @Valid @RequestBody Users usersDetails) throws ResourceNotFoundException {
        Users users = usersRepository.findById(usersId)
        .orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));

        users.setFirstName(usersDetails.getFirstName());
        users.setLastName(usersDetails.getLastName());
        users.setEmailId(usersDetails.getEmailId());
        users.setDateOfBirth(usersDetails.getDateOfBirth());
        users.setMobileNo(usersDetails.getMobileNo());
        users.setPassword(usersDetails.getPassword());
        users.setDateOfCreation(usersDetails.getDateOfCreation());
        users.setUpdatedDate(usersDetails.getUpdatedDate());
        users.setUserType(usersDetails.getUserType());
        final Users updatedUsers = usersRepository.save(users);
        return ResponseEntity.ok(updatedUsers);
    }
	
	@DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUsers(@PathVariable(value = "id") Long usersId)
         throws ResourceNotFoundException {
        Users users = usersRepository.findById(usersId)
       .orElseThrow(() -> new ResourceNotFoundException("Users not found for this id :: " + usersId));

        usersRepository.delete(users);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}
