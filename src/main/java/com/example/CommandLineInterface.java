package com.example;

import com.example.model.ServiceEntity;
import com.example.model.Shop;
import com.example.service.ServiceService;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandLineInterface implements CommandLineRunner {

    private final ShopService shopService;
    private final ServiceService serviceService;

    @Autowired
    public CommandLineInterface(ShopService shopService, ServiceService serviceService) {
        this.shopService = shopService;
        this.serviceService = serviceService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a command:");
            System.out.println("1. List all shops");
            System.out.println("2. List all services");
            System.out.println("3. Add a new shop");
            System.out.println("4. Add a new service");
            System.out.println("5. Delete a shop by UUID");
            System.out.println("6. Delete a service by UUID");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Shop> shops = shopService.findAll();
                    shops.forEach(System.out::println);
                    break;
                case 2:
                    List<ServiceEntity> services = serviceService.findAll();
                    services.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter shop name:");
                    String shopName = scanner.nextLine();
                    System.out.println("Enter shop location:");
                    String shopLocation = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter owner name:");
                    String ownerName = scanner.nextLine();
                    System.out.println("Enter rating (1-5):");
                    int rating = scanner.nextInt();
                    scanner.nextLine();
                    Shop shop = new Shop(UUID.randomUUID(), shopName, shopLocation, phoneNumber, email, ownerName, rating);
                    shopService.save(shop);
                    break;
                case 4:
                    System.out.println("Enter service name:");
                    String serviceName = scanner.nextLine();
                    System.out.println("Enter service price:");
                    double price = scanner.nextDouble();
                    System.out.println("Enter service duration (in minutes):");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter service category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter shop UUID:");
                    String shopId = scanner.nextLine();
                    Shop parentShop = shopService.findById(UUID.fromString(shopId)).orElse(null);
                    if (parentShop == null) {
                        System.out.println("Shop not found. Cannot add service.");
                        break;
                    }
                    ServiceEntity service = new ServiceEntity(UUID.randomUUID(), serviceName, price, duration, category, parentShop);
                    serviceService.save(service);
                    break;
                case 5:
                    System.out.println("Enter the UUID of the shop to delete:");
                    String shopUuid = scanner.nextLine();
                    shopService.deleteById(UUID.fromString(shopUuid));
                    break;
                case 6:
                    System.out.println("Enter the UUID of the service to delete:");
                    String serviceUuid = scanner.nextLine();
                    serviceService.deleteById(UUID.fromString(serviceUuid));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
