package org.reto3.services;

import org.reto3.entities.Message;
import org.reto3.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MessageService {

    //Attributes
    @Autowired
    private MessageRepository messageRepository;

    //Constructor
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    //CRUD Methods
    public List<Message> getAllMessages(){
        return this.messageRepository.findAll();
    }

    public Message getMessageById(int id) {
        Optional<Message> selectedMessage = this.messageRepository.findById(id);
        if(!selectedMessage.isEmpty()){
            return selectedMessage.get();
        }else{
            return null;
        }
    }

    public Message createMessage(Message newMessage) { return ºthis.messageRepository.save(newMessage);}

    public void updateMessage (int idMessage, Message capturedMessage){
        Optional<Message> messageToUpdate = this.messageRepository.findById(idMessage);
        if(!messageToUpdate.isEmpty()){
                Message messageDB = messageToUpdate.get();
                setAllAtts(messageDB, capturedMessage);
                this.messageRepository.save(messageDB);
        }
    }

    private void setAllAtts(Message fmToUpdate, Message newData){
        if(newData.getIdMessage() != null)       fmToUpdate.setName(newData.getIdMessage());
        if(newData.getMessageText() != null)        fmToUpdate.setAddress(newData.getMessageText());
    }

    public void deleteMessage(int id) {
        if(!this.messageRepository.findById(id).isEmpty())   this.messageRepository.deleteById(id);
    }
}
