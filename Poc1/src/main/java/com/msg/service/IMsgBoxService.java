package com.msg.service;

import java.util.List;

import com.msg.dto.MsgBoxDto;
 

public interface IMsgBoxService {

	
	List<MsgBoxDto> fetchAll();
	
	MsgBoxDto findOne(int msgid);
	
	MsgBoxDto update(MsgBoxDto msg);
	
	MsgBoxDto save(MsgBoxDto msg);
	
	void delete(int msgid );
}
