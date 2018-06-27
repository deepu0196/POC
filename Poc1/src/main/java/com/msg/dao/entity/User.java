package com.msg.dao.entity;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "mobileno")
	private String mobileno;
	
	@Column(name = "email")
	private String email;
	private String address;
	
	
	@OneToOne
	@JoinColumn(name = "senderid")
 	private MsgBox msgbox;
	
		 
	public MsgBox getMsgbox() {
		return msgbox;
	}
	
	public void setMsgbox(MsgBox msgbox) {
		this.msgbox = msgbox;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	 
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
