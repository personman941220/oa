package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午3:08:15
 * 类描述：区域信息实体类
 * 版本：v1.0 
 */
public class Area {
	private int areaId;		//区域ID
	private	String name;	//区域名称
	private int parentId;	//父区域ID
	private int status;	//区域是否有效，1：有效，0无效。
	private String descirption;		//区域描述
	private int provinceId;			//省ID
	private int cityId;				//市ID
	private int regionId;			//区域ID 例如：青秀区
	private Date createDate;		//创建时间
	private String createBy;		//创建人
	private Date updateDate;		//更新时间
	private String updateBy;		//更新人
	private int regionLevel;		//区域等级  省为一级，依次类推
	private int townsId;			//乡镇ID
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescirption() {
		return descirption;
	}
	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public int getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(int regionLevel) {
		this.regionLevel = regionLevel;
	}
	public int getTownsId() {
		return townsId;
	}
	public void setTownsId(int townsId) {
		this.townsId = townsId;
	}
	public Area() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", name=" + name + ", parentId=" + parentId + ", status=" + status
				+ ", descirption=" + descirption + ", provinceId=" + provinceId + ", cityId=" + cityId + ", regionId="
				+ regionId + ", createDate=" + createDate + ", createBy=" + createBy + ", updateDate=" + updateDate
				+ ", updateBy=" + updateBy + ", regionLevel=" + regionLevel + ", townsId=" + townsId + "]";
	}
	
	
	
}
