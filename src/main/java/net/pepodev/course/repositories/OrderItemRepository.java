package net.pepodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pepodev.course.entities.OrderItem;
import net.pepodev.course.entities.pk.OrderItemPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {}
