package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the compound interest calculator! ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount of money you have deposited");
        double depositAmount = scanner.nextDouble();

        System.out.println("Please enter the annual interest rate on your loan");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years you would like to see the money grow");
        double years = scanner.nextDouble();

        double interestRateDec = annualInterestRate / 100;

        double dailyInterestRate = interestRateDec / 365;

        double futureValue = depositAmount * Math.pow(1 + interestRateDec, 365 * years);
        System.out.printf("Here is the future value of your money $%.2f", futureValue);

        double totalInterestearned = futureValue - depositAmount;
        System.out.printf("Here is the total interest earned $%.2f.", totalInterestearned);






    }
}