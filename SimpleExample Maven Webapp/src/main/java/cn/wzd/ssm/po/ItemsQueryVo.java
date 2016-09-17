package cn.wzd.ssm.po;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

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
	
	//批量操作时，（如批量删除、修改等批量操作），该属性用于存储批量操作的条目的id
	private Integer[] multiEditIds;

	//批量修改时，用于存储多个修改后的商品条目
	private List<ItemsCustom> editItemsCustoms;
	
	//为了测试Map类型的参数绑定而定义的无意义数据
	private Map<String, Object> mapValue;

	public Map<String, Object> getMapValue() {
		return mapValue;
	}

	public void setMapValue(Map<String, Object> mapValue) {
		this.mapValue = mapValue;
	}

	public List<ItemsCustom> getEditItemsCustoms() {
		return editItemsCustoms;
	}

	public void setEditItemsCustoms(List<ItemsCustom> editItemsCustoms) {
		this.editItemsCustoms = editItemsCustoms;
	}

	public Integer[] getMultiEditIds() {
		return multiEditIds;
	}

	public void setMultiEditIds(Integer[] multiEditIds) {
		this.multiEditIds = multiEditIds;
	}

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
