package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Area;

/**
 * @作者 王培源
 * @创建日期 2017/10/24
 * @描述 地区数据访问层
 */
public interface AreaMapper {
	
	public List<Area> getAllArea(int status) throws Exception;			//查询所有是否域信息
	public void deleteById(int areaId) throws Exception;				//删除区域根据ID
	public void updateById(@Param("status")int status,@Param("areaId")int areaId) throws Exception;	//更新节点是否有效信息
	public Area getAreaById(int areId) throws Exception;					//查询区域的详细信息
	public List<Integer> getAreaByParentId(int areaId);					//获取所有的字节点的信息
	public String getNameById(int areaId) throws Exception;				//获取区域名称
}
