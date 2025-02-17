package net.pepodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.pepodev.course.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {}
