package com.example.controller;

import com.example.dto.ServiceCreateUpdateDTO;
import com.example.dto.ServiceReadDTO;
import com.example.model.ServiceEntity;
import com.example.service.ServiceService;
import com.example.service.ShopService;
import com.example.model.Shop;
import com.example.dto.ShopCreateUpdateDTO;
import com.example.dto.ShopReadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    // POST: Create a new service
    @PostMapping
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceCreateUpdateDTO dto) {
        ServiceEntity service = new ServiceEntity(dto.getName(), dto.getPrice(), dto.getDuration(), dto.getServiceCategory(), dto.getShopId());
        return new ResponseEntity<>(serviceService.save(service), HttpStatus.CREATED);
    }

    // GET: Fetch all services
    @GetMapping
    public ResponseEntity<List<ServiceReadDTO>> getAllServices() {
        List<ServiceReadDTO> services = serviceService.findAll().stream()
                .map(service -> {
                    UUID shopId = (service.getShop() != null) ? service.getShop().getShopId() : null;
                    return new ServiceReadDTO(
                            service.getServiceId(),
                            service.getName(),
                            service.getPrice(),
                            service.getDuration(),
                            service.getServiceCategory(),
                            shopId
                    );
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    // PUT: Update an existing service
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable UUID id, @RequestBody ServiceCreateUpdateDTO dto) {
        ServiceEntity existingService = serviceService.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found")); // Replace with a custom exception if needed
        existingService.setName(dto.getName());
        existingService.setPrice(dto.getPrice());
        ServiceEntity updatedService = serviceService.save(existingService);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    // DELETE: Delete a service
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable UUID id) {
        serviceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
