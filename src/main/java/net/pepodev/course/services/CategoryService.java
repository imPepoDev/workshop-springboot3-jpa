package net.pepodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pepodev.course.entities.Category;
import net.pepodev.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository rep;
	
	public List<Category> findAll() {
		return rep.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> CategoryID = rep.findById(id);
		return CategoryID.get();
	}
	
}
