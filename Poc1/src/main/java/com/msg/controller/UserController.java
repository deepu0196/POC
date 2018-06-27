package com.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msg.dto.UserDto;
import com.msg.response.ResponseData;
import com.msg.service.IUserService;

@RestController("userController")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping( value = "/allusers", method  = RequestMethod.GET )
 	public ResponseData getUsers() {
 		
 		List<UserDto> users = userService.fetchAllUsers();
 		
 		ResponseData reponseData = new ResponseData("200", "success", users);
 		
 		return reponseData;
 		
 	}
	
 	@RequestMapping(value="/notes/{id}",method=RequestMethod.GET)
	public ResponseData findOne(@PathVariable(value="id") int iduser)
	{
		UserDto emp= userService.findOne(iduser);
		ResponseData responseData = new ResponseData("200", "success", emp);
		return responseData;
	}
 	
 	
 	@RequestMapping(value="/add",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData save(@RequestBody UserDto emp)
	{
		 emp= userService.saveemp(emp);
		ResponseData responseData=new ResponseData("200","success",emp);
		return responseData;
	}
 	
 	
 	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseData updateEmp(@RequestBody  UserDto emp)
	{
		 emp= userService.updateEmp(emp);
		ResponseData status=new ResponseData("200","Successfuylly Updated!!",emp);
		return status;
	}
 	
 	
 	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData delete(@PathVariable("id") int iduser) {
	 userService.delete(iduser);	
     ResponseData status = new ResponseData();
     status.setCode("200");
     status.setMessage("Employee Deleted Successfully");    
     return status;
	}
	

}
