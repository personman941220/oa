package com.bwjf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwjf.entity.Account;
import com.bwjf.entity.Role;
import com.bwjf.service.ITest;

@Controller
@RequestMapping("")
public class TestController {
	
	@Resource
	private ITest tService;
	
	public ITest gettService() {
		return tService;
	}

	public void settService(ITest tService) {
		this.tService = tService;
	}

	@RequestMapping("/home.do")
	private String home(Model model, String userName,String userPassword) {
		
		System.out.println("===TestController.home(userName="+userName+",userPassword="+userPassword+")====");
		//List<Role> roleList = tService.getAllRole();
		//model.addAttribute("roleList", roleList);
		//return "home";
		//Account account = new Account();
		//account.setPassword("123456");
		//model.addAttribute("account", account);
		return "index";
	}
}
