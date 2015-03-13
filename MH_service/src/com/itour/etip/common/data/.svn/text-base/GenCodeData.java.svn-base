package com.itour.etip.common.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.itour.etip.pub.frame.FrmData;

/**
 * 通用规则编号存储类
 * @author Administrator
 *
 */
@Entity()
@Table(name = "GENCODE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class GenCodeData extends FrmData{
	private static final long serialVersionUID = -2798974079933402820L;
	
	/**
	 * 编号类型:如（订单、号段等）
	 */
	private Integer codeType;
	/**
	 * 编号,应该是每个类型唯一的
	 */
	private String codeValue;
	
	@Column(length = 8,name = "CODETYPE",nullable = true)
	public Integer getCodeType() {
		return codeType;
	}
	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}
	@Column(length = 300,name = "CODEVALUE",nullable = true)
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
}
