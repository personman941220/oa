package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;
import com.bwjf.mapper.EmployeeMapper;
import com.bwjf.service.EmployeeService;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 员工逻辑业务层
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeMapper employeeMapper;

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	@Resource
	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	@Override
	public List<Employee> getEmployeeByList(List<Account> accountList) {
		
		//1.输出数据流向日志	
		//2.查询员工信息,插入集合emList
		System.out.println("---EmployeeServiceImpl.getEmployeeByList(List<Account> accountList)---");
		System.out.println("---accountList.size()"+accountList.size()+"---");
		
		List<Employee> emList = new ArrayList<>();
		Employee e = null;
		for (Account account : accountList) {
			//System.out.println(account.toString());
			e = new Employee();
			e = employeeMapper.getEmployeeById(account.getEmployeeId());
			emList.add(e);
		}
		return emList;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		System.out.println("---EmployeeServiceImpl.getEmployeeByName(name:"+name+")---");
		
		return employeeMapper.getEmployeeByName(name);
	}

}
