package com.bwjf.mapper;

import java.util.List;

import com.bwjf.entity.Role;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色数据访问层
 */
public interface RoleMapper {
	public List<Role> getAllRole();
	public Role getRoleById(int roleId);
}
