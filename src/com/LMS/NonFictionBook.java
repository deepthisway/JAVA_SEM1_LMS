package com.LMS;

// Concrete class representing a non-fiction book
class NonFictionBook extends Book {
    private String topic;

    // Constructor
    public NonFictionBook(String title, String author, String topic) {
        super(title, author, Genre.NON_FICTION);
        this.topic = topic;
    }

    // Overridden method to get book details
    @Override
    public String getDetails() {
        return "Non-Fiction com.LMS.Book: " + getTitle() + " by " + getAuthor() + ", Topic: " + topic;
    }
}
