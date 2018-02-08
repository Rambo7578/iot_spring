package com.iot.spring.service;

import java.util.List;



import com.iot.spring.vo.UserVO;

public interface UserService {
	
	public List<UserVO> getUserList();
	public int insertUser(UserVO uvo);
	public int deleteUser(int uNo);
}
