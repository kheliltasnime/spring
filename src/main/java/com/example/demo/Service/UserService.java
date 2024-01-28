package com.example.demo.Service;

import com.example.demo.Dto.RequestUser;
import com.example.demo.Dto.RequestUserUpdate;
import com.example.demo.Dto.ResponseUser;
import com.example.demo.Entities.User;

import java.util.List;

public interface UserService {
    List<ResponseUser> getAllUser();
    boolean deleteUser(Long id);
   void createUser(RequestUser userRequest);
   User updateUser(Long id, RequestUserUpdate userRequest);
   ResponseUser getUserById(Long id);
}
