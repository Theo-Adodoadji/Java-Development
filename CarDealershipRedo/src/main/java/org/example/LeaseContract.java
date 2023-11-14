package org.example;


import java.time.LocalDate;

public class LeaseContract extends Contract {
    double expectedEndingValue;

    double leaseFee;

    public LeaseContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValue() {
        return 0.5 * getVehicleSold().getPrice();
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return 0.07 * getVehicleSold().getPrice();
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getTotalPrice() {
         return getVehicleSold().getPrice() - getExpectedEndingValue()+ getLeaseFee();
    }

    public  double getMonthlyPayment() {
        return ((getVehicleSold().getPrice() - getExpectedEndingValue() *(1.04))/36);

    }


}
