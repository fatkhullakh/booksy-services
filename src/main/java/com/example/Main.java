package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import static com.example.model.Shop.readFromFile;
//import static com.example.model.Shop.saveToFile;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
    /*for (Shop shop : shops) {
            System.out.println("Shop: " + shop.getName() + ", Location: " + shop.getLocation());
            System.out.println("Owner: " + shop.getOwnerName() + ", Rating: " + shop.getRating());
            System.out.println("Contact: " + shop.getPhoneNumber() + ", Email: " + shop.getEmail());
            System.out.println("Services:");
            for (Service service : shop.getServices()) {
                System.out.println("  - " + service.getName() + " ($" + service.getPrice() +
                        ", " + service.getDuration() + " mins, " + service.getServiceCategory() + ")");
            }
            System.out.println();
        } */
    /* Transform services into DTOs
        System.out.println("Services (as DTOs):");
        for (Shop shop : shops) {
            for (Service service : shop.getServices()) {
                // Convert Service to ServiceDTO
                ServiceDTO dto = toDTO(service, shop.getName());
                // Print the DTO
                System.out.println(dto);
            }
        } */
    /*
        List<Shop> shops = DataGenerator.generateShops();
        // 3. unique services into a Set
        Set<Service> uniqueServices = shops.stream()
                .flatMap(shop -> shop.getServices().stream())
                .collect(Collectors.toSet());

        // print
        System.out.println("3. Unique Services:");
        uniqueServices.forEach(service ->
                System.out.println(service.getName() + " ($" + service.getPrice() + ", " + service.getDuration() + " mins)"));


        // 4. Filter and sort services
        List<Service> filteredAndSortedServices = uniqueServices.stream()
                .filter(service -> service.getPrice() > 10)
                .sorted(Comparator.comparingInt(Service::getDuration))
                .collect(Collectors.toList());

        // printing
        System.out.println("4. Filtered and Sorted Services:");
        filteredAndSortedServices.forEach(service ->
                System.out.println(service.getName() + " ($" + service.getPrice() + ", " + service.getDuration() + " mins)"));

        // 5. Transform into DTOs
        Map<Service, String> serviceToShopMap = new HashMap<>();
        for (Shop shop : shops) {
            for (Service service : shop.getServices()) {
                serviceToShopMap.put(service, shop.getName());
            }
        }

        List<ServiceDTO> serviceDTOs = uniqueServices.stream()
                .map(service -> toDTO(service, serviceToShopMap.get(service)))
                .sorted() // natural order
                .toList();

        System.out.println("5. Unique ServiceDTOs:");
        for (ServiceDTO serviceDTO : serviceDTOs) {
            System.out.println(serviceDTO);
        }

        // 6. Task to save to file
        String fileName = "shops.bin";
        saveToFile(shops, fileName);

        List<Shop> deserializedShops = readFromFile(fileName);

        System.out.println("6. Deserialized Shops:");
        deserializedShops.forEach(System.out::println);


        // 7. Thread Pool
        ForkJoinPool customThreadPool = new ForkJoinPool(4);

        try {
            customThreadPool.submit(() ->
                    shops.parallelStream().forEach(shop -> simulateWorkload(shop))
            ).get(); // Wait for completion
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        } */
    /*public static ServiceDTO toDTO(Service service, String shopName) {
        return ServiceDTO.builder()
                .name(service.getName())
                .price(service.getPrice())
                .duration(service.getDuration())
                .shopName(shopName)
                .build();
    }

    public static void simulateWorkload(Shop shop) {
        shop.getServices().forEach(service -> {
            try {
                // Simulate heavy work
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " processed " + service.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    } */
}

