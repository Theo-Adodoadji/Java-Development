package org.example;


import java.time.LocalDate;

public class LeaseContract extends Contract {
    public LeaseContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }
    public double getExpectedEndingValue(){
        return 0.5*getVehicleSold().getPrice();
    }
    public double getLeaseFee(){
        return 0.07*getVehicleSold().getPrice();
    }
    @Override
    public double getTotalPrice() {
        return getMonthlyPayment()*36+getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        return (getVehicleSold().getPrice() - getExpectedEndingValue())/36+((getVehicleSold().getPrice() + getExpectedEndingValue())* (4/2400));
    }
}

//1. P is cost vehicle
//2. RV the residual value which is 50% of the cost of the vehicle
//3. r is the monthly interest rate which is 4% (divide by 12)
//4. n number of payments, which is 36