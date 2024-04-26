package com.LMS;

import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create library object to use further
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Library Management System!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search books by author");
            System.out.println("4. Search books by genre");
            System.out.println("5. Add a user");
            System.out.println("6. Display all the users");
            System.out.println("7. Borrow a book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    displayUsers(library);
                    break;
                case 7:
                    borrowBook(library, scanner);
                    break;
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a book to the library
    /* POLYMORPHISM
    * invoking the addBook method, this method might be declared
    * to accept a Book object. However, since FictionBook and NonFictionBook are subclasses of Book,
    * you can pass objects of either type to this method due to polymorphism. The method will treat
    * them as Book objects, allowing you to work with them interchangeably.
    * */
    public static void addBook(Library library, Scanner scanner) {

        System.out.print("\nEnter the title of the book: ");
        String title = scanner.nextLine();
        try {
            if (title.isEmpty()) {
                throw new CustomException("Title is empty!!");
            }
        }
        // we have used custom exception here to be very specific about the exception being thrown.
        catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();
        try {
            if (author.isEmpty()) {
                throw new CustomException("Author can't be empty!!");
            }
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Enter the genre of the book (FICTION or NON_FICTION): ");
        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase()); // This line of code reads input from the user using a
        // Scanner object, converts it to uppercase, and then converts it
        // to an enum value of the Genre enum type
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
        try {
            System.out.print("\nEnter the author's name: ");
            String author = scanner.nextLine();
            // Check if the input contains any digits
            // The regular expression .*\\d.* matches any string that contains at least one digit (0-9) anywhere within it.
            /*
            *: This part of the regular expression matches any sequence of characters (including zero characters) in the input string.
            \\d: This part of the regular expression matches any digit (0-9).
            *: Similar to the first part, this matches any sequence of characters (including zero characters) after the digit.
            */
            if (author.matches(".*\\d.*")) {
                throw new InputMismatchException("Author's name cannot contain numbers.");
            }
            List<Book> booksByAuthor = library.searchByAuthor(author); // This line of code retrieves a list of books
            // authored by a specific author from the library's collection.
            if (booksByAuthor.isEmpty()) {
                System.out.println("No books found by author: " + author);
            } else {
                System.out.println("Books by author " + author + ":");
                for (Book book : booksByAuthor) {
                    System.out.println(book.getDetails());
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
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
        scanner.nextLine();
        User user = new User(name, id);
        library.addUser(user);
        System.out.println("User added successfully!");
    }


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

        // this adds the user to the library (if not already added) when borrowing a book.
        library.addUser(user);

        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        Book book = library.getBookByTitle(title);
        try {
            if (book != null) {
                library.borrowBook2(user, book);
                System.out.println("Book \"" + title + "\" successfully borrowed by user " + userName + " (ID: " + userId + ")");
            } else {
                throw new CustomException("Book \"" + title + "\" not found in the library.");
            }
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
