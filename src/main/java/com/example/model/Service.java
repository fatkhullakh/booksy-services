package com.example.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    private int serviceId;
    private String name;
    private double price;
    private int duration; // in minutes
    private String serviceCategory;
    private int shopId;
}
