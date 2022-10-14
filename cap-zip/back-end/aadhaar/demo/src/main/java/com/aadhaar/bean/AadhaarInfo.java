package com.aadhaar.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "AadhaarInfo")
public class AadhaarInfo {
	
	@Id
	private String emailid;
	@Column(unique = true)
	private String aid;
	private String name,address,mobileNo,gender,date,status;
	public AadhaarInfo() {
		super();
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AadhaarInfo(String emailid, String aid, String name, String address, String mobileNo, String gender,
			String date, String status) {
		super();
		this.emailid = emailid;
		this.aid = aid;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.date = date;
		this.status = status;
	}
	@Override
	public String toString() {
		return "AadhaarInfo [emailid=" + emailid + ", aid=" + aid + ", name=" + name + ", address=" + address
				+ ", mobileNo=" + mobileNo + ", gender=" + gender + ", date=" + date + ", status=" + status + "]";
	}
	
	 
}
