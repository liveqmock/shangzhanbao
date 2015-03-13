package com.itour.etip.pub.ldap;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itour.etip.pub.ldap.runtime.ConfigDef;
import com.itour.etip.pub.ldap.runtime.DisplayGroup;
import com.itour.etip.pub.ldap.runtime.PropertyDef;
import com.itour.etip.pub.ldap.runtime.RuntimeConfigDefs;
import com.itour.etip.pub.ldap.runtime.RuntimeConfigDefsParser;
import com.bjsasc.common.io.Resources;

/**
 * ManagerRuntimeConfig工具类为通过PropertiesManager读取系统允许属性提供方便的途径。
 * 之所以增加该工具类是因为在大多数情况下通过PropertiesManager读取的只是属性值而不需要是
 * 整个RuntimeConfigProperty对象。
 */

public class ManagerRuntimeConfig {
	private static Log log = LogFactory.getLog(ManagerRuntimeConfig.class);

	private static String runtime_config = "com/itour/etip/pub/ldap/runtime/runtimeConfigDefs.xml";
	private static RuntimeConfigDefs configDefs = null;
	
	private static HashMap<String,String> parame ;

	// special case for our context urls
	private static String relativeContextURL = null;
	private static String absoluteContextURL = null;

	/**
	 * 返回系统的绝对路径
	 * 
	 * @return
	 */
	public static String getAbsoluteContextURL() {

		// db prop takes priority if it exists
		String absURL = getProperty("site.absoluteurl");
		if (absURL != null && absURL.trim().length() > 0) {
			return absURL;
		}

		return absoluteContextURL;
	}

	/**
	 * 返回boolean类型的属性值，如果出现异常则返回false
	 * 
	 * @param name
	 *            属性名
	 * @return boolean boolean类型属性值
	 */
	public static boolean getBooleanProperty(String name) {

		// get the value first, then convert
		String value = getProperty(name);

		if (value == null)
			return false;

		return (new Boolean(value)).booleanValue();
	}

	/**
	 * 返回int类型的属性值，如果出现异常则返回-1
	 * 
	 * @param name
	 *            属性名
	 * @return int int类型属性值
	 */
	public static int getIntProperty(String name) {

		// get the value first, then convert
		String value = getProperty(name);

		if (value == null)
			return -1;

		int intval = -1;
		try {
			intval = Integer.parseInt(value);
		} catch (Exception e) {
			log.warn("Trouble converting to int: " + name, e);
		}

		return intval;
	}

	/**
	 * 通过PropertiesManager返回单一属性值 ... 如果出现异常，则返回null
	 * 
	 * @param name
	 *            属性名
	 * @return String 返回的属性值
	 */
	public static String getProperty(String name) {
		parame = null;
		setParame();
		return parame.get(name);
	}
	
	public static void setParame(){
		if(parame==null){
			parame = new HashMap<String, String>();
			List<ConfigDef> list = getRuntimeConfigDefs().getConfigDefs();
			for(ConfigDef configDef : list){
				List<DisplayGroup> displayGroupList = configDef.getDisplayGroups();
				for(DisplayGroup displayGroup : displayGroupList){
					List<PropertyDef> propertyDefList = displayGroup.getPropertyDefs();
					for(PropertyDef propertyDef : propertyDefList){
						parame.put(propertyDef.getName(), propertyDef.getDefaultValue());
					}
				}
			}
		}
	}

	public static String getRelativeContextURL() {
		return relativeContextURL;
	}

	/**
	 * 返回系统运行时属性配置信息
	 * 
	 * @return
	 */
	public static RuntimeConfigDefs getRuntimeConfigDefs() {

		if (configDefs == null) {

			// unmarshall the config defs file
			try {
				InputStream is = Resources.getResourceAsStream(runtime_config);

				RuntimeConfigDefsParser parser = new RuntimeConfigDefsParser();
				configDefs = parser.unmarshall(is);

			} catch (Exception e) {
				// error while parsing :(
				log.error("Error parsing runtime config defs", e);
			}

		}

		return configDefs;
	}

	/**
	 * 获取运行时配置XML文件定义为一个字符串。 这是一个用于访问此文件的便捷方法。
	 * 文件本身包含有关如何配置属性，我们在运行时通过改变用户界面和如何设置编辑显示这些属性的元数据。
	 * 
	 * @return
	 */
	public static String getRuntimeConfigDefsAsString() {

		log.debug("Trying to load runtime config defs file");

		try {
			InputStreamReader reader = new InputStreamReader(ManagerRuntimeConfig.class
					.getResourceAsStream(runtime_config));
			StringWriter configString = new StringWriter();

			char[] buf = new char[8196];
			int length = 0;
			while ((length = reader.read(buf)) > 0)
				configString.write(buf, 0, length);

			reader.close();

			return configString.toString();
		} catch (Exception e) {
			log.error("Error loading runtime config defs file", e);
		}

		return "";
	}

	public static void setAbsoluteContextURL(String url) {
		absoluteContextURL = url;
	}

	public static void setRelativeContextURL(String url) {
		relativeContextURL = url;
	}

	// prevent instantiations
	private ManagerRuntimeConfig() {
	}

}