package com.sds.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.dsdeliver.dto.OrderDTO;
import com.sds.dsdeliver.entities.Order;
import com.sds.dsdeliver.repositories.OrderRepository;





@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	// Sinaliza que trata-se de conexão ao banco. O readOnly evita fazer o locking de escrita.
	@Transactional(readOnly = true)
	public List<OrderDTO> findOrdersWithProducts(){
		List<Order> list = repository.findAll();
		
		// Precisamos retornar uma lista de ProductDTO (estamos transportando para a camada externa)
		// Sendo assim, converte-se para stream para poder usar map que instancia cada p do List
		// para ProductDTO usando o contrutor (que recebe um Product como argumento). Depois, converte-se
		// novamente para List usando collectors.toList()
		
		return list.stream().map(o -> new OrderDTO(o)).collect(Collectors.toList());
	}
}
