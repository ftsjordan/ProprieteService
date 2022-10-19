package com.immolocationapp.proprieteservice.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data @DiscriminatorValue("Apartment")

public class Apartment extends Property implements Serializable {
    private int nbBedrooms = 1;
    private int nbShowers = 1;

    public Apartment(){
        super();
    }


    public Apartment(String proprietyName, String region, String department, String district, String image, long price, long BailleurId, boolean IsDisponible, int nbBedrooms, int nbShowers) {
        super(proprietyName, region, department, district, image, price, BailleurId, IsDisponible);
        this.nbBedrooms = nbBedrooms;
        this.nbShowers = nbShowers;
    }
}
