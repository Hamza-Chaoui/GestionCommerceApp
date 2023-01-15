package com.example.gestioncommercial.repository;

import com.example.gestioncommercial.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.username = ?1 and u.password = ?2")
    Optional<Users> findByUsernameAndPassword(String username, String password);

}
