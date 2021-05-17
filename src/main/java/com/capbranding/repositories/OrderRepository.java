package com.capbranding.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capbranding.entities.Order;
@Repository

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o where o.orderDate=:orderDate")
	public List<Order> viewAllOrderByDate(@Param("orderDate")LocalDate localdate);

	@Query("select o from Order o where o.employeeOrder.address=:address")
	public List<Order> viewAllEmployeesByLocation(@Param("address")String address);

}
