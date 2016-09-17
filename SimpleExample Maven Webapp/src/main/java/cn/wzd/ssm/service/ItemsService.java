package cn.wzd.ssm.service;

import java.util.List;

import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.po.ItemsQueryVo;

public interface ItemsService {
	
	//商品列表查询
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

	//通过商品id获取商品
	public ItemsCustom findItemById(Integer id)throws Exception; 
	
	//更新商品信息
	public void updateItem(Integer id,ItemsCustom itemsCustom) throws Exception;
}
