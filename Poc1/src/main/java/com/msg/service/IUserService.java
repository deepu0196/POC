package com.msg.service;

import java.util.List;

import com.msg.dto.UserDto;

 

public interface IUserService {
	
	List<UserDto> fetchAllUsers();
	
	UserDto findOne(int iduser);
	
	UserDto updateEmp(UserDto user);
	
	UserDto saveemp(UserDto emp);
	
	void delete(int iduser );

	

}
