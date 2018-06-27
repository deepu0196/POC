package com.msg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msg.dto.MsgBoxDto;
import com.msg.response.ResponseData;
import com.msg.service.IMsgBoxService;
 
 
 
 
@RestController("msgController")
@RequestMapping("/msg")
public class MsgController {
	
	@Autowired
	private IMsgBoxService msgService;
	
	 
	@RequestMapping( value = "/allmsg", method  = RequestMethod.GET )
 	public ResponseData getMsgs() {
 		
 		List<MsgBoxDto> msgs = msgService.fetchAll();
 		
 		ResponseData reponseData = new ResponseData("200", "success", msgs);
 		
 		return reponseData;
 		
 	}
	
	@RequestMapping(value="/notes/{id}",method=RequestMethod.GET)
	public ResponseData findOne(@PathVariable(value="id") int msgid)
	{
		MsgBoxDto msgs= msgService.findOne(msgid);
		ResponseData responseData = new ResponseData("200", "success", msgs);
		return responseData;
	}
 	
 	
 	@RequestMapping(value="/add",method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData save(@RequestBody MsgBoxDto msgs)
	{
		 msgs= msgService.save(msgs);
		ResponseData responseData=new ResponseData("200","success",msgs);
		return responseData;
	}
 	
 	
 	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public ResponseData updateEmp(@RequestBody  MsgBoxDto msgs)
	{
		 msgs= msgService.update(msgs);
		ResponseData status=new ResponseData("200","Successfuylly Updated!!",msgs);
		return status;
	}
 	
 	
 	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseData delete(@PathVariable("id") int msgid) {
	 msgService.delete(msgid);	
     ResponseData status = new ResponseData();
     status.setCode("200");
     status.setMessage(" Deleted Successfully");    
     return status;
	}
	
 	
  
	
	
	
	
	 
 	
	
	 

}
