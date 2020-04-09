package com.schroodinger.matomeEngine.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "userPropfile")
public class userAddress extends auditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;

    @NotBlank
    private  String streetNumber;

    public userAddress() {
    }

    public userAddress(@NotBlank String streetNumber, @NotBlank String streetName, @NotBlank String city, @NotBlank String suburb, @NotBlank String country, @NotBlank String postCode, User user) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.suburb = suburb;
        this.country = country;
        this.postCode = postCode;
        this.user = user;
    }


    @NotBlank
    private  String streetName;


    @NotBlank
    private  String city;


    @NotBlank
    private String suburb;


    @NotBlank
    private String country;

    @NotBlank
    private  String postCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//  @JoinColumn(name = "user_id", nullable = false)
//     @JoinTable(name = "userRes", joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "userAddress_id") })
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCountry() {
        return country;
    }



    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
