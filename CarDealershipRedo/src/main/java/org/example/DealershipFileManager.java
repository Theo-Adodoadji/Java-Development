package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {
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
                            dataRow[3], dataRow[4], dataRow[5], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));

                    dealership.addVehicle(vehicle);

                }
                scanner.close();


            } catch (FileNotFoundException ex) {
                System.out.println("Couldn't find the file to read from sorry.");
            }



        return dealership;
    }

public static void saveDealership(Dealership dealership){
    try{
        FileWriter fw = new FileWriter("src/main/resources/inventory.csv", true);

        //Write the header
       // String headerRow = String.format("%s|%s|%s %n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
        // fw.write(headerRow);

        for(Vehicle vehicle : dealership.getAllVehicles()){

            String row = String.format("%d|%d|%s|%s|%s|%s|%d|%f \n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                     vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

            // Needs to be formatted this way: Vin|Year|Make|Model|Type|Color|Odometer|Price

            fw.write(row);
        }

        fw.close();
    }
    catch (IOException ex){
        System.out.println("Had a problem writing to the file cuz of: " + ex);
    }
}
}

