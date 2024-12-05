package com.example.model;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.util.Comparator;

@Data
@Builder
public class ServiceDTO implements Comparable<ServiceDTO> {
    private String name;
    private double price;
    private int duration;
    private String shopName;

    @Override
    public int compareTo(ServiceDTO other) {
        return this.name.compareTo(other.name);
    }

}


