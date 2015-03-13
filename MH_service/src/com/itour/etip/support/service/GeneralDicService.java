package com.itour.etip.support.service;

import java.util.List;

import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.support.business.IGeneralDicBusiness;
import com.itour.etip.support.data.GeneralDicData;

public class GeneralDicService extends FrmService implements IGeneralDicService{
	
	private IGeneralDicBusiness generalDicBusiness;

	public GeneralDicData addGeneralDic(GeneralDicData data) {
		// TODO Auto-generated method stub
		return generalDicBusiness.addGeneralDic(data);
	}

	public int deleteGeneralDic(String dicCode) {
		// TODO Auto-generated method stub
		return generalDicBusiness.deleteGeneralDic(dicCode);
	}

	public void deleteGeneralDics(String[] dicCodes) {
		// TODO Auto-generated method stub
		generalDicBusiness.deleteGeneralDics(dicCodes);
	}

	public GeneralDicData retrieveGeneralDic(String id) {
		// TODO Auto-generated method stub
		return generalDicBusiness.retrieveGeneralDic(id);
	}

	public List<GeneralDicData> searchGeneralDics(GeneralDicData data) {
		// TODO Auto-generated method stub
		return generalDicBusiness.searchGeneralDics(data);
	}

	public GeneralDicData updateGeneralDic(GeneralDicData data) {
		// TODO Auto-generated method stub
		return generalDicBusiness.updateGeneralDic(data);
	}

	public IGeneralDicBusiness getGeneralDicBusiness() {
		return generalDicBusiness;
	}

	public void setGeneralDicBusiness(
			IGeneralDicBusiness generalDicBusiness) {
		this.generalDicBusiness = generalDicBusiness;
	}
	/**
	 * 根据字典代码查询单个记录
	 * @param dicCode
	 * @return
	 */
	public GeneralDicData getGeneralDic(String dicCode){
		return generalDicBusiness.getGeneralDic(dicCode);
	}
	
	/**
	 * 根据字典代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDic(String dicCode){
		return generalDicBusiness.searchGeneralDic(dicCode);
	}
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode){
		return generalDicBusiness.searchGeneralDicByArrtCode(attrCode);
	}
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param attrCode
	 * @param dicType
	 * 		比如说城市下有好多区，县，商圈等，用来区分
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode, String dicType){
		return generalDicBusiness.searchGeneralDicByArrtCode(attrCode, dicType);
	}
	
	/**
	 * 根据父id查询子数据
	 * @param parentID
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByParentID(String parentID){
		return generalDicBusiness.searchGeneralDicByParentID(parentID);
	}
	/**
	 * 查询角色类型
	 * @return
	 */
	public List<GeneralDicData>  getGeneralRoleList(){
		return generalDicBusiness.getGeneralRoleList();
	}
}
