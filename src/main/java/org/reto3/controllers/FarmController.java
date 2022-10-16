package org.reto3.controllers;


import java.util.List;

import org.reto3.entities.Farm;
import org.reto3.services.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/api/Farm")
public class FarmController {

    //Attributes
    @Autowired
    FarmService farmService;

    //Constructor
    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Farm>> getFarm(){
        return new ResponseEntity<List<Farm>>(this.farmService.getListFarm(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<List<Farm>>  getFarm(@PathVariable("id") int id) {
        return new ResponseEntity<List<Farm>>(this.farmService.getFarmById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Farm>> createFarm(@RequestBody Farm farm){
        return  new ResponseEntity<List<Farm>>(this.farmService.createFarm(farm), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarm(@PathVariable("id") int id){
        this.farmService.deleteFarm(id);
        return new ResponseEntity<String>("Farm has been deleted", HttpStatus.NO_CONTENT);
    }
}

