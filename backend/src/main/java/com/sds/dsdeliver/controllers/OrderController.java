package com.sds.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.dsdeliver.dto.OrderDTO;
import com.sds.dsdeliver.dto.ProductDTO;
import com.sds.dsdeliver.services.OrderService;
import com.sds.dsdeliver.services.ProductService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> list = service.findOrdersWithProducts();
		return ResponseEntity.ok().body(list);		
	}
	
}
