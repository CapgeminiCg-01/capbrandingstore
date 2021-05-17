package com.capbranding.entities;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="cart_details")

public class Cart {
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq", allocationSize=1)
	private int cartId;

	//private Map<Product, Integer>products; // product and quantity 

	//mapping
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
	Set<Product> product= new HashSet<>();


	@OneToOne
	@JoinColumn(name="employee_id")
	private Employee employeeCart;


	public Cart() {
		super();
		
	}


	public Cart(int cartId, Set<Product> product, Employee employeeCart) {
		super();
		this.cartId = cartId;

		this.product = product;
		this.employeeCart = employeeCart;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}





	public Set<Product> getProduct() {
		return product;
	}


	public void setProduct(Set<Product> product) {
		this.product = product;
	}


	public Employee getEmployeeCart() {
		return employeeCart;
	}


	public void setEmployeeCart(Employee employeeCart) {
		this.employeeCart = employeeCart;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", product=" + product + ", employeeCart="
				+ employeeCart + "]";
	}



}
