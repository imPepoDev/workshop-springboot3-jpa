package net.pepodev.course.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.pepodev.course.entities.Order;
import net.pepodev.course.entities.User;
import net.pepodev.course.entities.enums.OrderStatus;
import net.pepodev.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService us;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = us.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id) {
		Order obj = us.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	

}
