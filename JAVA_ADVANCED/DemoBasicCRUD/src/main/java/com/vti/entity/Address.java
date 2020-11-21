package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Address", catalog = "TestingSystem")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short addressID;

	@Column(name = "AddressName", length = 100, nullable = false, unique = true, updatable = true)
	private String addressName;
	
	@OneToMany(mappedBy = "Position")
	private List<Department> departments;
}
