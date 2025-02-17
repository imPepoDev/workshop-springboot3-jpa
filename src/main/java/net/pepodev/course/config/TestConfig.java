package net.pepodev.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import net.pepodev.course.entities.User;
import net.pepodev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRep;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Gabriel", "gabriel@gmail.com", "21781838123", "123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "2112512123", "321");
		
		userRep.saveAll(Arrays.asList(u1, u2));
	}
	
}
