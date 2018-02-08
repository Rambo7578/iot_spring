package com.iot.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UrlController {
 
   private static final Logger logger = LoggerFactory.getLogger(UrlController.class);

   private String getUri(String uri, String rootPath) {
      return uri.replace(rootPath + "/path", "");
   }

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      model.addAttribute("title", "IOT-SPRING-2");
      return "index";
   }

   @RequestMapping("/path/**")
   public ModelAndView forwardJsp(HttpServletRequest request, ModelAndView model) {

      String uri = request.getRequestURI();
      String rootPath = request.getContextPath();
      uri = getUri(uri, rootPath);
      logger.info("path =>{}", uri);
      model.setViewName(uri);
      return model;
   }

}



