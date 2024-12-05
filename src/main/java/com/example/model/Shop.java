package com.example.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@ToString
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String location;
    private String phoneNumber;
    private String email;
    private String ownerName;
    private int rating; // 1 out of 5
    private List<Service> services = new ArrayList<>(); // by default empty

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
