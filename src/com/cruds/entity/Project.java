package com.cruds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project
{
	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private long id;
	
	@Column(name = "project_name")
	private String pName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public Project(String pName, List<Employee> employees) {
		super();
		this.pName = pName;
		this.employees = employees;
	}*/
	
	

	public String getpName() {
		return pName;
	}

	public Project(String pName) {
		super();
		this.pName = pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", pName=" + pName + ", employees=" + employees + "]";
	}
	
	
}
