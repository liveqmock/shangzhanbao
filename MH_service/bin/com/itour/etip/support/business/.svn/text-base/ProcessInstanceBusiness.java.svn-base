package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.support.data.ProcessInstanceData;
import com.itour.etip.support.persistence.IProcessInstancePersistence;

public class ProcessInstanceBusiness extends FrmBusiness implements
		IProcessInstanceBusiness {

	private IProcessInstancePersistence processInstancePersistence;

	public IProcessInstancePersistence getProcessInstancePersistence() {
		return processInstancePersistence;
	}

	public void setProcessInstancePersistence(
			IProcessInstancePersistence processInstancePersistence) {
		this.processInstancePersistence = processInstancePersistence;
	}

	public void addProcessInstance(ProcessInstanceData data) {
		// TODO Auto-generated method stub
		processInstancePersistence.add(data);
	}

	public void deleteProcessInstance(String id) {
		// TODO Auto-generated method stub
		processInstancePersistence.delete(id);
	}

	public void deleteProcessInstances(String[] ids) {
		// TODO Auto-generated method stub
		processInstancePersistence.delete(ids);
	}

	public List searchProcessInstances(PageRoll pageRoll,
			ProcessInstanceData data) {
		// TODO Auto-generated method stub
		// 未完待续
		pageRoll.setSearchSQL("from ProcessInstanceData");
		pageRoll.setCountSQL("select count(*) from ProcessInstanceData");
		return processInstancePersistence.search(pageRoll);
	}

	public void updateProcessInstance(ProcessInstanceData data) {
		// TODO Auto-generated method stub
		processInstancePersistence.update(data);
	}

	public List getInstanceList(String[] ids) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			list.add(processInstancePersistence.retrieve(ids[i]));
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
	public List<ProcessInstanceData> search(PageRoll pageRoll,
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

		String countSQL = "select count(*) from ProcessData" + where;
		String selectSQL = "from ProcessInstanceData " + where;
		pageRoll.setCountSQL(countSQL);
		pageRoll.setSearchSQL(selectSQL);
		List<ProcessInstanceData> processList = processInstancePersistence
				.search(pageRoll);
		// 最后查询返回值
		return processList;
	}

}
