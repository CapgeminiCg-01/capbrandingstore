package com.capbranding.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capbranding.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.cart.cartId=:cartId")
    public List<Product> viewAllProductsByCart(@Param("cartId")int cartId);
   
    @Query("select p from Product p where p.category.catId=:catId")
    public List<Product> viewAllProductsByCategory(@Param("catId")int catId);

}