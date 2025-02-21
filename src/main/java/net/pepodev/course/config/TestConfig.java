package net.pepodev.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import net.pepodev.course.entities.Category;
import net.pepodev.course.entities.Order;
import net.pepodev.course.entities.OrderItem;
import net.pepodev.course.entities.Payments;
import net.pepodev.course.entities.Product;
import net.pepodev.course.entities.User;
import net.pepodev.course.entities.enums.OrderStatus;
import net.pepodev.course.repositories.CategoryRepository;
import net.pepodev.course.repositories.OrderItemRepository;
import net.pepodev.course.repositories.OrderRepository;
import net.pepodev.course.repositories.ProductRepository;
import net.pepodev.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private OrderRepository orderRep;

	@Autowired
	private CategoryRepository categoryRep;
	
	@Autowired
	private ProductRepository prodRep;
	
	@Autowired
	private OrderItemRepository orderItemRep;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Gabriel", "gabriel@gmail.com", "21781838123", "123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "2112512123", "321");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-17T21:26:07Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-08-14T14:15:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		Category cat1 = new Category(null, "Eletronicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		
		Product p1 = new Product(null, "Raio", "Irrita", 150.0, "Ler");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.0, "");
		
		categoryRep.saveAll(Arrays.asList(cat1, cat2, cat3));
		prodRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		
		prodRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		userRep.saveAll(Arrays.asList(u1, u2));
		orderRep.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRep.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payments pay1 = new Payments(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayments(pay1);

		orderRep.save(o1);
	}

}
