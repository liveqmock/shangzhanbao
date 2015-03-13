package com.itour.etip.support.business;

import java.util.List;

import com.itour.etip.pub.base.IBusiness;
import com.itour.etip.support.data.GeneralDicData;

/**
 * <p>Title: 服务注册表Business</p>
 * <p>Description: 服务注册表Business</p>
 * <p>Copyright: Copyright (C), 2009-2010, eTIP </p>
 * @Author txc
 * @Version 1.0
 * @Date 2009-06-02
 */
public interface IGeneralDicBusiness extends IBusiness{
	
	/**
	 * 添加单条服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录
	 *
	 * 
	 * 备注：添加记录时的服务编码生成规则？
	 */
	public GeneralDicData addGeneralDic(GeneralDicData data);
	/**
	 * 删除单条服务注册记录
	 * @param serviceCode 服务编号
	 *
	 * 
	 * 备注：由于数据库中是树形结构，故删除数据时使用服务编码字段模糊匹配删除
	 */
	public int deleteGeneralDic(String serviceCode);
	/**
	 * 批量删除服务注册记录
	 * @param ids 服务编号数组
	 *
	 */
	public void deleteGeneralDics(String[] serviceCodes);
	
	/**
	 * 修改服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录
	 *
	 */
	public GeneralDicData updateGeneralDic(GeneralDicData data);
	
	/**
	 * 查询单条服务注册记录
	 * @param id服务注册记录ID
	 * @return 服务注册记录
	 *
	 */
	public GeneralDicData retrieveGeneralDic(String id);
	
	/**
	 * 查询多条服务注册记录
	 * @param data 服务注册记录
	 * @return 服务注册记录集合
	 *
	 */
	public List<GeneralDicData> searchGeneralDics(GeneralDicData data);
	
	/**
	 * 给角色查看权限时使用
	 * @return
	 */
	public List<GeneralDicData> getServiceList(String[] ids);
	
	/**
	 * 根据字典代码查询单个记录
	 * @param dicCode
	 * @return
	 */
	public GeneralDicData getGeneralDic(String dicCode);
	
	/**
	 * 根据字典代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDic(String dicCode);
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode);
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param attrCode
	 * @param dicType
	 * 		比如说城市下有好多区，县，商圈等，用来区分
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode, String dicType);
	
	/**
	 * 根据父id查询子数据
	 * @param parentID
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByParentID(String parentID);
	/**
	 * 查询角色类型
	 * @return
	 */
	public List<GeneralDicData>  getGeneralRoleList();
	
	/**
	 * 根据传过来的参数查询对应的数据
	 * 主要用来匹配各渠道同步过来的地域资料在我们自己的数据中是否存在
	 *@param
	 */
	public List<GeneralDicData>  getGeneralDicList(String param);
}
