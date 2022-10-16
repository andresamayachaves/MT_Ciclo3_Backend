package org.reto3.services;

import org.reto3.entities.Farm;
import org.reto3.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FarmService {

    //Attributes
    @Autowired
    private FarmRepository farmRepository;

    //Constructor
    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }


    //CRUD Methods
    public List<Farm> getListFarm() {return this.farmRepository.findAll();}

    public Farm getFarmById(int id) {
        Optional<Farm> requestedFarm = this.farmRepository.findById(id);
        if(!requestedFarm.isEmpty()){return requestedFarm.get();
        }else{return null; }
    }

    public Farm createFarm(Farm newFarm) {return this.farmRepository.save(newFarm); }

    public void updateFarm (int idFarm, Farm capturedData){
    Optional<Farm> farmToUpdate =  this.farmRepository.findById(idFarm);
        if(!farmToUpdate.isEmpty()) {
            Farm farmDB = farmToUpdate.get();
            setAllAtts(farmDB, capturedData);
            this.farmRepository.save(farmDB);
        }
    }

    private void setAllAtts(Farm fmToUpdate, Farm newData){
        if(newData.getName() != null)       fmToUpdate.setName(newData.getName());
        if(newData.getAddress() != null)        fmToUpdate.setAddress(newData.getAddress());
        if(newData.getDescription() != null)    fmToUpdate.setDescription(newData.getDescription());
        if(newData.getExtension() != null)           fmToUpdate.setExtension(newData.getExtension());
    }

    public void deleteFarm(int id) {  if(!this.farmRepository.findById(id).isEmpty())     this.farmRepository.deleteById(id); }
}