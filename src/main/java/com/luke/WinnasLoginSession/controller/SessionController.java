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

    @GetMapping("/validate")
    public ResponseEntity<Map<String, Object>> validateSession(@RequestParam String sessionId) {
        Map<String, Object> response = sessionService.validateSession(sessionId);
        return response.get("valid").equals(true) ? ResponseEntity.ok(response) : ResponseEntity.status(401).body(response);
    }
}
