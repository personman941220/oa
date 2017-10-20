package com.bwjf.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {
	
	Logger log = LogManager.getLogger(ErrorPageController.class);

	@RequestMapping("404")
	public String page404() {
		log.info("HTTP-400错误");
		
		System.out.println("====404错误===");
		return "HTTP-404";
	}

	@RequestMapping("500")
	public String page500() {
		log.error(500);
		return "HTTP-500";
	}

}
