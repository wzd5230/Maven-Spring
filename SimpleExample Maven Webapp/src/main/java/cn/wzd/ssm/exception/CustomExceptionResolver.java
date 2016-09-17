package cn.wzd.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @ClassName: CustomExceptionResolver 
 * @Description: 同意异常处理器的实现 
 * @author wzd 
 * @date 2016年9月15日 下午1:11:16 
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		/*
		 * 测试代码，用来查看是否可以准确获取到handler的类名
		 */
		System.out.print("====Exception Handler Class name: ");
		System.out.print(handler.getClass().getName());
		System.out.println("====");
		
		CustomException exception = null;
		/*
		 * 判断异常信息，如果是用户定义异常，则将异常中的信息提取出来，如果是非用户定义异常，则创建一个新的异常，
		 * 并设置异常信息为"未知错误，请联系管理员处理！".
		 */
		if(ex instanceof CustomException){
			exception = ((CustomException)ex);
		}else{
			exception = new CustomException("未知错误，请联系管理员处理！");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", exception);
		mv.setViewName("errorItems");
		
		return mv;
	}

}
