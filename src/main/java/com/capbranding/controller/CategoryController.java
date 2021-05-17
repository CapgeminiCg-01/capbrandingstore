package com.capbranding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capbranding.entities.Category;
import com.capbranding.repositories.CategoryRepository;


@RestController
@RequestMapping("/onlineshopping")

public class CategoryController {
	
	@Autowired(required = true)
	CategoryRepository categoryRepository;

	@PostMapping("/category")
	public Category addCategory(@RequestBody Category cat) {

		categoryRepository.save(cat);

		return cat;

	}

	@PutMapping("/category")
	public Category updateCategory(@RequestBody Category cat) {
		
		categoryRepository.save(cat);
		return cat;

	}

	@DeleteMapping("/category/{catId}")
	public Category removeCatgory( @PathVariable("catId") int catId) {
		Category cat = categoryRepository.findById(catId).get();
		categoryRepository.deleteById(catId);
		return cat;

	}

	@GetMapping("/category")
	public List<Category> findCat(){
		return categoryRepository.findAll();
	}



}