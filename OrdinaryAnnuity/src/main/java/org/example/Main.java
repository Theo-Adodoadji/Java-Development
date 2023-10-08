package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the ordinary annuity calculator");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your monthly payout");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Please enter your interest rate");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Please enter the total amount of years you want to calculate for");
        double years = scanner.nextDouble();

        double monthlyInterestrate = annualInterestRate / 12 / 100 ;

        double monthlyPayments = years * 12;

        double equation = Math.pow(1 + monthlyInterestrate,-monthlyPayments);

        double equationTwo = 1 - equation;

        double presentValue = monthlyPayout * equationTwo / monthlyInterestrate;

        System.out.printf("Here is the present value of annuity $%.2f", presentValue);

    }
}