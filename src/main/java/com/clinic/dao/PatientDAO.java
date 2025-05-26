package com.clinic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {

    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patient (first_name, last_name, date_of_birth, gender, contact_number, address, medical_history_notes) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getFirstName());
            stmt.setString(2, patient.getLastName());
            stmt.setDate(3, patient.getDateOfBirth());
            stmt.setString(4, patient.getGender());
            stmt.setString(5, patient.getContactNumber());
            stmt.setString(6, patient.getAddress());
            stmt.setString(7, patient.getMedicalHistoryNotes());

            stmt.executeUpdate();
        }
    }
}