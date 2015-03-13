package com.itour.etip.contract;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

/**
 * 大订单结构相关的实现
 * 
 * @author txc
 */
@WebService(endpointInterface = "com.itour.etip.contract.IAreaService")
public class AreaService implements IAreaService{
	/**
	 * 获取中国所有节点
	 * @return
	 */
	public String getAllChinaNode() {
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		String sql = "select * from generaldic g where g.diccode like '0101%'";
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		
		if(list == null || list.size() == 0)return null;
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("<ChinaArea>");
		for(ETIPResultSet area : list){
			sb.append("<Area>");
			sb.append("<AreaID>"+area.getString("ID")+"</AreaID>");
			sb.append("<ParentID>"+area.getString("PARENTID")+"</ParentID>");
			sb.append("<DicCode>"+area.getString("DICCODE")+"</DicCode>");
			sb.append("<DicType>"+area.getString("DicType")+"</DicType>");
			sb.append("<AttrCode>"+area.getString("ATTRCODE")+"</AttrCode>");
			sb.append("<AttrName>"+area.getString("ATTRNAME")+"</AttrName>");
			sb.append("<EnglishName>"+area.getString("ENGLISHNAME")+"</EnglishName>");
			sb.append("<AbbreviateName>"+area.getString("ABBREVIATENAME")+"</AbbreviateName>");
			sb.append("</Area>");
		}
		sb.append("</ChinaArea>");
		return sb.toString();
	}
	/**
	 * 查询节点对象：根据地区id,地区编码,全拼，简拼，名称,如参数都为空则返回所有的节点
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
			@WebParam(name = "areaName")String areaName) {
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		String sql = "select * from generaldic g where 1=1 ";
		
		if(areaID!=null && !("".equals(areaID.trim()))){
			sql += " and g.id='"+areaID+"'";
		}
		if(areaCode!=null && !("".equals(areaCode.trim()))){
			sql += " and g.attrCode='"+areaCode+"'";
		}
		if(allSpell!=null && !("".equals(allSpell.trim()))){
			sql += " and g.englishName='"+allSpell+"'";
		}
		if(simpleSpell!=null && !("".equals(simpleSpell.trim()))){
			sql += " and g.abbreviateName='"+simpleSpell+"'";
		}
		if(areaName!=null && !("".equals(areaName.trim()))){
			sql += " and g.attrName='"+areaName+"'";
		}
		
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		if(list == null || list.size() == 0)return null;
		StringBuffer sb = new StringBuffer();
		sb.append("<Areas>");
		for(ETIPResultSet area : list){
			sb.append("<Area>");
			sb.append("<AreaID>"+area.getString("ID")+"</AreaID>");
			sb.append("<ParentID>"+area.getString("PARENTID")+"</ParentID>");
			sb.append("<DicCode>"+area.getString("DICCODE")+"</DicCode>");
			sb.append("<DicType>"+area.getString("DicType")+"</DicType>");
			sb.append("<AttrCode>"+area.getString("ATTRCODE")+"</AttrCode>");
			sb.append("<AttrName>"+area.getString("ATTRNAME")+"</AttrName>");
			sb.append("<EnglishName>"+area.getString("ENGLISHNAME")+"</EnglishName>");
			sb.append("<AbbreviateName>"+area.getString("ABBREVIATENAME")+"</AbbreviateName>");
			sb.append("</Area>");
		}
		sb.append("</Areas>");
		// TODO Auto-generated method stub
		return sb.toString();
	}
	/**
	 * 根据id获取其子节点
	 * 
	 * @param areaID 地区ID
	 * @return
	 */
	public String getChildNodeByID(@WebParam(name = "areaID")String areaID) {
		// TODO Auto-generated method stub
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		if(areaID == null || "".equals(areaID.trim()))return null;
		String sql = "select * from generaldic g where g.parentID='"+areaID+"'";
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		if(list == null || list.size() == 0)return null;
		StringBuffer sb = new StringBuffer();
		sb.append("<Areas>");
		for(ETIPResultSet area : list){
			sb.append("<Area>");
			sb.append("<AreaID>"+area.getString("ID")+"</AreaID>");
			sb.append("<ParentID>"+area.getString("PARENTID")+"</ParentID>");
			sb.append("<DicCode>"+area.getString("DICCODE")+"</DicCode>");
			sb.append("<DicType>"+area.getString("DicType")+"</DicType>");
			sb.append("<AttrCode>"+area.getString("ATTRCODE")+"</AttrCode>");
			sb.append("<AttrName>"+area.getString("ATTRNAME")+"</AttrName>");
			sb.append("<EnglishName>"+area.getString("ENGLISHNAME")+"</EnglishName>");
			sb.append("<AbbreviateName>"+area.getString("ABBREVIATENAME")+"</AbbreviateName>");
			sb.append("</Area>");
		}
		sb.append("</Areas>");
		return sb.toString();
	}
	/**
	 * 获取地区的根节点，应该是中国
	 * 返回地区树的根节点，中国
	 * 
	 * @return
	 */
	public String getRootNode() {
		JdbcDao jdbc = (JdbcDao)SpringContextHelper.getBean("jdbc");
		String sql = "select * from generaldic g where g.diccode = '0101'";
		List<ETIPResultSet> list = jdbc.queryForList(sql, null);
		
		if(list == null || list.size() == 0)return null;
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		for(ETIPResultSet area : list){
			sb.append("<Area>");
			sb.append("<AreaID>"+area.getString("ID")+"</AreaID>");
			sb.append("<ParentID>"+area.getString("PARENTID")+"</ParentID>");
			sb.append("<DicCode>"+area.getString("DICCODE")+"</DicCode>");
			sb.append("<DicType>"+area.getString("DicType")+"</DicType>");
			sb.append("<AttrCode>"+area.getString("ATTRCODE")+"</AttrCode>");
			sb.append("<AttrName>"+area.getString("ATTRNAME")+"</AttrName>");
			sb.append("<EnglishName>"+area.getString("ENGLISHNAME")+"</EnglishName>");
			sb.append("<AbbreviateName>"+area.getString("ABBREVIATENAME")+"</AbbreviateName>");
			sb.append("</Area>");
		}
		return sb.toString();
	}

}
