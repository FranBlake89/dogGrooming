package com.mycompany.doggrooming.logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Francisco Castillo
 */
@Entity
public class Owner implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idOwner;
    private String ownerName;
    private String ownerPhone;
    
    public Owner(){
    }

    public Owner(int idOwner, String ownerName, String ownerPhone) {
        this.idOwner = idOwner;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    
    
}
