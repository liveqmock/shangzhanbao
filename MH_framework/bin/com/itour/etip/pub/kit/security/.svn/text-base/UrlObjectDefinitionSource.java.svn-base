package com.itour.etip.pub.kit.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.SecurityConfig;
import org.springframework.security.intercept.web.FilterInvocation;
import org.springframework.security.intercept.web.FilterInvocationDefinitionSource;

public class UrlObjectDefinitionSource implements
		FilterInvocationDefinitionSource, InitializingBean {

	public ServiceJdbcDaoImpl serviceDao = null;

	public RoleServiceJdbcDaoImpl roleDao = null;

	// EhCacheManagerFactoryBean cacheManager = null;
	/**
	 * 判断当前url权限是否需要刷新，当刷新后，设置false.
	 * 在授权管理模块中，如果添加角色，修改角色，删除角色，都需要设置needRefresh=true.
	 */
	public static boolean needRefresh = true;

	public static HashMap<String, ConfigAttributeDefinition> urlConfigRoles = new HashMap<String, ConfigAttributeDefinition>();

	public Collection getConfigAttributeDefinitions() {
		return null;
	}

	public ServiceJdbcDaoImpl getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceJdbcDaoImpl serviceDao) {
		this.serviceDao = serviceDao;
	}

	public RoleServiceJdbcDaoImpl getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleServiceJdbcDaoImpl roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * 获取当前访问uri地址所对应的权限
	 * 
	 */
	public ConfigAttributeDefinition getAttributes(Object filter)
			throws IllegalArgumentException {

		FilterInvocation filterInvocation = (FilterInvocation) filter;
		String requestURI = filterInvocation.getRequestUrl();// requestURI地址
		//System.out.println("request:"+requestURI);
		/*
		 * 如果无需刷新，检查当前url对应的角色是否已初始化设置，如果有则直接返回 如果没有设置，可能当前url对应权限还未初始化，也可能是无授权。
		 */
		if (!needRefresh) {
			ConfigAttributeDefinition rv = urlConfigRoles.get(requestURI);
			if (rv != null){
				return rv;
			}
		}

		/*
		 * 以下检查当前url是否配置到serviceRegistry中，如果未配置，那么肯定没有授权，返回Null
		 */
		if (!serviceDao.isExist(requestURI))
			return null;
		
		String[] strs = requestURI.split("\\?");
		String firstStr = strs[0];

		// url,角色对应关系。
		Map<String, SecurityConfig> urlAuthorities = this.getUrlAuthorities();

		// 此处建立授权对象。
		SecurityConfig grantedAuthorities = null;
		for (Iterator<Map.Entry<String, SecurityConfig>> iter = urlAuthorities
				.entrySet().iterator(); iter.hasNext();) {

			Map.Entry<String, SecurityConfig> entry = iter.next();
			String url = entry.getKey();
			
			
			// 获得url对应角色。
			if (url.equalsIgnoreCase(firstStr)) {
				grantedAuthorities = entry.getValue();
				break;
			}
		}

		/**
		 * grantedAuthorities为逗号隔开的格式，需要转换成数组，否则投票器当作一个角色名称。
		 */
		ConfigAttributeDefinition configRoles = null;
		if (grantedAuthorities != null) {
			// System.out.println("url "+requestURI+"'s authorities
			// are:"+grantedAuthorities.getAttribute());
			String attrs[] = grantedAuthorities.getAttribute().split(",");
			configRoles = new ConfigAttributeDefinition(attrs);
		}
		needRefresh = false;
		urlConfigRoles.put(firstStr, configRoles);
//		System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.err.println(configRoles);
		return configRoles;
	}

	/**
	 * 返回当前应用中url对应的授权角色
	 * 
	 * @return
	 */
	public String getURLRoles(String url) {
		// HashMap<String, SecurityConfig> urlConfig = new HashMap<String,
		// SecurityConfig>();
		// 服务注册表
		List serviceReigstry = this.serviceDao.getServices();

		// 角色服务注册表
		// txc update
		Map<String, SecurityConfig> roleMap = this.roleDao
				.getRoleServices(needRefresh);

		SecurityConfig cfg = null;
		// 针对每个服务注册表
		for (Object serviceObj : serviceReigstry) {
			ServiceRegistry service = (ServiceRegistry) serviceObj;
			// 获取服务代码对应的角色
			if (url.equalsIgnoreCase(service.getServiceAddress())) {
				cfg = getServiceRole(service.getServiceCode(), roleMap);
				break;
			}
		}
		String roles = null;
		if (cfg != null) {
			roles = cfg.getAttribute();
		} else {
			roles = "";
		}
		return roles;

	}

	public boolean supports(Class clazz) {
		return true;
	}

	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * 此处获取url,角色对应关系
	 * 
	 * @param filterInvocation
	 * @return url对应角色。
	 */
	private Map<String, SecurityConfig> getUrlAuthorities() {
		HashMap<String, SecurityConfig> urlConfig = new HashMap<String, SecurityConfig>();
		// 服务注册表
		List serviceReigstry = this.serviceDao.getServices();

		// 角色服务注册表
		Map<String, SecurityConfig> roleMap = this.roleDao
				.getRoleServices(needRefresh);
		// 针对每个服务注册表
		for (Object serviceObj : serviceReigstry) {
			ServiceRegistry service = (ServiceRegistry) serviceObj;
			// System.out.println("code vs address
			// "+service.getServiceCode()+":"+service.getServiceAddress());
			// 获取服务代码对应的角色
			SecurityConfig cfg = getServiceRole(service.getServiceCode(),
					roleMap);

			if (cfg != null) {
				// 建立服务地址和角色对应关系
				// System.out.println("find service code's role
				// of"+service.getServiceCode());
				urlConfig.put(service.getServiceAddress(), cfg);
			}
		}

		return urlConfig;
	}

	/**
	 * 根据服务代码，查找角色。如果没有找到，就找父节点的权限。
	 * 
	 * @param serviceCode
	 * @param roles
	 * @return
	 */
	private SecurityConfig getServiceRole(String serviceCode,
			Map<String, SecurityConfig> roles) {
		SecurityConfig rvCfg = null;
		for (int i = 0; serviceCode.length() > 1; i++) {
			rvCfg = roles.get(serviceCode);
			if (rvCfg != null) {
				break;
			} else {

				serviceCode = serviceCode
						.substring(0, serviceCode.length() - 2);
			}
		}

		return rvCfg;
	}

}
