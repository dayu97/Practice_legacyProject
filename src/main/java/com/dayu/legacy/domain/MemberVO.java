package com.dayu.legacy.domain;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	
	/*
	"MID" VARCHAR2(500 BYTE), 
	"MPW" VARCHAR2(15 BYTE), 
	"MNAME" VARCHAR2(100 BYTE), 
	"MADDRESS" VARCHAR2(500 BYTE), 
	"MPHONE" VARCHAR2(300 BYTE), 
	"MRDATE" DATE DEFAULT SYSDATE, 
	 */

	private String mid;
	private String mpw;
	private String mname;
	private String maddress;
	private String mphone;
	
	
	
	
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	
	
	
}
