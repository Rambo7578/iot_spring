package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;



public interface ConnectionDAO {
	public List<ConnectionInfoVO> selectConnectionList();
	public ConnectionInfoVO selectConnectionInfoVO();
	public int insertConnectionInfoVO();
	public int updateConnectionInfoVO();
	public int deleteConnectionInfoVO();
	public List<Map<String,Object>>selectDatabaseList();
	List<ConnectionInfoVO> selectConnectionInfoList();
	List<TableVO> selectTableList(String dbName);
	List<ColumnVO> selectColumnList(String cuName);
}
