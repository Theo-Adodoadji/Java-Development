package org.example;

import java.time.LocalDate;

public class SalesContract extends Contract{
    private boolean isFinanced;
    public SalesContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public String isFinanced() {
        if(isFinanced){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public double salesTaxAmount(){
        return getVehicleSold().getPrice()*0.05;
    }
    public double recordingFee(){
        return 100;
    }
    public double processingFee(){
        if (getVehicleSold().getPrice()<=10000){
            return 295;
        }
        else{
            return 495;
        }
    }

//1. P is cost vehicle
//2. RV the residual value which is 50% of the cost of the vehicle
//3. r is the monthly interest rate which is 4% (divide by 12)
//4. n number of payments, which is 36

    @Override
    public double getTotalPrice() {
        if(isFinanced) {
            double P = getVehicleSold().getPrice();
            double r = 0.0425/12;
            double R = 0.0525/12;
            if(P>=10000){
                return (48*(P*r*Math.pow(1+r,48))/(Math.pow(1+r,48)-1))+ recordingFee() + processingFee() + salesTaxAmount();
            }
            else {
                return (24*(P*R*Math.pow(1+R,24))/(Math.pow(1+R,24)-1))+ recordingFee() + processingFee() + salesTaxAmount();
            }

        }
        else{
            return getVehicleSold().getPrice() + recordingFee() + processingFee() + salesTaxAmount();

        }

    }
//1. P is cost vehicle
//2. RV the residual value which is 50% of the cost of the vehicle
//3. r is the monthly interest rate which is 4% (divide by 12)
//4. n number of payments, which is 36

    @Override
    public double getMonthlyPayment() {
        double P = getVehicleSold().getPrice();
        double r = 0.0425/12;
        double R = 0.0525/12;
        if(isFinanced && P>=10000){
            return (P*r*Math.pow(1+r,48))/(Math.pow(1+r,48)-1);
        }
        else if(isFinanced && P<10000){
            return (P*R*Math.pow(1+R,24))/(Math.pow(1+R,24)-1);
        }
        else{
            return 0;
        }

    }
}

