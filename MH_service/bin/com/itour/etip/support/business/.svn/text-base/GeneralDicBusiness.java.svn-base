package com.itour.etip.support.business;

import java.util.ArrayList;
import java.util.List;

import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.support.data.GeneralDicData;
import com.itour.etip.support.persistence.IGeneralDicPersistence;

public class GeneralDicBusiness extends FrmBusiness implements IGeneralDicBusiness{
	
	private IGeneralDicPersistence generalDicPersistence;

	public GeneralDicData addGeneralDic(GeneralDicData data) {
		String where=" ";
		String dicType = data.getDicType();
		boolean t = false;  //是否需要3位编码 
		if(dicType.equals("businessarea") || dicType.equals("por")){
			t= true;
			where = " and (s.dicType='businessarea' or s.dicType='por')";
		}else if (dicType.equals("district")){
			where = " and s.dicType='district'";
		}
		// TODO Auto-generated method stub
		String parentID = data.getParentID();
		String dicCode=null;
		List list = null;
		if( parentID == null  ||parentID.trim().length()<=0){
			list = generalDicPersistence.search("select max(s.dicCode) from GeneralDicData s where s.parentID is null"+where);
		}else{
			list = generalDicPersistence.search("select max(s.dicCode) from GeneralDicData s where s.parentID='"+parentID+"'"+where);
		}
		
		if(list.get(0) == null){  //此父ID不存在子数据
			if(parentID == null  ||  parentID.trim().length()<=0){
				if(t){
					dicCode= parentID.trim()+"001";
				}else{
					dicCode= parentID.trim()+"01";
				}
			}else{
				GeneralDicData parentObj = generalDicPersistence.retrieve(parentID);
				if(t){
					dicCode= parentObj.getDicCode()+"001";
				}else{
					dicCode= parentObj.getDicCode()+"01";
				}
			}
		}else{  //存在子数据
			dicCode= (String)list.get(0);
			//如果数据类型为商圈或地标，编码规则改成3位
			if(t){
				dicCode = get3Code(dicCode);
			}else{
				dicCode= getCode(dicCode);
			}
		}
		data.setDicCode(dicCode);
		//未完成
		if(data.getAttrCode()==null || data.getAttrCode().equals("")){
			data.setAttrCode(dicCode);
		}
		generalDicPersistence.add(data);
		return data;
	}

	public int deleteGeneralDic(String dicCode) {
		// TODO Auto-generated method stub
		
		String sql = "delete from generaldic where dicCode like '"+dicCode+"%'";
	//	//System.out.println("sql:"+sql);
		return generalDicPersistence.executeSQL(sql);
	}

	public void deleteGeneralDics(String[] dicCodes) {
		// TODO Auto-generated method stub
		for(int i=0;i<dicCodes.length;i++){
			generalDicPersistence.executeSQL("delete from generaldic where dicCode like '"+dicCodes[i]+"%'");
		}
	}

	public GeneralDicData retrieveGeneralDic(String id) {
		// TODO Auto-generated method stub
		return generalDicPersistence.retrieve(id);
	}

	/**
	 * 应该查询data的子节点，可是data==null，所以就全查了。
	 */
	public List<GeneralDicData> searchGeneralDics(GeneralDicData data) {
		String where  =" where 1>0";
		if(data==null) {
			where +=" and g.parentID is null";
		}else{
			where +=" and g.parentID ='"+data.getId()+"'";
		}
		List<GeneralDicData> generalDics = generalDicPersistence.search("from GeneralDicData g "+where+" order by g.dicCode");
		if(generalDics != null && generalDics.size() > 0){
			return generalDics;
		}
		return null;
	}

	public GeneralDicData updateGeneralDic(GeneralDicData data) {
		// TODO Auto-generated method stub
		generalDicPersistence.update(data);
		return data;
	}

	public IGeneralDicPersistence getGeneralDicPersistence() {
		return generalDicPersistence;
	}

	public void setGeneralDicPersistence(
			IGeneralDicPersistence generalDicPersistence) {
		this.generalDicPersistence = generalDicPersistence;
	}
	
	public List<GeneralDicData> getServiceList(String[] ids){
		List<GeneralDicData> list = new ArrayList<GeneralDicData>();
		for(int i=0;i<ids.length;i++){
			List<GeneralDicData> serviceList = generalDicPersistence.search("from GeneralDicData where dicCode='"+ids[i]+"'");
			list.add(serviceList.get(0));
		}
		return list;
	}
	
	
	public static void main(String[] args){
		String dicCode= "0101";
		String lastSub = dicCode.substring(dicCode.length()-2, dicCode.length());
		if(Integer.valueOf(lastSub) == 99){
		}
		String firstSub = dicCode.substring(0, dicCode.length()-2);
		//System.err.println(firstSub);
		if(Integer.valueOf(lastSub.substring(0,1)) == 0){
			Integer tmpCode = Integer.valueOf(lastSub.substring(1,2))+1;
			if(tmpCode == 10){
				String service = tmpCode.toString();
				//System.out.println(firstSub+service+"--1");
			}else{
				String service = "0"+tmpCode;
				//System.out.println(firstSub+service+"--2");
			}
		}
		else{
			Integer tmpCode = Integer.valueOf(lastSub)+1;
			String service = tmpCode.toString();
			//System.out.println(firstSub+service+"--3");
		}
		
	}
	
