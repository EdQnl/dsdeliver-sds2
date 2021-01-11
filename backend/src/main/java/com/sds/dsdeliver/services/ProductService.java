package com.sds.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sds.dsdeliver.dto.ProductDTO;
import com.sds.dsdeliver.entities.Product;
import com.sds.dsdeliver.repositories.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	// Sinaliza que trata-se de conexão ao banco. O readOnly evita fazer o locking de escrita.
	@Transactional(readOnly = true)
	public List<ProductDTO> findAllByOrderByNameAsc(){
		List<Product> list = repository.findAll();
		
		// Precisamos retornar uma lista de ProductDTO (estamos transportando para a camada externa)
		// Sendo assim, converte-se para stream para poder usar map que instancia cada p do List
		// para ProductDTO usando o contrutor (que recebe um Product como argumento). Depois, converte-se
		// novamente para List usando collectors.toList()
		
		return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
}
