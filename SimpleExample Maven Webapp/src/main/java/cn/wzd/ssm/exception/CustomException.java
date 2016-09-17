package cn.wzd.ssm.exception;

/**
 * 
 * @ClassName: CunstomException 
 * @Description: 用户自定义异常，针对预期的异常，需要在程序中抛出此类的异常实例。
 * @author wzd 
 * @date 2016年9月15日 下午1:14:03 
 *
 */
public class CustomException extends Exception {
	
	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = -4931029376262914650L;
	
	//异常信息
	private String message;
	
	public CustomException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
