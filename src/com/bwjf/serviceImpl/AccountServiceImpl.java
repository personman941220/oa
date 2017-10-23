package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
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
	public List<Account> getAccountList() {
		System.out.println("---AccountServiceImpl.getAccountList()---");
		List<Account> accountList = accountMapper.getAccountList();
		return accountList;
	}

}
