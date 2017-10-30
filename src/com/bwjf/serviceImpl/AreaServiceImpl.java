package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.mapper.AreaMapper;
import com.bwjf.service.AreaService;
/**
 * @作者 王培源
 * @创建日期 2017/10/24
 * @描述 地区逻辑业务层
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	
	public AreaMapper areaMapper;
	
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}
	@Resource
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}

	
	@Override
	public List<Area> getAllArea(int status) throws Exception {
		//查询所有的区域信息
		return areaMapper.getAllArea(status);
	}
	@Override
	public void deleteById(int areaId) throws Exception{
		//删除区域信息
		areaMapper.deleteById(areaId);
	}
	@Override
	public void updateById(int status, int areaId) throws Exception {
		//更新状态信息,以及所有的子节点状态
		areaMapper.updateById(status, areaId);
		//获取所有的子节点的ID
		List<Integer> areas=areaMapper.getAreaByParentId(areaId);
		//判断集合是否为空
		if(areas==null){
			return;
		}
		//更新所有的子节点
		for(Integer i:areas){
			areaMapper.updateById(status, i);
		}
		
	}
	@Override
	public Area getAreaById(int areaId) throws Exception {
		//获取区域的详细信息
		return areaMapper.getAreaById(areaId);
	}
	@Override
	public String getNameById(int areaId) throws Exception {
		//获取区域名称
		return areaMapper.getNameById(areaId);
	}
	@Override
	public List<Area> getChooseArea(List<Account> accountAllList)  {
		System.out.println("---AreaServiceImpl.getChooseArea(List<Account> accountAllList)---");
		List<Area> areaAllList = new ArrayList<>();
		Area area = null;
		for (Account account : accountAllList) {
			area = new Area();
			try {
				area = areaMapper.getAreaById(account.getAreaId());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("---AreaServiceImpl.getChooseArea()调用AreaMapper.getAreaById发生异常---");
			}
			areaAllList.add(area);
		}
		return areaAllList;
	}
}
