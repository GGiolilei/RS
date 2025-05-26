package main.java.com.clinic;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

import main.java.com.clinic.dao.DoctorDAO;
import main.java.com.clinic.dao.PatientDAO;
import main.java.com.clinic.dao.UrgencyQueueDAO;
import main.java.com.clinic.model.Doctor;
import main.java.com.clinic.model.Patient;
import main.java.com.clinic.model.UrgencyQueue;

public class Main {
    public static void main(String[] args) {
        try {
            DoctorDAO doctorDAO = new DoctorDAO();
            PatientDAO patientDAO = new PatientDAO();
            UrgencyQueueDAO urgencyQueueDAO = new UrgencyQueueDAO();

            // Add a doctor
            Doctor doctor = new Doctor("John", "Doe", "Cardiology", "1234567890", "john.doe@example.com");
            doctorDAO.addDoctor(doctor);
            System.out.println("Doctor added.");

            // Add a patient
            Patient patient = new Patient("Jane", "Smith", Date.valueOf("1990-05-15"), "Female", "0987654321", "123 Main St", "No allergies");
            patientDAO.addPatient(patient);
            System.out.println("Patient added.");

            // Add to urgency queue (assuming patient_id=1, doctor_id=1)
            UrgencyQueue queue = new UrgencyQueue(1, 1, Timestamp.from(Instant.now()), 2, "Headache", "Waiting");
            urgencyQueueDAO.addToQueue(queue);
            System.out.println("Patient added to urgency queue.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
