package net.pepodev.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pepodev.course.entities.User;
import net.pepodev.course.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository rep;
	
	public List<User> findAll() {
		return rep.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> userID = rep.findById(id);
		return userID.get();
	}
	
	public User insert(User obj) {
		return rep.save(obj);
	}
	
	public void delete(Integer id) {
		rep.deleteById(id);
	}
	
	public User update(Integer id, User user) {
		User entity = rep.getReferenceById(id);
		updateData(entity, user);
		return rep.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}
