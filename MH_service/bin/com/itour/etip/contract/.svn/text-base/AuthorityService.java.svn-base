package com.itour.etip.contract;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmService;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.support.data.ServiceRegistryData;

/**
 * 权限服务
 * @author Administrator
 *
 */
@WebService(endpointInterface = "com.itour.etip.contract.IAuthorityService")
public class AuthorityService extends FrmService implements IAuthorityService{
	
	/**
	 * 根据EtipUserId获得该用户能访问的所有服务地址
	 * 
	 * @param account
	 *            String 会员账号
	 * @return UserBaseID String
	 */
	public String getServiceRegistry(@WebParam(name = "etipUserId")
	String etipUserId, @WebParam(name = "serviceName")String serviceName){
		if(etipUserId == null || etipUserId.equals("") || serviceName == null || serviceName.equals("")){
			return null;
		}
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String sql = "select serviceCode from serviceregistry where serviceName='" + serviceName + "'";
		List<ETIPResultSet> rs = jdbc.queryForList(sql, null);
		if(rs.size() == 0){
			return "<services></services>";
		}
		String serviceCode = rs.get(0).getString("SERVICECODE");
		sql = "select usertype,memberid from etipuser where id ='" + etipUserId + "'";
		rs = jdbc.queryForList(sql, null);
		String memberId = rs.get(0).getString("MEMBERID");
		int userType = rs.get(0).getInt("USERTYPE");
		switch (userType) {
		case 1:
			return getServiceRegistryByUserBase(serviceCode, memberId);
		case 2:
			return getServiceRegistryByGroupBase(serviceCode, memberId);
		case 3:
			return getServiceRegistryByGroupUser(serviceCode, memberId);
		}
		
		return "<services></services>";
	}
	
	/**
	 * 根据EtipOperatorId找到组织成员的服务列表
	 * @param serviceCode
	 * @param etipOperatorId
	 * @return
	 */
	private String getServiceRegistryByGroupUser(String serviceCode, String etipOperatorId){
		String sql = "select * from serviceregistry where serviceCode like '" + serviceCode + "%' and servicecode in (select servicecode from roleauthority where roleid in (select id from roleregistry where roleclass in(1,4) and id in (select roleid from etipuserrole where etipoperatorid='"
			+ etipOperatorId + "')))";
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList(sql, null);
		if(rs.size() == 0){
			return "<services></services>";
		}
		List<ServiceRegistryData> services = new ArrayList<ServiceRegistryData>();
		getServiceRegistry(rs, services);
		
		
		return DataToString(services);
	}
	
	/**
	 * 根据UserBaseId找到个体会员的服务列表
	 * @param serviceCode
	 * @param memberId
	 * @return
	 */
	private String getServiceRegistryByUserBase(String serviceCode, String memberId){
		String sql = "select rank from userbizrole where userbaseid='" + memberId + "'";
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList(sql, null);
		if(rs.size() == 0){
			return null;
		}
		int rank = rs.get(0).getInt("RANK"); 
		
		sql = "select * from serviceregistry where serviceCode like '" + serviceCode + "%' and servicecode in (select servicecode from roleauthority where roleid in (select id from roleregistry where roleclass=3 and id in (select roleid from memberrole where memberroleid in (select id from memberroleauthority where membertype='3' and memberroletype='1' and rank='"
			+ rank + "'))))";
		rs = jdbc.queryForList(sql, null);
		if(rs.size() == 0){
			return null;
		}
		List<ServiceRegistryData> services = new ArrayList<ServiceRegistryData>();
		getServiceRegistry(rs, services);

		return DataToString(services);
	}
	
	/**
	 * 根据GroupBaseId找到组织会员的服务列表
	 * @param serviceCode
	 * @param memberId
	 * @return
	 */
	private String getServiceRegistryByGroupBase(String serviceCode, String memberId){
		String sql = "select rank,roletype from groupbizrole where groupbaseid='" + memberId + "'";
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = jdbc.queryForList(sql, null);
		if(rs.size() == 0){
			return null;
		}
		List<ServiceRegistryData> services = new ArrayList<ServiceRegistryData>();
		for(ETIPResultSet item : rs){
			int rank = item.getInt("RANK"); 
			int roleType_temp = item.getInt("ROLETYPE");
			
			sql = "select * from serviceregistry where serviceCode like '" + serviceCode + "%' and servicecode in (select servicecode from roleauthority where roleid in (select id from roleregistry where roleclass=4 and id in (select roleid from memberrole where memberroleid in (select id from memberroleauthority where membertype='4' and memberroletype='"
						+ roleType_temp + "' and rank='" + rank + "'))))";
			List<ETIPResultSet> rs1 = jdbc.queryForList(sql, null);
			if(rs1.size() == 0){
				continue;
			}
			
			getServiceRegistry(rs1, services);
		}

		return DataToString(services);
	}
	
