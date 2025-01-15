package com.example.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ServiceReadDTO {
    private UUID ServiceId;
    private String name;
    private double price;
    private int duration;
    private String serviceType;
    private UUID ShopID;

    public ServiceReadDTO(UUID ServiceId, String name, double price, int duration, String serviceCategory, UUID ShopID) {
        this.ServiceId = ServiceId;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.serviceType = serviceCategory;
        this.ShopID = ShopID;
    }

    // Getters and Setters
    public UUID getServiceId() {
        return ServiceId;
    }

    public void setServiceId(UUID ServiceId) {
        this.ServiceId = ServiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UUID getShopID() { return ShopID; }

    public void setShopID(UUID ShopID) { this.ShopID = ShopID; }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public String getServiceType() { return serviceType; }

    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
}
