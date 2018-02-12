package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	private ConnectionDAO cdao;

	@Override
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		
		List<ConnectionInfoVO> ciList = cdao.selectConnectionInfoList(ci);
//		for(ConnectionInfoVO civ:ciList) {
//			civ.setItems(new Object[] {"a","b"});
//		}
		return ciList;
	}

	@Override
	public void insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		int result=cdao.insertConnectionInfo(ci);
		rMap.put("msg","저장 실패");
		if(result==1) {
			rMap.put("msg", "저장성공");
		}
		
	}

	@Override
	public List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception {
		ConnectionInfoVO ci=cdao.selectConnectionInfo(ciNo);
		DBConnector dbc=new DBConnector(ci);
		SqlSession ss=dbc.getSqlSession();
		hs.setAttribute("sqlSession", ss);
		List<Map<String,Object>>dbList=cdao.selectDatabaseList(ss);
		int idx=0;
		for(Map<String,Object>mDb:dbList) {
			mDb.put("id",ciNo+"_"+(++idx));
			mDb.put("text",mDb.get("Database"));
			mDb.put("items",new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(HttpSession hs, String dbName) {
		SqlSession ss=(SqlSession)hs.getAttribute("sqlSession");
		return cdao.selectTableList(ss,dbName);
	}
	
	

}
