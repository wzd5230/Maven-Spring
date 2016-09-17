package cn.wzd.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName: ItemsDateConverter 
 * @Description: 自定义参数绑定，将 "yyyy-MM-dd hh:mm:ss"格式的时间字符串转换成java.util.Data类的实例，如果异常，返回null
 * @author wzd 
 * @date 2016年9月15日 上午10:36:08 
 *
 */
public class ItemsDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		/*
		 * 将yyyy-MM-dd hh:mm:ss格式的字符串转换成Date类型的对象
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			//e.printStackTrace();
			return null;
		}
		
	}
	
}
