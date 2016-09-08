package cn.wzd.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.service.ItemsService;

/**
 * 
 * @ClassName: ItemsController1 
 * @Description: 使用注解的方式实现handler 
 * @author wzd 
 * @date 2016年9月6日 下午9:55:06 
 *
 */
@Controller
@RequestMapping("/items")
public class ItemsController{
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		//添加属性，作用和request.setAttribute是一样的
		mv.addObject("itemsList",itemsList );
		
		//设置view，通过设置view name的方式。
		//已经在spring配置文件中配置了视图解析器的前缀和后缀
		mv.setViewName("items");
		
		
		return mv;
	}

}
