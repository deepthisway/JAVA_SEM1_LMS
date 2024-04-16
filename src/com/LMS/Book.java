package com.LMS;

import java.util.Date;

//abstract class Book {
//    private String title;
//    private String author;
//    private Genre genre;
//    private Borrower borrower;
//    private Date dueDate;
//
//    // Constructor
//    public Book(String title, String author, Genre genre) {
//        this.title = title;
//        this.author = author;
//        this.genre = genre;
//    }
//
//    // Getters
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public Genre getGenre() {
//        return genre;
//    }
//
//    // Method to borrow the book
//    public void borrowBook(Borrower borrower, Date dueDate) {
//        this.borrower = borrower;
//        this.dueDate = dueDate;
//    }
//
//    // Method to return the book
//    public void returnBook() {
//        this.borrower = null;
//        this.dueDate = null;
//    }
//
//    // Method to check if the book is currently borrowed
//    public boolean isBorrowed() {
//        return borrower != null;
//    }
//
//    // Method to get borrower details
//    public String getBorrowerDetails() {
//        if (borrower != null) {
//            return "com.LMS.Borrower: " + borrower.getName() + ", ID: " + borrower.getId();
//        } else {
//            return "Not borrowed";
//        }
//    }
//
//    // Method to get due date
//    public Date getDueDate() {
//        return dueDate;
//    }
//
//    // Abstract method to get book details
//    public abstract String getDetails();
//}

// Abstract class representing a book
abstract class Book {
    private String title;
    private String author;
    private Genre genre;
    private boolean borrowed;

    // Constructor
    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.borrowed = false; // Initially, the book is not borrowed
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    // Abstract method to get book details
    public abstract String getDetails();
}
