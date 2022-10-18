package org.reto3.ThirdCycle.repositories;

import org.reto3.ThirdCycle.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository  extends JpaRepository<Message, Integer> {
}
