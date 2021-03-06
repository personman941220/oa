package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Menu;
import com.bwjf.mapper.MenuMapper;
import com.bwjf.service.MenuService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:49:45
 * 类描述：菜单service层实现
 * 版本：v1.0 
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	private MenuMapper menuMapper;
	
	public MenuMapper getMenuMapper() {
		return menuMapper;
	}
	@Resource
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}

	@Override
	public List<Menu> getMenuById(int menuId) throws Exception {
		//调用mapper查询，返回查询的到的菜单信息
		return menuMapper.getMenuById(menuId);
	}

	@Override
	public List<Menu> getMenuByParentId(int parentId) throws Exception {
		//调用mapper，返回查询结果信息
		return menuMapper.getMenuByParentId(parentId);
	}

}
