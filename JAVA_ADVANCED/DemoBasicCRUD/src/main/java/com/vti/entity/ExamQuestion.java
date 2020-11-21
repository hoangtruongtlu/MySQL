package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ExamQuestion", catalog = "TestingSystem")
public class ExamQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	private short examId;

	@Column(name = "QuestionID")
	private short questionId;
}
