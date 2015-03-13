package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.data.ProcessRegistryData;
import com.itour.etip.support.persistence.IProcessRegistryPersistence;

public class ProcessRegistryBusiness extends FrmBusiness implements
		IProcessRegistryBusiness {

	private IProcessRegistryPersistence processRegistryPersistence;

	public IProcessRegistryPersistence getProcessRegistryPersistence() {
		return processRegistryPersistence;
	}

	public void setProcessRegistryPersistence(
			IProcessRegistryPersistence processRegistryPersistence) {
		this.processRegistryPersistence = processRegistryPersistence;
	}

	public void addProcessRegistry(ProcessRegistryData data)
			 {
		// TODO Auto-generated method stub
		processRegistryPersistence.add(data);
	}

	public void deleteProcessRegistry(String id) {
		// TODO Auto-generated method stub
		processRegistryPersistence.delete(id);
	}

	public void deleteProcessRegistrys(String[] ids) {
		// TODO Auto-generated method stub
		processRegistryPersistence.delete(ids);
	}

	public List searchProcessRegistrys(PageRoll pageRoll,
			ProcessRegistryData data) {
		// TODO Auto-generated method stub
		// 未完待续
		pageRoll.setSearchSQL("from ProcessRegistryData");
		pageRoll.setCountSQL("select count(*) from ProcessRegistryData");
		return processRegistryPersistence.search(pageRoll);
	}

	public void updateProcessRegistry(ProcessRegistryData data)
			 {
		// TODO Auto-generated method stub
		processRegistryPersistence.update(data);
	}

	public List getProcessList(String[] ids) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			list.add(processRegistryPersistence.retrieve(ids[i]));
		}
		return list;
	}
	
	/**
	 * 获取流程注册表
	 * @param id 流程对应的id
	 * @return id对应的流程实例
	 */
	public ProcessRegistryData getProcess(String id){
		ProcessRegistryData data= processRegistryPersistence.load(id);
		return data;
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
		String jbpmClassName = condition.getString("jbpmClassName");
		String where = " where 1>0";
		if (processName != null && processName.trim().length() > 0) {

			where = where + " and processName like '%" + processName + "%'";

		}

		if (jbpmClassName != null && jbpmClassName.trim().length() > 0) {
			where = where + " and jbpmClassName like '%" + jbpmClassName + "%'";
		}

		String countSQL = "select count(*) from ProcessRegistryData" + where;
		String selectSQL = "from ProcessRegistryData " + where+" order by processName,processVersion";
		pageRoll.setCountSQL(countSQL);
		pageRoll.setSearchSQL(selectSQL);
		List<ProcessRegistryData> processList = processRegistryPersistence
				.search(pageRoll);
		// 最后查询返回值
		return processList;
	}

}
