package com.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
import com.msg.dto.StatusDto;
import com.msg.response.ResponseData;
import com.msg.service.IStatusService;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private IStatusService staService;
	
	@RequestMapping( value = "/allstatus", method  = RequestMethod.GET )
 	public ResponseData getMsgs() {
 		
 		List<StatusDto> stas = staService.fetchAll();
 		ResponseData reponseData = new ResponseData("200", "success", stas);
 		
 		return reponseData;
 		
 	}
	
  	
 	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseData update(@RequestBody  StatusDto stas)
	{
		 stas= staService.update(stas);
		ResponseData status=new ResponseData("200","Successfuylly Updated!!",stas);
		return status;
	}
 	
 	
 	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData delete(@PathVariable("id") int statusid) {
	 staService.delete(statusid);	
     ResponseData status = new ResponseData();
     status.setCode("200");
     status.setMessage(" Deleted Successfully");    
     return status;
	}
	

	
	
	

	
	
}
