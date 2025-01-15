package com.example.dto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ShopReadDTO {
    private UUID ShopId;
    private String name;

    public ShopReadDTO() {}

    public ShopReadDTO(UUID shopId, String name) {
        this.ShopId = shopId;
        this.name = name;
    }

    // Getters and Setters
    public UUID getShopId() { return ShopId; }

    public void setShopId(UUID shopId) { ShopId = shopId; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

}
