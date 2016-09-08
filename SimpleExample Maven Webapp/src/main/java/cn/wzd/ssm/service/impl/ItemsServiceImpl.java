package cn.wzd.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wzd.ssm.mapper.ItemsMapperCustom;
import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.po.ItemsQueryVo;
import cn.wzd.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
