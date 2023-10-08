package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello! Welcome to the Mortgage calculator!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the principal amount on your loan");
        double principalAmount = scanner.nextDouble();

        System.out.println("Please enter the annual interest rate on your loan");
        double annualRate = scanner.nextDouble();

        double annualRateDec = annualRate / 100;

        double interestRate = annualRateDec / 12;

        System.out.println("Please enter the loan length in months on your loan");
        double loanLength = scanner.nextDouble();

        double numberofMonthlyPayments = loanLength * 12;

        double monthlyPayment = (principalAmount * Math.pow(1+interestRate, numberofMonthlyPayments)) / (Math.pow((1 + interestRate), numberofMonthlyPayments - 1));

        double totalInterestPaid = (monthlyPayment * numberofMonthlyPayments) - principalAmount;

        System.out.printf("This is your total interest paid! $%.2f. Thank you!", totalInterestPaid);

        System.out.printf("This is your monthly payment %.2fs. Thank you!", monthlyPayment);

    }
}