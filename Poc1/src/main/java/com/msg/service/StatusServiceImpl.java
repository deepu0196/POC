package com.msg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.msg.dao.entity.Status;
import com.msg.dao.repository.StatusRepository;
import com.msg.dto.StatusDto;
 

@Service("staService")
public class StatusServiceImpl  implements IStatusService{
	
	
	@Autowired
	private StatusRepository staRepository;

	@Override
	public List<StatusDto> fetchAll() {
		List<Status> statusList = staRepository.findAll();
		 return staAssembler(statusList);
		 
	}
	

	private List<StatusDto> staAssembler(List<Status> staList){
		List<StatusDto> statuss = new ArrayList<>();
		staList.forEach( status -> {
			StatusDto staDto = new StatusDto();
			staDto.setStatusid(status.getStatusid());
			staDto.setStatustype(status.getStatustype());
			staDto.setStatusdesc(status.getStatusdesc());
			
			statuss.add(staDto);
		});
		
		return statuss;
	}
	
	 
 
	@Override
	public StatusDto update(StatusDto status) {
		 
		
		Status staupdate = staRepository.getOne(status.getStatusid());
		 staupdate.setStatustype(status.getStatustype());
		 staupdate.setStatusdesc(status.getStatusdesc());
	 
	   staupdate = staRepository.save(staupdate);
		 return status;
	 
	}

	
	 

	@Override
	public void delete(int statusid) {
		Status sta = staRepository.getOne(statusid);
		staRepository.delete(sta);	
		
	}

	 
	
}
