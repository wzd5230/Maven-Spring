package cn.wzd.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @ClassName: LoginController 
 * @Description: 登陆、退出操作的Controller。 
 * @author wzd 
 * @date 2016年9月17日 上午12:57:22 
 *
 */
@Controller
public class LoginController {

	/**
	 * 
	 * @Title: login 
	 * @Description: 用户登录 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password){
		
		System.out.println("====="+username+"=====");
		System.out.println("====="+password+"=====");
		
		session.setAttribute("loginUsername", username);
		
		
		//return "redirect:/items/queryItems.do";
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		
		return "redirect:/index.jsp";
	}
}
