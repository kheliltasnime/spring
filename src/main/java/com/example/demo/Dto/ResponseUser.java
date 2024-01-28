package com.example.demo.Dto;

import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUser {
    Long id;
    String firstname;
    String lastname;
    Boolean status;
    int phoneNumber;
    String email;
    String password;
    Long deaprtmentId; //foreign key
    private Instant createdAt;
    private Instant updatedAt;
    private ResponseDepartement department;

    public static ResponseUser makeUser(User user){
        return ResponseUser.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .status(user.getStatus())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
               // .department(ResponseDepartement
                     //   .makeDepartment(user.getDepartment()))
                .build();
    }


}
