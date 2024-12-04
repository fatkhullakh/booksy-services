package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Shop {
    private int id;
    private String name;
    private String location;
    private String phoneNumber;
    private String email;
    private String ownerName;
    private int rating; // 1 out of 5
    private List<Service> services = new ArrayList<>(); // Default empty list

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", rating=" + rating +
                ", services=" + services +
                '}';
    }
}
