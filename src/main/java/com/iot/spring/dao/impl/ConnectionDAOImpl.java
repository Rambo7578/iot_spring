package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList() {
		SqlSession ss = ssf.openSession();

		return ss.selectList("connection.selectConnectionList");
	}

	@Override
	public List<ConnectionInfoVO> selectConnectionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionInfoVO selectConnectionInfoVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConnectionInfoVO() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateConnectionInfoVO() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteConnectionInfoVO() {
		
		return 0;		

	}

	@Override
	public List<Map<String, Object>> selectDatabaseList() {
		SqlSession ss=ssf.openSession();
		return ss.selectList("connection.selectDatabase");
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {

		SqlSession ss = ssf.openSession();
		return ss.selectList("connection.selectTable", dbName);
	}

	@Override
	public List<ColumnVO> selectColumnList(String cuName) {

		SqlSession ss = ssf.openSession();
		return ss.selectList("connection.selectColumnList", cuName);
	}

}