	/**
	 * 根据查询到的所有服务EtipResultSet转换为ServiceRegistryData列表,并且把所有模块的URL查询出来
	 * @param resultSets
	 * @param services
	 * @return
	 */
	private void getServiceRegistry(List<ETIPResultSet> resultSets, List<ServiceRegistryData> services){
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		boolean is = false;//标示是否已经有了当前服务
		for(ETIPResultSet item : resultSets){
			//这里能查处模块和URL,如果是模块,那么需要把当前模块下的所有URL查询出来
			if(item.getString("SERVICETYPE").equals("模块")){
				String sql = "select * from serviceregistry where servicetype='URL' and serviceCode like '" + item.getString("SERVICECODE") + "%'";
				List<ETIPResultSet> rs1 = jdbc.queryForList(sql, null);
				boolean is1 = false;//标示是否已经有了当前服务
				for(ETIPResultSet item1 : rs1){
					is1 = false;//每次循环的必须初始化一次,为了防止如果有一次重复,以后都不会再往services里添加
					for(ServiceRegistryData service : services){
						//判断是否已经有相同的id,如果有,说明已经重复,那么需要把is1设置为true,并且推出当前循环
						if(service.getId().equals(item1.getString("ID"))){
							is1 = true;
							break;
						}
					}
					//如果is1是true说明已经重复了,那么不再添加到services中
					if(is1){
						continue;
					}
					ServiceRegistryData serviceRegistry = new ServiceRegistryData();
					serviceRegistry.setId(item1.getString("ID"));
					serviceRegistry.setMemo(item1.getString("MEMO"));
					serviceRegistry.setParentID(item1.getString("PARENTID"));
					serviceRegistry.setServiceAddress(item1.getString("SERVICEADDRESS"));
					serviceRegistry.setServiceCode(item1.getString("SERVICECODE"));
					serviceRegistry.setServiceName(item1.getString("SERVICENAME"));
					serviceRegistry.setServiceType(item1.getString("SERVICETYPE"));
					services.add(serviceRegistry);
				}
			}else{
				
				is = false;//每次循环的必须初始化一次,为了防止如果有一次重复,以后都不会再往services里添加
				for(ServiceRegistryData service : services){
					//判断是否已经有相同的id,如果有,说明已经重复,那么需要把is1设置为true,并且推出当前循环
					if(service.getId().equals(item.getString("ID"))){
						is = true;
						break;
					}
				}
				//如果is1是true说明已经重复了,那么不再添加到services中
				if(is){
					continue;
				}
				ServiceRegistryData serviceRegistry = new ServiceRegistryData();
				serviceRegistry.setId(item.getString("ID"));
				serviceRegistry.setMemo(item.getString("MEMO"));
				serviceRegistry.setParentID(item.getString("PARENTID"));
				serviceRegistry.setServiceAddress(item.getString("SERVICEADDRESS"));
				serviceRegistry.setServiceCode(item.getString("SERVICECODE"));
				serviceRegistry.setServiceName(item.getString("SERVICENAME"));
				serviceRegistry.setServiceType(item.getString("SERVICETYPE"));
				services.add(serviceRegistry);
			}
		}
	}
	
	private String DataToString(List<ServiceRegistryData> services){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<services>");
		for(ServiceRegistryData item : services){
			sb.append("<service>");
			sb.append("<serviceId>");
			sb.append(item.getId());
			sb.append("</serviceId>");
			sb.append("<serviceCode>");
			sb.append(item.getServiceCode());
			sb.append("</serviceCode>");
			sb.append("<serviceType>");
			sb.append(item.getServiceType());
			sb.append("</serviceType>");
			sb.append("<serviceName>");
			sb.append(item.getServiceName());
			sb.append("</serviceName>");
			sb.append("<serviceAddress>");
			sb.append(item.getServiceAddress());
			sb.append("</serviceAddress>");
			sb.append("</service>");
		}
		sb.append("</services>");
		return sb.toString();
	}
}
