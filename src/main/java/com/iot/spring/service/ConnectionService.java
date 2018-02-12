package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionService {

	
	ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	int insertConnectionInfo(ConnectionInfoVO ci);
	List<Map<String,Object>> selectDatabaseList();
	List<TableVO> selectTableList(String dbName);
	
	
	
	
	
	
	public void getConnectionList();
	public List<ConnectionInfoVO> getConnectionInfo(int ciNo);

	public List<Map<String,Object>> getDatabasetList();
	List<TableVO> getTableList(String dbName);
	List<ColumnsVO> getColumnList(String cuName);
	List<Map<String, Object>> getDatabasetList(HttpSession hs, int ciNo);
	List<ConnectionInfoVO> getConnectionInfo(ConnectionInfoVO ci);
	
}
