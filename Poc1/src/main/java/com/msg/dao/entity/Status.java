package com.msg.dao.entity;

 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	
	@Id
	@Column(name = "statusid")
	private Integer statusid;
	
	
	private Integer statustype;
	private String statusdesc; 
	
	@OneToOne
	@JoinColumn(name = "statusid")
	private MsgBox msgbox;
	
	
	public MsgBox getMsgbox() {
		return msgbox;
	}
	
	public void setMsgbox(MsgBox msgbox) {
		this.msgbox = msgbox;
	}
	public Integer getStatusid() {
		return statusid;
	}
	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}
	 
	public Integer getStatustype() {
		return statustype;
	}

	public void setStatustype(Integer statustype) {
		this.statustype = statustype;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

}
