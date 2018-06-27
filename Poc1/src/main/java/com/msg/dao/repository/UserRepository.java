package com.msg.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msg.dao.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
