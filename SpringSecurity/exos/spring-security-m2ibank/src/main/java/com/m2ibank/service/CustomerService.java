package com.m2ibank.service;

import com.m2ibank.config.jwt.JwtTokenProvider;
import com.m2ibank.model.Customer;
import com.m2ibank.repository.CustomerRepository;
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
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean verifyCustomer(String email, String password) {
        return customerRepository.findByEmail(email)
                .map(customer -> passwordEncoder.matches(password, customer.getPwd()))
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));
    }

    public boolean checkUserNameExists(String email){
        return customerRepository.findByEmail(email).isPresent();
    }

    public String generateToken(String email, String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    public boolean createUser(Customer customer){
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customerRepository.save(customer);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

}