	/**
	 * 2位编码
	 *@param
	 */
	private String getCode(String serviceCode){
//System.out.println("---------"+serviceCode+"--------");		
//		GeneralDicData data = new GeneralDicData();
//		data.setServiceCode("01");
//		//System.out.println(SQLTest.makeSQL("from GeneralDicData ", data, null, null));
		String lastSub = serviceCode.substring(serviceCode.length()-2, serviceCode.length());
		if(Integer.valueOf(lastSub) == 99){
			throw new ETIPException("TreeTooLongException");
		}
		String firstSub = serviceCode.substring(0, serviceCode.length()-2);
		//System.err.println(firstSub);
		if(Integer.valueOf(lastSub.substring(0,1)) == 0){
			Integer tmpCode = Integer.valueOf(lastSub.substring(1,2))+1;
			if(tmpCode == 10){
				String service = tmpCode.toString();
				//System.out.println(firstSub+service+"--1");
				return firstSub+service;
			}else{
				String service = "0"+tmpCode;
				//System.out.println(firstSub+service+"--2");
				return firstSub+service;
			}
		}
		else{
			Integer tmpCode = Integer.valueOf(lastSub)+1;
			String service = tmpCode.toString();
			//System.out.println(firstSub+service+"--3");
			return firstSub+service;
		}
		
	}
	
	/**
	 * 3位编码
	 * 
	 * @param
	 */
	private String get3Code(String serviceCode) {
		String lastSub = serviceCode.substring(serviceCode.length() - 3,
				serviceCode.length()); // 截取后3位
		if (Integer.valueOf(lastSub) == 999) {
			throw new ETIPException("TreeTooLongException");
		}
		String firstSub = serviceCode.substring(0, serviceCode.length() - 3);// 除最后3位字符串
		Integer temCode = Integer.parseInt(lastSub)+1;
		String tempStr = String.valueOf(temCode);
		for(int i = tempStr.length();i<3;i++){
			tempStr="0"+tempStr;
		}
		return firstSub+tempStr;
	}
	/**
	 * 根据字典代码查询单个记录
	 * @param dicCode
	 * @return
	 */
	public GeneralDicData getGeneralDic(String dicCode){
		List<GeneralDicData> generalDics = generalDicPersistence.search("from GeneralDicData g where g.dicCode='" + dicCode + "'");
		if(generalDics != null && generalDics.size() > 0){
			return generalDics.get(0);
		}else{
			return null;
		}
	}

	/**
	 * 根据字典代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDic(String dicCode){
		GeneralDicData generalDic = getGeneralDic(dicCode);
		if(generalDic != null){
			return searchGeneralDicByParentID(generalDic.getId());
		}else{
			return null;
		}
	}
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param dicCode
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode){
		List<GeneralDicData> generalDics = generalDicPersistence.search("from GeneralDicData g where g.attrCode='" + attrCode + "'");
		if(generalDics != null && generalDics.size() > 0){
			generalDics = generalDicPersistence.search("from GeneralDicData g where g.parentID='" + generalDics.get(0).getId() + "' order by g.dicCode");
			if(generalDics != null && generalDics.size() > 0){
				return generalDics;
			}
			return null;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据属性代码查询所有子数据
	 * @param attrCode
	 * @param dicType
	 * 		比如说城市下有好多区，县，商圈等，用来区分
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByArrtCode(String attrCode, String dicType){
		List<GeneralDicData> generalDics = generalDicPersistence.search("from GeneralDicData g where g.attrCode='" + attrCode + "'");
		if(generalDics != null && generalDics.size() > 0){
			StringBuffer sb = new StringBuffer();
			sb.append("from GeneralDicData g");
			sb.append(" where g.parentID='" + generalDics.get(0).getId() + "'");
			sb.append(" and g.dicType='" + dicType + "'");
			sb.append(" order by g.dicCode");
			generalDics = generalDicPersistence.search(sb.toString());
			if(generalDics != null && generalDics.size() > 0){
				return generalDics;
			}
			return null;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据父id查询子数据
	 * @param parentID
	 * @return
	 */
	public List<GeneralDicData> searchGeneralDicByParentID(String parentID){
		List<GeneralDicData> generalDics = generalDicPersistence.search("from GeneralDicData g where g.parentID='" + parentID + "' order by g.dicCode");
		if(generalDics != null && generalDics.size() > 0){
			return generalDics;
		}
		return null;
	}
	/**
	 * 查询角色类型
	 * @return
	 */
	public List<GeneralDicData>  getGeneralRoleList(){
		return generalDicPersistence.search("from GeneralDicData g where g.dicCode like '02%'");
	}
	
	/**
	 * 根据传过来的参数查询对应的数据
	 * 主要用来匹配各渠道同步过来的地域资料在我们自己的数据中是否存在
	 *@param
	 */
	public List<GeneralDicData>  getGeneralDicList(String param){
		return generalDicPersistence.search("from GeneralDicData g where 1=1 "+param);
	}
}
