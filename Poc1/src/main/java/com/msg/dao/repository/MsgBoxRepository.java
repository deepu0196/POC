package com.msg.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msg.dao.entity.MsgBox;

@Repository("msgboxRepositorty")
public interface MsgBoxRepository extends JpaRepository<MsgBox, Integer> { 

	
}
