package com.iot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserVO;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDao;

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return userDao.selectUserList();
	}

	@Override
	public int insertUser(UserVO uvo) {
		// TODO Auto-generated method stub
		return userDao.insertUser(uvo);
	}

	@Override
	public int deleteUser(int uNo) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(uNo);
	}

	


}
