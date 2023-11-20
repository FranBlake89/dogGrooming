package com.mycompany.doggrooming.logic;

import com.mycompany.doggrooming.persistence.PersistenceController;
import java.util.List;

/**
 *
 * @author Francisco Castillo
 */

public class Controller {
    
    PersistenceController persisControl = new PersistenceController();

    public void save(String petName, String breed, String color, String obs, String allergies, String specialAt, String ownerName, String phone) {
        //Create Owner and set their values
        Owner owner = new Owner();
        owner.setOwnerName(ownerName);
        owner.setOwnerPhone(phone);
        
        //Create Pet and its values
        Pet pet = new Pet();
        pet.setName(petName);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setObservations(obs);
        pet.setAllergies(allergies);
        pet.setSpecial_attention(specialAt);
        pet.setOwner(owner);
        
        persisControl.save(owner, pet);
        
        
    }

    public List<Pet> getPets() {
        return persisControl.getPets();
    }

    public void deletePet(int client_number) {
        persisControl.deletePet(client_number);
    }

    public Pet getPet(int num_client) {
        return persisControl.getPet(num_client);
    }

    public void editRecord(Pet pet, String petName, String breed, String color, String obs, String allergies, String specialAt, String ownerName, String phone) {
        pet.setName(petName);
        pet.setBreed(breed);
        pet.setColor(color);
        pet.setObservations(obs);
        pet.setAllergies(allergies);
        pet.setSpecial_attention(specialAt);
        
        //Edit Pet
        persisControl.editPet(pet);
        
        //set new values to Owner
        Owner owner = this.findOwner( pet.getOwner().getIdOwner() );        
        owner.setOwnerName(ownerName);
        owner.setOwnerPhone(phone);
        
        this.editOwner(owner);
    }

    private Owner findOwner(int id_Owner) {
       return persisControl.getOwner(id_Owner);
    }

    private void editOwner(Owner owner) {
        persisControl.editOwner(owner);
    }
    


    
}
