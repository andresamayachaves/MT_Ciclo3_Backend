package org.reto3.ThirdCycle.repositories;

import org.reto3.ThirdCycle.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {
    public List<Reservation> findByStartDateBetween(Date start, Date end);
    //public List<Reservation> findByStatus(String status);
}
