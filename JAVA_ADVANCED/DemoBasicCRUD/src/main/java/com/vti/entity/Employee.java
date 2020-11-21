package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Employee",catalog = "TestingSystem")
public class Employee extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="WorkingOfYear",nullable = false)
	private short workingOfYear;
}
