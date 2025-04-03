package com.luke.WinnasLoginSession.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Sessions")
public class Session {

    @Id
    private String sessionId;

    @Column(nullable = false)
    private String studentId;  // Store student ID directly instead of a Student object

    @Column(nullable = false)
    private Date expirationTime;

    @Column(nullable = false)
    private Date lastActivity;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
