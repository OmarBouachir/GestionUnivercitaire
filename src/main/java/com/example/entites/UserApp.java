package com.example.entites;

import com.example.enums.Role;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String password;
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;
    @OneToOne
    private Enseignant enseignant;

}
