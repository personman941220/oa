package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;
import com.bwjf.mapper.AccountMapper;
import com.bwjf.service.AccountService;
/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 账户逻辑业务层
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	public AccountMapper accountMapper;
	
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
	@Resource
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public List<Account> getAccountList(int page) {
		System.out.println("---AccountServiceImpl.getAccountList("+page+")---");
		int start = page*10;
		System.out.println("start:"+start);
		
		List<Account> accountList =	accountMapper.getAccountList(start);
		
		return accountList;
	}
	@Override
	public Account getAcccountByConditions(String accountId, int status) throws Exception {
		
		return accountMapper.getAcccountByConditions(accountId, status);
	}
	@Override
	public int getPage() {
		int num = accountMapper.getPage();
		if (num % 10 != 0) {
			num = num / 10 + 1;
		} else
			num = num / 10;
		return num;
	}
	@Override
	public List<Account> getAreaAccount(int areaId) {
		System.out.println("---AccountServiceImpl.getAreaAccount(areaId:"+areaId+")---");	
		return accountMapper.getAreaAccount(areaId);
	}
	@Override
	public List<Account> getAccountByEmployeeName(List<Employee> employeeAllList) {
		System.out.println("---AccountServiceImpl.getAccountByEmployeeName(List<Employee> employeeAllList)---");
//		System.out.println("employeeAllList:");
//		for (Employee employee : employeeAllList) {
//			System.out.println(employee.getEmployeeId());
//		}
		
		List<Account> accounts = new ArrayList<>();
		Account account=null;		
		
		for (Employee employee : employeeAllList) {
			account = new Account();
			account = accountMapper.getAccountByEmployeeId(employee.getEmployeeId());
			accounts.add(account);
		}
//		System.out.println("--- accounts:---");
//		for (Account a : accounts) {
//			System.out.println(a.getEmployeeId());
//		}
		return accounts;
	}
	@Override
	public void UpdateRole(int employeeId, int roleId) {
		
		accountMapper.UpdateRole(employeeId, roleId);
		
	}
	
	@Override
	public void setPasswordById(Account account){
		accountMapper.setPasswordById(account);
	}
}
