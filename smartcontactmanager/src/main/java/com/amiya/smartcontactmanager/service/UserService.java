package com.amiya.smartcontactmanager.service;

import java.util.List;
import java.util.Optional;

import com.amiya.smartcontactmanager.entity.Users;

public interface UserService {

    Users saveUser(Users user);

    Optional<Users> getUserById(String id);

    Optional<Users> updateUser(Users user);

    void deleteUser(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<Users> getAllUsers();

    Users getUserByEmail(String email);

}
