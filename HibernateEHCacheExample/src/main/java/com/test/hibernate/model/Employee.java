package com.test.hibernate.model;

import javax.persistence.CascadeType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "EMPLOYEE")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "age")
	private int age;

	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="project_employee",
			joinColumns=@JoinColumn(name="emp_id"),
			inverseJoinColumns=@JoinColumn(name="proj_id")
			)	
	private List<Project> projects;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String salary) {
		this.email = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	

}
