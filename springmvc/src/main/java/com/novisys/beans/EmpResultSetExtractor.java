package com.novisys.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmpResultSetExtractor implements ResultSetExtractor<Emp> {

	public Emp extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		if(rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSalary(rs.getInt(3));
//			emp.setDeptno(rs.getInt(4));
			return emp;
		}
		return null;
	}

}
