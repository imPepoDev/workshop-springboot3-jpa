package net.pepodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pepodev.course.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
