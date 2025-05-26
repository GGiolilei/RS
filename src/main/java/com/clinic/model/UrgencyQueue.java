package com.clinic.model;
import java.sql.Timestamp;
public class UrgencyQueue {
     private int queueId;
    private int patientId;
    private Integer doctorId; // nullable
    private Timestamp arrivalTime;
    private int urgencyLevel;
    private String reasonForVisit;
    private String status;

    public UrgencyQueue(int patientId, Integer doctorId, Timestamp arrivalTime, int urgencyLevel, String reasonForVisit, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.arrivalTime = arrivalTime;
        this.urgencyLevel = urgencyLevel;
        this.reasonForVisit = reasonForVisit;
        this.status = status;
    }
}
