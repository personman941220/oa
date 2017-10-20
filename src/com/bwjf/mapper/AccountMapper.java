package com.bwjf.mapper;

import com.bwjf.entity.Account;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午12:02:10
 * 类描述：帐户mapper接口
 * 版本：v1.0 
 */
public interface AccountMapper {
	public Account getAccountByEmployeeId(int employeeId);		//获取帐户信息通过员工ID
}
