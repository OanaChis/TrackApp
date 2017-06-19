package com.TrackApp.TrackApp.services.reposervices;

import com.TrackApp.TrackApp.domain.User;
import com.TrackApp.TrackApp.repository.UserRepository;
import com.TrackApp.TrackApp.services.UserService;
import com.TrackApp.TrackApp.services.security.EncryptionService;
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
public class UserRepoServicesImp implements UserService {



    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private EncryptionService encryptionService;

    // some error here , no encryptionService bean was found , to check
    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }


    @Override
    public List<?> listAll() {
        List<User> users  = new ArrayList<>();
        userRepository.findAll().forEach(users :: add);
        return users;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = false)
    public User saveOrUpdate(User domainObject) {
        return userRepository.save(domainObject);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
       userRepository.delete(id);
    }

    @Override
    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }
}
