package com.itour.etip.pub.frame;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.itour.etip.pub.base.IData;
import com.itour.etip.pub.kit.cache.IDMappingNameCache;
import com.itour.etip.pub.kit.log.LogUtil;

@MappedSuperclass
public abstract class FrmData implements IData, java.io.Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * id:数据的主键
	 */
	protected String id;

	@Id
	@Column(name = "id", length = 32, nullable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 版本戳,自增长，保存一次增一
	 */
	@Version
	private Integer version = 1;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	// 数据创建人的中文名称
	private String creatorName = "";

	
	// 数据修改人的中文名称
	private String updatorName = "";


	/**
	 * 向创建人名称赋值
	 * 
	 * @param etipUserID
	 */
	public void setValueToCreatorName(String etipUserID) {
		if (etipUserID != null && etipUserID.trim().length() > 0){
			setCreatorName((String) IDMappingNameCache.nameMap.get(etipUserID));
		}
	}


	/**
	 * 向修改人名称赋值
	 * 
	 * @param etipUserID
	 */
	public void setValueToUpdatorName(String etipUserID) {
		if (etipUserID != null && etipUserID.trim().length() > 0)
			setUpdatorName((String) IDMappingNameCache.nameMap.get(etipUserID));
	}
	@Transient
	public String getValueToUpdatorName(){
		return this.updatorName;
	}
	@Transient
	public String getValueToCreatorName(){
		return this.creatorName;
	}

	/**
	 * 通用的toString方法，显示每个字段值。
	 */
	public String toMyString() {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(this.getClass().getCanonicalName() + ":{");
			Field[] fields = this.getClass().getDeclaredFields();

			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				String getName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				Method method = this.getClass().getMethod(getName, null);
				Object fieldValue = method.invoke(this, null);
				sb.append(fieldName + ":" + fieldValue + ";");
			}
			sb.append("}");
			return sb.toString();
		} catch (Exception ex) {
			return "toString Error";
		}
	}

	/**
	 * lazy状态，判断是否处理过懒加载 0：未处理 1：已经加载 2: 已经去掉懒加载
	 */
	public int lazyStatus = 0;

	@Transient
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Transient
	public String getUpdatorName() {
		return updatorName;
		// return "testUpdatorName";
	}

	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}

	/**
	 * 克隆方法，不克隆id
	 */
	public FrmData clone() {
		Object rv = null;
		try {
			rv = super.clone();
		} catch (Exception ex) {
			// 不可能发生这个错误
			LogUtil.error("CONSOLE", "FrmData Clone Exception");
			return null;
		}
		FrmData rvData = (FrmData) rv;
		rvData.setId(null);
		return rvData;
	}

}
