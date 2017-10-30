package com.bwjf.service;

import java.util.List;


import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 账户逻辑业务层接口
 */
public interface AccountService {
	public List<Account> getAccountList(int page);											//获得当页所有账户
	public int getPage();																	//获取总页码数
	public Account getAcccountByConditions(String accountId,int status) throws Exception;	//条件查询获取帐户信息
	public List<Account> getAreaAccount(int areaId);										//获得区域内所有账户
	public List<Account> getAccountByEmployeeName(List<Employee> employeeAllList);			//根据employeeAllList集合的employeeId查询账户信息						
	public void UpdateRole(int employeeId,int roleId);					//根据工号修改用户角色id
	public void setPasswordById(Account account);//通过Id修改账号密码
}	
