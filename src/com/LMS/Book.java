package com.LMS;

// Abstraction is Book class:
/*The Book class defines methods and attributes that are common to all
types of books, such as title, author, genre, and methods like getDetails().
However, it doesn't provide a complete implementation of the getDetails() method
because the details of each book type can vary. Therefore, it's marked as abstract to
indicate that it's incomplete and should be subclassed to provide concrete implementations.*/
abstract class Book {
    private String title;
    private String author;
    private Genre genre;
    private boolean borrowed;
    /*Making the fields title, author, genre, and borrowed private encapsulates the internal state of the
    Book class. This encapsulation ensures that these fields cannot be directly accessed or
    modified from outside the class, promoting data integrity and encapsulation principles.*/

    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
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

    public abstract String getDetails();
    // Abstraction:  By making getDetails abstract in the Book class, subclasses such as
    // FictionBook and NonFictionBook are required to provide their own
    // implementations of the method. This allows different types of books to
    // define their details differently.
}
