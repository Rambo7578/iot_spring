package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	ConnectionDAO cdao;
	
	@Override
	public void getConnectionList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> getDatabasetList() {
		List<Map<String,Object>> dbList=cdao.selectDatabaseList();
		int idx=0;
		for(Map<String,Object>mDb:dbList) {
			mDb.put("id",++idx);
			mDb.put("text",mDb.get("Database"));
			mDb.put("items",new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		// TODO Auto-generated method stub
		return cdao.selectTableList(dbName);
	}

	@Override
	public List<ColumnVO> getColumnList(String cuName) {
		
		return cdao.selectColumnList(cuName);
	}

	

}
