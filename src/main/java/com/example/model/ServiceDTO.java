package com.example.model;

import lombok.Data;
import lombok.Builder;


@Data
@Builder
public class ServiceDTO {
    private String serviceName;
    private double price;
    private int duration;
    private String shopName;
}
