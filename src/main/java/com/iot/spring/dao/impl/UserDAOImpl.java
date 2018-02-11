package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.UserInfoVO;


@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO ui) {
	final SqlSession ss=ssf.openSession();
		List<UserInfoVO> result=ss.selectList("user.selectUser",ui);
		ss.close();
		return result;
	}


	
	
	
	
	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		final SqlSession ss=ssf.openSession();
		UserInfoVO rUi=ss.selectOne("user.insertUser",ui);
		return rUi;
	}

	@Override
	public int insertUser(UserInfoVO ui) {
		final SqlSession ss=ssf.openSession();
		int result=ss.insert("user.insertUser",ui);
		return result;
	}
	

	

	@Override
	public int checkUserInfo(UserInfoVO ui) {
		final SqlSession ss=ssf.openSession();
		int result=ss.selectOne("user.checkUser",ui);
		ss.close();
		return result;
	}

	


	@Override
	public int deleteUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.delete("user.updateUser", ui);
		return result;
	}

	@Override
	public int updateUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.update("user.updateUser", ui);
		return result;
	}






	@Override
	public List<UserInfoVO> selectUserList() {
		// TODO Auto-generated method stub
		return null;
	}


}
