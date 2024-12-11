package com.example.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jakarta.persistence.*;
import java.util.UUID;

@Data
@Builder
@ToString
@NoArgsConstructor
@Entity
@Table(name = "shops")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID  shopId = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "rating", nullable = false)
    private int rating; // 1 out of 5

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Service> services = new ArrayList<>();

    public static void saveToFile(List<Shop> shops, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(shops);
            System.out.println("Shops saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Shop> readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Shop>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
