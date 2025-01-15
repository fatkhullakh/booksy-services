package com.example.dto;

import lombok.Data;

@Data
public class ShopCreateUpdateDTO {
    private String name;
    private String location;
    private String phoneNumber;
    private String email;
    private String ownerName;
    private int rating;

    public ShopCreateUpdateDTO() {}

    public ShopCreateUpdateDTO(String name, String location, String phoneNumber, String email, String ownerName, int rating) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ownerName = ownerName;
        this.rating = rating;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getRating() {
        return rating;
    }



    //setter

    public void setName(String name) {

        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}




