package com.tharsikan.oauthoauthoauth.repository;

import com.tharsikan.oauthoauthoauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String name);
}
