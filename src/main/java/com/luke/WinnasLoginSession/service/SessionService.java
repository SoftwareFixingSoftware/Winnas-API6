package com.luke.WinnasLoginSession.service;

import com.luke.WinnasLoginSession.entity.Session;
import com.luke.WinnasLoginSession.entity.Session1;
import com.luke.WinnasLoginSession.entity.Session2;
import com.luke.WinnasLoginSession.repository.SessionRepository;
import com.luke.WinnasLoginSession.repository.SessionRepository1;
import com.luke.WinnasLoginSession.repository.SessionRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private SessionRepository1 sessionRepository1;
    @Autowired
    private SessionRepository2 sessionRepository2;

    public Map<String, Object> validateSession(String sessionId) {
        Map<String, Object> response = new HashMap<>();
        Session session = sessionRepository.findBySessionId(sessionId);
        if (session == null) {
            response.put("valid", false);
            response.put("message", "Session not found");
            return response;
        }

        if (session.getExpirationTime().before(new Date())) {
            response.put("valid", false);
            response.put("message", "Session expired");
            return response;
        }

        session.setLastActivity(new Date());
        sessionRepository.save(session);

        response.put("valid", true);
        response.put("message", "Session is active");
        return response;
    }

    //for lecturers
    public Map<String, Object> validateSession1(String sessionId) {
        Map<String, Object> response = new HashMap<>();
        Session1 session1 = sessionRepository1.findBySessionId(sessionId);

        if (session1 == null) {
            response.put("valid", false);
            response.put("message", "Session not found");
            return response;
        }

        if (session1.getExpirationTime().before(new Date())) {
            response.put("valid", false);
            response.put("message", "Session expired");
            return response;
        }

        session1.setLastActivity(new Date());
        sessionRepository1.save(session1);

        response.put("valid", true);
        response.put("message", "Session is active");
        return response;
    }
    //for admin
    public Map<String, Object> validateSession2(String sessionId) {
        Map<String, Object> response = new HashMap<>();
        Session2 session2 = sessionRepository2.findBySessionId(sessionId);

        if (session2 == null) {
            response.put("valid", false);
            response.put("message", "Session not found");
            return response;
        }

        if (session2.getExpirationTime().before(new Date())) {
            response.put("valid", false);
            response.put("message", "Session expired");
            return response;
        }

        session2.setLastActivity(new Date());
        sessionRepository2.save(session2);
        response.put("valid", true);
        response.put("message", "Session is active");
        return response;
    }
}
