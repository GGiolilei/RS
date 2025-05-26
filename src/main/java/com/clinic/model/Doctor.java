package com.clinic.model;

public class Doctor {
      private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private String contactNumber;
    private String email;

    public Doctor(String firstName, String lastName, String specialty, String contactNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
    }
}