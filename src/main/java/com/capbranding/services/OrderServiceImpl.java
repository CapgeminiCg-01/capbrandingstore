package com.capbranding.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbranding.entities.Order;
import com.capbranding.exceptions.OrderNotFoundException;
import com.capbranding.repositories.EmployeeRepository;
import com.capbranding.repositories.LoginRepository;
import com.capbranding.repositories.OrderRepository;



@Service
@Transactional

public class OrderServiceImpl implements OrderService {
	
	@Autowired(required = true)
	OrderRepository orderRepo;

	@Autowired(required = true)
	private LoginRepository loginRepo;

	@Autowired(required = true)
	private EmployeeRepository empRepo;


	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Override
	public Order addOrder(Order order) {
		logger.info("Order addOrder()");
		if(order == null)
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.save(order);
			return order;
		}
	}

	@Override
	public Order updateOrder(Order order) {
		logger.info("Order updateOrder()");
		if(order == null)
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.save(order);
			return order;
		}
	}

	@Override
	public Order removeOrder(int orderId) {
		logger.info("Order removeOrder()");
		Optional<Order> order = orderRepo.findById(orderId);
		if(order.isPresent())
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.delete(order.get());
			return order.get();
		}
	}

	@Override
	public Order viewOrder(Order order) {
		logger.info("Order viewOrder()");
		Optional<Order> orders = orderRepo.findById(order.getOrderId());
		if(orders.isPresent())
			throw new OrderNotFoundException("Order Not Found");
		else {
			orderRepo.delete(orders.get());
			return orders.get();
		}
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) {
		logger.info("Order viewAllOrders()");
		List<Order> orders = orderRepo.viewAllOrderByDate(date);
		if(orders.isEmpty())
			throw new OrderNotFoundException("Order Not Found");
		else
			return orders;
	}

	@Override
	public List<Order> viewAllOrdersByLocation(String location) {
		logger.info("Order viewAllOrdersByLocation()");
		List<Order> list = orderRepo.viewAllEmployeesByLocation(location);
		if(list.isEmpty())
			throw new OrderNotFoundException("Order Not Found");
		else
			return list;

	}

	@Override
	public Order viewAllOrderById(int id) {
		logger.info("Order viewAllOrderByUserId()");;
		Optional<Order> list = orderRepo.findById(id);

		if(!list.isPresent())
			throw new OrderNotFoundException("Order Not Found");
		else
			return list.get();
	}

}
