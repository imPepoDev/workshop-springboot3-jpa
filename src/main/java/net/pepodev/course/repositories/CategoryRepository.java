package net.pepodev.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.pepodev.course.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
