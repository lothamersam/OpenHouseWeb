package com.openhouse.beans;

public class StaffMemberTO {
    private final String firstName;
    private final String lastName;
    private final String title;
    private final String bio;
    private final String imagePath;

    public StaffMemberTO(String firstName, String lastName, String title, String bio, String imagePath){
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
        this.imagePath = ("".equals(imagePath)) ?  "/static/img/blank.jpg" : imagePath;        
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBio() {
        return this.bio;
    }

    public String getImagePath() {
        return this.imagePath;
    }
}