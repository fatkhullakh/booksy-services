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
    private String ownerName;
    private List<Service> services = new ArrayList<>();
}
