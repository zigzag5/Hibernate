package com.test.hibernate.model;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "PROJECT")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="employee")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proj_id")
	private long id;

	@Column(name = "title")
	private String title;

	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="project_employee",
			joinColumns=@JoinColumn(name="proj_id"),
			inverseJoinColumns=@JoinColumn(name="emp_id")
			)
	private List<Employee> employees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

		
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

		
	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + "]";
	}
	
}
