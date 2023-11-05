package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;

    private String address;

    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max){
        throw new UnsupportedOperationException("This method hasn't been implemented yer.");
    }
}
