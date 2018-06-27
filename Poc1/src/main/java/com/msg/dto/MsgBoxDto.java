package com.msg.dto;

 

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.msg.dao.entity.Status;
import com.msg.dao.entity.Theme;
import com.msg.dao.entity.User;

@JsonInclude(Include.NON_NULL)
public class MsgBoxDto {
	
	private Integer msgid;		 
	private String msgtitle;
	
	private String msgdesc;
	private Date msgdate;
	

	private Integer statusid;
	private Integer themeid;
	
	private Integer senderid;
	private String sendername;
	
	private User users;
	private Status status;
	private Theme theme;
	
	
	
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	 	
	public String getMsgtitle() {
		return msgtitle;
	}
	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}
	public String getMsgdesc() {
		return msgdesc;
	}
	public void setMsgdesc(String msgdesc) {
		this.msgdesc = msgdesc;
	}
	
	public Date getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(Date msgdate) {
		this.msgdate = msgdate;
	}
	public Integer getStatusid() {
		return statusid;
	}
	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}
	public Integer getThemeid() {
		return themeid;
	}
	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}
	public Integer getSenderid() {
		return senderid;
	}
	public void setSenderid(Integer senderid) {
		this.senderid = senderid;
	}
	public String getSendername() {
		return sendername;
	}
	public void setSendername(String sendername) {
		this.sendername = sendername;
	}
	
		public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}
	 
	 
	 
	
}
