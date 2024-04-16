package com.LMS;

import java.util.Date;

class Borrower {
    private String name;
    private int id;
    private Date membershipStartDate;

    // Constructor
    public Borrower(String name, int id, Date membershipStartDate) {
        this.name = name;
        this.id = id;
        this.membershipStartDate = membershipStartDate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getMembershipStartDate() {
        return membershipStartDate;
    }
}
