package com.bugra.service;

import com.bugra.repo.UserRepo;
import com.bugra.model.User;
import com.bugra.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userRepo.findByUsername(username);
       if(user==null){
           throw new UsernameNotFoundException("User not found");
       }
        System.out.println(user.getUsername());
       return new UserPrinciple(user);
    }
}
