package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Menu;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:48:43
 * 类描述：菜单service接口
 * 版本：v1.0 
 */
public interface MenuService {
	public List<Menu> getMenuById(int menuId) throws Exception;		//查询菜单信息通过菜单ID
	public List<Menu> getMenuByParentId(int parentId) throws Exception; 	//查询菜单信息通过父ID

}
