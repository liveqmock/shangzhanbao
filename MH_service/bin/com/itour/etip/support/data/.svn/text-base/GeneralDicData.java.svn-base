/**
 * Auto generator by Leo
 */
package com.itour.etip.support.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;


@Entity()
@Table(name = "GeneralDic")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GeneralDicData extends FrmData{
	
	/**
	 * 此地区是否有酒店数据
	 */
	private Boolean hasHotel = false;
	/**
	 * 推荐等级
	 */
	private String recommendGrade;
	/**
	 * 浏览等级
	 */
	private String lookGrade;
	/**
	 * 父编号
	 */
	
	private String parentID;

	/**
	 * 字典代码
	 */
	
	private String dicCode;

	/**
	 * 记录类型
	 */
	
	private String dicType;

	/**
	 * 属性代码
	 */
	
	private String attrCode;

	/**
	 * 属性名称
	 */
	
	private String attrName;

	/**
	 * 扩展代码
	 */
	
	private String extendCode;
	/**
	 * 地区英文名称
	 */
	private String englishName;
	/**
	 * 地区缩写
	 */
	private String abbreviateName;
	
	/**
	 * 备注
	 */
	
	private String memo;
	
	
	@Column(length = 20,name = "EXTENDCODE",nullable = true)
	public String getExtendCode() {
		return extendCode;
	}

	public void setExtendCode(String extendCode) {
		this.extendCode = extendCode;
	}

	/**
	 *获得父编号
	 */
	@Column(length = 32,name = "PARENTID",nullable = true)
	public String getParentID(){
		return parentID;
}

	/**
	 *设置父编号
	 */
	public void setParentID(String parentID) {
		this.parentID = parentID;
}


	/**
	 * 获得字典代码
	 */
	@Column(length = 255,name = "DICCODE",nullable = false)
	public String getDicCode(){
		return dicCode;
}

	/**
	 * 设置字典代码
	 */
	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
}


	/**
	 *获得记录类型
	 */
	@Column(length = 20,name = "DICTYPE",nullable = false)
	public String getDicType(){
		return dicType;
}

	/**
	 *设置记录类型
	 */
	public void setDicType(String dicType) {
		this.dicType = dicType;
}


	/**
	 *获得属性代码
	 */
	@Column(length =400,name = "ATTRCODE",nullable = true)
	public String getAttrCode(){
		return attrCode;
}

	/**
	 *设置属性代码
	 */
	public void setAttrCode(String attrCode) {
		this.attrCode = attrCode;
}


	/**
	 *获得属性名字
	 */
	@Column(length = 200,name = "ATTRNAME",nullable = false)
	public String getAttrName(){
		return attrName;
}

	/**
	 *设置属性名字
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
}


	/**
	 *获得备注
	 */
	@Column(length = 4000,name = "MEMO",nullable = true)
	public String getMemo(){
		return memo;
}

	/**
	 *设置备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
}
	@Column(length = 100,name = "LOOKGRADE",nullable = true)
	public String getLookGrade() {
		return lookGrade;
	}

	public void setLookGrade(String lookGrade) {
		this.lookGrade = lookGrade;
	}
	@Column(length = 100,name = "RECOMMENDGRADE",nullable = true)
	public String getRecommendGrade() {
		return recommendGrade;
	}

	public void setRecommendGrade(String recommendGrade) {
		this.recommendGrade = recommendGrade;
	}
	@Column(name = "HASHOTEL",nullable = true)
	public Boolean getHasHotel() {
		return hasHotel;
	}

	public void setHasHotel(Boolean hasHotel) {
		this.hasHotel = hasHotel;
	}
	@Column(length = 100,name = "ABBREVIATENAME",nullable = true)
	public String getAbbreviateName() {
		return abbreviateName;
	}

	public void setAbbreviateName(String abbreviateName) {
		this.abbreviateName = abbreviateName;
	}
	@Column(length = 100,name = "ENGLISHNAME",nullable = true)
	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}



}
