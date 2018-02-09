package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.UserInfoVO;


public interface UserDAO {
	
	public List<UserInfoVO> selectUserList();
	public UserInfoVO selectUser(UserInfoVO ui);
	public int insertUser(UserInfoVO ui);
	public int deleteUser(UserInfoVO ui);
	public int updateUser(UserInfoVO ui);
		int checkUserInfo(UserInfoVO ui);
		
		List<UserInfoVO> selectUserInfoList(UserInfoVO ui);

}
