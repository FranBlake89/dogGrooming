package com.mycompany.doggrooming.persistence;

import com.mycompany.doggrooming.logic.Owner;
import com.mycompany.doggrooming.logic.Pet;
import com.mycompany.doggrooming.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco Castillo
 */
public class PersistenceController {
    
    OwnerJpaController ownerJpa = new OwnerJpaController();
    PetJpaController petJpa = new PetJpaController();

    public void save(Owner owner, Pet pet) {
       //Create in DB the owner
        ownerJpa.create(owner);
        
        //Create in DB the pet
        petJpa.create(pet);
    }

    public List<Pet> getPets() {
        return petJpa.findPetEntities();
    }

    public void deletePet(int client_number) {
        
        try {
            petJpa.destroy(client_number);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

    public Pet getPet(int num_client) {
        return petJpa.findPet(num_client);
    }

    public void editPet(Pet pet) {
        try {
            petJpa.edit(pet);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Owner getOwner(int id_Owner) {
        return ownerJpa.findOwner(id_Owner);
    }

    public void editOwner(Owner owner) {
        try {
            ownerJpa.edit(owner);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
