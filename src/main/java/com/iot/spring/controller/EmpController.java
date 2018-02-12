package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;



@Controller
@RequestMapping("/emp")
public class EmpController {
	private static final Logger log = LoggerFactory.getLogger(EmpController.class);
	@Autowired
	private EmpService es;

	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList", empList);
		return "emp/jstl_list";

	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getEmpListAjax(Model m) {
		List<Emp> empList = es.getEmpList();
		Map<String,Object>returnMap=new HashMap<String,Object>();
		returnMap.put("empList1", empList);
		returnMap.put("empList2", empList);
		returnMap.put("msg", "리스트 조회 성공");
		return returnMap;

	}
	

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView InsertEmp(
			@Valid Emp empDTO, Errors es, ModelAndView m) throws Exception {
		
		if (es.hasErrors()) {
			log.info("error =>{}", es);
			throw new Exception(es.getAllErrors().get(0).getDefaultMessage());
		}
		log.info("insert result =>{}", empDTO);
	
		m.setViewName("emp/write");
		return m;
	}

}
