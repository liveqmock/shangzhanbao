package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessRegistryData;
import com.itour.etip.support.data.ProcessTaskRegistryData;
import com.itour.etip.support.persistence.IProcessRegistryPersistence;
import com.itour.etip.support.persistence.IProcessTaskRegistryPersistence;

public class ProcessTaskRegistryBusiness extends FrmBusiness implements
		IProcessTaskRegistryBusiness {

	private IProcessTaskRegistryPersistence processTaskRegistryPersistence;
	private IProcessRegistryPersistence processRegistryPersistence;

	public IProcessTaskRegistryPersistence getProcessTaskRegistryPersistence() {
		return processTaskRegistryPersistence;
	}

	public IProcessRegistryPersistence getProcessRegistryPersistence() {
		return processRegistryPersistence;
	}

	public void setProcessRegistryPersistence(
			IProcessRegistryPersistence processRegistryPersistence) {
		this.processRegistryPersistence = processRegistryPersistence;
	}

	public void setProcessTaskRegistryPersistence(
			IProcessTaskRegistryPersistence processTaskRegistryPersistence) {
		this.processTaskRegistryPersistence = processTaskRegistryPersistence;
	}


	/**
	 * 此处查询流程任务注册表
	 */
	public List searchProcessTaskRegistrys(PageRoll pageRoll,
			ProcessTaskRegistryData data)   {
		// TODO Auto-generated method stub
		// 此处查询最新版本的ProcessTaskRegistry,可是怎么会有懒加载问题呢？
		pageRoll.setSearchSQL("from ProcessTaskRegistryData");
		pageRoll.setCountSQL("select count(*) from ProcessTaskRegistryData");
		return processTaskRegistryPersistence.search(pageRoll);
	}


	public List getProcessTaskList(String[] ids)  {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			ProcessTaskRegistryData p = processTaskRegistryPersistence.retrieve(ids[i]);
			if(p!=null){
				list.add(p);
			}
			
		}
		return list;
	}

	/**
	 * 查询工作流模板。 通过condition拼出查询条件，利用pageRoll进行分页查询
	 * 
	 * @param pageRoll
	 *            分页状态容器
	 * @param condition
	 *            查询条件容器
	 */
	public List<ProcessRegistryData> search(PageRoll pageRoll,
			JSONObject condition) {
		// 首先根据condition拼出where语句
		String processName = condition.getString("processName");
		String processURL = condition.getString("processURL");
		String where = " where 1>0";
		if (processName != null && processName.trim().length() > 0) {

			where = where + " and processName like '%" + processName + "%'";

		}

		if (processURL != null && processURL.trim().length() > 0) {
			where = where + " and processURL like '%" + processURL + "%'";
		}

		String countSQL = "select count(*) from ProcessRegistryData" + where;
		String selectSQL = "from ProcessRegistryData " + where;
		pageRoll.setCountSQL(countSQL);
		pageRoll.setSearchSQL(selectSQL);
		List<ProcessRegistryData> processList = processRegistryPersistence.search(pageRoll);
		// 最后查询返回值
		return processList;
	}

}
