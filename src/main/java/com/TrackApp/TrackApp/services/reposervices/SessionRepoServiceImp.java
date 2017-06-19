package com.TrackApp.TrackApp.services.reposervices;

import com.TrackApp.TrackApp.domain.Session;
import com.TrackApp.TrackApp.repository.SessionRepository;
import com.TrackApp.TrackApp.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oana_ on 6/14/2017.
 */

@Service
@Transactional(readOnly = true)
public class SessionRepoServiceImp implements SessionService {
    private SessionRepository sessionRepository;

    @Autowired
    public void setSessionRepository(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<?> listAll() {
        List<Session> sessions = new ArrayList<>();
        sessionRepository.findAll().forEach(sessions :: add);
        return sessions;
    }

    @Override
    public Session getById(Integer id) {
        return sessionRepository.findOne(id);

    }

    @Override
    @Transactional(readOnly = false)
    public Session saveOrUpdate(Session domainObject) {
        return sessionRepository.save(domainObject);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
       sessionRepository.delete(id);
    }
}
