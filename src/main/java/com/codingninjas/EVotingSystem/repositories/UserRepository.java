package com.codingninjas.EVotingSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingninjas.EVotingSystem.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);

}
