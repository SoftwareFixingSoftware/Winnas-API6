package com.luke.WinnasLoginSession.repository;

import com.luke.WinnasLoginSession.entity.Session2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository2 extends JpaRepository<Session2, String> {
    Session2 findBySessionId(String sessionId);
}
