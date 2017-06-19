package com.TrackApp.TrackApp.converter;

import com.TrackApp.TrackApp.domain.Role;
import com.TrackApp.TrackApp.services.security.UserDetailsImp;
import com.TrackApp.TrackApp.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by oana_ on 6/17/2017.
 */
@Component
public class UserToUserDetails implements Converter<User,UserDetails> {

    @Override
    public UserDetails convert(User user) {
        UserDetailsImp userDetails = new UserDetailsImp();

        if (user != null){
            userDetails.setUserName(user.getUserName());
            userDetails.setPassword(user.getEncryptedPassword()); // to check this line
            userDetails.setEnabled(user.getEnabled());
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.toString()));
            authorities.add(new SimpleGrantedAuthority(Role.USER.toString()));

            userDetails.setAuthorities(authorities);

        }

        return userDetails;
    }
}


