package main.java.com.clinic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.clinic.model.UrgencyQueue;
import com.clinic.util.DBConnection;

public class UrgencyQueueDAO {

    public void addToQueue(UrgencyQueue queue) throws SQLException {
        String sql = "INSERT INTO Urgency_Queue (patient_id, doctor_id, arrival_time, urgency_level, reason_for_visit, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, queue.getPatientId());

            if (queue.getDoctorId() == null) {
                stmt.setNull(2, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(2, queue.getDoctorId());
            }

            stmt.setTimestamp(3, queue.getArrivalTime());
            stmt.setInt(4, queue.getUrgencyLevel());
            stmt.setString(5, queue.getReasonForVisit());
            stmt.setString(6, queue.getStatus());

            stmt.executeUpdate();
        }
    }
}