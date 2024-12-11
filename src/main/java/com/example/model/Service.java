package com.example.model;

import java.io.Serializable;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@Entity
@Table(name = "services")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID serviceId = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "duration", nullable = false)
    private int duration; // in minutes

    @Column(name = "service_category", nullable = false)
    private String serviceCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
