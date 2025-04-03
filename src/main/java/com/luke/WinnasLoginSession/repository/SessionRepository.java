package com.luke.WinnasLoginSession.repository;

import com.luke.WinnasLoginSession.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    Session findBySessionId(String sessionId);
}
