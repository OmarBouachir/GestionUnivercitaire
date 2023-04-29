package com.example.DTO;

import com.example.entites.Enseignant;
import com.example.entites.Etudiant;
import com.example.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String email;
    private String password;
    private Role role;
    private Etudiant etudiant;
    private Enseignant enseignant;

}
