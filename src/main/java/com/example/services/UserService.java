package com.example.services;

import com.example.DTO.*;
import com.example.entites.Enseignant;
import com.example.entites.Etudiant;
import com.example.entites.UserApp;
import com.example.enums.Role;
import com.example.repositories.EnseignantRepository;
import com.example.repositories.EtudiantRepository;
import com.example.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;

    ModelMapper modelMapper=new ModelMapper();

    public List<UserApp> getAllUsers(){
        List<UserApp> userAppFromDataBase =userRepository.findAll();
        return userAppFromDataBase;
    }

    public UserApp getById(UUID id){
        return userRepository.findById(id).get();
    }

    public UUID create(UserRequestFromFrontDTO userRequestFromFrontDTO) {
        if (userRequestFromFrontDTO.getRole()==Role.Etudiant){
            EtudiantDTO etudiantDTO =new EtudiantDTO(userRequestFromFrontDTO.getFirstName(),userRequestFromFrontDTO.getLastName(),userRequestFromFrontDTO.getCin());
            Etudiant etudiantToPersist=modelMapper.map(etudiantDTO,Etudiant.class);
            etudiantRepository.save(etudiantToPersist);
            UserDTO userDTO =new UserDTO(userRequestFromFrontDTO.getEmail(),userRequestFromFrontDTO.getPassword(),userRequestFromFrontDTO.getRole(),etudiantToPersist,null);
            UserApp userAppToPersist =modelMapper.map(userDTO, UserApp.class);
            userRepository.save(userAppToPersist);
            return userAppToPersist.getId();
        }else if (userRequestFromFrontDTO.getRole()==Role.Enseignant){
            EnseignantDTO enseignantDTO=new EnseignantDTO(userRequestFromFrontDTO.getFirstName(),userRequestFromFrontDTO.getLastName(),userRequestFromFrontDTO.getCin());
            Enseignant enseignantToPersist=modelMapper.map(enseignantDTO,Enseignant.class);
            enseignantRepository.save(enseignantToPersist);
            UserDTO userDTO=new UserDTO(userRequestFromFrontDTO.getEmail(),userRequestFromFrontDTO.getPassword(),userRequestFromFrontDTO.getRole(),null,enseignantToPersist);
            UserApp userAppToPersist =modelMapper.map(userDTO, UserApp.class);
            userRepository.save(userAppToPersist);
            return userAppToPersist.getId();
        }else {
            return null;
        }

    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public List<UserApp> getUserByRole(String role) {
        if (role.equals("Etudiant")){
            return userRepository.findAllByRole(Role.Etudiant);
        }else if (role.equals("Enseignant")){
            return userRepository.findAllByRole(Role.Enseignant);
        }else return null;
    }

    public UUID login(AuthRequestDTO authRequestDTO) {
       UserApp userAppFromDataBase= userRepository.findByEmailAndPassword(authRequestDTO.getEmail(),authRequestDTO.getPassword());
       if (userAppFromDataBase==null){
           System.out.println("user don't exist ");
           throw new RuntimeException("user dosn't exist");
       }else {
           return userAppFromDataBase.getId();
       }
    }
}
