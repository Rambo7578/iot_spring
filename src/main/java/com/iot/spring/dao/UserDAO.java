package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.UserInfoVO;


public interface UserDAO {
//
//	List<UserInfoVO> selectUserInfoList(UserInfoVO ui);
//	public List<UserInfoVO> selectUserList();
//	public UserInfoVO selectUser(UserInfoVO ui);
	
	List<UserInfoVO> selectUserInfoList(UserInfoVO ui);
	UserInfoVO selectUserInfo(UserInfoVO ui);
	int insertUser(UserInfoVO ui);
	int checkUserInfo(UserInfoVO ui);
	public int deleteUser(UserInfoVO ui);
	public int updateUser(UserInfoVO ui);
	List<UserInfoVO> selectUserList();
	
	   	  
		

}
