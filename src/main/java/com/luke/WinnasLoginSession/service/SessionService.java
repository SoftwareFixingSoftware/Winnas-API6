package com.luke.WinnasLoginSession.service;

import com.luke.WinnasLoginSession.entity.Session;
import com.luke.WinnasLoginSession.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

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
}
