package com.openhouse.beans;

public class StaffMemberTO {
    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String bio;
    private String imagePath;
    private String imagePublicId;

    public StaffMemberTO(){};

    public StaffMemberTO(int id, String firstName, String lastName, String title, String bio, String imagePath, String imagePublicId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.bio = bio;
        this.imagePath = (null == imagePath) ?  "/static/img/blank.png" : imagePath;        
        this.imagePublicId = imagePublicId;
    }

    public int getId() {
        return this.id;
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

    public String getImagePublicId() {
        return this.imagePublicId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImagePublicId(String imagePublicId) {
        this.imagePublicId = imagePublicId;
    }
}