package com.vti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="`Question`",catalog = "TestingSystem")
public class Question implements Serializable{
	
	@ManyToMany
	Set<Exam> exams;
}
