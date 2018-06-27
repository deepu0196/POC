package com.msg.dao.entity;

 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "msgbox")
public class MsgBox {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer msgid;
	
	@Column(name = "msgtitle")
	private String msgtitle;

	private String msgdesc;
	
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date msgdate;
	
	
	private Integer statusid;
	private Integer themeid;
	
	
	private Integer senderid;
	private String sendername;
	
	
	@OneToOne(mappedBy = "msgbox")
	private User users;
	
	@OneToOne(mappedBy = "msgbox")
	private Status status;
	
	
	@OneToOne(mappedBy = "msgbox")
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

	public MsgBox() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getMsgid() {
		return msgid;
	}
	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
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
 


}
