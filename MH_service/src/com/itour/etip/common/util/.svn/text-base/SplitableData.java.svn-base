package com.itour.etip.common.util;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmData;

/**
 * 可以拆分数据的时间段数据
 * 
 * @author lishan
 */
@MappedSuperclass
public abstract class SplitableData extends FrmData implements Cloneable {


	
	// 供算法用的变量，如果该对象被删除，那么设置为true,后续的算法将不再处理。
	private boolean deleted = false;
	//供算法调用，如果该对象被保存，那么不再保存
	private boolean saved = false;

	/**
	 * 供应商编号VARCHAR2(32) add by Jame 2010-05-13
	 */
	@javax.persistence.Column(name = "PROVIDERID", length = 32)
	private String providerId;

	
	@Transient
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Transient
	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	/**
	 * 克隆对象
	 */
	public SplitableData clone() {
		SplitableData cloneObj;
		try {
			cloneObj =(SplitableData)super.clone();
			if(this.getSubObj() != null)cloneObj.setSubObj(this.getSubObj().clone());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return cloneObj;
	}
	
	
	public abstract void setJson(JSONObject json);
	
	public abstract void setRoomId(String roomId);
	
	public abstract void setHotelId(String hotelId);
	
	public abstract void setReleaseState(Integer releaseState);
	
	public abstract void setApprovalState(Integer approvalState);
	
	public abstract void setSubObj(FrmData subObj);
	
	public abstract void setEffectBeginTime(java.util.Date effectBeginTime);
	
	public abstract void setEffectEndTime(java.util.Date effectEndTime);
	
	@Transient
	public abstract Integer getApprovalState();
	@Transient
	public abstract Integer getReleaseState();
	@Transient
	public abstract String getRoomId();
	@Transient
	public abstract String getHotelId();
	@Transient
	public abstract FrmData getSubObj();
	@Transient
	public abstract java.util.Date getEffectBeginTime();
	@Transient
	public abstract java.util.Date getEffectEndTime();
	/**
	 * 如果是审批产生的记录，此属性保存对应的任务id.
	 */
	
	private String taskID;


	@Column(name = "TASKID", length = 32, nullable = true)
	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	
	/**
	 * 此方法无用，主要是消除控制台中的警告信息
	 * @return
	 */
	@Transient
	public JSONObject getJson(){
		return null;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
}
