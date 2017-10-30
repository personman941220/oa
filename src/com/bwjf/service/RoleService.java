package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.Role;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色逻辑业务层接口
 */
public interface RoleService {
	public List<Role> getAllRole();			//获得所有角色名
	public List<Role> getRoleByList(List<Account> accountAllList);		//根据accountAllList查询对应的角色信息集合	
	
}
