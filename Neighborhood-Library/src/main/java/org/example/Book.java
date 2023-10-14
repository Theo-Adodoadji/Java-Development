package org.example;

public class Book {

    //properties and fields
    public int id;
    public String isbn;
    public String title;
    public boolean isCheckedOut;
    public String checkedOutTo;

    // Method for checking out a book
    public void checkOut(String person) {
        if (!isCheckedOut) {
            isCheckedOut = true;
            checkedOutTo = person;
            System.out.println(title + " has been checked out to " + person);
        } else {
            System.out.println(title + " is already checked out by " + checkedOutTo);
        }
    }

    // Method for checking in a book
    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = null;
            System.out.println(title + " has been checked in.");
        } else {
            System.out.println(title + " is not checked out.");
        }
    }


    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public Book setIsCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
        return this;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public Book setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
        return this;
    }

    public String toString() {
        return "ID: " + id + ", isbn: " + isbn + ", Title: " + title + ", Is checked Out?: " + isCheckedOut + ",To:" + checkedOutTo;
    }



}
