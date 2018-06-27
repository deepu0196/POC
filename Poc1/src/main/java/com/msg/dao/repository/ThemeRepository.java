package com.msg.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msg.dao.entity.Theme;

@Repository("themeRepository")
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
