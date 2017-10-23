package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Role;
import com.bwjf.mapper.RoleMapper;
import com.bwjf.service.RoleService;
/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色逻辑业务层
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	
	public RoleMapper roleMapper; 
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public List<Role> getAllRole() {
		System.out.println("---RoleServiceImpl.getAllRole()---");
		List<Role> roleList = roleMapper.getAllRole();
		return roleList;
	}

}
