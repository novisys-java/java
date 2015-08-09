/**
 * 
 */
package com.novisys.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/**
 * @author KCSunkara
 *
 */
//public class UserController implements Controller {
public class UserController extends AbstractCommandController {
	
	private EmpDAO empDAO;
	
	public EmpDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(EmpDAO empDAO) {
		this.empDAO = empDAO;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Emp emp = new Emp();
		emp.setEname(req.getParameter("userName"));
		
//		Emp empDetails = empDAO.getEmpDetails(emp);
		Emp empDetails = empDAO.getEmp(Integer.parseInt(req.getParameter("userName")));
		
		if(empDetails != null) {
			ModelAndView model = new ModelAndView("/userDetails.jsp");
			model.addObject("empDetails", empDetails);
			return model;
		} else {
			return new ModelAndView("/userDetails.html");
		}
	}*/
	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object commandObject, BindException errors)
			throws Exception {
		System.out.println("In handle method...");
		
		if(errors.hasErrors()) {
			return new ModelAndView("/errorPage.jsp", "errors", errors);
		}
		
		Emp emp = (Emp) commandObject;
		System.out.println("In handle method... After breakpoint");		
		System.out.println("EmpName --- : "+emp.getEname());
		
		Emp empDetails = empDAO.getEmpDetails(emp);
//		Emp empDetails = empDAO.getEmp(Integer.parseInt(req.getParameter("userName")));
		
		if(empDetails != null) {
			ModelAndView model = new ModelAndView("/userDetails.jsp");
			model.addObject("empDetails", empDetails);
			return model;
		} else {
			return new ModelAndView("/userDetails.html");
		}
		
	}

}
