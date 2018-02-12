package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionService {

	ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);
	void insertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVO ci);
	List<Map<String,Object>> getDatabaseList(HttpSession hs, int ciNo)throws Exception ;
	List<TableVO> getTableList(HttpSession hs,String dbName);
	
	
	
	
	
//	public void getConnectionList();
//	public List<ConnectionInfoVO> getConnectionInfo(int ciNo);
//
//	public List<Map<String,Object>> getDatabasetList();
//	List<TableVO> getTableList(String dbName);
//	List<ColumnsVO> getColumnList(String cuName);
//	List<Map<String, Object>> getDatabasetList(HttpSession hs, int ciNo);
//	
	
}
