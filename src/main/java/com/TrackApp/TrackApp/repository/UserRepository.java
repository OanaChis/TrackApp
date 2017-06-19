package com.TrackApp.TrackApp.repository;

import com.TrackApp.TrackApp.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by oana_ on 6/14/2017.
 */
public interface UserRepository extends CrudRepository <User,Integer>{
    User findByUserName(String userName);

}
