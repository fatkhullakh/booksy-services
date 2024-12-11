package com.example.booksy.main;

import com.example.model.Service;
import com.example.model.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataGenerator {

    public static List<Shop> generateShops() {
        // Create Services
        Service haircut = Service.builder()
                .serviceId(UUID.randomUUID())
                .name("Haircut")
                .price(15.0)
                .duration(30) // in minutes
                .serviceCategory("Men's Hair")
                .build();

        Service beardTrim = Service.builder()
                .serviceId(UUID.randomUUID())
                .name("Beard Trim")
                .price(10.0)
                .duration(20)
                .serviceCategory("Men's Grooming")
                .build();

        Service manicure = Service.builder()
                .serviceId(UUID.randomUUID())
                .name("Manicure")
                .price(25.0)
                .duration(45)
                .serviceCategory("Nail Care")
                .build();

        // Create Shops
        Shop barberShop = Shop.builder()
                .shopId((UUID.randomUUID()))
                .name("Barber Shop")
                .location("Downtown")
                .phoneNumber("+123456789")
                .email("contact@barbershop.com")
                .ownerName("John Doe")
                .rating(5) // Rating out of 5
                .services(new ArrayList<>(List.of(haircut, beardTrim)))
                .build();

        Shop beautySalon = Shop.builder()
                .shopId((UUID.randomUUID()))
                .name("Beauty Salon")
                .location("Uptown")
                .phoneNumber("+987654321")
                .email("info@beautysalon.com")
                .ownerName("Jane Smith")
                .rating(4)
                .services(new ArrayList<>(List.of(manicure)))
                .build();

        return List.of(barberShop, beautySalon);
    }
}
