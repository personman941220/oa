package com.bwjf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import com.bwjf.entity.Account;
import com.bwjf.service.AccountService;
import com.bwjf.utils.LoginContextUtil;
import com.bwjf.utils.MD5Util;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午11:51:29
 * 类描述：登录控制处理
 * 版本：v1.0 
 */
@Controller
public class LoginController {
	private AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}
	
	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	private JSONObject jsonData;
	
	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	@RequestMapping("/home.do")
	public String login(String username,String password,HttpServletRequest request){
		//session声明
		HttpSession session;
		//错误信息声明
		String error="";
		//将密码进行md5加密
		password=MD5Util.getMD5(password);
		//查询帐户信息
		try {
			Account account=accountService.getAcccountByConditions(username, 1);
			//判断帐户信息是否存在
			if(account==null){
				//设置错误信息
				error="帐户不存在或已失效";
				//将错误信息放到session中
				request.getSession().setAttribute("error", error);
				System.out.println("帐户不存在或已失效");
				//重定向到登录页面
				return "redirect:/login.jsp";
			}
			//判断密码信息是否正确
			if(!account.getPassword().equals(password)){
				//设置错误信息
				error="密码错误！";
				//将错误信息放到model中
				request.getSession().setAttribute("error", error);
				System.out.println("密码错误！");
				//重定向到登录页面
				return "redirect:/login.jsp";
				
			}
			//判断用户是否已经登录,如果已经登录，跳转到已经登录页面
			if(LoginContextUtil.checkIsLogin(username, request)){
				return "index";
			}
			//验证通过，登录用户
			//将账户信息放到session中
			session=request.getSession();
			session.setAttribute("account", account);
			//将用户session与id绑定
			LoginContextUtil.putContext(username, session, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "index";
	}
	//接收修改密码请求
	@RequestMapping("/pwdModify.do")
	public String Modify(Model model,HttpServletRequest httpServletRequest){
		Account account = (Account) httpServletRequest.getSession().getAttribute("account");
		model.addAttribute("account",account);
		return "account/pwdModify";
	}
	//输入原密码时触发的异步
	@RequestMapping("/Oldpassword.do")
	@ResponseBody
	public String Oldpassword(String Oldpassword,HttpServletRequest req){
		System.out.println("==========LoginController.Oldpassword()=========");
		Oldpassword=MD5Util.getMD5(Oldpassword);
		Account account = (Account) req.getSession().getAttribute("account");
		Map map = new HashMap();
		if(Oldpassword.equals(account.getPassword())){
		}else{
			map.put("msg","请输入原密码或密码错误");
		}
		//将map转成json，然后接收
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
		//
	}
	//修改密码前的提交
	@RequestMapping("/pwdModify2.do")
	@ResponseBody
	public String Modify2(String Oldpassword,String Newpassword,String Newpassword2,HttpServletRequest req){
		System.out.println("==========LoginController.Modify2()=========");
		Oldpassword=MD5Util.getMD5(Oldpassword);
		Account account = (Account) req.getSession().getAttribute("account");
		Map map = new HashMap();
		//判断是否是本人
		System.out.println(Oldpassword);
		System.out.println(Oldpassword.equals(account.getPassword()));
		if(Oldpassword.equals(account.getPassword())){
			System.out.println("daole2");
			//判断两次密码是否一致
			if(Newpassword.equals(Newpassword2)){
				//进行修改密码操作。
				Newpassword2 = MD5Util.getMD5(Newpassword2);
				System.out.println("daole3");
				accountService.setAccountPasswordById(Newpassword2, account.getAccountId());
			}else{
				map.put("msg", "新密码和确认密码不一致，请确认");
			}
		}else{
			map.put("msg","请输入原密码或密码错误");
		}
		//将map转成json，然后接收
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}
}
