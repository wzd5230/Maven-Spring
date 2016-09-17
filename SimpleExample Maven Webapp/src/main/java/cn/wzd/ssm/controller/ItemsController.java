package cn.wzd.ssm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import cn.wzd.ssm.controller.validation.SingleItemsEditValidation;
import cn.wzd.ssm.exception.CustomException;
import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.po.ItemsQueryVo;
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
	
	/**
	 * 
	 * @Title: testModelAttribute 
	 * @Description: 测试模型属性在Controller方法上的注解 ，当请求传递到其他Handler方法时，在这些Handler方法执行
	 * 之前，会先执行所有使用@ModelAttribute注解的方法。
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@ModelAttribute("testModelAttribute")
	public String testModelAttribute(){
		System.out.println("======>testModelAttribute<======");
		return "this is model attribute message1.";
	}
	
	@ModelAttribute("testModelAttribute2")
	public String testModelAttribute2(){
		System.out.println("======>testModelAttribute2<======");
		return "this is model attribute message2.";
	}
	
	/**
	 * 
	 * @Title: queryItems 
	 * @Description: 请求查看所有的商品信息 
	 * @param @param request
	 * @param @param session
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return ModelAndView    返回类型 
	 * @throws
	 */
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		//添加属性，作用和request.setAttribute是一样的
		mv.addObject("itemsList",itemsList );
		
		//设置view，通过设置view name的方式。
		//已经在spring配置文件中配置了视图解析器的前缀和后缀
		mv.setViewName("items");
		
		//测试model modelandview request session属性使用优先级
		mv.addObject("testAttribute", "mv.testAttribute");
		request.setAttribute("testAttribute", "request.testAttribute");
		session.setAttribute("testAttribute", "request.testAttribute");
		
		return mv;
	}
	
	
	/**
	 * 
	 * @Title: editItem 
	 * @Description: 编辑单个商品信息 
	 * @param @param request
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/editItem")
	public String editItem(HttpServletRequest request)throws Exception{
		
		//测试模型数据是否传递到controller方法中
		System.out.println("=======editItem======>"+request.getAttribute("testModelAttribute2")+"<=======editItem======");
		
		ItemsCustom itemsCustom = itemsService.findItemById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("itemsCustom", itemsCustom);
		
		//返回逻辑视图名
		return "editItem";
	}
	
	
	/**
	 * 
	 * @Title: updateItems 
	 * @Description: 更新多个商品信息 
	 * @param @param model
	 * @param @param id
	 * @param @param itemsQueryVo
	 * @param @param bindingResult
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	//对于需要进行校验的参数使用@Validated进行注解，并且在该参数的下一参数设置为BindingResult类型的形参，用于接收错误信息
	//如果有多个参数需要校验，那么在每一个使用@Validated进行注解的参数后面都要跟随一个BingdingResult类型的形参，用于接收前面那个参数的校验错误信息。
	@RequestMapping(value="/updateItems",method={RequestMethod.POST,RequestMethod.GET})
	public String updateItems(
			HttpServletRequest request,
			Model model,
			@RequestParam(value = "id", required = true) Integer id,
			@Validated(value = { SingleItemsEditValidation.class }) ItemsCustom iCustom,
			BindingResult bindingResult,
			MultipartFile itemPicture		//接受商品的图片
			) throws Exception {
		
		if(iCustom.getDetail()==null){
			System.out.println("=====itemsQueryVo.getItemsCustom().getDetail()==null=====");
		}else if( "".equals(iCustom.getDetail())){
			System.out.println("=======\"\".equals(itemsQueryVo.getItemsCustom().getDetail())========");
		}
		
		if(iCustom.getCreatetime()==null){
			System.out.println("=====itemsQueryVo.getItemsCustom().getCreatetime()==null=====");
		}
		
		//首先需要对校验结果进行判断
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			Map<String, String> editMessageMap = new HashMap<String,String>();
			
			for (ObjectError objectError :allErrors){
		        // 输出错误信息
		        System.out.println(objectError.getDefaultMessage());
		        
		        //添加错误信息
		        String message = objectError.getDefaultMessage();
		        
		        if(message.contains(":")==false){
					continue;
				}
				
				int firstIndex = message.indexOf(":");
								
				String key = message.substring(0, firstIndex);
				String value = message.substring(firstIndex+1, message.length());
				
				editMessageMap.put(key, value);

				
		    }
			
			//写入属性
			model.addAttribute("errorMessage", editMessageMap);
			//model.addAttribute("itemsCustom", iCustom);
			
			if(request.getAttribute("itemsCustom")!=null){
				System.out.println("=====Attribute named 'itemsCustom' was found.=====");
			}else{
				System.out.println("=====Attribute named 'itemsCustom' was not found.=====");
			}
			
			
			return "editItem";
		}else{//参数传递正确，可以写入数据库
			
			//判断图片是否有效
			String originalFilename = itemPicture.getOriginalFilename();
			
			if (null != itemPicture								//获取到对象
					&& null != originalFilename					//原文件名存在
					&& !"".equals(originalFilename)				//原文件名不为""
					&& !itemPicture.isEmpty()					//文件有内容
					) {
				//文件后缀名
				String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
				System.out.println("====filename:"+fileSuffix+"====");
				
				//使用随机数作为文件名
				String filename = UUID.randomUUID()+fileSuffix;
				
				File picFile = new File("D:\\Program Files (x86)\\apache-tomcat-8.5.4\\picture"+File.separator+filename);
				
				//将文件传递到磁盘中
				itemPicture.transferTo(picFile);
				
				//设置需要写入到数据库中的新文件名
				iCustom.setPic(filename);
			}

			
			iCustom.setId(id);
			
			itemsService.updateItem(id, iCustom);
			
			//用于测试model是否可以进行属性传递，在success.jsp文件中，获取"success_msg"属性并进行显示
			model.addAttribute("success_msg", "更新单个条目成功！");
			
			
			return "success";			
		}
		
	}
	
	
	/**
	 * 
	 * @Title: deleteItems 
	 * @Description: 删除多个商品条目。 
	 * @param @param model
	 * @param @param itemsQueryVo
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/deleteItems")
	public String deleteItems( Model model,ItemsQueryVo itemsQueryVo )throws Exception{
		
		//没有选中任何一个条目，抛出异常
		if(itemsQueryVo.getMultiEditIds()==null){
			throw new CustomException("没有选中任何需要选中的条目！");
		}
		
		//调用service层中对应的方法，这里不删除，否则表将不方便维护
		//.....
		
		
		//写入成功信息
		model.addAttribute("success_msg", "删除单个条目成功！");
		
		
		return "success";
	}
	
	/**
	 * 
	 * @Title: multiEditItems 
	 * @Description: 同时编辑多个商品条目，根据需要编辑的多个商品的id，从数据库中读取这些id对应的信息，在jsp中进行显示，并且可编辑。
	 * @param @param request
	 * @param @param itemsQueryVo
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/multiEditItems")
	public String multiEditItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo)throws Exception{
		
		//判断是否有选中的操作条目的id
		if( itemsQueryVo.getMultiEditIds() == null ){
			throw new CustomException("修改多个商品，但是没有选中任何需要修改的条目");
		}
		
		//从数据库中读取对应条目的信息
		List<ItemsCustom> itemsCustoms = new ArrayList<ItemsCustom>();
		
		for(Integer i:itemsQueryVo.getMultiEditIds()){
			itemsCustoms.add(itemsService.findItemById(i));
		}
		
		//将查询到的商品信息保存到属性中
		request.setAttribute("itemsCustoms", itemsCustoms);
		
		//
		return "multiEditItems";
	}
	
	/**
	 * 
	 * @Title: updateMultiItems 
	 * @Description: 更新多个商品信息 
	 * @param @param model
	 * @param @param itemsQueryVo
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/updateMultiItems")
	public String updateMultiItems(Model model,ItemsQueryVo itemsQueryVo)throws Exception{
		
		//判断是否有修改的信息提交到服务器端
		if(itemsQueryVo.getEditItemsCustoms().size()==0){
			throw new CustomException("没有修改信息被提交到服务器端！");
		}
		
		//迭代获取每一个修改的商品信息
		Iterator<ItemsCustom> iterator = itemsQueryVo.getEditItemsCustoms().iterator();
		
		//将商品信息写入数据库
		while(iterator.hasNext()){
			ItemsCustom custom = iterator.next();
			itemsService.updateItem(custom.getId(), custom);
		}
		
		//设置成功属性消息
		model.addAttribute("success_msg", "修改多个商品成功！");
		
		return "success";
	}
	
	
	/**
	 * 
	 * @Title: bindParamMap 
	 * @Description: 测试Map类型的参数绑定 
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/bindParamMap")
	public String bindParamMap(Model model, ItemsQueryVo itemsQueryVo)throws Exception{
		
		//
		if(itemsQueryVo.getMapValue()!=null){
			model.addAttribute("mapValue", itemsQueryVo);
		}
		
		
		return "bindParamMap";
	}
	
	

}
