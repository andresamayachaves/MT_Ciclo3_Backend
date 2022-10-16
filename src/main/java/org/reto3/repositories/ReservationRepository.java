package org.reto3.repositories;

import org.reto3.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {
}
