package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book[] books = new Book[20];
        int bookCount = 20;

        books[0] = new Book(101121, "978-0-670-81302-8", "it", true, "Jack Torrance");
        books[1] = new Book(101122, "978-0-385-12167-5", "The Shining", true, "Pennywise the Dancing Clown");
        books[2] = new Book(101123, "978-0-385-50130-6", "Carrie", false, "");
        books[3] = new Book(101124, "978-0-451-16918-3", "Misery", true, "Roland Deschain");
        books[4] = new Book(101125, "978-0-385-12168-2", "The Stand", false, "");
        books[5] = new Book(101126, "978-0-385-11874-3", "Pet Sematary", false, "");
        books[6] = new Book(101127, "978-0-670-22866-2", "Cujo", true, "Leland Gaunt");
        books[7] = new Book(101128, "978-0-385-12166-8", "Salem's Lot", true, "Randall Flagg");
        books[8] = new Book(101129, "978-0-451-45253-7", "The Dark Tower I: The Gunslinger", true, "Danny Torrance");
        books[9] = new Book(101130, "978-1-4767-2765-3", "Doctor Sleep", false, "");
        books[10] = new Book(101131, "978-1-5011-9270-8", "The Outsider", true, "Susannah Dean");
        books[11] = new Book(101132, "978-1-4516-2614-9", "11/22/63", false, "");
        books[12] = new Book(101133, "978-1-4165-2400-8", "Duma Key", false, "");
        books[13] = new Book(101134, "978-1-5011-9266-1", "The Dead Zone", true, "The Gunslinger");
        books[14] = new Book(101135, "978-0-451-20551-3", "The Green Mile", true, "Louis Creed");
        books[15] = new Book(101136, "978-0-451-18870-9", "Different Seasons", true, "Andy Dufresne");
        books[16] = new Book(101137, "978-1-4391-6806-1", "Under the Dome", false, "");
        books[17] = new Book(101138, "978-0-451-16694-6", "Needful Things", false, "");
        books[18] = new Book(101139, "978-1-5011-9274-6", "Firestarter", true, "Joe Hillstrom King");
        books[19] = new Book(101140, "978-0-451-20438-7", "The Long Walk", true, "Nick Andros");


        // if a book is checked in, the isCheckedOut variable is set to false
        // if a book is checked out, the isCheckedOut variable is set to true
        boolean continueRunning = true;

        while (continueRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do?");
            System.out.println(" 1 - Show Available Books");
            System.out.println(" 2 - Show Checked Out books");
            System.out.println(" 3 - Check In a book");
            System.out.println(" 4 - Exit");


            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Here are all the available books:");

                    for (int i = 0; i < bookCount; i++) {
                        if (!books[i].isCheckedOut) {
                            System.out.println("Title: " + books[i].getTitle());

                        }
                    }

                    System.out.println("Would you like to check out a book?");
                    String yesorno = scanner.next();
                    if (yesorno.equalsIgnoreCase("yes")) {
                        System.out.println("What is your name?");
                        String personsname = scanner.next();
                        System.out.println("What is the title of the book you are checking out?");
                        String titleofBook = scanner.next();
                        System.out.println("Congrats. You have checked out this book!");
                    } else {
                        System.out.println("Okay! Let's take you back to the homescreen");
                    }

                    break;

                case 2:
                    System.out.println("Here are all the unavailable books:");

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].isCheckedOut) {
                            System.out.println("Title: " + books[i].getTitle());

                        }
                    }

                    System.out.println("What do you want to do?");
                    System.out.println(" C - To Check In a book");
                    System.out.println(" X - To go Back to Home Screen");

                    String userInputCorX = scanner.next();
                    userInputCorX = userInputCorX.toLowerCase();

                    if (userInputCorX.equalsIgnoreCase("C")) {
                        System.out.println("Let's Check in a Book");
                        System.out.println("What is your ID Number?");
                        int newID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Which book would you like to check out?");
                        String userInputTitle = scanner.next();
                        //input normalization
                        userInputTitle = userInputTitle.toLowerCase();

                        boolean found = false;


                        for (int i = 0; i < bookCount; i++) {
                            if (books[i].getTitle().equalsIgnoreCase(userInputTitle)) {
                                if (books[i].isCheckedOut) {
                                    System.out.println("This book is already checked out by someone");
                                } else {
                                    System.out.println("Enter your name:");
                                    String person = scanner.next();
                                    books[i].checkOut(person); // Call the checkOut method
                                    found = true;
                                    System.out.println("You have checked out this book");

                                }
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("This book was already checked out by someone else!");
                        }
                        break;


                    } else {

                        break;
                    }

                case 3:
                    System.out.println("Check in a book:");
                    System.out.println("What is your ID Number?");
                    int newID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Which book would you like to check out?");
                    String userInputTitle = scanner.next();
                    //input normalization
                    userInputTitle = userInputTitle.toLowerCase();

                    boolean found = false;


                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(userInputTitle)) {
                            if (books[i].isCheckedOut) {
                                System.out.println("This book is already checked out by someone");
                            } else {
                                System.out.println("Enter your name:");
                                String person = scanner.next();
                                books[i].checkOut(person); // Call the checkOut method
                                found = true;
                                System.out.println("You have checked out this book");

                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("This book was already checked out by someone else or Not available");
                    }
                    break;

                case 4:
                    System.out.println("You have exited!");
                    continueRunning = false;
                    break;
                default:
                    System.out.println("You may select 1, 2, 3, or 4");
                    break;

            }

        }
    }

}







