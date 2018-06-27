package com.msg.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msg.dao.entity.Status;

@Repository("staRepository")
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
