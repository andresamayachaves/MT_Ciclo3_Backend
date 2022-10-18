package org.reto3.ThirdCycle.repositories;

import org.reto3.ThirdCycle.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepository  extends JpaRepository<Farm, Integer> {
}
