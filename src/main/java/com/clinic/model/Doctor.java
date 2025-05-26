package com.clinic.model;

import java.util.Objects;

/**
 * Represents a Doctor in the clinic system.
 */
public final class Doctor {
    private final int doctorId;  // Made final if ID shouldn't change after creation
    private final String firstName;
    private final String lastName;
    private final String specialty;
    private final String contactNumber;
    private final String email;

    public Doctor(String firstName, String lastName, String specialty, 
                 String contactNumber, String email) {
        this(0, firstName, lastName, specialty, contactNumber, email); // 0 as default ID
    }

    public Doctor(int doctorId, String firstName, String lastName, String specialty,
                 String contactNumber, String email) {
        this.doctorId = doctorId;
        this.firstName = Objects.requireNonNull(firstName, "First name cannot be null");
        this.lastName = Objects.requireNonNull(lastName, "Last name cannot be null");
        this.specialty = Objects.requireNonNull(specialty, "Specialty cannot be null");
        this.contactNumber = validateContactNumber(contactNumber);
        this.email = validateEmail(email);
    }

    // Validation methods
    private String validateContactNumber(String number) {
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact number cannot be null or empty");
        }
        // Add additional validation logic if needed
        return number;
    }

    private String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return email;
    }

    // Getters
    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId &&
               Objects.equals(firstName, doctor.firstName) &&
               Objects.equals(lastName, doctor.lastName) &&
               Objects.equals(specialty, doctor.specialty) &&
               Objects.equals(contactNumber, doctor.contactNumber) &&
               Objects.equals(email, doctor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, firstName, lastName, specialty, contactNumber, email);
    }

    @Override
    public String toString() {
        return "Doctor{" +
               "doctorId=" + doctorId +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", specialty='" + specialty + '\'' +
               ", contactNumber='" + contactNumber + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}