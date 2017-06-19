package com.TrackApp.TrackApp.services.security;

import com.TrackApp.TrackApp.domain.User;
import com.TrackApp.TrackApp.services.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by oana_ on 6/15/2017.
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private UserService userService;
    private Converter<User,UserDetails> userUserDetailsConverter;



    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUserUserDetailsConverter(Converter<User,UserDetails> userUserDetailsConverter){
        this.userUserDetailsConverter = userUserDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userUserDetailsConverter.convert(userService.findByUsername(userName));
    }
}
