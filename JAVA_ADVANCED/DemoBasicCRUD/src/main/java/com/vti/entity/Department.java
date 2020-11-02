package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`department`", catalog = "TestingSystem")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "DepartmentID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Id
	private int departmentID;

	@Column(name = "DepartmentName", length = 30, nullable = false, unique = false, updatable = true)
	@Size(min = 6, max = 20, message = "Ten tu 6-20 ky tu")
	private String departmentName;

	public Department() {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]";
	}

}