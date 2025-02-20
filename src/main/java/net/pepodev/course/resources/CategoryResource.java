package net.pepodev.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pepodev.course.entities.Category;
import net.pepodev.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService us;
	
	// Executa a função a baixo conforme a url, no caso, localhost:8080/categories
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = us.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	// Executa a função a baixo conforme a url, no caso, localhost:8080/categories/{id} ( 1,2,3, ... )
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = us.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
