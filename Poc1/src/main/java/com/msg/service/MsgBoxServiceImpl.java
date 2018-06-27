package com.msg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msg.dao.entity.MsgBox;
 import com.msg.dao.repository.MsgBoxRepository;
import com.msg.dto.MsgBoxDto;
 
 

@Service("msgService")
public class MsgBoxServiceImpl implements IMsgBoxService {
	
	@Autowired
	private MsgBoxRepository msgboxRepository;

	@Override
	public List<MsgBoxDto> fetchAll() {
		List<MsgBox> msgList = msgboxRepository.findAll();
		return msgAssembler(msgList);
		 
	}
	
	private List<MsgBoxDto> msgAssembler(List<MsgBox> msgList){
		List<MsgBoxDto> msgs = new ArrayList<>();
		msgList.forEach( msg -> {
			MsgBoxDto msgDto = new MsgBoxDto();
			msgDto.setMsgid(msg.getMsgid());
			msgDto.setMsgtitle(msg.getMsgtitle());
			msgDto.setMsgdesc(msg.getMsgdesc());
			msgDto.setMsgdate(msg.getMsgdate());
		 	msgDto.setSenderid(msg.getSenderid());
			msgDto.setSendername(msg.getSendername());
			msgDto.setStatusid(msg.getStatusid());
			msgDto.setThemeid(msg.getThemeid());
			 
			msgs.add(msgDto);
		});
		
		return msgs;
	}

	@Override
	public MsgBoxDto findOne(int msgid) {
		 
		MsgBox msgbox = msgboxRepository.getOne(msgid);
		MsgBoxDto  msgDto = new MsgBoxDto();
		 
		msgDto.setMsgid(msgbox.getMsgid()); 
		msgDto.setMsgtitle(msgbox.getMsgtitle());
		msgDto.setMsgdesc(msgbox.getMsgdesc());
		msgDto.setSenderid(msgbox.getSenderid());
		msgDto.setSendername(msgbox.getSendername());
		msgDto.setStatusid(msgbox.getStatusid());
		msgDto.setThemeid(msgbox.getThemeid());
		msgDto.setMsgdate(msgbox.getMsgdate());
		 
	 	return msgDto;
	}

	@Override
	public MsgBoxDto update(MsgBoxDto msgDto) {
		
		MsgBox msgupdate = msgboxRepository.getOne(msgDto.getMsgid());
		 
		msgupdate.setMsgtitle(msgDto.getMsgtitle());
		msgupdate.setMsgdesc(msgDto.getMsgdesc());
		msgupdate.setSenderid(msgDto.getSenderid());
		msgupdate.setSendername(msgDto.getSendername());
		msgupdate.setStatusid(msgDto.getStatusid());
		msgupdate.setThemeid(msgDto.getThemeid());
		
		 msgupdate = msgboxRepository.save(msgupdate);
		 return msgDto;
		
	}
	

	@Override
	public MsgBoxDto save(MsgBoxDto msgDto) {
		 
		MsgBox msgbox = new MsgBox();
		msgbox.setMsgtitle(msgDto.getMsgtitle());
		msgbox.setMsgdesc(msgDto.getMsgdesc());
		msgbox.setMsgdate(msgDto.getMsgdate());
		msgbox.setSenderid(msgDto.getSenderid());
		msgbox.setSendername(msgDto.getSendername());
		msgbox.setStatusid(msgDto.getStatusid());
		msgbox.setThemeid(msgDto.getThemeid());
		
		
	   	msgbox = msgboxRepository.save(msgbox);
		msgDto.setMsgid(msgbox.getMsgid());
		
	return msgDto;
	 
	}
	
 
	
	 
	

	@Override
	public void delete(int msgid) {

		MsgBox msg = msgboxRepository.getOne(msgid);
	msgboxRepository.delete(msg);	
	
		
	}
 

	 
}
