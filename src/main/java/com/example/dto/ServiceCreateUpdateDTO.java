package com.example.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ServiceCreateUpdateDTO {
    private String name;
    private double price;
    private int duration;
    private String ServiceCategory;
    private UUID ShopId;

    public ServiceCreateUpdateDTO() {}

    public ServiceCreateUpdateDTO(String name, double price, int duration, String ServiceCategory, UUID ShopId) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.ServiceCategory = ServiceCategory;
        this.ShopId = ShopId;
    }

    // Getters and Setters
    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getShopId() { return ShopId; }

    public void setShopId(UUID ShopId) { this.ShopId = ShopId; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public String getServiceCategory() { return ServiceCategory; }

    public void setServiceCategory(String ServiceCategory) { this.ServiceCategory = ServiceCategory; }
}