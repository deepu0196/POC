package com.msg.dao.entity;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "theme")
public class Theme {

	@Id
	@Column(name = "themeid")
	private Integer themeid;
	
	private String themedesc;
	
	private Integer themetype;

	@OneToOne 
	@JoinColumn(name = "themeid")
	private MsgBox msgbox;
	
	
	public MsgBox getMsgbox() {
		return msgbox;
	}
	
	public void setMsgbox(MsgBox msgbox) {
		this.msgbox = msgbox;
	}
	
	public Integer getThemeid() {
		return themeid;
	}
	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}
	
	public String getThemedesc() {
		return themedesc;
	}

	public void setThemedesc(String themedesc) {
		this.themedesc = themedesc;
	}

	public Integer getThemetype() {
		return themetype;
	}

	public void setThemetype(Integer themetype) {
		this.themetype = themetype;
	}
	 
}
