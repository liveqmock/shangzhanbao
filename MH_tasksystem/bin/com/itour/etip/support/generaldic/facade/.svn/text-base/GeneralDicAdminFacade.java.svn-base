package com.itour.etip.support.generaldic.facade;

import java.util.List;

import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.kit.log.LogUtil;
import com.itour.etip.pub.kit.tool.TreeUtils;
import com.itour.etip.support.data.GeneralDicData;
import com.itour.etip.support.service.IGeneralDicService;


public class GeneralDicAdminFacade extends FrmFacade{
	
	private IGeneralDicService generalDicService;
	
	public IGeneralDicService getGeneralDicService() {
		return generalDicService;
	}
	public void setGeneralDicService(
			IGeneralDicService generalDicService) {
		this.generalDicService = generalDicService;
	}
	/**
	 * 添加时保存服务信息
	 * @return 
	
	 */
	public GeneralDicData addService(GeneralDicData sr){
		return generalDicService.addGeneralDic(sr); 
	}
	
	/**
	 * 修改权限信息
	 * @return
	
	 */
	public GeneralDicData updateService(GeneralDicData sr){
		return  generalDicService.updateGeneralDic(sr);
	}
	
	/**
	 * 删除权限信息
	 * @return
	
	 */
	public void deleteService(String[] serviceCodes) {
		generalDicService.deleteGeneralDics(serviceCodes);
	}
	
	public List getServiceTree(GeneralDicData srd,String id){
		
		if(id.equals("0")){
			
			List list1 = generalDicService.searchGeneralDics(srd);
			
			TreeUtils treeUtils = new TreeUtils(list1);
			
			List list =  treeUtils.getTransferedTrees();
			
			List theFirst = treeUtils.getRoots(list);
			
			
			return theFirst;
		}else if(id!=null){
			
			srd = new GeneralDicData();
			srd.setId(id);
			List list1= generalDicService.searchGeneralDics(srd);
			
			TreeUtils treeUtils = new TreeUtils(list1);
			
			List list =  treeUtils.getTransferedTrees();
			
			List childrens = treeUtils.getDirectChildrenTrees(list, id);
			
			return childrens;
		}
		return null;
	}
	
	
}
