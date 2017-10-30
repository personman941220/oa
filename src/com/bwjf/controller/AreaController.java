package com.bwjf.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Area;
import com.bwjf.service.AreaService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月23日 上午11:18:42
 * 类描述：区域树的控制层
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/area")
public class AreaController {
	
	private AreaService areaService;	
	public AreaService getAreaService() {
		return areaService;
	}
	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	/*
	 * ztree实现区域树的加载
	 */
	@RequestMapping("/tree.do")
	@ResponseBody
	public List<Area> tree(){
		try {
			//返回有效的区域信息
			return areaService.getAllArea(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 跳转区域树
	 * 
	 */
	@RequestMapping("/toTree.do")
	public String toTree(){
		return "rolePermissions/areaTree";
	}
	/*
	 * 查询区域详细信息
	 */
	@RequestMapping("/detail.do")
	public String detail(int areaId,Model model){
		//判断区域id是否为空
		if(areaId==0){
			return	"error";
		}
		//查询详细信息
		try {
			Area area=areaService.getAreaById(areaId);
			//将信息放到model中
			model.addAttribute("area", area);
			return "area/detail";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
	}
	/*
	 * 跳转编辑页面
	 */
	@RequestMapping("/toEdit.do")
	public String toEdit(){
		return "area/areaEdit";
	}
	/*
	 * ajax删除操作
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int areaId){
		//消息声明
		String msg;
		//判断areaId是否为空
		if(areaId==0){
			msg="one";
		}
		//将区域有效性设置为0，以及子节点的有效性
		try {
			areaService.updateById(0, areaId);
			msg="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="two";
		}
		return msg;
	}
	/*
	 * 跳转添加页面
	 */
	
	@RequestMapping("/toAdd.do")
	public String toAdd(int id,Model model){
		int areaId=id;
		//判断areaId是否为空
		if(areaId==0){
			return "error/500";
		}
		//查询父亲区域名称
		try {
			String name=areaService.getNameById(areaId);
			//将区域名称放到model中
			model.addAttribute("name", name);
			//将区域id放到model中
			model.addAttribute("areaId", areaId);
			return "area/add";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
	}
	/*
	 * 添加操作
	 */
	@RequestMapping("/add.do")
	public String add(Area area){
		//判断对象是否为空
		if(area==null){
			return "error/500";
		}
		//设置状态为1
		area.setStatus(1);
		//将区域信息保存到数据库中
		return null;
	}
	/*
	 * 跳转修改页面
	 */
	@RequestMapping("/toAlter.do")
	public String toAlter(){
		return "area/alter";
	}
	
}
