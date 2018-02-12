package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public ConnectionInfoVO selectConnectionInfo(int ciNo) {
		SqlSession ss = ssf.openSession();
		ConnectionInfoVO ci = ss.selectOne("connection_info.selectConnectionInfoWithCiNo", ciNo);
		ss.close();
		return ci; 
	}

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci) {
		List<ConnectionInfoVO> result = null;
		final SqlSession ss = ssf.openSession();
		result = ss.selectList("connection_info.selectConnectionInfo",ci);
		ss.close();
		return result;
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		int result = 0;
		final SqlSession ss = ssf.openSession();
		result = ss.insert("connection_info.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		return ss.selectList("connection_info.selectDatabase");
	}
	@Override
	public List<TableVO> selectTableList(SqlSession ss,String dbName) {
		List<TableVO> result = null;
		result = ss.selectList("connection_info.selectTable",dbName);
		return result;
	}

	@Override
	public int updateConnectionInfoVO() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteConnectionInfoVO() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
