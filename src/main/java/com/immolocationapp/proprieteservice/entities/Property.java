package com.immolocationapp.proprieteservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PROPERTY_TYPE")
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Property implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String proprietyName;
    private String region;
    private String department;
    private String district;
    private String image;
    private long price;
    private long lessorId;//Bailleur
    protected boolean IsAvailable = false;//true if the propriety is not occupied by somebody

    public Property(String proprietyName, String region, String department, String district, String image, long price, long lessorId, boolean isAvailable) {
        this.proprietyName = proprietyName;
        this.region = region;
        this.department = department;
        this.district = district;
        this.image = image;
        this.price = price;
        this.lessorId = lessorId;
        IsAvailable = isAvailable;
    }
}
