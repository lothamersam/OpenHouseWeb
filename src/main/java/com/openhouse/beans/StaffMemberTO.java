package com.openhouse.beans;

public class StaffMemberTO {
    private final String firstName;
    private final String lastName;
    private final String title;
    private final String bio;

    public StaffMemberTO(String firstName, String lastName, String title, String bio){
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
    }
}