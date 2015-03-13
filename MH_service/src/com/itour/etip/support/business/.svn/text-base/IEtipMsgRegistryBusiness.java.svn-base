package com.itour.etip.support.business;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.EtipMsgRegistry;

public interface IEtipMsgRegistryBusiness extends IBusiness {

	public void addEtipMsgRegistry(EtipMsgRegistry data);

	public void deleteEtipMsgRegistry(String id);

	public void deleteEtipMsgRegistries(String[] ids);

	public void updateEtipMsgRegistry(EtipMsgRegistry data);

	public EtipMsgRegistry retrieveOne(String id);

	public List searchEtipMsgRegistries(PageRoll pageRoll, EtipMsgRegistry data);

	public List getRegistryList(String[] ids);

	public List<EtipMsgRegistry> search(PageRoll pageRoll, JSONObject condition);

	public List<EtipMsgRegistry> searchList(PageRoll pageRoll,
			JSONObject condition);

}
