package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = "services", callSuper = true)
@EqualsAndHashCode()
@SuperBuilder()
@Data
@Entity
@Table(name = "shops")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID  shopId = randomUUID();

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

    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ServiceEntity> services = new ArrayList<>();

    /*public Shop(String name, String location, String phoneNumber, String email, int rating) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.rating = rating;
    } */

    public Shop(UUID randomUUID, String name, String location, String phoneNumber, String email, String ownerName, int rating) {
        this.shopId = randomUUID();
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ownerName = ownerName;
        this.rating = rating;
    }

    public String getName() { return name; }

    public String getLocation() { return location; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getEmail() { return email; }

    public String getOwnerName() { return ownerName; }

    public int getRating() { return rating; }

    /*public static void saveToFile(List<Shop> shops, String fileName) {
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
    } */
}
