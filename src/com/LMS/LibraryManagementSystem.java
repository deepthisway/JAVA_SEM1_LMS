package com.LMS;

import java.util.Scanner;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create library object
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add books to the library
        System.out.println("Welcome to the Library Management System!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search books by author");
            System.out.println("4. Search books by genre");
            System.out.println("5. Add a user");
            System.out.println("6. Calculate fine for a user");
            System.out.println("7. Display all the users");
            System.out.println("8. Borrow a book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    searchByAuthor(library, scanner);
                    break;
                case 4:
                    searchByGenre(library, scanner);
                    break;
                case 5:
                    addUser(library, scanner);
                    break;
                case 6:
                    calculateFine(library, scanner);
                    break;
                case 7:
                    displayUsers(library);
                    break;
                case 8:
                    borrowBook(library, scanner);
                    break;
                case 9:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a book to the library
    public static void addBook(Library library, Scanner scanner) {
        System.out.print("\nEnter the title of the book: ");
        String title = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        System.out.print("Enter the genre of the book (FICTION or NON_FICTION): ");
        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
        if (genre == Genre.FICTION) {
            System.out.print("Enter the subgenre of the book: ");
            String subgenre = scanner.nextLine();
            FictionBook fictionBook = new FictionBook(title, author, subgenre);
            library.addBook(fictionBook);
        } else {
            System.out.print("Enter the topic of the book: ");
            String topic = scanner.nextLine();
            NonFictionBook nonFictionBook = new NonFictionBook(title, author, topic);
            library.addBook(nonFictionBook);
        }
        System.out.println("Book added successfully!");
    }


    // Method to search books by author
    public static void searchByAuthor(Library library, Scanner scanner) {
        System.out.print("\nEnter the author's name: ");
        String author = scanner.nextLine();
        List<Book> booksByAuthor = library.searchByAuthor(author);
        if (booksByAuthor.isEmpty()) {
            System.out.println("No books found by author: " + author);
        } else {
            System.out.println("Books by author " + author + ":");
            for (Book book : booksByAuthor) {
                System.out.println(book.getDetails());
            }
        }
    }

    // Method to search books by genre
    public static void searchByGenre(Library library, Scanner scanner) {
        System.out.print("\nEnter the genre of the book (FICTION or NON_FICTION): ");
        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
        List<Book> booksByGenre = library.searchByGenre(genre);
        if (booksByGenre.isEmpty()) {
            System.out.println("No books found in genre: " + genre);
        } else {
            System.out.println("Books in genre " + genre + ":");
            for (Book book : booksByGenre) {
                System.out.println(book.getDetails());
            }
        }
    }

    // Method to add a user to the library
    public static void addUser(Library library, Scanner scanner) {
        System.out.print("\nEnter the name of the user: ");
        String name = scanner.nextLine();
        System.out.print("Enter the user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        User user = new User(name, id);
        library.addUser(user);
        System.out.println("User added successfully!");
    }

    // Method to calculate fine for a user
    public static void calculateFine(Library library, Scanner scanner) {
        System.out.print("\nEnter the user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        User user = null;
        for (User u : library.getUsers()) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }
        if (user != null) {
            double fine = library.calculateFine(user);
            System.out.println("Fine for user " + user.getName() + " (ID: " + user.getId() + "): $" + fine);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }
    // method to display all the users
    // Method to display all the users
    public static void displayUsers(Library library) {
        List<User> users = library.getUsers();
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println(user.getDetails());
        }
    }

    // Method to borrow a book
    public static void borrowBook(Library library, Scanner scanner) {
        System.out.print("\nEnter the user's name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter the user's ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        User user = new User(userName, userId);

        // Add the user to the library (if not already added)
        library.addUser(user);

        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = library.getBookByTitle(title);
        if (book != null) {
            library.borrowBook2(user, book);
            System.out.println("Book \"" + title + "\" successfully borrowed by user " + userName + " (ID: " + userId + ")");
        } else {
            System.out.println("Book \"" + title + "\" not found in the library.");
        }
    }


}
