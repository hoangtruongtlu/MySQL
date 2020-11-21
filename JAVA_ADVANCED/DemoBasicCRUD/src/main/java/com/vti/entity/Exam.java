package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Exam", catalog = "TestingSystem")
public class Exam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examId;

	@Column(name = "`Code`", length = 10, nullable = false)
	private String code;

	@Column(name = "Title", length = 50, nullable = false)
	private String title;

	@Column(name = "Duration", nullable = false, columnDefinition = "tinyint default 45")
	private short duration;

	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name="CreatorID")
	private Account account;
	
	@ManyToMany
	Set<Question> questions;
}
