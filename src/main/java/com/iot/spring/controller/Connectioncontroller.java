package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class Connectioncontroller {
	private static final Logger log = LoggerFactory.getLogger(Connectioncontroller.class);

	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private ConnectionService cs;

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertConnectionInfo(@Valid ConnectionInfoVO ci, Map<String,Object> map) {
		log.info("ci=>{}",ci);
		cs.insertConnectionInfo(map, ci);
		return map;
	}

//	@RequestMapping(value = "/db_list", method = RequestMethod.GET)
//	public @ResponseBody Map<String, Object> getDatabaseList(@RequestParam Map<String, Object> map) {
//		List<Map<String, Object>> dbList = cs.getDatabasetList();
//		map.put("dbList", dbList);
//		return map;
//	}
	@RequestMapping(value="/db_list/{ciNo}", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getDatabaseList(@PathVariable("ciNo") int ciNo,
			Map<String,Object> map,HttpSession hs) {
		List<Map<String, Object>> dbList;
		try {
			dbList = cs.getDatabaseList(hs, ciNo);
			map.put("list", dbList);
			map.put("parentId", ciNo);
		} catch (Exception e) {
			map.put("error",e.getMessage());
			log.error("db connection error =>{}",e);
		}
		return map;
	}
	
	@RequestMapping(value="/columns", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getColumnList(Map<String,Object> map) {
//		List<Map<String,Object>>dbList = cs.getDatabaseList();
//		map.put("dbList", dbList);
		return map;
	}
	


	   @RequestMapping(value="/list", method=RequestMethod.GET)
	   public @ResponseBody Map<String,Object> getConnectionInfoList(
	         Map<String,Object> map, HttpSession hs) {
	      UserInfoVO ui = new UserInfoVO();
	      if(hs.getAttribute("user")!=null) {
	         ui = (UserInfoVO)hs.getAttribute("user");
	      }else {
	         ui.setUiId("red");
	      }
	      ConnectionInfoVO ci = new ConnectionInfoVO();
	      ci.setUiId(ui.getUiId());
	      List<ConnectionInfoVO> ciList = cs.getConnectionInfoList(ci);
	      map.put("list", ciList);
	      return map;
	   }

	   

		@RequestMapping(value="/tables/{dbName}/{parentId}", method=RequestMethod.GET)
		public @ResponseBody Map<String,Object> getTabeList(
				@PathVariable("dbName")String dbName, 
				@PathVariable("parentId")String parentId,
				HttpSession hs,	Map<String,Object> map) {
			List<TableVO> tableList = cs.getTableList(hs, dbName);
			map.put("list", tableList);
			map.put("parentId", parentId);
			return map;
		}

}
