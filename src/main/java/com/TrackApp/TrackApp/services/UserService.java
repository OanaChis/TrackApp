package com.TrackApp.TrackApp.services;

import com.TrackApp.TrackApp.domain.User;

/**
 * Created by oana_ on 6/14/2017.
 */
public interface UserService extends CrudService <User> {
    User findByUsername(String userName);
}
