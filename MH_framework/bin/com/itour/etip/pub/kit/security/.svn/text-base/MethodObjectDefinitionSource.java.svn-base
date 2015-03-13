	package com.itour.etip.pub.kit.security;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.ConfigAttributeDefinition;
import org.springframework.security.SecurityConfig;
import org.springframework.security.intercept.method.AbstractMethodDefinitionSource;

public class MethodObjectDefinitionSource extends
		AbstractMethodDefinitionSource implements InitializingBean {

    /** Map from RegisteredMethod to ConfigAttributeDefinition */
    protected Map<String,SecurityConfig> methodMap = new HashMap<String,SecurityConfig>();
	
	public ServiceJdbcDaoImpl serviceDao = null;

	public RoleServiceJdbcDaoImpl roleDao = null;

	public MethodObjectDefinitionSource() {
	}

	/**
	 * 查询服务注册表，然后根据ServiceCode到角色授权表中查找对应的角色集合
	 */
	public void afterPropertiesSet() throws Exception {
		List svc = this.serviceDao.getServices();
		Map<String,SecurityConfig> roleMap = this.roleDao.getRoleServices(true);
		for (Object obj : svc) {
			ServiceRegistry service = (ServiceRegistry)obj;
			SecurityConfig cfg = getServiceRole(service.getServiceCode(), roleMap);
			if (cfg == null) {
			} else {
				methodMap.put(service.getServiceAddress(), cfg);
			}
		}
	}

	/**
	 * 没认为className ＋ method
	 */
	public ConfigAttributeDefinition getAttributes(Method method,Class targetClass) {
		String resource = targetClass.getName() + "." + method.getName();
		SecurityConfig grantedAuthorities = null;   
        for(Iterator<Map.Entry<String,SecurityConfig>> iter = methodMap.entrySet().iterator(); iter.hasNext();) {   
            Map.Entry<String,SecurityConfig> entry = iter.next();   
            String url = entry.getKey();
            if(url.equalsIgnoreCase(resource)) {   
            	grantedAuthorities = entry.getValue();   
                break;   
            }
        }
        /**
         * grantedAuthorities为逗号隔开的格式，需要转换成数组，否则投票器当作一个角色名称。
         */
        if(grantedAuthorities != null) {  
        	String attrs[] = grantedAuthorities.getAttribute().split(",");
            return new ConfigAttributeDefinition(attrs);   
        }
        return null;
	}

	public Collection getConfigAttributeDefinitions() {
		return Collections.unmodifiableCollection(this.methodMap.values());
	}


	/**
	 * 根据服务代码，查找角色。如果没有找到，就找父节点的权限。
	 * 
	 * @param serviceCode
	 * @param roles
	 * @return
	 */
	private SecurityConfig getServiceRole(String serviceCode,Map<String,SecurityConfig> roles){
		String code = serviceCode;
		for(int i=0;code.length() >1;i++){
			SecurityConfig cfg = roles.get(code);
			if(cfg != null){
				return cfg;
			}else{
				code = code.substring(0,code.length() -2);
			}
		}
		return null;
	}
	
	public boolean supports(Class clazz) {
		return true;
	}

	public RoleServiceJdbcDaoImpl getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleServiceJdbcDaoImpl roleDao) {
		this.roleDao = roleDao;
	}

	public ServiceJdbcDaoImpl getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceJdbcDaoImpl serviceDao) {
		this.serviceDao = serviceDao;
	}

	
	protected ConfigAttributeDefinition lookupAttributes(Method method) {
		String authorities = null;
		//
		String mString = method.getDeclaringClass().getName();
		/**
		 * 因为在facade中调用Service使用的是接口而不是Class，所以这里
		 * 得到的是接口的名字，配置的时候需要配置接口的名字，而不是Class。
		int ind = mString.lastIndexOf(".") + 1;
		char c = mString.charAt(ind + 1 );
		if(mString.charAt(ind) == 'I' && (c > 'A' && c < 'Z')){
			mString = mString.replace(".I", ".");
		}
		*/
		//得到全名类名＋方法名
		String clazzName = mString;
		mString = mString + "." + method.getName();
		Iterator it = this.methodMap.keySet().iterator();
		while(it.hasNext()){
			String serviceAddress = it.next().toString();
			//类名相同
			if(serviceAddress.startsWith(clazzName)){
				//比较方法名
				String methodName = serviceAddress.substring(serviceAddress.lastIndexOf(".") + 1,serviceAddress.length());
				for(int i=0;i<methodName.length();i++){
					char nc = methodName.charAt(i);
					if((nc>'a' & nc < 'z') || (nc>'A' & nc < 'Z') || nc == '_'){
						continue;
					}else{
						if(i>0){
							methodName = methodName.substring(0,i);
						}else{
							methodName = "*";
						}
					}
				}
				//所有方法
				if(methodName.equalsIgnoreCase("*")){
					authorities = this.methodMap.get(serviceAddress).toString();
					break;
				}else if(method.getName().startsWith(methodName)) {
					authorities = this.methodMap.get(serviceAddress).toString();
					break;
				}
			}
		}
		if(authorities != null){
			authorities = authorities.substring(authorities.indexOf("=")+1,authorities.length());
			ConfigAttributeDefinition ca = new ConfigAttributeDefinition(authorities);
	        return ca;   
		}else{
			return null;
		}
	}

	public Map getMethodMap() {
		return methodMap;
	}

	public void setMethodMap(Map<String,SecurityConfig> methodMap) {
		this.methodMap = methodMap;
	}


}
