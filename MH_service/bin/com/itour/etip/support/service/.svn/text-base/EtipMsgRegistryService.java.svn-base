package com.itour.etip.support.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.EtipMsgRegistry;
import com.itour.etip.support.business.IEtipMsgRegistryBusiness;

public class EtipMsgRegistryService extends FrmBusiness implements
		IEtipMsgRegistryService {

	private IEtipMsgRegistryBusiness business;

	public IEtipMsgRegistryBusiness getBusiness() {
		return business;
	}

	public void setBusiness(IEtipMsgRegistryBusiness business) {
		this.business = business;
	}

	public void addEtipMsgRegistry(EtipMsgRegistry data) {
		// TODO Auto-generated method stub
		business.addEtipMsgRegistry(data);
	}

	public void deleteEtipMsgRegistry(String id) {
		// TODO Auto-generated method stub
		business.deleteEtipMsgRegistry(id);
	}

	public void deleteEtipMsgRegistries(String[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++){
			business.deleteEtipMsgRegistry(ids[i]);
		}
	}

	public List searchEtipMsgRegistries(PageRoll pageRoll, EtipMsgRegistry data) {
		return business.searchEtipMsgRegistries(pageRoll, data);
	}

	public void updateEtipMsgRegistry(EtipMsgRegistry data) {
		// TODO Auto-generated method stub
		business.updateEtipMsgRegistry(data);
	}

	public List getRegistryList(String[] ids) {
		// TODO Auto-generated method stub
		return business.getRegistryList(ids);
	}
	/**
	 * 查看明细
	 */
	public EtipMsgRegistry retrieveOne(String id) {
		return business.retrieveOne(id);
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
		return business.search(pageRoll, condition);
	}
	public List<EtipMsgRegistry> searchList(PageRoll pageRoll, JSONObject condition){
		return business.searchList(pageRoll, condition);
	}
}
