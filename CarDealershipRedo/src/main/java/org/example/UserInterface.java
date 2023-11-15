package org.example;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public void display() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
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
            System.out.println("10) Sell/Lease a vehicle");
            System.out.println("11) Quit");

            Scanner banner = new Scanner(System.in);
            int userInput = banner.nextInt();

            switch (userInput) {
                case 0:
                    //save all changes
                    DealershipFileManager.saveDealership(dealership);
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
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSaleorLeaseVehicle();
                    break;
                case 11:
                    System.exit(0);
                    break;

                default:
                    System.out.println("This isn't an option. Sorry, try again.");
                    break;

            }

        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }


    public void processGetByPriceRequest() {
        boolean isGettingByPrice = true;

        while (isGettingByPrice) {
            try {
                Scanner tanner = new Scanner(System.in);
                System.out.println("What is the minimum price of the vehicle you are looking for?");
                double minPrice = tanner.nextDouble();
                System.out.println("What is the maximum price of the vehicle you are looking for?");
                double maxPrice = tanner.nextDouble();

                if (minPrice < maxPrice) {
                    System.out.printf("Here are all the vehicles between %.2f and %.2f%n", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehicleList);
                    isGettingByPrice = false;
                } else {
                    System.out.println("Min price cannot be greater than max price");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Price must be a number");
            }
        }
    }





    public void processGetByYearRequest() {
        boolean isGettingByYear = true;

        while (isGettingByYear) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum year of the vehicle you are looking for?");
                int minYear = scanner.nextInt();
                System.out.println("What is the maximum year of the vehicle you are looking for?");
                int maxYear = scanner.nextInt();

                if (minYear <= maxYear) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehicleList);
                    isGettingByYear = false;
                } else {
                    System.out.println("Not a valid year! Try again");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Not a valid year! Try again");
            }
        }
    }

    public void processGetByMakeModelRequest() {
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the make of the vehicle you are looking for?");
                String make = scanner.nextLine();
                System.out.println("What is the the model of the vehicle you are looking for?");
                String model = scanner.nextLine();
                System.out.println("Searching for make: " + make + ", model: " + model);

                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                isGettingByMakeModel = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void processGetByColorRequest() {
        boolean isGettingByColor = true;

        while (isGettingByColor) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the color of the vehicle you are looking for?");
                String color = scanner.nextLine();
                System.out.println("Searching for color: "  + color);


                List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
                displayVehicles(vehicleList);
                isGettingByColor = false;
            } catch (InputMismatchException ex) {
                System.out.println("Wrong! Try again!");
            }
        }
    }

    public void processGetByMileageRequest() {
        boolean isGettingByMileage = true;

        while (isGettingByMileage) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the minimum mileage of the vehicle you are looking for?");
                int minMileage = scanner.nextInt();
                System.out.println("What is the maximum mileage of the vehicle you are looking for?");
                int maxMileage = scanner.nextInt();

                if (minMileage <= maxMileage) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    displayVehicles(vehicleList);
                    isGettingByMileage = false;
                } else {
                    System.out.println("Wrong! Try again!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong! Try again!");
            }
        }
    }

    public void processGetByVehicleTypeRequest() {
        boolean isGettingByVehicleType = true;

        while (isGettingByVehicleType) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the vehicle type you are looking for?");
                String vehicleType = scanner.nextLine();
                System.out.println("Searching for Vehicle Type: "  + vehicleType);


                List<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
                displayVehicles(vehicleList);
                isGettingByVehicleType = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input.");
            }
        }
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(this.dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        boolean isAddingVehicle = true;

        while (isAddingVehicle) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the VIN?");
                int vin = scanner.nextInt();
                scanner.nextLine();

                System.out.println("What is the year?");
                int year = scanner.nextInt();
                scanner.nextLine();

                System.out.println("What is the make?");
                String make = scanner.nextLine();

                System.out.println("What is the model?");
                String model = scanner.nextLine();

                System.out.println("What is the vehicle type?");
                String vehicleType = scanner.nextLine();

                System.out.println("What is the color?");
                String color = scanner.nextLine();

                System.out.println("What is the odometer reading?");
                int odometer = scanner.nextInt();
                scanner.nextLine();

                System.out.println("What is the price of the vehicle?");
                double price = scanner.nextDouble();

                Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
             // Needs to be formatted this way: Vin|Year|Make|Model|Type|Color|Odometer|Price

                dealership.addVehicle(newVehicle);

                System.out.println("Vehicle added successfully!");
                isAddingVehicle = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please check your input format and try again.");
            }
        }
    }

    public void processRemoveVehicleRequest() {
        boolean isRemovingVehicle = true;

        while (isRemovingVehicle) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("What is the VIN of the vehicle?");
                int vinToRemove = scanner.nextInt();
                scanner.nextLine();

                // Search for the vehicle with the VIN in the inventory
                List<Vehicle> inventory = dealership.getAllVehicles();
                Vehicle vehicleToRemove = null;

                for (Vehicle vehicle : inventory) {
                    if (vehicle.getVin() == vinToRemove) {
                        vehicleToRemove = vehicle;
                        break;
                    }
                }

                if (vehicleToRemove != null) {
                    // Remove the vehicle from the inventory
                    dealership.removeVehicle(vehicleToRemove);
                    System.out.println("Vehicle removed successfully!");
                } else {
                    System.out.println("Vehicle with VIN " + vinToRemove + " not found in inventory.");
                }

                isRemovingVehicle = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. VIN must be a number.");
            }
        }
    }


    /*     1. Make an option to buy or lease a car (Ask if they need financing)
     2. Get personal information of the buyer (name/email)
     3. Ask them which car do they want? (VIN number to identify the car)
            4. Create the appropriate contract (SalesContract or LeaseContract) and fill in the information.
            5. Let the user know the total cost and monthly payment.
            6. If user agrees to the contract, remove the car from the lot, and return to the home menu.
            7. IF the user agreed, write the contract to a file
    */

    public void processSaleorLeaseVehicle() {
        System.out.println("Here is the list of our vehicles ");
        displayVehicles(this.dealership.getAllVehicles());
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Chose an option:");
                System.out.println("1) Would you like to purchase a vehicle?");
                System.out.println("2) Would you like to finance a vehicle?");
                System.out.println("3) Would you like to lease a vehicle?");
                System.out.println("4) Would you like to return to the main menu?");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        getPurchase();
                        break;
                    case 2:
                        getFinance();
                        break;
                    case 3:
                        getLease();
                        break;
                    case 0:
                        System.out.println("You are returning to the main menu");
                        return;
                    default:
                        System.out.println("Pick a correct option");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Choose the correct input");
                scanner.nextLine();
            }
        }



    }
    private void getPurchase() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter customer name please");
            scanner.nextLine();
            String name = scanner.nextLine().trim();
            System.out.println("Enter customer email address ");
            String email = scanner.nextLine().trim();
            System.out.println("Enter the vin number of the car to purchase");
            int vinNumber = scanner.nextInt();

            Vehicle foundVehicle = null;

                while(true) {
                    try {
                        if (foundVehicle != null) {
                            System.out.println(foundVehicle + "\nFinal confirmation do you still wanna purchase it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();

                            switch (userInput) {

                                case 1:
                                    SalesContract sc = new SalesContract(LocalDate.now(), name, email, foundVehicle, false);
                                    System.out.println("Your monthly payment will be:\n" + foundVehicle + "\nMonthly Payment: " + sc.getTotalPrice() + "$");
                                    ContractDataManager.saveContract(sc);
                                    dealership.removeVehicle(foundVehicle);

                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/lease/finance menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("invalid input");
                        scanner.nextLine();
                    }
                }



        } catch (InputMismatchException exception) {
            System.out.println("Enter a valid Input");

        }
    }
    private void getFinance(){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Enter customer name please");
                scanner.nextLine();
                String name = scanner.nextLine().trim();
                System.out.println("Enter customer email address ");
                String email = scanner.nextLine().trim();
                System.out.println("Enter the vin number of the car to Finance");
                int vinNumber = scanner.nextInt();

                Vehicle foundVehicle = null;

                for (Vehicle v : dealership.inventory) {
                    if (vinNumber == v.getVin()) {
                        foundVehicle = v;
                        break;
                    }
                }
                while (true) {
                    try {
                        if (foundVehicle != null) {
                            System.out.println(foundVehicle + "\nFinal confirmation do you still wanna Finance it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();
                            switch (userInput) {

                                case 1:
                                    LeaseContract lc = new LeaseContract(LocalDate.now(), name, email, foundVehicle);

                                    System.out.println("Your monthly payment for: " + foundVehicle + "\nMonthly Payment: " + lc.getMonthlyPayment() + "$");
                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/lease/finance menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Invalid Input");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input");
            }
        }

    }
    private void getLease() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter Customer name please");
                scanner.nextLine();
                String name = scanner.nextLine().trim();
                System.out.println("Enter Customer email address ");
                String email = scanner.nextLine().trim();
                System.out.println("Enter the vin number of the car to Lease");
                int vinNumber = scanner.nextInt();

                Vehicle foundVehicle = null;

                for (Vehicle v : dealership.inventory) {
                    if (vinNumber == v.getVin()) {
                        foundVehicle = v;
                        break;
                    }
                }
                while (true) {
                    try {
                        if (foundVehicle != null) {
                            System.out.println(foundVehicle + "\nFinal confirmation do you still wanna lease it:\n1> yes\n2> no");
                            int userInput = scanner.nextInt();
                            switch (userInput) {

                                case 1:

                                    LeaseContract lc = new LeaseContract(LocalDate.now(), name, email, foundVehicle);
                                    System.out.println("Your monthly payment will be:\n" + foundVehicle + "\nMonthly Payment: " + lc.getMonthlyPayment() + "$");
                                    ContractDataManager.saveContract(lc);
                                    dealership.removeVehicle(foundVehicle);
                                    return;
                                case 2:
                                    System.out.println("Your are returning to the purchase/finance/lease menu");
                                    return;
                                default:
                                    System.out.println("chose the correct option");
                                    break;
                            }
                        } else {
                            System.out.println("We do not have the vehicle with that VIN number.");
                            return;
                        }
                    } catch (InputMismatchException exception) {
                        System.out.println("Invalid Input");
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter a valid Input");
            }
        }
    }


    }







