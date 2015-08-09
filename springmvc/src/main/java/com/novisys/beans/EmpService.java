package com.novisys.beans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpService {

	@PersistenceContext
	private EntityManager em;

	public Emp getEmpJPA(int empNo) {
		Emp empObj = em.find(Emp.class, empNo);
		return empObj;
	}
	
	public Dept getDeptDetailsJPA(int deptNo) {
		Dept dept = em.find(Dept.class, deptNo);
		return dept;
	}
	
	public Address getAddressDetailsJPA(int addrID) {
		Address address = em.find(Address.class, addrID);
		return address;
	}
	
	
	public Emp saveEmp() {
		
		Dept dept = em.find(Dept.class, 30);
		
		Emp empObj = new Emp();
		empObj.setEname("Emp-9");
		empObj.setSalary(20000);
		empObj.setDept(dept);
		
		em.persist(empObj);
		em.flush();
		return empObj;
	}

}
