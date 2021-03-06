package com.bwjf.service;
/**
 * @作者 王培源
 * @创建日期 2017/10/27
 * @描述 部门逻辑业务层接口
 */

import java.util.List;

import com.bwjf.entity.Department;

public interface DepartmentService {
	public List<Department>	getAllDepartment(); //查询所有部门
	public int add(Department department);		//添加部门
	public Department getDepartmentByNameMH(String name);	//根据名字模糊查询部门信息
	public Department getDepartmentByName(String name);	//根据名字精确查询部门信息
	public int delet(int departmentId);			//根据部门id删除部门
}
