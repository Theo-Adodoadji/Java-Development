package org.example;

import java.util.ArrayList;
import java.util.List;

//This class is going to need a LOT more work. Why didn't you stub out the methods
//as they were laid out in the UML diagram? You didn't have to fill in all the logic.
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
