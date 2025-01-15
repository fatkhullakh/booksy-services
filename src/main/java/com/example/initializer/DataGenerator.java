package com.example.initializer;

import com.example.model.Shop;
import com.example.model.ServiceEntity;
import com.example.service.ShopService;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.UUID;

@Component
public class DataGenerator {

    private final ShopService shopService;
    private final ServiceService serviceService;

    @Autowired
    public DataGenerator(ShopService shopService, ServiceService serviceService) {
        this.shopService = shopService;
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
        // Create Shop instances
        Shop barberShop = new Shop(UUID.randomUUID(), "Barber Shop", "Downtown", "123456789", "contact@barbershop.com", "John Doe", 5);
        Shop beautySalon = new Shop(UUID.randomUUID(), "Beauty Salon", "Uptown", "+987654321", "info@beautysalon.com", "Jane Smith", 4);

        // Save Shops to the database
        shopService.save(barberShop);
        shopService.save(beautySalon);

        // Create ServiceEntity instances
        ServiceEntity haircut = new ServiceEntity(UUID.randomUUID(), "Haircut", 15.0, 30, "Men's Hair", barberShop);
        ServiceEntity beardTrim = new ServiceEntity(UUID.randomUUID(), "Beard Trim", 10.0, 20, "Men's Grooming", barberShop);
        ServiceEntity manicure = new ServiceEntity(UUID.randomUUID(), "Manicure", 25.0, 45, "Nail Care", beautySalon);

        // Save Services to the database
        serviceService.save(haircut);
        serviceService.save(beardTrim);
        serviceService.save(manicure);
    }
}
