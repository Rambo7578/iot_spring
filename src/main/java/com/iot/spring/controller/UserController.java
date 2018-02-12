package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfoVO;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(@Valid UserInfoVO ui, HttpSession hs) {
		Map<String, Object> map = new HashMap<String, Object>();
		ui = us.getUserInfo(ui);
		map.put("loginOk", false);
		map.put("msg", "로그인실패");
		if (ui != null) {
			hs.setAttribute("user", ui);
			hs.setAttribute("isLogin", true);
			map.put("loginOk", true);
			map.put("msg", "로그인성공");
		}
		return map;
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> singnup(
			@Valid UserInfoVO ui,HttpSession hs){
		Map<String, Object> map = new HashMap<String,Object>();
		us.insertUser(map, ui);
		return map;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)

	public @ResponseBody List<UserInfoVO> getUserInfoList(UserInfoVO ui) {
		return us.getUserInfoList(ui);

	}

}
