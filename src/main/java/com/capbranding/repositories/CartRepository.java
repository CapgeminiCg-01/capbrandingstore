package com.capbranding.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capbranding.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	@Query("select c from Cart c where c.employeeCart.employeeId=:employeeId")
	public Cart viewCartByEmployeeId(@Param("employeeId")int employeeId);

}
