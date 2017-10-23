package com.bwjf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;
import com.bwjf.entity.Role;
import com.bwjf.service.AccountService;
import com.bwjf.service.EmployeeService;
import com.bwjf.service.RoleService;


/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色分配控制层
 * @方法名解释 roleIndex - 角色分配首页
 */
@Controller
public class RoleController {
	public RoleService roleService;
	public AccountService accountService;
	public EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

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
		 * 需要数据： 1.角色列表 roleList。提供下拉框数据; 2.员工列表
		 * accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据;
		 */
		List<Role> roleList = roleService.getAllRole();
		int page = 0;
		List<Account> accountAllList = accountService.getAccountList(page);
		List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
		List<Role> roleAllList = roleService.getRoleByList(accountAllList);
		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAllList: 存放第1行到第10行的账户表记录
		 * 3.employeeAllList: 存放第1行到第10行的账户表对应的员工记录 4.roleAllList 存放第1行到第10行的账户表对应的角色记录
		 */
		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAllList", accountAllList);
		model.addAttribute("employeeAllList", employeeAllList);
		model.addAttribute("roleAllList", roleAllList);
		return "rolePermissions/role";
	}

	@RequestMapping("/rolePageContent")
	public String rolePageContent(int page,Model model) {
		System.out.println("===RoleController.rolePageContent(page:" + page + ")===");
		/*
		 * 需要数据： 1.对应页员工列表 accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据;
		 */
		List<Role> roleList = roleService.getAllRole();
		List<Account> accountAllList = accountService.getAccountList(page);
		List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
		List<Role> roleAllList = roleService.getRoleByList(accountAllList);
		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAllList:
		 * 存放第page*10+1行到第(page+1)*10+2行的账户表记录 3.employeeAllList:
		 * 存放第page*10+1行到第(page+1)*10+2行的账户表对应的员工记录 4.roleAllList
		 * 存放第page*10+1行到第(page+1)*10+2行的账户表对应的角色记录
		 */
		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAllList", accountAllList);
		model.addAttribute("employeeAllList", employeeAllList);
		model.addAttribute("roleAllList", roleAllList);
		model.addAttribute("nowPage", page);
		return "rolePermissions/role";

	}
}
