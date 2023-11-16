package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DealershipFileManager {
    //Nice use of static and a private constructor!
    private DealershipFileManager() {

    }

    public static Dealership getDealership() {
        //Make a file input stream that points to the file that holds my vehicles

        //Make a scanner to take in the file input stream

        //Create Dealership object

        //Loop through the file until there is no more file

        //Take each row, and use the String.split() method to get your data

        //Create a vehicle, from the array, that String.split() returns

        //Take that vehicle and add it to the inventoryList of the Dealership

        //After the loop is finished, return the Dealership

        Dealership dealership = new Dealership("GMC", "123 Whenever St", "935-444-5555");

        boolean continueRunning = true;
        while (continueRunning) {

            try {
                FileInputStream fs = new FileInputStream("src/main/resources/inventory.csv");

                Scanner scanner = new Scanner(fs);

                //skip first Line
                scanner.nextLine();

                String input;
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    String[] dataRow = input.split("\\|");
                    Vehicle vehicle = new Vehicle(Integer.parseInt(dataRow[0]), Integer.parseInt(dataRow[1]), dataRow[2],
                            dataRow[3], dataRow[5], dataRow[4], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));
                    //Why did you comment this out? How is the dealership going to get its vehicles?
                    //dealership.addVehicle(vehicle);

                }
                continueRunning = false;

            } catch (FileNotFoundException ex) {
                System.out.println("Couldn't find the file to read from sorry.");
                continueRunning = false;
            }
        }


            return dealership;
        }
    }








