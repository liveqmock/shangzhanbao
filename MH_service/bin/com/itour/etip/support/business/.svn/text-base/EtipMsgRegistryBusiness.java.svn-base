package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.EtipMsgRegistry;
import com.itour.etip.pub.kit.jms.IEtipMsgRegistryPersistence;

public class EtipMsgRegistryBusiness extends FrmBusiness implements
		IEtipMsgRegistryBusiness {

	private IEtipMsgRegistryPersistence persistence;

	public IEtipMsgRegistryPersistence getPersistence() {
		return persistence;
	}

	public void setPersistence(IEtipMsgRegistryPersistence persistence) {
		this.persistence = persistence;
	}

	public void addEtipMsgRegistry(EtipMsgRegistry data) {
		// TODO Auto-generated method stub
		persistence.add(data);
	}

	public void deleteEtipMsgRegistry(String id) {
		// TODO Auto-generated method stub
		persistence.delete(id);
	}

	public void deleteEtipMsgRegistries(String[] ids) {
		// TODO Auto-generated method stub
		persistence.delete(ids);
	}

	public List searchEtipMsgRegistries(PageRoll pageRoll, EtipMsgRegistry data) {
		// TODO Auto-generated method stub
		// 未完待续
		pageRoll.setSearchSQL("from EtipMsgRegistry");
		pageRoll.setCountSQL("select count(*) from EtipMsgRegistry");
		return persistence.search(pageRoll);
	}

	public List searchList(PageRoll pageRoll, JSONObject condition) {
		StringBuffer sbFrom = new StringBuffer();
		StringBuffer sbWhere = new StringBuffer();
		String hql = "";

		sbFrom.append("from EtipMsgRegistry u ");
		sbWhere.append("where 1=1");

		String messageName = (String) condition.get("messageName");
		if (messageName != null && !"".equals(messageName)) {
			sbWhere.append(" and u.messageName like '%" + messageName + "%'");
		}
		String handlerType = (String) condition.get("handlerType");
		if (handlerType != null && !("".equals(handlerType))
				&& !("0".equals(handlerType))) {
			sbWhere.append(" and u.handlerType=" + handlerType + " ");
		}

		String triggerAction = (String) condition.get("triggerAction");
		if (triggerAction != null && !("".equals(triggerAction))) {
			sbWhere.append(" and u.triggerAction like '%" + triggerAction
					+ "%' ");
		}

		String triggerPoint = (String) condition.get("triggerPoint");
		if (triggerPoint != null && !("".equals(triggerPoint))
				&& !("0".equals(triggerPoint))) {
			sbWhere.append(" and u.triggerPoint=" + triggerPoint + " ");
		}

		String synchronize = (String) condition.get("synchronize");
		if (synchronize != null && !("".equals(synchronize))) {
			sbWhere.append(" and u.synchronize=" + synchronize + " ");
		}

		hql = sbFrom.toString() + sbWhere.toString();
		pageRoll.setSearchSQL("select u " + hql);
		pageRoll.setCountSQL("select count(*) " + hql);
		return persistence.search(pageRoll);
	}

	public void updateEtipMsgRegistry(EtipMsgRegistry data) {
		// TODO Auto-generated method stub
		persistence.update(data);
	}

	public List getRegistryList(String[] ids) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			list.add(persistence.retrieve(ids[i]));
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
	public List<EtipMsgRegistry> search(PageRoll pageRoll, JSONObject condition) {
		// 首先根据condition拼出where语句
		String where = " where 1>0";

		String countSQL = "select count(*) from EtipMsgRegistry" + where;
		String selectSQL = "from EtipMsgRegistry " + where;
		pageRoll.setCountSQL(countSQL);
		pageRoll.setSearchSQL(selectSQL);
		List<EtipMsgRegistry> processList = persistence.search(pageRoll);
		// 最后查询返回值
		return processList;
	}

	public EtipMsgRegistry retrieveOne(String id) {
		return persistence.retrieve(id);
	}

}
