package com.novisys.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class EmpDAO {
	
	private static final Logger logger = Logger.getLogger(EmpDAO.class);
	
	private JdbcTemplate jt;
	private EmpResultSetExtractor extractor;
	
	public EmpResultSetExtractor getExtractor() {
		return extractor;
	}

	public void setExtractor(EmpResultSetExtractor extractor) {
		this.extractor = extractor;
	}

	public JdbcTemplate getJt() {
		return jt;
		
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void remove(int empno) {
		jt.update("delete emp where empno="+empno);
	}
	
	public void updateSalary(int empno, int salary) {
		jt.update("update emp set salary = ? where empno = ?", new Object[]{salary, empno});
	}
	
	public void save() {
		PreparedStatementSetter pss = new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, 106);
				ps.setString(2, "EMP-6");
				ps.setInt(3, 55000);
				ps.setInt(4, 20);
			}
		};
		jt.update("insert into emp values (?,?,?,?)", pss);
	}
	
	public Emp getEmp(int empNo) {
		logger.debug("EmpDAO - /empDetails/{empNo} - GET");
		return jt.query("Select *from emp where empno = " + empNo, extractor);
	}
	
	public Emp getEmpDetails(Emp empObj) {
		return jt.query("Select *from emp where ename = '" + empObj.getEname()+"'", extractor);
	}
	
}
