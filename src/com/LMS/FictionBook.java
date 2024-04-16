package com.LMS;

// Concrete class representing a fiction book
class FictionBook extends Book {
    private String subgenre;

    // Constructor
    public FictionBook(String title, String author, String subgenre) {
        super(title, author, Genre.FICTION);
        this.subgenre = subgenre;
    }

    // Overridden method to get book details
    @Override
    public String getDetails() {
        return "Fiction com.LMS.Book: " + getTitle() + " by " + getAuthor() + ", Subgenre: " + subgenre;
    }
}
