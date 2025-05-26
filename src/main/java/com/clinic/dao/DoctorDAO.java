package com.clinic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.clinic.model.Doctor;
import com.clinic.util.DBConnection;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO Doctor (first_name, last_name, specialty, contact_number, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, doctor.getFirstName());
            stmt.setString(2, doctor.getLastName());
            stmt.setString(3, doctor.getSpecialty());
            stmt.setString(4, doctor.getContactNumber());
            stmt.setString(5, doctor.getEmail());

            stmt.executeUpdate();
        }
    }
}