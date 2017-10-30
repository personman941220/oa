package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.Employee;
import com.bwjf.entity.Role;
import com.bwjf.service.AccountService;
import com.bwjf.service.AreaService;
import com.bwjf.service.EmployeeService;
import com.bwjf.service.RoleService;

import net.sf.json.JSONObject;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色分配页面role.jsp控制层
 * @方法名解释 roleIndex - 角色分配首页
 * rolePageContent -  所有角色role.jsp翻页显示......
 */
@Controller
public class RoleController {
	public RoleService roleService;
	public AccountService accountService;
	public EmployeeService employeeService;
	public AreaService areaService;

	private JSONObject jsonData;

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

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

	/**
	 * @描述 角色role.jsp首页显示
	 */
	@RequestMapping("/roleIndex")
	public String roleIndex(Model model) {
		System.out.println("===RoleController.roleIndex()===");
		/*
		 * 需要数据： 1.角色列表 roleList。提供下拉框数据; 2.员工列表
		 * accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据; 3.地区
		 * areaAllList
		 */
		List<Role> roleList = roleService.getAllRole();
		int page = 0;
		List<Account> accountAllList = accountService.getAccountList(page);
		List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
		List<Role> roleAllList = roleService.getRoleByList(accountAllList);
		List<Area> areaAllList = areaService.getChooseArea(accountAllList);

		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAllList: 存放第1行到第10行的账户表记录
		 * 3.employeeAllList: 存放第1行到第10行的账户表对应的员工记录 4.roleAllList 存放第1行到第10行的账户表对应的角色记录
		 * 5.areaAllList 存放第1行到第10行的账户表对应的区域记录 6.pageNumber:总页码
		 */

		int pageNumber = accountService.getPage();

		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAllList", accountAllList);
		model.addAttribute("employeeAllList", employeeAllList);
		model.addAttribute("roleAllList", roleAllList);
		model.addAttribute("areaAllList", areaAllList);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("nowPage", page);
		model.addAttribute("type", "normal");
		return "rolePermissions/role";

	}

	/**
	 * @描述 所有角色role.jsp翻页显示
	 */
	@RequestMapping("/rolePageContent")
	public String rolePageContent(int page, Model model, int pageNumber) {
		System.out.println("===RoleController.rolePageContent(page:" + page + ")===");
		/*
		 * 需要数据： 1.对应页员工列表
		 * accountAllList,employeeAllList,roleAllList,areaAllList下标一一对应。提供页面表格显示数据;
		 */
		List<Role> roleList = roleService.getAllRole();
		List<Account> accountAllList = accountService.getAccountList(page);
		List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
		List<Role> roleAllList = roleService.getRoleByList(accountAllList);
		List<Area> areaAllList = areaService.getChooseArea(accountAllList);

		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAllList:
		 * 存放第page*10+1行到第(page+1)*10行的账户表记录 3.employeeAllList:
		 * 存放第page*10+1行到第(page+1)*10行的账户表对应的员工记录 4.roleAllList
		 * 存放第page*10+1行到第(page+1)*10行的账户表对应的角色记录 5.areaAllList
		 * 存放第page*10+1行到第(page+1)*10行的账户表对应的区域记录
		 */
		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAllList", accountAllList);
		model.addAttribute("employeeAllList", employeeAllList);
		model.addAttribute("roleAllList", roleAllList);
		model.addAttribute("areaAllList", areaAllList);
		model.addAttribute("nowPage", page);
		model.addAttribute("pageNumber", pageNumber);

		model.addAttribute("type", "normal");
		return "rolePermissions/role";

	}

