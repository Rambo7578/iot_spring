package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionDAO {
	
	
	ConnectionInfoVO selectConnectionInfo(int ciNo);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	int insertConnectionInfo(ConnectionInfoVO ci);
	List<Map<String,Object>> selectDatabaseList(SqlSession ss)throws Exception ;
	List<TableVO> selectTableList(SqlSession ss, String dbName);
	
	

	public int updateConnectionInfoVO();
	public int deleteConnectionInfoVO();
	
	
	
	
	
	

	
	
}
