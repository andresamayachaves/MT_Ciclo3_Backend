package org.reto3.ThirdCycle.repositories;

import org.reto3.ThirdCycle.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
