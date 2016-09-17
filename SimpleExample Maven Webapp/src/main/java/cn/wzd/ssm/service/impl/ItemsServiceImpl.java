package cn.wzd.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wzd.ssm.mapper.ItemsMapper;
import cn.wzd.ssm.mapper.ItemsMapperCustom;
import cn.wzd.ssm.po.Items;
import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.po.ItemsQueryVo;
import cn.wzd.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemById(Integer id) throws Exception {
		ItemsCustom itemsCustom = new ItemsCustom();
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		
		/*
		 * 下面的代码是将父类中的属性值赋值到子类中，在传智播客的视频中有说明，spring已经提供了相应的方法
		 * 实现该功能，这里因为记不得了，所以使用最笨的方法。
		 */
		itemsCustom.setCreatetime(items.getCreatetime());
		itemsCustom.setDetail(items.getDetail());
		itemsCustom.setId(items.getId());
		itemsCustom.setName(items.getName());
		itemsCustom.setPic(items.getPic());
		itemsCustom.setPrice(items.getPrice());
		
		return itemsCustom;
	}

	@Override
	public void updateItem(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		
		//这里需要编写很多和具体的业务相关的代码
		//.......
		
		//调用dao层方法，修改数据库中信息
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}

}
