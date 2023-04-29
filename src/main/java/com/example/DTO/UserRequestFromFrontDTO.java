package com.example.DTO;


import com.example.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequestFromFrontDTO {
    private String email;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private Long cin;
}
