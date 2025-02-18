package net.pepodev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import net.pepodev.course.entities.Order;
import net.pepodev.course.entities.User;
import net.pepodev.course.entities.enums.OrderStatus;
import net.pepodev.course.repositories.OrderRepository;
import net.pepodev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private OrderRepository orderRep;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Gabriel", "gabriel@gmail.com", "21781838123", "123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "2112512123", "321");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-17T21:26:07Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-08-14T14:15:07Z"),OrderStatus.WAITING_PAYMENT, u1);

		userRep.saveAll(Arrays.asList(u1, u2));
		orderRep.saveAll(Arrays.asList(o1, o2, o3));

	}

}
