package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionService {

	public void getConnectionList();
	public void getConnectionInfo(ConnectionInfoVO ci);
	public int insertConnectionInfo(ConnectionInfoVO ci);
	public List<Map<String,Object>> getDatabasetList();
	List<TableVO> getTableList(String dbName);
	List<ColumnVO> getColumnList(String cuName);
}