	/**
	 * @描述 异步显示点击树节点后的区域信息
	 */
	@RequestMapping("/showAreaRole")
	@ResponseBody
	public String ShowAreaRole(int areaId, int nowPage, String name) {

		/*
		 * 解决url中文乱码
		 */
		try {
			name = new String(name.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("---RoleController.rolePageContentByName.name中文字符转码异常---");
			e.printStackTrace();
		}
		name = null;// 可以完善这个功能（王培源）
		System.out.println(
				"===RoleController.ShowAreaRole(areaId:" + areaId + ",nowPage:" + nowPage + ",name:" + name + ")===");
		/*
		 * 需要传到页面的数据： 1.对应页员工列表
		 * accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据; 2.roleList:
		 * 用于下拉框显示数据 3.nowPage,pageNumber
		 */
		Map map = new HashMap();
		List<Role> roleList = roleService.getAllRole();
		List<Account> accountList = new ArrayList<>();
		List<Account> accountAllList = new ArrayList<>();
		int pageNumber = 0;

		if (name == null || name.equals("")) {

			accountList = accountService.getAreaAccount(areaId);

			// 计算页码
			pageNumber = accountList.size();
			if (pageNumber % 10 != 0) {
				pageNumber = pageNumber / 10 + 1;
			} else
				pageNumber = pageNumber / 10;

			for (int i = (nowPage * 10); i < accountList.size(); i++) {
				if (i < (nowPage + 1) * 10)
					accountAllList.add(accountList.get(i));
				else
					break;
			}

		} else {

			List<Employee> employeeList = employeeService.getEmployeeByName(name); // 姓名模糊查询结果集employeeList

			accountList = accountService.getAccountByEmployeeName(employeeList);// 姓名模糊查询结果集employeeList对应得到accountList
			List<Account> accountInArea = new ArrayList<>();// accountInArea存放accountList里符合areaid区域的账户结果集
			Account account = null;
			for (Account accounts : accountList) {
				account = new Account();
				if (accounts.getAreaId() == areaId) {// 判断符合
					accountInArea.add(accounts);
				}
			}
			// 当页10行
			for (int i = (nowPage * 10); i < accountInArea.size(); i++) {
				if (i < ((nowPage + 1) * 10))
					accountAllList.add(accountInArea.get(i));
				else
					break;
			}

			// 计算页码
			pageNumber = accountInArea.size();
			if (pageNumber % 10 != 0) {
				pageNumber = pageNumber / 10 + 1;
			} else {
				pageNumber = pageNumber / 10;
			}

		}
		/*
		 * 如果accountList记录大于十行，则分页显示 提供数据： 1.pageNumber：总页码 2.nowPage：当前页码
		 * 3.nowPage页的accountAllList、employeeAllList、roleAllList、areaAllList
		 */

		List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
		List<Role> roleAllList = roleService.getRoleByList(accountAllList);
		List<Area> areaAllList = areaService.getChooseArea(accountAllList);

		map.put("accountAllList", accountAllList);
		map.put("employeeAllList", employeeAllList);
		map.put("roleAllList", roleAllList);
		map.put("areaAllList", areaAllList);
		map.put("roleList", roleList);
		map.put("nowPage", nowPage);
		map.put("pageNumber", pageNumber);
		// 把map转成 json,然后再前台接收
		jsonData = JSONObject.fromObject(map);
		// System.out.println("最后转成的json为："+jsonData);
		return jsonData.toString();
	}

	/**
	 * @描述 按姓名查找角色role.jsp翻页显示
	 * @实现功能 1.姓名模糊查询 2.姓名模糊+区域精确查询
	 */
	@RequestMapping("/rolePageContentByName")
	public String rolePageContentByName(String name, String areaId, int page, Model model) {
		areaId = null; // 可以完善这个功能（王培源）
		/*
		 * 解决url中文乱码
		 */
		try {
			name = new String(name.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("---RoleController.rolePageContentByName.name中文字符转码异常---");
			e.printStackTrace();
		}
		System.out.println("===RoleController.rolePageContentByName(name:" + name + ",areaId:" + areaId + ",page:"
				+ page + ")===");
		/*
		 * 需要数据： 1.对应页员工列表
		 * accountAllList,employeeAllList,roleAllList,areaAllList下标一一对应。提供页面表格显示数据;
		 * 
		 */
		boolean isNull1 = (name == null || name.equals("")); // 名字为空
		boolean isNull2 = (areaId == null || areaId.equals("")); // 区域id为空
		if (isNull1 && isNull2) {
			System.out.println("2为空");
		} else {
			if (isNull2) {
				System.out.println("名字不为空，区域id为空");
				List<Role> roleList = roleService.getAllRole();
				List<Employee> employeeList = employeeService.getEmployeeByName(name);
				List<Employee> employeeAllList = new ArrayList<>();
				// 当页10行
				for (int i = (page * 10); i < employeeList.size(); i++) {
					if (i < ((page + 1) * 10))
						employeeAllList.add(employeeList.get(i));
					else
						break;
				}
				List<Account> accountAllList = accountService.getAccountByEmployeeName(employeeAllList);
				List<Role> roleAllList = roleService.getRoleByList(accountAllList);
				List<Area> areaAllList = areaService.getChooseArea(accountAllList);
				int pageNumber = employeeList.size();
				if (pageNumber % 10 != 0) {
					pageNumber = pageNumber / 10 + 1;
				} else {
					pageNumber = pageNumber / 10;
				}
				model.addAttribute("roleList", roleList);
				model.addAttribute("accountAllList", accountAllList);
				model.addAttribute("employeeAllList", employeeAllList);
				model.addAttribute("roleAllList", roleAllList);
				model.addAttribute("areaAllList", areaAllList);
				model.addAttribute("nowPage", page);
				model.addAttribute("pageNumber", pageNumber);
				model.addAttribute("name", name);
				model.addAttribute("dqid", areaId);
				model.addAttribute("type", "search");
			} else {
				System.out.println("名字，区域id不为空");
				List<Role> roleList = roleService.getAllRole();
				List<Employee> employeeList = employeeService.getEmployeeByName(name); // 姓名模糊查询结果集employeeList

				List<Account> accountList = accountService.getAccountByEmployeeName(employeeList);// 姓名模糊查询结果集employeeList对应得到accountList
				List<Account> accountInArea = new ArrayList<>();// accountInArea存放accountList里符合areaid区域的账户结果集
				Account account = null;
				for (Account accounts : accountList) {
					account = new Account();
					if (accounts.getAreaId() == Integer.parseInt(areaId)) {// 判断符合
						accountInArea.add(accounts);
					}
				}
				List<Account> accountAllList = new ArrayList<>();
				// 当页10行
				for (int i = (page * 10); i < accountInArea.size(); i++) {
					if (i < ((page + 1) * 10))
						accountAllList.add(accountInArea.get(i));
					else
						break;
				}
				List<Employee> employeeAllList = employeeService.getEmployeeByList(accountAllList);
				List<Role> roleAllList = roleService.getRoleByList(accountAllList);
				List<Area> areaAllList = areaService.getChooseArea(accountAllList);

				// 计算页码
				int pageNumber = accountInArea.size();
				if (pageNumber % 10 != 0) {
					pageNumber = pageNumber / 10 + 1;
				} else {
					pageNumber = pageNumber / 10;
				}

				model.addAttribute("roleList", roleList);
				model.addAttribute("accountAllList", accountAllList);
				model.addAttribute("employeeAllList", employeeAllList);
				model.addAttribute("roleAllList", roleAllList);
				model.addAttribute("areaAllList", areaAllList);
				model.addAttribute("nowPage", page);
				model.addAttribute("pageNumber", pageNumber);
				model.addAttribute("name", name);
				model.addAttribute("dqid", areaId);
				model.addAttribute("type", "search");
			}
		}

		return "rolePermissions/role";

	}

	/**
	 * @描述 角色分配
	 * @实现功能 1.修改用户角色名
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public String UpdateRole(int no, int roleId) {
		System.out.println("===RoleController.UpdateRole(no:"+no+",roleId:"+roleId+")===");
		accountService.UpdateRole(no, roleId);
		Map map = new HashMap();
		
		map.put("msg", "修改成功");
		// 把map转成 json,然后再前台接收
		jsonData = JSONObject.fromObject(map);
		// System.out.println("最后转成的json为："+jsonData);
		return jsonData.toString();

	}
}
