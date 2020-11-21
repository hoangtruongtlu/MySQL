package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetailDepartment", catalog = "TestingSystem")
public class DetailDepartment implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "AddressID")
	private Address address;

	@Column(name = "EmulationpPoint")
	private short emulationPoint;
}
