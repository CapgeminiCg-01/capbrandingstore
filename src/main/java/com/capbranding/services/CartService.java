package com.capbranding.services;


import org.springframework.stereotype.Service;

import com.capbranding.entities.Cart;

@Service
public interface CartService {
	
	
		public Cart addCart(Cart cart);
		
		public Cart removeCart(int cartId);

		public Cart viewEmployee(int employeeId);

}