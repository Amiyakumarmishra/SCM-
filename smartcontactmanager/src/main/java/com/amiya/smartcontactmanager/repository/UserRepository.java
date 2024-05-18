package com.amiya.smartcontactmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amiya.smartcontactmanager.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByEmailAndPassword(String email, String password);
}
