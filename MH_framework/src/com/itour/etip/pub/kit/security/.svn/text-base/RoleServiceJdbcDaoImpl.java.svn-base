package com.itour.etip.pub.kit.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.security.SecurityConfig;

public class RoleServiceJdbcDaoImpl extends JdbcDaoSupport {

	static HashMap<String, SecurityConfig> roleServiceMap = null;

	private String roleServiceQuery = null;

	private MappingSqlQuery roleServiceMapping = null;

	public RoleServiceJdbcDaoImpl() {
		// this.roleServiceQuery = "select RoleCode,serviceCode from
		// RoleAuthority";
	}

	
	protected void initDao() throws Exception {
		super.initDao();
		this.roleServiceMapping = new RoleServiceMapping(getDataSource());
	}

	private class RoleServiceMapping extends MappingSqlQuery {
		protected RoleServiceMapping(DataSource ds) {
			super(ds, roleServiceQuery);
			compile();
		}

		protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
			RoleAuthority role = new RoleAuthority();
			role.setRoleCode(rs.getString("roleName"));// 角色名称
			role.setServiceCode(rs.getString("resname"));// 服务代码
			return role;
		}
	}

	/**
	 * 返回角色对应的服务。
	 * 
	 * @return
	 */
	public Map<String, SecurityConfig> getRoleServices(boolean needRefresh) {
		//问题好像出在这里  txc
		if (needRefresh || roleServiceMap == null || roleServiceMap.size() == 0) {
			roleServiceMap = new HashMap<String, SecurityConfig>();
			List list = roleServiceMapping.execute();
			for (Object roleObj : list) {
				RoleAuthority role = (RoleAuthority) roleObj;
				SecurityConfig cfg = roleServiceMap.get(role.getServiceCode());
				// 新角色服务
				if (cfg != null) {
					// 产生新角色
					// System.out.println("role serice 1");
					cfg = new SecurityConfig(cfg.getAttribute() + ","
							+ role.getRoleCode());
				} else {
					// 新服务
					// System.out.println("role service 2");
					cfg = new SecurityConfig(role.getRoleCode());
				}
				//System.out.println("role service:"+role.getServiceCode()+"/"+role.getRoleCode());
				roleServiceMap.put(role.getServiceCode(), cfg);
			}
		}
		return roleServiceMap;
	}

	public String getRoleServiceQuery() {
		return roleServiceQuery;
	}

	public void setRoleServiceQuery(String roleServiceQuery) {
		this.roleServiceQuery = roleServiceQuery;
	}

}
