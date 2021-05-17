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

import com.capbranding.entities.Cart;
import com.capbranding.repositories.CartRepository;
import com.capbranding.services.CartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/onlineshopping")
public class CartController {
	
	@Autowired(required = true)
	CartService cartService;
	
	@Autowired(required = true)
	CartRepository cartRepo;

	Logger logger = LoggerFactory.getLogger(CartController.class);


	@PostMapping("/cart")
	
	public Cart addCart(@RequestBody Cart cart)
	{
		logger.info("Cart addCart()");
		return cartService.addCart(cart);
	}

	@DeleteMapping("/cartId{cartId}")
	public Cart removeCart(@PathVariable("cartId") int cartId)
	{
		logger.info("Cart removeCart()");
		return cartService.removeCart(cartId);
	}

	@GetMapping("/cart/{employeeId}")
	public Cart viewAllEmployee(@PathVariable("employeeId")int employeeId)
	{
		logger.info("Cart viewEmployee()");
		return cartService.viewEmployee(employeeId);
	}

}