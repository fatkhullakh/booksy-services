package com.example.controller;

import com.example.dto.ShopCreateUpdateDTO;
import com.example.dto.ShopReadDTO;
import com.example.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

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
    }
}
