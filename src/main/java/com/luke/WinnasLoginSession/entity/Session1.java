package com.luke.WinnasLoginSession.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Lecturer_Sessions")
public class Session1 {

    @Id
    private String sessionId;

    @Column(nullable = false)
    private String lecturerId;
    private Date expirationTime;
    private Date lastActivity;

    // Getters and Setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLecturerId() {
        return lecturerId;
    }
    public void setLecturer(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }
}

