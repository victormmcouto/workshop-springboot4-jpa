package com.educandoweb.coursoSpring.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
