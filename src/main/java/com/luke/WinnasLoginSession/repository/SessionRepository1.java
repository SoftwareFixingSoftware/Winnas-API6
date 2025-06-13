package com.luke.WinnasLoginSession.repository;

import com.luke.WinnasLoginSession.entity.Session1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository1 extends JpaRepository<Session1, String> {
     Session1 findBySessionId(String sessionId);
}
