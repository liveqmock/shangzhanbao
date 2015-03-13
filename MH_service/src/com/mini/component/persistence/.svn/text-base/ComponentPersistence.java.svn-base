package com.mini.component.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.mini.component.data.ComponentData;

/**
 * 
 * 〈组件操作Persistence层〉<br>
 * 〈功能详细描述〉
 * 
 * @author 左香勇
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SuppressWarnings("unchecked")
@Component("componentPersistence")
public class ComponentPersistence extends BasePersistence<ComponentData>
		implements IComponentPersistence {

	/**
	 * 
	 * 〈添加组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-19
	 * @update
	 * @param [ComponentData] [组件实体信息]
	 * @return [无返回值]
	 * @exception/throws
	 * @see
	 * @since [起始版本]
	 */
	public void addComponent(ComponentData data) {
		add(data);
	}

	/**
	 * 
	 * 〈删除组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-19
	 * @update
	 * @param [id] [要删除的组件实体的id]
	 * @return [无返回值]
	 * @exception/throws
	 * @see
	 * @since [起始版本]
	 */
	public void deleteComponent(String id) {
		delete(id);
	}

	/**
	 * 
	 * 〈编辑组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-19
	 * @update
	 * @param [ComponentData] [组件实体信息]
	 * @return [无返回值]
	 * @exception/throws
	 * @see
	 * @since [起始版本]
	 */
	public void editComponent(ComponentData data) {
		editComponent(data);
	}

	/**
	 * 
	 * 
	 * 〈根据组件id查询组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-2-19
	 * @update
	 * @param [id] [要查询的组件实体的id]
	 * @return [无返回值]
	 * @exception/throws
	 * @see
	 * @since [起始版本]
	 */
	public ComponentData getComponentByid(String id) {

		StringBuffer querySQL = new StringBuffer(
				"FROM ComponentData bd WHERE 1=1");
		querySQL.append(" AND bd.id = ").append("'").append(id).append("'");

		List<ComponentData> list = search(querySQL.toString());

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 
	 * 〈根据pageid查询组件信息〉<br>
	 * 
	 * @author 左香勇 <br>
	 *         2014-3-10
	 * @update
	 * @param [参数1] [参数1说明]
	 * @return [返回类型说明]
	 * @exception/throws [异常类型] [异常说明]
	 * @see [类、类#方法、类#成员]
	 * @since [起始版本]
	 */
	public List getComponent(String pageid) {
		StringBuffer sql = new StringBuffer(
				"FROM com.mini.pageComponent.data.PageComponentData a,com.mini.component.data.ComponentData b WHERE 1=1");
		sql.append(" AND a.componentid = b.id AND a.pageid = '")
				.append(pageid).append("' AND b.stepcode2 IS NOT NULL")
				.append(" ORDER BY a.taxis");
		return search(sql.toString());
	}

    @Override
    public List<ComponentData> searchBySn(String tempSn) {
        // 存放参数
        List<Object> objects = new ArrayList<Object>();
        // 定义sql语句
        String sql = "from ComponentData where 1=1 and sn = ?";
        objects.add(tempSn);
        // 获取查询到的结果
        List<ComponentData> datas = this.search(sql, objects);
        return datas;
    }
}
