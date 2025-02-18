package net.pepodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pepodev.course.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {}
