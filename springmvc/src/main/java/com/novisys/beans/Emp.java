package com.novisys.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "emp")

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="empno")
public class Emp implements Serializable {

//	private static final long serialVersionUID = 5069815149657599384L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MyEmpNo_Gen")
	@SequenceGenerator(name="MyEmpNo_Gen", sequenceName="empno_seq")
	@Column(name = "empno")
	private int empno;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "salary")
	private int salary;
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Dept.class)
	@JoinColumn(name = "deptno")
	private Dept dept;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Addr_ID")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
		//djflsvjalskdg,laskfgjsalkfjlaskjlak
	}
	
}
