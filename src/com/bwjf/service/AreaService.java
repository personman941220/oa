package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;

/**
 * @作者 王培源
 * @创建日期 2017/10/24
 * @描述 地区逻辑业务层接口
 */
public interface AreaService {
	/**
	 * @param accountAllList
	 * @描述 根据accountAllList集合内的areaid查询
	 */
	public List<Area> getChooseArea(List<Account> accountAllList);      
	
	public List<Area> getAllArea(int status) throws Exception;			//查询所有区域信息
	public void deleteById(int areaId) throws Exception;			//删除区域根据ID
	public void updateById(int status,int areaId) throws Exception;		//更新节点是否有效信息
	public Area getAreaById(int areaId) throws Exception;					//查询区域的详细信息
	public String getNameById(int areaId) throws Exception;				//获取区域名称
}
