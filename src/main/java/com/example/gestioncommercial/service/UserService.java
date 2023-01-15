package com.example.gestioncommercial.service;

import com.example.gestioncommercial.Entity.Users;
import com.example.gestioncommercial.repository.UserRepository;
import com.example.gestioncommercial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public Users createUser(Users user) throws Exception {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        Optional<Users> userExist=userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(userExist.isPresent()) {
            throw new Exception("user already exist");
        }
        return userRepository.save(user);
    }

    public Users login(Users user) throws Exception {
        Optional<Users> userExist=userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(userExist.isPresent()) {
            if(passwordEncoder.matches(user.getPassword(),userExist.get().getPassword()))
                return userExist.get();
            else
                throw new Exception("password is incorrect");
        }
        throw new Exception("username or password is incorrect");
    }

}
