package com.msg.service;

import java.util.List;

import com.msg.dto.StatusDto;

 

public interface IStatusService {
	
	List<StatusDto> fetchAll();
		 
	StatusDto update(StatusDto status);
	
	void delete(int statusid );

}
