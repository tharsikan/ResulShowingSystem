package com.tharsikan.oauthoauthoauth.service;

import com.tharsikan.oauthoauthoauth.model.User;
import com.tharsikan.oauthoauthoauth.model.UserDetail;
import com.tharsikan.oauthoauthoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(name);
        optionalUser.orElseThrow(()-> new UsernameNotFoundException("username or password wrong"));
        UserDetails userDetails = new UserDetail(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
