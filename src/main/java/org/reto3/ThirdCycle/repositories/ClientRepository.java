package org.reto3.ThirdCycle.repositories;

import org.reto3.ThirdCycle.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
