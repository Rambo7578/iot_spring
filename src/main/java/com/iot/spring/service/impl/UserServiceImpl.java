package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfoVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO udao;
	

	@Override
	public List<UserInfoVO> getUserList() {
		
		return udao.selectUserList();
	}
	
	@Override
	public UserInfoVO getUserInfo(UserInfoVO ui) {
		
		return udao.selectUserInfo(ui);
	}
		
	private boolean isDuplInfo(UserInfoVO ui) {
		if(udao.checkUserInfo(ui)==1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void insertUser(UserInfoVO ui, Map<String, Object> rMap) {
		rMap.put("msg","회원가입이 실패 하였습니다.");
		rMap.put("signupOk",false);
		if(isDuplInfo(ui)) {
			rMap.put("msg",ui.getuId()+"는 이미 존재하는 아이디입니다");
			return;
		}
		
		
		int result = udao.insertUser(ui);
		if(result==1) {
			rMap.put("msg","회원가입이 성공");
			rMap.put("signupOk",true);
		}
	}
	

	@Override
	public void deleteUser(UserInfoVO ui, Map<String, Object> rMap) {
		int result = udao.insertUser(ui);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
	}

	@Override
	public void updateUser(UserInfoVO ui, Map<String, Object> rMap) {
		int result = udao.insertUser(ui);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
	}

	@Override
	public List<UserInfoVO> getUserInfoList(UserInfoVO ui) {
		// TODO Auto-generated method stub
		return udao.selectUserInfoList(ui);
	}

	

}
