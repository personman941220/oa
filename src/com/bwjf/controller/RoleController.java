package com.bwjf.controller;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwjf.entity.Account;
import com.bwjf.entity.Role;
import com.bwjf.service.AccountService;
import com.bwjf.service.RoleService;
/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色分配控制层
 * @方法名解释
 * 	roleIndex - 角色分配首页
 */
@Controller
public class RoleController {
	public RoleService roleService;
	public AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}
	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public RoleService getRoleService() {
		return roleService;
	}
	
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@RequestMapping("/roleIndex")
	public String roleIndex(Model model) {
		System.out.println("===RoleController.roleIndex()===");
		/*
		 * 需要数据：
		 * 1.角色列表 roleList。提供下拉框数据;
		 * 2.员工列表 accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据;
		 */
		List<Role> roleList = roleService.getAllRole();
		List<Account> accountAllList = accountService.getAccountList();
		
		model.addAttribute("accountAllList", accountAllList);
		model.addAttribute("roleList", roleList);
		return "rolePermissions/role";
	}
}
