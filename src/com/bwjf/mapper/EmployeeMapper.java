package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Employee;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 员工数据访问层
 */
public interface EmployeeMapper {
	public Employee getEmployeeById(int employeeId);
	public List<Employee> getEmployeeByName(String name);
}
