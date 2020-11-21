package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`Account`", catalog = "TestingSystem")
public class Account implements Serializable {

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountId;

	@Column(name = "Email", nullable = false, unique = true, updatable = true)
	private String email;

	@Column(name = "Username", nullable = false, unique = true, updatable = true)
	private String userName;

	@Column(name = "FirstName", nullable = false, unique = false)
	private String firstName;
	
	@Column(name = "LastName", nullable = false, unique = false)
	private String lastName;
	
	@Formula("concat(FirstName,' ',Lastname)")
	private String fullName;
	
	@ManyToOne
	@JoinColumn(name="DepartmentID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="PositionID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name="SalaryID")
	private Salary salary;

	@Column(name="CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	
}
