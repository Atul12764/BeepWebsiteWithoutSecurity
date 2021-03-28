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
import com.checkbeep.model.Tags;
import com.checkbeep.repository.TagsRepository;

@RestController
@RequestMapping("/api/v1")


public class TagsController {
	
	@Autowired
    private TagsRepository tagsRepository;
	
	@GetMapping("/tags")
    public List<Tags> getAllOrderDetails() {
        return tagsRepository.findAll();
    }
	
	@GetMapping("/tags/{id}")
    public ResponseEntity<Tags> getTagssById(@PathVariable(value = "id") Long tagsId)
        throws ResourceNotFoundException {
        Tags tags = tagsRepository.findById(tagsId)
          .orElseThrow(() -> new ResourceNotFoundException("Tags not found for this id :: " + tagsId));
        return ResponseEntity.ok().body(tags);
    }
	
	@PostMapping("/tags")
    public Tags createTags(@Valid @RequestBody Tags tags) {
        return tagsRepository.save(tags);
    }
	
	@PutMapping("/tags/{id}")
    public ResponseEntity<Tags> updateTags(@PathVariable(value = "id") Long tagsId,
         @Valid @RequestBody Tags tagsDetails) throws ResourceNotFoundException {
        Tags tags = tagsRepository.findById(tagsId)
        .orElseThrow(() -> new ResourceNotFoundException("Tags Details not found for this id :: " + tagsId));

        tags.setTagName(tagsDetails.getTagName());
        
       
        final Tags updatedTags = tagsRepository.save(tags);
        return ResponseEntity.ok(updatedTags);
    }
	
	@DeleteMapping("/tags/{id}")
    public Map<String, Boolean> deleteTags(@PathVariable(value = "id") Long tagsId)
         throws ResourceNotFoundException {
        Tags tags = tagsRepository.findById(tagsId)
       .orElseThrow(() -> new ResourceNotFoundException("Tags not found for this id :: " + tagsId));

        tagsRepository.delete(tags);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	

}
