package com.sys.resources.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;

/**
 * 权限persistence实现类
 * @author jmj
 * 2013-10-11 上午11:17:04
 */
@Component("resourcePersistence")
public class ResourcePersistence extends BasePersistence<ResourceData> implements IResourcePersistence{

	@Override
	public List<ResourceData> getParentResource() {
		
		String hql = "from ResourceData r where r.parentId is null order by r.sort";
		
		return this.search(hql);
	}

	@Override
	public List<ResourceData> getSonResource() {
		
		String hql = "from ResourceData r where r.parentId is not null order by r.sort";
		
		return this.search(hql);
	}

	@Override
	public List<ResourceData> searchAllResours(PageRoll pageRoll,
			ResourceData resourceData) {
		Map<String, String> map = new HashMap<String, String>();// 定义一个map集合
		map.put("resType", "=");// 查询的是spstate这个字段
		return searchByField(pageRoll, resourceData, map,
				null);// 分页查询服务商
	}

}
