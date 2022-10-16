package org.reto3.controllers;

import org.reto3.entities.Client;
import org.reto3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/Client")
public class ClientController {
    //Attributes
    @Autowired
    ClientService clientService;

    //Constructor
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClient(){
        return new ResponseEntity<List<Client>>(this.clientService.getListClient(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<List<Client>>  getClient(@PathVariable("id") int id) {
        return new ResponseEntity<List<Client>>(this.clientService.getClientById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Client>> createClient(@RequestBody Client cl){
        return  new ResponseEntity<List<Client>>(this.clientService.createClient(cl), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") int id){
        this.clientService.deleteClient(id);
        return new ResponseEntity<String>("Client has been deleted", HttpStatus.NO_CONTENT);
    }
}

