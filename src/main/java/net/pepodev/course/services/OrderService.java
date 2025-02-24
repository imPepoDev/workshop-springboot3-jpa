package net.pepodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pepodev.course.entities.Order;
import net.pepodev.course.entities.User;
import net.pepodev.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository rep;
	
	public List<Order> findAll() {
		return rep.findAll();
	}
	
	public Order findById(Integer id) {
		Optional<Order> orderID = rep.findById(id);
		return orderID.get();
	}
	
	public Order insert(Order obj) {
		return rep.save(obj);
	}
}
