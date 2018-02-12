package com.iot.spring.service;

import java.util.List;
import java.util.Map;


import com.iot.spring.vo.UserInfoVO;

public interface UserService {
	
	
	
	List<UserInfoVO> getUserInfoList(UserInfoVO ui);
	UserInfoVO getUserInfo(UserInfoVO ui);
	void insertUser(Map<String,Object> rMap, UserInfoVO ui);
	
	
	public void deleteUser(UserInfoVO ui, Map<String, Object> rMap);
	public void updateUser(UserInfoVO ui, Map<String, Object> rMap);
	

	
	
	

}
