package org.example;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    public void display() {
        System.out.println("Welcome to the car dealership app, what would you like to do?");
        System.out.println("1) Find vehicles within a price range");
        System.out.println("2) Find vehicles by make/model");
        System.out.println("3) Find vehicles by year range");
        System.out.println("4) Find vehicles by color");
        System.out.println("5) Find vehicles by mileage range");
        System.out.println("6) Find vehicles by type");
        System.out.println("7) List ALL vehicles");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicle");
        System.out.println("10) Quit");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        switch (userInput) {
            case 0:
                //save all changes
                //DealershipFileManager.saveDealership(dealership);
                System.exit(0);
                break;

            case 1:
                processGetByPriceRequest();
                break;
            case 2:
                processGetByMakeModelRequest();
                break;
            case 3:
                processGetByYearRequest();
                break;
            case 4:
                processGetByColorRequest();
                break;
            case 5:
                processGetByMileageRequests();
                break;
            case 6:
                processGetByVehicleTypeRequest();
                break;
            case 7:
                processGetAllVehicleRequest();
                break;
            case 8:
                processAddVehicleRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
            case 10:
                System.exit(0);
                break;

            default:
                System.out.println("This isn't an option. Sorry, try again.");
                break;

        }
    }

    public void processGetAllVehicleRequest() {
        //We will list all vehicles in the dealership with this method
        //1) call the dealership's getAllVehicles method 2)call the display Vehicles()
        //helper method passing it the list returned from getAllVehicles()
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");

            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                System.out.println(input);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }
    }

    public void processGetByPriceRequest() {
        System.out.println("What price range would you like to search the cars for? ");
        System.out.println("1) Less than 1,000");
        System.out.println("2) 1,000-5,000");
        System.out.println("3) 5,000-10,000");
        System.out.println("4) 10,000-15,000");
        System.out.println("5) 15,000-20000");
        System.out.println("6) 20,000-30,000");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        //Trying to make a series of loops so that file can print ranges of prices that I want
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            // Skip the header line
            if (banner.hasNextLine()) {
                banner.nextLine();
            }

            String input;
            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    double carPrice = Double.parseDouble(carList[7]); // Parse the price from the CSV
                    // Assuming the make is in the third column,
                    //Parse the price fromm the CSV element 7

                    switch (userInput) {
                        case 1:
                            if (carPrice < 1000) {
                                System.out.println(input);
                            }
                            break;
                        case 2:
                            if (carPrice >= 1000 && carPrice <= 5000) {
                                System.out.println(input);
                            }
                            break;
                        case 3:
                            if (carPrice >= 5000 && carPrice <= 10000) {
                                System.out.println(input);
                            }
                            break;
                        case 4:
                            if (carPrice >= 10000 && carPrice <= 15000) {
                                System.out.println(input);
                            }
                            break;
                        case 5:
                            if (carPrice >= 15000 && carPrice <= 20000) {
                                System.out.println(input);
                            }
                            break;
                        case 6:
                            if (carPrice >= 20000 && carPrice <= 30000) {
                                System.out.println(input);
                            }
                            break;
                        default:
                            System.out.println("This isn't an option. Sorry, try again.");
                            break;
                    }
                }

            }
            fileInputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        } catch (IOException ex) {
            System.out.println("Error reading the file.");
        }
    }


    public void processGetByMakeModelRequest() {
        System.out.println("Which car make would you like to search by?");

        Scanner scanner = new Scanner(System.in);
        String userInputMake = scanner.next();
        scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    String carListLine = carList[2]; // Assuming the make is in the third column

                    if (userInputMake.equalsIgnoreCase(carListLine)) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }

    }

    public void processGetByYearRequest() {
        System.out.println("Which car year would you like to search by?");

        Scanner scanner = new Scanner(System.in);
        String userInputMake = scanner.next();
        scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    String carListLine = carList[1]; // Assuming the year is in the second column

                    if (userInputMake.equalsIgnoreCase(carListLine)) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }

    }


    public void processGetByColorRequest() {
        System.out.println("Which car color would you like to search by?");

        Scanner scanner = new Scanner(System.in);
        String userInputMake = scanner.next();
        scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    String carListLine = carList[4]; // Assuming the color is in the fifth column

                    if (userInputMake.equalsIgnoreCase(carListLine)) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }

    }


    public void processGetByMileageRequests() {
        System.out.println("What mileage range would you like to search the cars for? ");
        System.out.println("1) Less than 10,000");
        System.out.println("2) 10,000-50,000");
        System.out.println("3) 50,000-100,000");
        System.out.println("4) 100,000-200,000");
        System.out.println("5) 200,000-600000");


        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        //Trying to make a series of loops so that file can print ranges of prices that I want
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            // Skip the header line
            if (banner.hasNextLine()) {
                banner.nextLine();
            }

            String input;
            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    double carMileage = Double.parseDouble(carList[6]); // Parse the price from the CSV
                    // Assuming the make is in the third column,
                    //Parse the price fromm the CSV element 6

                    switch (userInput) {
                        case 1:
                            if (carMileage < 10000) {
                                System.out.println(input);
                            }
                            break;
                        case 2:
                            if (carMileage >= 10000 && carMileage <= 50000) {
                                System.out.println(input);
                            }
                            break;
                        case 3:
                            if (carMileage >= 50000 && carMileage <= 100000) {
                                System.out.println(input);
                            }
                            break;
                        case 4:
                            if (carMileage >= 100000 && carMileage <= 200000) {
                                System.out.println(input);
                            }
                            break;
                        case 5:
                            if (carMileage >= 200000 && carMileage <= 600000) {
                                System.out.println(input);
                            }
                            break;
                        default:
                            System.out.println("This isn't an option. Sorry, try again.");
                            break;
                    }
                }

            }
            fileInputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        } catch (IOException ex) {
            System.out.println("Error reading the file.");
        }
    }


    public void processGetByVehicleTypeRequest() {
        System.out.println("Which car vehicle type would you like to search by?");

        Scanner scanner = new Scanner(System.in);
        String userInputMake = scanner.next();
        scanner.nextLine();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);

            String input;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a line-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    String carListLine = carList[2]; // Assuming the car type is in the third column

                    if (userInputMake.equalsIgnoreCase(carListLine)) {
                        System.out.println(input);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }

    }


    public void processAddVehicleRequest() {
        System.out.println("Okay! So you would like to add a vehicle!");
        Scanner scanner = new Scanner(System.in);

        //Properties and fields
        //Vin|Year|Make|Model|Type|Color|Odometer|Price
        System.out.println("Okay what is the vin?");
        String userVin = scanner.nextLine();
        System.out.println("What is the year?");
        String userYear = scanner.nextLine();
        System.out.println("What is the make? ");
        String userMake = scanner.nextLine();
        System.out.println("What is the model?");
        String userModel = scanner.nextLine();
        System.out.println("What is the color?");
        String userColor = scanner.nextLine();
        System.out.println("What is the odometer reading?");
        String userReading = scanner.nextLine();
        System.out.println("What is the price?");
        String userPrice = scanner.nextLine();

        System.out.println(userVin + "|" + userYear + "|" + userYear + "|" + userMake + "|" + userModel + "|" + userColor + "|" + userReading + "|" + userPrice);

        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);

            Dealership dealership = new Dealership("GMC", "123 Whenever St", "935-444-5555");


            //append means add on to the end of something
            fileWriter.write(userVin + "|" + userYear + "|" + userYear + "|" + userMake + "|" + userModel + "|" + userColor + "|" + userReading + "|" + userPrice + "\n");

            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Had a problem writing in the file, I'm sorry");

        }
    }

    public void processRemoveVehicleRequest() {
        System.out.println("What is the vin number of the vehicle you would like to remove?");
        Scanner scanner = new Scanner(System.in);
        String userInputVendor = scanner.next();
        scanner.nextLine();

        try {

            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner banner = new Scanner(fileInputStream);
            String input;
            boolean found = false;

            while (banner.hasNextLine()) {
                input = banner.nextLine();
                // Split the CSV line into parts (assuming a comma-separated format)
                String[] carList = input.split("\\|");
                if (carList.length >= 2) {
                    String carListLine = carList[0]; // Assuming the car type is in the third column

                    if (input.matches(carList[0])) {
                        found = true;
                        input = banner.nextLine();
                        System.out.println(input);

                    }
                    else
                    {
                            System.out.println(input);
                    }
                        }
                    }
            if (!found) {
                System.out.println("Vin not found in the inventory.");
            }

                } catch(FileNotFoundException ex){
                    System.out.println("Could not find the file.");
                }
            }
        }
