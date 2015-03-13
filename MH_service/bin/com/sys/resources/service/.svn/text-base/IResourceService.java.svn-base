package com.sys.resources.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IService;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;
import com.sys.userrole.data.AuthorityData;
import com.sys.userrole.data.UserRoleCtnData;

/**
 * 权限service层接口
 * @author jmj
 * 2013-10-11 上午11:19:21
 */
public interface IResourceService extends IService {

	/**
	 * 查询资源
	 * 2013-10-11 上午11:23:21
	 * @author jmj
	 */
	public List<ResourceData> getResource(String type);
	
	/**
	 * 查询资源并存储：资源ID-key,资源名称-value
	 * 2013-10-12 上午11:41:39
	 * @author jmj
	 */
	public Map<String,String> getResoureMap();
	
	/**
	 * 查询所有资源
	 * @param pageRoll
	 * @param resourceData
	 * @return
	 * @author wendong
	 * @date 2013-10-15
	 * @update
	 */
	public List<ResourceData> searchAllResours(PageRoll pageRoll,
			ResourceData resourceData);
}
