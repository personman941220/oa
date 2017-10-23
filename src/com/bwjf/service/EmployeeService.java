package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 员工逻辑业务层接口
 */
public interface EmployeeService {
	public List<Employee> getEmployeeByList(List<Account> accountList);			//根据accountList里的员工工号查询员工信息		
}
