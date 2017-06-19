package com.TrackApp.TrackApp.services.security;

/**
 * Created by oana_ on 6/15/2017.
 */
public interface SecurityService {
     String findLoggedInUserName();

     void autoLogin(String userName,String pass);

}
