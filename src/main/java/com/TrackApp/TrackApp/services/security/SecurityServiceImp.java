package com.TrackApp.TrackApp.services.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by oana_ on 6/15/2017.
 */
@Service
public class SecurityServiceImp  implements SecurityService{

    private AuthenticationManager authenticationManager;

    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImp.class);


    @Override
    public String findLoggedInUserName() {
        Object userDet = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDet instanceof UserDetails){
            return ((UserDetails)userDet).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String userName, String pass) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken
                usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,pass,userDetails.getAuthorities());


        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("Auto Login With Success",userName));
        }


    }
}
