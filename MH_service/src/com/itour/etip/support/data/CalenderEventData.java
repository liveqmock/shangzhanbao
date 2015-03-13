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
@Table(name = "CalenderEvent")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CalenderEventData extends FrmData{

	/**
	 * 生效开始时间.TIMESTAMP.notnull
	 */
	private java.util.Date startTime;

	/**
	 * 生效结束时间.TIMESTAMP.notnull
	 */
	private java.util.Date endTime;

	/**
	 * 类型.CalendarEvent
	 */
	private int eventType;

	/**
	 * 城市.City.notnull
	 */
	private String city;

	/**
	 * 省.Province.notnull
	 */
	private String province;

	/**
	 * 国家.Country.notnull
	 */
	private String country;

	/**
	 * 标题.VARCHAR2(50).notnull
	 */
	private String title;

	/**
	 * 描述.VARCHAR2(255)
	 */
	private String memo;
	

	/**
	 *获得生效开始时间.TIMESTAMP.notnull
	 */
	@Column(name = "STARTTIME",nullable = true)
	public java.util.Date getStartTime(){
		return startTime;
}

	/**
	 *设置生效开始时间.TIMESTAMP.notnull
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
}


	/**
	 *获得生效结束时间.TIMESTAMP.notnull
	 */
	@Column(name = "ENDTIME",nullable = true)
	public java.util.Date getEndTime(){
		return endTime;
}

	/**
	 *设置生效结束时间.TIMESTAMP.notnull
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
}


	/**
	 *获得类型.CalendarEvent
	 */
	@Column(length = 3,name = "EVENTTYPE",nullable = true)
	public int getEventType(){
		return eventType;
}

	/**
	 *设置类型.CalendarEvent
	 */
	public void setEventType(int eventType) {
		this.eventType = eventType;
}


	/**
	 *获得城市.City.notnull
	 */
	@Column(length = 16,name = "CITY",nullable = true)
	public String getCity(){
		return city;
}

	/**
	 *设置城市.City.notnull
	 */
	public void setCity(String city) {
		this.city = city;
}


	/**
	 *获得省.Province.notnull
	 */
	@Column(length = 16,name = "PROVINCE",nullable = true)
	public String getProvince(){
		return province;
}

	/**
	 *设置省.Province.notnull
	 */
	public void setProvince(String province) {
		this.province = province;
}


	/**
	 *获得国家.Country.notnull
	 */
	@Column(length = 16,name = "COUNTRY",nullable = true)
	public String getCountry(){
		return country;
}

	/**
	 *设置国家.Country.notnull
	 */
	public void setCountry(String country) {
		this.country = country;
}


	/**
	 *获得标题.VARCHAR2(50).notnull
	 */
	@Column(length = 64,name = "TITLE",nullable = true)
	public String getTitle(){
		return title;
}

	/**
	 *设置标题.VARCHAR2(50).notnull
	 */
	public void setTitle(String title) {
		this.title = title;
}


	/**
	 *获得描述.VARCHAR2(255)
	 */
	@Column(length = 4000,name = "MEMO",nullable = true)
	public String getMemo(){
		return memo;
}

	/**
	 *设置描述.VARCHAR2(255)
	 */
	public void setMemo(String memo) {
		this.memo = memo;
}

}
