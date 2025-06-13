package com.luke.WinnasLoginSession.controller;

import com.luke.WinnasLoginSession.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/validate/student")
    public ResponseEntity<Map<String, Object>> validateSession(@RequestParam String sessionId) {
        Map<String, Object> response = sessionService.validateSession(sessionId);
        return response.get("valid").equals(true) ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }
    @GetMapping("/validate/lecturer")
    public ResponseEntity<Map<String, Object>> validateSession1(@RequestParam String sessionId) {
        Map<String, Object> response = sessionService.validateSession1(sessionId);
        return response.get("valid").equals(true) ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }
    @GetMapping("/validate/admin")
    public ResponseEntity<Map<String, Object>> validateSession2(@RequestParam String sessionId) {
        Map<String, Object> response = sessionService.validateSession2(sessionId);
        return response.get("valid").equals(true) ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }

}
