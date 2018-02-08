package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(Connectioncontroller.class);
	
	@Autowired
	private UserService us;
	
	ObjectMapper om=new ObjectMapper();
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public @ResponseBody Map inserUser(@RequestParam Map<String,Object>map) {
		UserVO uvo=om.convertValue(map,UserVO.class);
		log.info("UserVO=>{}",uvo.getuName());
		int result=us.insertUser(uvo);
		if(result==1) {
			map.put("msg","입력성공");
		}
		return map;
		
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody Map getUserList(Model m) {
		List<UserVO> userList=us.getUserList();
		Map<String,List>map=new HashMap<String,List>();
		map.put("userList", userList);
		return map;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public @ResponseBody Map deleteUser(int uNo,Model m) {
		int result=us.deleteUser(uNo);
		log.info("result=>{}",result);
		Map<String,Object> map=new HashMap<String,Object>();
		if(result==1) {
			map.put("msg", "삭제 완료");
		}
		return map;
		
		
	}
	
}
