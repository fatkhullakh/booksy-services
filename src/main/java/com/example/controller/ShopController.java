package com.example.controller;

import com.example.dto.ServiceReadDTO;
import com.example.dto.ShopCreateUpdateDTO;
import com.example.dto.ShopReadDTO;
import com.example.model.Shop;
import com.example.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody ShopCreateUpdateDTO dto) {
        Shop shop = new Shop(dto.getName(), dto.getLocation(), dto.getPhoneNumber(), dto.getEmail(), dto.getOwnerName(),dto.getRating());
        return new ResponseEntity<>(shopService.save(shop), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShopReadDTO>> getAllShops() {
        List<ShopReadDTO> shops = shopService.findAll().stream()
                .map(shop -> new ShopReadDTO(shop.getShopId(), shop.getName()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    // PUT: Update an existing shop
    @PutMapping("/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable UUID id, @RequestBody ShopCreateUpdateDTO dto) {
        Shop existingShop = shopService.findById(id)
                .orElseThrow(() -> new RuntimeException("Shop not found")); // Replace with a custom exception if needed
        existingShop.setName(dto.getName());
        existingShop.setLocation(dto.getLocation());
        existingShop.setPhoneNumber(dto.getPhoneNumber());
        existingShop.setEmail(dto.getEmail());
        existingShop.setOwnerName(dto.getOwnerName());
        existingShop.setRating(dto.getRating());
        Shop updatedShop = shopService.save(existingShop);
        return new ResponseEntity<>(updatedShop, HttpStatus.OK);
    }

    // DELETE: Delete a shop
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable UUID id) {
        shopService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{shopId}/services")
    public ResponseEntity<List<ServiceReadDTO>> getServicesByShop(@PathVariable UUID shopId) {
        Shop shop = shopService.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found"));
        List<ServiceReadDTO> services = shop.getServices().stream()
                .map(service -> new ServiceReadDTO(service.getServiceId(), service.getName(), service.getPrice(), service.getDuration(), service.getServiceCategory(), shopId))
                .collect(Collectors.toList());
        return ResponseEntity.ok(services);
    }








    /* private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<ShopReadDTO> createShop(@RequestBody ShopCreateUpdateDTO shopCreateUpdateDTO) {
        ShopReadDTO shop = shopService.createShop(shopCreateUpdateDTO);
        return new ResponseEntity<>(shop, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopReadDTO> updateShop(@PathVariable Long id, @RequestBody ShopCreateUpdateDTO shopCreateUpdateDTO) {
        ShopReadDTO updatedShop = shopService.updateShop(id, shopCreateUpdateDTO);
        return ResponseEntity.ok(updatedShop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopReadDTO> getShopById(@PathVariable Long id) {
        ShopReadDTO shop = shopService.getShopById(id);
        return ResponseEntity.ok(shop);
    }

    @GetMapping
    public ResponseEntity<List<ShopReadDTO>> getAllShops() {
        List<ShopReadDTO> shops = shopService.getAllShops();
        return ResponseEntity.ok(shops);
    } */
}
