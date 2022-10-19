package com.immolocationapp.proprieteservice.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@Data @DiscriminatorValue("Shop")
@Builder
public class Shop extends Property implements Serializable {
    public Shop() {

    }

    public Shop( String proprietyName, String region, String department, String district, String image, long price, long BailleurId, boolean IsDisponible) {
        super( proprietyName, region, department, district, image, price, BailleurId, IsDisponible);
    }
}
