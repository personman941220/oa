package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 账户逻辑业务层接口
 */
public interface AccountService {
	public List<Account> getAccountList(int page);			//获得当页所有账户
	public int getPage();									//获取页码
}