package com.capbranding.controller;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
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

import com.capbranding.entities.Order;
import com.capbranding.repositories.OrderRepository;
import com.capbranding.services.OrderService;

@RestController
@RequestMapping("/onlineshopping")

public class OrderController {
	
	@Autowired(required = true)
	OrderService orderService;
	@Autowired(required = true)
	OrderRepository orderRepo;

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) 
	{
		logger.info("Order addOrder()");
		orderService.addOrder(order);
		return order;

	}

	@PutMapping("/order")
	public Order updateOrder(@RequestBody Order order) {
		logger.info("Order updateOrder()");
		orderService.updateOrder(order);
		return order;

	}

	@GetMapping("/order")
	public List<Order> viewAllOrder(){
		logger.info("Order viewAllOrders()");
		return orderRepo.findAll();
	}
	
   

	@DeleteMapping("/order/orderId")
	public Order removeOrder(@PathVariable("orderId") int orderId) {
		logger.info("Order removeOrder()");
		return orderService.removeOrder(orderId);
	}


}
