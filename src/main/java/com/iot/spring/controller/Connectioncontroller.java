package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

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
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Controller
@RequestMapping("/connection")
public class Connectioncontroller {
	private static final Logger log = LoggerFactory.getLogger(Connectioncontroller.class);

	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private ConnectionService cs;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> insertConnection(@RequestParam Map map) {
		ConnectionInfoVO ci = om.convertValue(map, ConnectionInfoVO.class);

		map.put("msg", "성공");
		return map;
	}

	@RequestMapping(value = "/db_list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDatabaseList(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> dbList = cs.getDatabasetList();
		map.put("dbList", dbList);
		return map;
	}

	@RequestMapping(value = "/tables/{dbName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableList(@PathVariable("dbName")String dbName, Map<String, Object> map) {
		List<TableVO> dbList = cs.getTableList(dbName);
		map.put("dbList", dbList);
		return map;
	}
	
	@RequestMapping(value = "/cutable/{dbName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getColumnList(@PathVariable("dbName")String dbName, Map<String, Object> map) {
		List<ColumnVO> cuList = cs.getColumnList(dbName);
		map.put("cuList", cuList);
		return map;
	}

}
