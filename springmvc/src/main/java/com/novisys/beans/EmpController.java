package com.novisys.beans;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	
	private static final Logger logger = Logger.getLogger(EmpController.class);
	
	EmpController() {
		logger.info("EmpController object created...");
	}
	
	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	EmpService empService;
	
	@RequestMapping(value="/empDetails", method=RequestMethod.GET)
	public String getEmp(@RequestParam("empNo") int empNo, ModelMap modelMap) {
		Emp emp = empDAO.getEmp(empNo);
		modelMap.put("empDetails", emp);
		return "userDetails"; 
	}
	
	@RequestMapping(value="/empDetailsPost", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Emp> getEmp(@RequestParam("empno") String empno) {
		Emp emp1 = empDAO.getEmp(Integer.parseInt(empno));
		Map<String, Emp> empMap =  new HashMap<String, Emp>();
		empMap.put(emp1.getEname(), emp1);
		
		return empMap;
	}
	
	@RequestMapping(value="/empDetails/{empNo}", method=RequestMethod.GET)
	public ModelAndView getEmp(@PathVariable("empNo") int empNo) {
		logger.info("EmpController - /empDetails/{empNo} - GET");
		Emp emp = empDAO.getEmp(empNo);
		return new ModelAndView("userDetails", "empDetails", emp); 
	}
	
	/*@RequestMapping(value="/empJPA/{empNo}", method=RequestMethod.GET)
	public ModelAndView getEmpJPA(@PathVariable("empNo") int empNo) {
		Emp emp = empService.getEmpJPA(empNo);
		return new ModelAndView("userDetails", "empDetails", emp); 
	}*/
	
	@RequestMapping(value="/empDetailsJPA/{empNo}", method=RequestMethod.GET)
	@ResponseBody
	public Emp getEmpJPA(@PathVariable("empNo") int empNo) {
		Emp emp = empService.getEmpJPA(empNo);
		return emp; 
	}
	
	@RequestMapping(value="/deptDetailsJPA/{deptNo}", method=RequestMethod.GET)
	@ResponseBody
	public Dept getDeptDetailsJPA(@PathVariable("deptNo") int deptNo) {
		Dept dept = empService.getDeptDetailsJPA(deptNo);
		return dept; 
	}
	
	@RequestMapping(value="/addressDetailsJPA/{addrID}", method=RequestMethod.GET)
	@ResponseBody
	public Address getAddressDetailsJPA(@PathVariable("addrID") int addrID) {
		Address address = empService.getAddressDetailsJPA(addrID);
		return address; 
	}
	
	@RequestMapping(value="/saveEmp", method=RequestMethod.GET)
	@ResponseBody
	public Emp saveEmp() {
		Emp emp = empService.saveEmp();
		return emp; 
	}

}
