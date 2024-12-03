package com.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Service {
    private int serviceId;
    private String name;
    private double price;
    private int duration;
    private String ServiceCategory;
    private int shopId;
}
