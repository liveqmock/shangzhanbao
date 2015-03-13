package com.sys.resources.persistence;

import java.util.List;

import com.itour.etip.pub.base.IBasePersistence;
import com.itour.etip.pub.frame.PageRoll;
import com.sys.resources.data.ResourceData;

/**
 * 权限 persistence层接口
 * @author jmj
 * 2013-10-11 上午11:15:20
 */
public interface IResourcePersistence extends IBasePersistence<ResourceData> {
	
	/**
	 * 查询父资源
	 * 2013-10-11 上午11:23:21
	 * @author jmj
	 */
	public List<ResourceData> getParentResource();
	
	/**
	 * 查询子资源
	 * 2013-10-11 上午11:23:38
	 * @author jmj
	 */
	public List<ResourceData> getSonResource();
	
	/**
	 * 查询资源
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
