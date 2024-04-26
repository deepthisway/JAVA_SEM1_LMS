package com.LMS;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        //initializes both lists as empty ArrayLists when a new Library object is created
        books = new ArrayList<>();
        users = new ArrayList<>();
    }
    public List<User> getUsers() {
        return users;
    }
    public void addBook(Book book) {
        // we will use this method further for assigning fiction and non-fiction books, allowing us to achieve polymorphism
        //method allows adding a Book object to the library's collection of books
        books.add(book);
    }

    //prints details of all the books currently in the library's collection
    public void displayBooks() {
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.println(book.getDetails());
        }
    }

    // Method to search for books by author
    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for books by genre
    public List<Book> searchByGenre(Genre genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
    }


    // Method to get a book by its title
    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Method to borrow a book
    public void borrowBook2(User user, Book book) {
        // Check if the user is registered in the library
        if (!users.contains(user)) {
            System.out.println("User " + user.getName() + " is not registered in the library.");
            return;
        }

        // Check if the book is available in the library
        if (!books.contains(book)) {
            System.out.println("The book \"" + book.getTitle() + "\" is not available in the library.");
            return;
        }

        System.out.println("Book \"" + book.getTitle() + "\" successfully borrowed by user " + user.getName() + ".");
    }





}
