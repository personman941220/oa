package com.bwjf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwjf.service.ZtreeService;


/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午11:36:48
 * 类描述：ztree菜单控制实现
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/ztree")
public class ZtreeController {
	private ZtreeService ztreeService;
	
	public ZtreeService getZtreeService() {
		return ztreeService;
	}
	@Resource
	public void setZtreeService(ZtreeService ztreeService) {
		this.ztreeService = ztreeService;
	}
	/*
	 * 跳转到菜单页面
	 */
	@RequestMapping("/toMenu.do")
	public String  toMenu(){
		return "menu/menu";
	}
	
	/*
	 * 异步加载菜单信息
	 */
	@RequestMapping("/menu.do")
	public String getMenu(){
		try {
			return ztreeService.getMenuByRoleId(1).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}		
	}
}
