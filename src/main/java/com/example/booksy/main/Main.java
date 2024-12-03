package com.example.booksy.main;

import com.example.model.Service;
import com.example.model.Shop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Services
        Service haircut = Service.builder()
                .serviceId(1)
                .name("Haircut")
                .price(15.0)
                .build();

        Service beardTrim = Service.builder()
                .serviceId(2)
                .name("Beard Trim")
                .price(10.0)
                .build();

        Service manicure = Service.builder()
                .serviceId(3)
                .name("Manicure")
                .price(25.0)
                .build();

        // Create Shops
        Shop barberShop = Shop.builder()
                .id(1)
                .name("Barber Shop")
                .location("Downtown")
                .ownerName("John Doe")
                .services(new ArrayList<>(List.of(haircut, beardTrim)))
                .build();

        Shop beautySalon = Shop.builder()
                .id(2)
                .name("Beauty Salon")
                .location("Uptown")
                .ownerName("Jane Smith")
                .services(new ArrayList<>(List.of(manicure)))
                .build();

        // Print Shops and Services
        List<Shop> shops = List.of(barberShop, beautySalon);
        for (Shop shop : shops) {
            System.out.println("Shop: " + shop.getName() + ", Location: " + shop.getLocation());
            System.out.println("Services:");
            for (Service service : shop.getServices()) {
                System.out.println("  - " + service.getName() + " ($" + service.getPrice() + ")");
            }
            System.out.println();
        }
    }
}
