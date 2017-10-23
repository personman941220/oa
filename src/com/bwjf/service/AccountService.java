package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 账户逻辑业务层接口
 */
public interface AccountService {
	public List<Account> getAccountList();			//获得所有账户
	public Account getAcccountByConditions(String accountId,int status) throws Exception;	//条件查询获取帐户信息
}
