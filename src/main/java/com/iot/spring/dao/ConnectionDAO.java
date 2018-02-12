package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionDAO {
	
	
	ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	int insertConnectionInfo(ConnectionInfoVO ci);
	List<Map<String,Object>> selectDatabaseList();
	List<TableVO> selectTableList(String dbName);
	
	

	public int updateConnectionInfoVO();
	public int deleteConnectionInfoVO();
	
	
	
	
	
	

	
	
}
