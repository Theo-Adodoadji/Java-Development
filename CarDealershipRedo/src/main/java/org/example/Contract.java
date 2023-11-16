package org.example;

import java.time.LocalDate;
//Getters and setters for Contract properties
//needs a Localdatetime, customerName, customeremail, and vehicle sold
public abstract class Contract {
    private LocalDate dateOfContract;

    private String customerName;

    private String customerEmail;

    private Vehicle vehicleSold;



    public Contract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold; // Correctly assigns the parameter to the instance variable
    }



    public LocalDate getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(LocalDate dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
//abstract values for getTotalPrice() and get monthly payment

}

