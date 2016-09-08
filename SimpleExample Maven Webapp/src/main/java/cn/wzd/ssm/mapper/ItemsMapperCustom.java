package cn.wzd.ssm.mapper;

import java.util.List;

import cn.wzd.ssm.po.ItemsCustom;
import cn.wzd.ssm.po.ItemsQueryVo;


/**
 * 
 * @ClassName: ItemsMapperCustom 
 * @Description: 定义Items查询mapper接口 
 * @author wzd 
 * @date 2016年9月7日 下午10:52:08 
 *
 */
public interface ItemsMapperCustom {
	
	//查询商品列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

}
