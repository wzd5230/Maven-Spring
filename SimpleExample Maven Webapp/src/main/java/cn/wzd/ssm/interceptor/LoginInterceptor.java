package cn.wzd.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @ClassName: HandlerInterceptor1 
 * @Description: 登陆认证拦截器 
 * @author wzd 
 * @date 2016年9月16日 下午11:13:31 
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	/*
	 * (非 Javadoc) 
	 * <p>Title: preHandle</p> 
	 * <p>Description: 进行登陆认证步骤，
	 * 					1.获取请求url
	 * 					2.判断url是不是公共的url
	 * 					3.公共页面url直接放行
	 * 					4.非公共url需要进行登陆验证，如果没有登陆，跳转到认证界面，如果已经登陆，放行</p> 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception 
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		String url = request.getRequestURI();
		
		//判断请求url是不是公共的url
		if(url.indexOf("login.do")>0					//登陆操作的handler
				|| url.indexOf("logout.do")>0			//退出登陆操作的handler
				){
			return true;
		}
		
		//用户已经登陆，则可以访问非公共页面
		if(request.getSession().getAttribute("loginUsername")!=null){
			return true;
		}
		
		//将请求拦截，转到登陆页面
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
