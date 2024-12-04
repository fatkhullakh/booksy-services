package com.example.booksy.main;

import com.example.model.Service;
import com.example.model.ServiceDTO;
import com.example.model.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

public class Main {
    public static void main(String[] args) {
        // Create Services
        Service haircut = Service.builder()
                .serviceId(1)
                .name("Haircut")
                .price(15.0)
                .duration(30) // Duration in minutes
                .serviceCategory("Men's Hair")
                .build();

        Service beardTrim = Service.builder()
                .serviceId(2)
                .name("Beard Trim")
                .price(10.0)
                .duration(20)
                .serviceCategory("Men's Grooming")
                .build();

        Service manicure = Service.builder()
                .serviceId(3)
                .name("Manicure")
                .price(25.0)
                .duration(45)
                .serviceCategory("Nail Care")
                .build();

        // Create Shops
        Shop barberShop = Shop.builder()
                .id(1)
                .name("Barber Shop")
                .location("Downtown")
                .phoneNumber("+123456789")
                .email("contact@barbershop.com")
                .ownerName("John Doe")
                .rating(5) // Rating out of 5
                .services(new ArrayList<>(List.of(haircut, beardTrim)))
                .build();

        Shop beautySalon = Shop.builder()
                .id(2)
                .name("Beauty Salon")
                .location("Uptown")
                .phoneNumber("+987654321")
                .email("info@beautysalon.com")
                .ownerName("Jane Smith")
                .rating(4)
                .services(new ArrayList<>(List.of(manicure)))
                .build();

        // Print Shops and Services
        List<Shop> shops = List.of(barberShop, beautySalon);
        for (Shop shop : shops) {
            System.out.println("Shop: " + shop.getName() + ", Location: " + shop.getLocation());
            System.out.println("Owner: " + shop.getOwnerName() + ", Rating: " + shop.getRating());
            System.out.println("Contact: " + shop.getPhoneNumber() + ", Email: " + shop.getEmail());
            System.out.println("Services:");
            for (Service service : shop.getServices()) {
                System.out.println("  - " + service.getName() + " ($" + service.getPrice() +
                        ", " + service.getDuration() + " mins, " + service.getServiceCategory() + ")");
            }
            System.out.println();
        }
    }




}
