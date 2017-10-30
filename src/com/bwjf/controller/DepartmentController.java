package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Department;
import com.bwjf.service.DepartmentService;

import net.sf.json.JSONObject;


/**
 * @作者 王培源
 * @创建日期 2017/10/27
 * @描述 部门管理页面department.jsp控制层
 * @方法名解释 roleIndex - 角色分配首页
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	public DepartmentService dService;
	
	private JSONObject jsonData;

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	public DepartmentService getdService() {
		return dService;
	}
	@Resource
	public void setdService(DepartmentService dService) {
		this.dService = dService;
	}

	/**
	 * @描述 查询部门管理首页要显示的数据
	 */
	@RequestMapping("/index")
	public String departmentIndex(Model model) {
		System.out.println("===DepartmentController.departmentIndex()===");
		List<Department> departmentList = dService.getAllDepartment();
		
		model.addAttribute("departmentList", departmentList);
		return "department/department";
	}
	
	/**
	 * @描述 添加部门
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String addDepartment(String name) {
		System.out.println("===DepartmentController.addDepartment(name:"+name+")===");
		Map map = new HashMap();
		Department department = new Department();
		department.setName(name);
		department.setStatus(1);
		if(dService.add(department)==0) {
			map.put("msg", "部门已存在，不需要反复添加！");
		}else {
			department = dService.getDepartmentByName(name);//查询得出部门id
			map.put("msg", "部门添加成功！");
			map.put("newDepartmentName", name);
			map.put("dId", department.getDepartmentId());
		}
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}
	
	/**
	 * @描述 由部门名查部门
	 */
	@RequestMapping("/query")
	public String query(String name,Model model) {
		/*
		 * 解决url中文乱码
		 */
		try {
			name = new String(name.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("---RoleController.rolePageContentByName.name中文字符转码异常---");
			e.printStackTrace();
		}
		System.out.println("===DepartmentController.query(name:"+name+")===");
		
		List<Department> departmentList = new ArrayList<>();
		Department department = dService.getDepartmentByNameMH(name);//模糊查询
		departmentList.add(department);
		model.addAttribute("departmentList", departmentList);
		return "department/department";
	}
	
	/**
	 * @描述 由部门id删除部门
	 */
	@RequestMapping("/delet")
	public String delet(int departmentId,Model model) {
		if (dService.delet(departmentId)==1) {
			model.addAttribute("msg", "删除成功");
			return "redirect:index.do";
		}else {
			model.addAttribute("msg", "删除失败");
			return "department/department";
		}
		
	}
}
