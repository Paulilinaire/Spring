package com.example.backendspringsecurity.service;

import com.example.backendspringsecurity.config.jwt.JwtTokenProvider;
import com.example.backendspringsecurity.model.User;
import com.example.backendspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean verifyUser(String name, String password) {
        return userRepository.findByName(name)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + name));
    }

    public boolean checkUserNameExists(String name){
        return userRepository.findByName(name).isPresent();
    }


    public String generateToken(String name, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);
        return token;
    }

    public boolean createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + name));
    }

}

