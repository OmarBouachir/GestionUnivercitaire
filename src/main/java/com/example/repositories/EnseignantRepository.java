package com.example.repositories;

import com.example.entites.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, UUID> {
}
