package main.java.com.clinic.model;
import java.sql.Date;
public class Patient {
     private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String address;
    private String medicalHistoryNotes;

    public Patient(String firstName, String lastName, Date dateOfBirth, String gender, String contactNumber, String address, String medicalHistoryNotes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
        this.medicalHistoryNotes = medicalHistoryNotes;
    }
}