package org.example;

import java.time.LocalDate;

public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public String isFinanced() {
        if (isFinanced) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public double salesTaxAmount() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public double recordingFee() {
        return 100;
    }

    public double processingFee() {
        if (getVehicleSold().getPrice() <= 10000) {
            return 295;
        } else {
            return 495;
        }
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
