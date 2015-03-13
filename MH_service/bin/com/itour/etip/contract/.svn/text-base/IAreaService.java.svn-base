package com.itour.etip.contract;

import javax.jws.WebParam;
import javax.jws.WebService;
/**
 * 国家省市相关的接口
 * 
 * @author txc
 */
@WebService
public interface IAreaService {
/**
 * 查询节点对象：根据地区id,地区编码,全拼，简拼，名称，如参数都为空则返回所有的节点
 * 返回地区信息，格式为XML，参数地区ID可保证记录唯一性，其他参数不能保证记录唯一性
 * 
 * @param areaID  地区ID
 * @param areaCode  地区编码
 * @param allSpell  地区全拼
 * @param simpleSpell  地区简拼
 * @param areaName  地区名称
 * @return
 */
	public String getAreaNode(@WebParam(name = "areaID")String areaID,
			@WebParam(name = "areaCode")String areaCode,
			@WebParam(name = "allSpell")String allSpell,
			@WebParam(name = "simpleSpell")String simpleSpell,
			@WebParam(name = "areaName")String areaName);
	/**
	 * 获取地区的根节点，应该是中国
	 * 返回地区树的根节点，中国
	 * 
	 * @return
	 */
	public String getRootNode();
	/**
	 * 根据id获取其子节点
	 * 
	 * @param areaID 地区ID
	 * @return
	 */
	public String getChildNodeByID(@WebParam(name = "areaID")String areaID);
	/**
	 * 获取中国所有节点
	 * @return
	 */
	public String getAllChinaNode();
	
}
