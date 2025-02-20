package net.pepodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pepodev.course.entities.Product;
import net.pepodev.course.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository rep;
	
	public List<Product> findAll() {
		return rep.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> ProductID = rep.findById(id);
		return ProductID.get();
	}
	
}
