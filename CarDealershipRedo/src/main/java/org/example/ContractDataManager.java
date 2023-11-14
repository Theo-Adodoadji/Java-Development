package org.example;

import java.io.*;
import java.util.Scanner;

public class ContractDataManager {
    private ContractDataManager() {

    }

    public static void saveContract(Contract contract) {

        try {
            File file = new File("src/main/resources/contract.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            if (contract instanceof SalesContract) {
                String s = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f\n"
                        , contract.getDateOfContract(), contract.getCustomerName(), contract.getCustomerEmail()
                        , contract.getVehicleSold().getVin(), contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(), contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(), contract.getVehicleSold().getColor(), contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(), ((SalesContract) contract).salesTaxAmount(),
                        ((SalesContract) contract).recordingFee(), ((SalesContract) contract).processingFee(),
                        contract.getTotalPrice(), ((SalesContract) contract).isFinanced(),
                        contract.getMonthlyPayment());
                fileWriter.write(s);
            } else {
                String s = String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n"
                        , contract.getDateOfContract(), contract.getCustomerName(), contract.getCustomerEmail()
                        , contract.getVehicleSold().getVin(), contract.getVehicleSold().getYear(),
                        contract.getVehicleSold().getMake(), contract.getVehicleSold().getModel(),
                        contract.getVehicleSold().getVehicleType(), contract.getVehicleSold().getColor(), contract.getVehicleSold().getOdometer(),
                        contract.getVehicleSold().getPrice(), ((LeaseContract) contract).getExpectedEndingValue(),
                        ((LeaseContract) contract).getLeaseFee(), contract.getTotalPrice(),
                        contract.getMonthlyPayment());
                fileWriter.write(s);

            }
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }
}
