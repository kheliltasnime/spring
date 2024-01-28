package com.example.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RequestUserUpdate {
    Long id;
    String firstname;
    String lastname;
    Boolean status;
    int phoneNumber;
    @NotNull(message = "email is required")
    @Email
    String email;
    Long departmentId;


}
