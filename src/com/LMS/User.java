package com.LMS;
class User {
    private String name;
    private int id;

    // Constructor
    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Method to get user details
    public String getDetails() {
        return "User: " + name + " (ID: " + id + ")";
    }
}

