package com.novisys.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "dept")

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="deptno")
public class Dept implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MyDeptNo_Gen")
	@SequenceGenerator(name="MyDeptNo_Gen", sequenceName="deptno_seq")
	@Column(name = "deptno")
	private int deptno;
	
	@Column(name = "dname")
	private String dname;

	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "dept")
	public List<Emp> empList;

	@JsonIgnore
	public List<Emp> getEmpList() {
		return empList;
	}
	
	@JsonIgnore
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	@Transient
	public List<Integer> empIds;

	public List<Integer> getEmpIds() {
		
		List<Integer> empIds = new ArrayList<Integer>();
		for(Emp emp : this.empList) {
			empIds.add(emp.getEmpno());
		}
		
		return empIds;
	}
	/*public void setEmpIds(List<Integer> empIds) {
		this.empIds = empIds;
	}*/
	
	
}
