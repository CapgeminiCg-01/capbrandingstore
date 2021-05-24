package com.capbranding.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capbranding.entities.Product;
import com.capbranding.services.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/onlineshopping")

public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired(required = true)
	ProductService productService;

	@PostMapping("/product")
	public Product addProduct(@Valid@RequestBody Product product) {

		logger.info("Entered addProduct");

		return productService.addProduct(product);

	}
	
	@PutMapping("/product")
	public Product updateProduct(@Valid@RequestBody Product product)
	{
		logger.info("Entered updatedProducts");

		return productService.updateProduct(product);
	}

	@GetMapping("/product/{productId}")
	public Product viewProductById(@PathVariable("productId") int prodId)
	{
		logger.info("Entered viewProductById");

		return productService.viewProduct(prodId);
	}


	@DeleteMapping("/product/{prodId}")
	public Product removeProduct(@PathVariable("prodId") int prodId)
	{
		logger.info("removeProduct");

		return productService.removeProduct(prodId);
	}

}
