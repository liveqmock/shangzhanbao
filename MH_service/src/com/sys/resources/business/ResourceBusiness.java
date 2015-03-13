package com.sys.resources.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;
import com.sys.resources.persistence.IResourcePersistence;

/**
 * 权限business层实现类
 * @author jmj
 * 2013-10-11 上午11:18:42
 */
@Component("resourceBusiness")
public class ResourceBusiness extends FrmBusiness implements IResourceBusiness{

	@Resource(name="resourcePersistence")
	private IResourcePersistence resourcePersistence;
	
	@Override
	public List<ResourceData> getResource(String type) {
		List<ResourceData> list = new ArrayList<ResourceData>();
		if(type.equals("parent")){//查询父资源
			list = resourcePersistence.getParentResource();
		}else{//查询子资源
			list = resourcePersistence.getSonResource();
		}
		return list;
	}

	@Override
	public Map<String, String> getResoureMap() {
		List<ResourceData> list = resourcePersistence.getParentResource();
		Map<String,String> map = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			ResourceData rs = list.get(i);
			map.put(rs.getId(),rs.getResName());
		}
		return map;
	}

	@Override
	public List<ResourceData> searchAllResours(PageRoll pageRoll,
			ResourceData resourceData) {
		List<ResourceData> resourceDatas = resourcePersistence.searchAllResours(pageRoll,resourceData);
		
		return resourceDatas;
	}
	
	

}
