package com.amiya.smartcontactmanager.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amiya.smartcontactmanager.entity.Users;
import com.amiya.smartcontactmanager.exception.ResourceNotFoundException;
import com.amiya.smartcontactmanager.repository.UserRepository;
import com.amiya.smartcontactmanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Users saveUser(Users user) {

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        user.setPassword(user.getPassword());

        logger.info(user.getProvider().toString());

        return userRepo.save(user);

    }

    @Override
    public Optional<Users> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<Users> updateUser(Users user) {

        Users user2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        Users save = userRepo.save(user2);
        return Optional.ofNullable(save);

    }

    @Override
    public void deleteUser(String id) {
        Users user2 = userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.delete(user2);

    }

    @Override
    public boolean isUserExist(String userId) {
        Users user2 = userRepo.findById(userId).orElse(null);
        return user2 != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        Users user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

}