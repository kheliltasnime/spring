package com.example.demo.Dto;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDepartement {
    Long id;
    String adresse;
    String name;
    Boolean status;
    private Instant createdAt;
    private Instant updatedAt;
    private List<ResponseUser> user;

    public static ResponseDepartement makeDepartment(Department department) {
        return ResponseDepartement.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();
    }

    public static ResponseDepartement makeDeaprtmentWithUser(Department department) {
        List<User> users = department.getUser();
        List<ResponseUser> usersFormated = new ArrayList<>();
        for (User user : users) {
            ResponseUser memeber = ResponseUser.makeUser(user);
            usersFormated.add(memeber);
        }
        return ResponseDepartement.builder()
                .id(department.getId())
                .name(department.getName())
                .adresse(department.getAdresse())
                .status(department.getStatus())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .user(usersFormated)
                .build();

    }
}