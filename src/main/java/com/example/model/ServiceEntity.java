package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode()
@SuperBuilder()
@Data
@Entity
@Table(name = "services")
public class ServiceEntity implements Serializable {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    private Shop shop;


    /*public Service(String name, Double price, int duration, String serviceCategory) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.serviceCategory = serviceCategory;
    } */

    public ServiceEntity(UUID randomUUID, String name, Double price, int duration, String serviceCategory, Shop shop) {
        this.serviceId = randomUUID;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.serviceCategory = serviceCategory;
        this.shop = shop;
    }

    public String name() { return name; }
    public double price() { return price; }
    public int duration() { return duration; }
    public String serviceCategory() { return serviceCategory; }
    public Shop shop() { return shop; }


}
