package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO edao;

	@Override
	public List<Emp> getEmpList() {
		// TODO Auto-generated method stub
		return edao.selectEmpList();
	}

	@Override
	public Emp getEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEmp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return edao.insertEmp(map);
	}

	@Override
	public int updateEmp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
