package com.msg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.msg.dao.entity.User;
import com.msg.dao.repository.UserRepository;
import com.msg.dto.UserDto;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public List<UserDto> fetchAllUsers() {
		List<User> userList = userRepository.findAll();
		return userAssembler(userList);
		 
	}
		
	
	private List<UserDto> userAssembler(List<User> userList){
		List<UserDto> users = new ArrayList<>();
		userList.forEach( user -> {
			UserDto userDto = new UserDto();
			userDto.setUserid(user.getUserid());
			userDto.setUsername(user.getUsername());
			userDto.setMobileno(user.getMobileno());
			userDto.setEmail(user.getEmail());
			userDto.setAddress(user.getAddress());
		
		 									 
			users.add(userDto);
		});
		
		return users;
	}
	
	 

	 
	@Override
	public UserDto findOne(int iduser) {
		User user= userRepository.getOne(iduser);
		UserDto userDto = new UserDto();
		userDto.setUserid(user.getUserid()); 
		userDto.setUsername(user.getUsername());
		userDto.setMobileno(user.getMobileno());
		userDto.setEmail(user.getEmail());
		userDto.setAddress(user.getAddress());
		
		 
		return userDto;
	}

	@Override
	public UserDto updateEmp(UserDto user) {
		User userupdate = userRepository.getOne(user.getUserid());
		 userupdate.setUsername(user.getUsername());
		 userupdate.setMobileno(user.getMobileno());
		 userupdate.setEmail(user.getEmail());
		 userupdate.setAddress(user.getAddress());
	 
		 userupdate = userRepository.save(userupdate);
		 return user;
	}

	@Override
	public UserDto saveemp(UserDto userDto) {
		
			User user = new User();
		 	user.setUsername(userDto.getUsername());
		 	user.setMobileno(userDto.getMobileno());
		 	user.setEmail(userDto.getEmail());
		 	user.setAddress(userDto.getAddress());
		 	 
		 	 
		   	user = userRepository.save(user);
			userDto.setUserid(user.getUserid());
			
		return userDto;
	  
	}

	 	
	
	@Override
	public void delete(int iduser) {

		User user = userRepository.getOne(iduser);
		userRepository.delete(user);	
	
		
	}
		
}
