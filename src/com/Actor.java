package com;

public class Actor {
    private int actorId;
    private String name;
    private String dateOfBirth;
    private String nationality;

    // Constructor with corrected assignments
    public Actor(String name, int actorId, String dateOfBirth, String nationality) {
        this.name = name;
        this.actorId = actorId;
        this.dateOfBirth = dateOfBirth;  // Correct assignment using this.dateOfBirth
        this.nationality = nationality;
    }

    // Getters and Setters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Corrected getter name
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // Corrected setter method to use this.dateOfBirth
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
