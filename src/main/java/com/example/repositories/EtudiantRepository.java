package com.example.repositories;

import com.example.entites.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,UUID> {

}
