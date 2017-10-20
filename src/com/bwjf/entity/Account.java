package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午3:01:01
 * 类描述：账户实体类
 * 版本：v1.0 
 */
public class Account {
	private int accountId;		//账户ID
	private int employeeId;		//员工ID
	private int roleId;			//角色ID	
	private int	areaId;			//区域ID
	private String password;	//账户密码
	private boolean status;		//账户状态   员工是否离职，1：在职，0：离职
	private Date createDate;	//创建时间
	private String createBy;	//创建人。
	private Date updateDate;	//更新时间
	private String updateBy;	//更新人
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	
	
}
