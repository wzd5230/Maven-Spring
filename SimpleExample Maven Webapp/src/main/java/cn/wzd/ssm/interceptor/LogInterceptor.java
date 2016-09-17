package cn.wzd.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @ClassName: HandlerInterceptor1 
 * @Description: 日志拦截器，需要在配置中放在最先的位置
 * @author wzd 
 * @date 2016年9月16日 下午11:13:31 
 *
 */
public class LogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		return true;
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
		//使用日志记录，这里使用最简单的控制台打印
		System.out.println("=====log=====request src ip:"+request.getRemoteAddr()+" url:"+request.getRequestURI()+"=====");
		
	}

}
