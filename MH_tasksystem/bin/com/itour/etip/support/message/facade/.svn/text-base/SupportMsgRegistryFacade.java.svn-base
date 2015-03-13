package com.itour.etip.support.message.facade;

import java.util.List;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.kit.jms.EtipMsgRegistry;
import com.itour.etip.support.service.IEtipMsgRegistryService;

public class SupportMsgRegistryFacade extends FrmFacade {

	/**
	 * 查询用户基础信息，带分页查询
	 * 
	 * @param pageRoll
	 * @return
	 */
	private IEtipMsgRegistryService etipMsgRegistryService;

	public List<EtipMsgRegistry> listUser(PageRoll pageRoll,
			JSONObject jsonObject) {
		return etipMsgRegistryService.searchList(pageRoll, jsonObject);
	}

	public IEtipMsgRegistryService getEtipMsgRegistryService() {
		return etipMsgRegistryService;
	}

	public void setEtipMsgRegistryService(
			IEtipMsgRegistryService etipMsgRegistryService) {
		this.etipMsgRegistryService = etipMsgRegistryService;
	}

	/**
	 * 删除个人基础信息，可以批量删除
	 * 
	 * @param objs
	 *            id数组
	 * @return
	 */
	public void deleteUser(String[] objs) {
		etipMsgRegistryService.deleteEtipMsgRegistries(objs);
	}

	/**
	 * 添加基础信息
	 * 
	 * @param userBase
	 * @return
	 */
	public void addUser(EtipMsgRegistry data) {
		etipMsgRegistryService.addEtipMsgRegistry(data);
	}

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */

	public EtipMsgRegistry selectOne(String id) {
		return etipMsgRegistryService.retrieveOne(id);
	}

	/**
	 * 更新
	 * 
	 * @param userBase
	 * @return
	 */
	public void updateUser(EtipMsgRegistry Data) {
		etipMsgRegistryService.updateEtipMsgRegistry(Data);
	}

}
