-- Create the database
CREATE DATABASE IF NOT EXISTS clinic;
USE clinic;

-- Doctor table
CREATE TABLE Doctor (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialty VARCHAR(100),
    contact_number VARCHAR(20),
    email VARCHAR(100)
);

-- Patient table
CREATE TABLE Patient (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    date_of_birth DATE,
    gender VARCHAR(10),
    contact_number VARCHAR(20),
    address VARCHAR(255),
    medical_history_notes TEXT
);

-- Urgency Queue table
CREATE TABLE Urgency_Queue (
    queue_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    arrival_time DATETIME,
    urgency_level INT CHECK (urgency_level BETWEEN 1 AND 5),
    reason_for_visit VARCHAR(255),
    status VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

-- Prescription table
CREATE TABLE Prescription (
    prescription_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    prescription_date DATE,
    dosage_instructions TEXT,
    duration_days INT,
    notes TEXT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

-- Medicine table
CREATE TABLE Medicine (
    medicine_id INT AUTO_INCREMENT PRIMARY KEY,
    medicine_name VARCHAR(100),
    generic_name VARCHAR(100),
    manufacturer VARCHAR(100),
    unit_of_measure VARCHAR(20),
    stock_quantity INT,
    price_per_unit DECIMAL(10, 2)
);

-- Prescription Details table
CREATE TABLE Prescription_Details (
    prescription_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    prescription_id INT,
    medicine_id INT,
    quantity_prescribed INT,
    FOREIGN KEY (prescription_id) REFERENCES Prescription(prescription_id),
    FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id)
);
