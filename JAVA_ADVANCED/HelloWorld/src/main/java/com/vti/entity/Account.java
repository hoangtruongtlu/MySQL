package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`account`", catalog = "TestingSystem")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4078790070705975018L;

	@Column(name = "AccountID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
	@Id
	private int accountID;
	
	@Column(name = "Email",length = 50,nullable = false,unique = false,updatable = true)
	private String userName;
	
	@Column(name = "UserName",length = 50,nullable = false,unique = false,updatable = true)
	private String email;
	
	@Column(name = "FullName",length = 50,nullable = false,unique = false,updatable = true)
	private String fullName;
	
	@Column(name = "DepartmentID")
	private int departmentID;
	
	@Column(name = "PositionID")
	private int positionID;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)  // Date SQL
	private Date createDate;

	public Account() {

	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}