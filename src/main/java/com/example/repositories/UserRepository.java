package com.example.repositories;

import com.example.entites.UserApp;
import com.example.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserApp, UUID> {
    List<UserApp> findAllByRole(Role role);
    UserApp findByEmailAndPassword(String email, String password);

}
