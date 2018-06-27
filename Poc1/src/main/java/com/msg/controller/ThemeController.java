package com.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msg.dto.ThemeDto;
import com.msg.response.ResponseData;
 
import com.msg.service.IThemeService;

@RestController("themeController")
@RequestMapping("/theme")
public class ThemeController {
	
	
	
	@Autowired
	private IThemeService themeService;
	
	@RequestMapping( value = "/alltheme", method  = RequestMethod.GET )
 	public ResponseData getTheme() {
 		
 		List<ThemeDto> themes = themeService.fetchAll();
 		
 		ResponseData reponseData = new ResponseData("200", "success", themes);
 		
 		return reponseData;
 		
 	}
	
   	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseData update(@RequestBody  ThemeDto themes)
	{
		 themes= themeService.update(themes);
		ResponseData status=new ResponseData("200","Successfuylly Updated!!",themes);
		return status;
	}
 	
 	
 	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData delete(@PathVariable("id") int themeid) {
	 themeService.delete(themeid);	
     ResponseData status = new ResponseData();
     status.setCode("200");
     status.setMessage(" Deleted Successfully");    
     return status;
	}
	

	
	

}
