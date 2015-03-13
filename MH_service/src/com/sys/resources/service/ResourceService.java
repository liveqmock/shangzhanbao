package com.sys.resources.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.common.util.Page;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.business.IResourceBusiness;
import com.sys.resources.data.ResourceData;

/**
 * 权限service层实现类
 * @author jmj
 * 2013-10-11 上午11:19:59
 */
@Component("resourceService")
public class ResourceService extends FrmService implements IResourceService{
	
	@Resource(name="resourceBusiness")
	private IResourceBusiness resourceBusiness;
	@Override
	public List<ResourceData> getResource(String type) {
		return resourceBusiness.getResource(type);
	}
	@Override
	public Map<String, String> getResoureMap() {
		return resourceBusiness.getResoureMap();
	}
	@Override
	public List<ResourceData> searchAllResours(PageRoll pageRoll,
			ResourceData resourceData) {
		pageRoll = PageRoll.set(Page.SIZE_10, pageRoll);
		return resourceBusiness.searchAllResours(pageRoll,resourceData);
	}

}
