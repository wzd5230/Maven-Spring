package cn.wzd.ssm.po;

/**
 * 
 * @ClassName: ItemsQueryVo 
 * @Description: 商品包装对象 （包装了查询条件）
 * @author wzd 
 * @date 2016年9月7日 下午10:33:29 
 *
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统可扩展性能，我们一般对原始生成的po进行扩展
	private ItemsCustom itemsCustom;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	
	

}
