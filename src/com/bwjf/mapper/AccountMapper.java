package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Account;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午12:02:10
 * 类描述：帐户mapper接口
 * 版本：v1.0 
 */
public interface AccountMapper {
	public Account getAccountByEmployeeId(int employeeId);		//获取帐户信息通过员工ID
	public List<Account> getAccountList(int start);						//获取当页所有账户
	public List<Account> getAccountList();						//获取所有账户
	public Account getAcccountByConditions(@Param("accountId")String accountId,@Param("status")int status) throws Exception;	//条件查询获取帐户信息
	public Account setAccountPasswordById(@Param("password")String password,@Param("accountId")String accountId);//通过员工ID修改账户密码
}
