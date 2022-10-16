package org.reto3.controllers;

import org.reto3.entities.Reservation;
import org.reto3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    //Attributes
    @Autowired
    ReservationService resertvationService;

    //Constructor
    public ReservationController(ReservationService resertvationService) {
        this.resertvationService = resertvationService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservation(){
        return new ResponseEntity<List<Reservation>>(this.resertvationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<List<Reservation>>  getReservation(@PathVariable("id") int id) {
        return new ResponseEntity<List<Reservation>>(this.resertvationService.getReservationById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Reservation>> createReservation(@RequestBody Reservation reserv){
        return  new ResponseEntity<List<Reservation>>(this.resertvationService.createReservation(reserv), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") int id){
        this.resertvationService.deleteReservation(id);
        return new ResponseEntity<String>("Reservation has been deleted", HttpStatus.NO_CONTENT);
    }
}
