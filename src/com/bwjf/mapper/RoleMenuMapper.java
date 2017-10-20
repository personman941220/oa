package com.bwjf.mapper;

import java.util.List;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:20:14
 * 类描述：角色菜单接口mapper
 * 版本：v1.0 
 */
public interface RoleMenuMapper {
	public List<Integer> getRoleMenuByRoleId (int roleId) throws Exception;		//获取菜单ID
}
