package com.bwjf.mapper;

import java.util.List;

import com.bwjf.entity.Department;

public interface DepartmentMapper {
	public List<Department> getAllDepartment();
	public void add(Department department);
	public Department getDepartmentByName(String name);
	public Department getDepartmentByNameMH(String name); 
	public void delet(int departmentId);
	public Department getDepartmentById(int departmentId);
}
