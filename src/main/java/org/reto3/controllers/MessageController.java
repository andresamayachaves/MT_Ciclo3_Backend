package org.reto3.controllers;

import org.reto3.entities.Message;
import org.reto3.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    //Attributes
    @Autowired
    MessageService messageServiceService;

    //Constructor
    public MessageController(MessageService messageServiceService) {
        this.messageServiceService = MessageController.this.messageServiceService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Message>> getMessage(){
        return new ResponseEntity<List<Message>>(this.messageServiceService.getListMessage(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<List<Message>>  getMessage(@PathVariable("id") int id) {
        return new ResponseEntity<List<Message>>(this.messageServiceService.getMessageById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Message>> createMessage(@RequestBody Message message){
        return  new ResponseEntity<List<Message>>(this.messageServiceService.createMessage(message), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMessage(@PathVariable("id") int id){
        this.messageServiceService.deleteMessage(id);
        return new ResponseEntity<String>("Message has been deleted", HttpStatus.NO_CONTENT);
    }
}
