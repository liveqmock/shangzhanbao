package com.sys.resources.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.sys.resources.data.ResourceData;
import com.sys.resources.data.RoleResData;

/**
 * 权限persistence实现类
 * @author jmj
 * 2013-10-11 上午11:17:04
 */
@SuppressWarnings("unchecked")
@Component("roleResPersistence")
public class RoleResPersistence extends BasePersistence<RoleResData> implements IRoleResPersistence{

	@Override
	public void addRoleRes(RoleResData roleResData) {
		this.add(roleResData);
	}

	@Override
	public List<RoleResData> getRoleResById(String roleid) {
		
		StringBuffer str = new StringBuffer("");
		str.append(" select t.id RoleResId,t.resId,r.resName,r.parentId,r.resType,r.url,r.memo from");
		str.append(" TB_SYS_ROLERES t,TB_SYS_RESOURCES r where t.roleid = ? and t.resid=r.id");
		JdbcDao dao = (JdbcDao)SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> resultSet = dao.queryForList(str.toString(),new String[]{roleid});
		List<RoleResData> list = new ArrayList<RoleResData>();
		RoleResData roleres = null;
		ResourceData resource = null;
		if(resultSet!=null && resultSet.size()!=0){
			for (int i = 0; i < resultSet.size(); i++) {
				ETIPResultSet set = resultSet.get(i);
				roleres = new RoleResData();
				resource = new ResourceData();
				roleres.setId(set.getString("ROLERESID"));
				roleres.setResId(set.getString("RESID"));
				resource.setResName(set.getString("RESNAME"));
				resource.setParentId(set.getString("PARENTID"));
				resource.setResType(set.getString("RESTYPE"));
				resource.setUrl(set.getString("URL"));
				resource.setMemo(set.getString("MEMO"));
				roleres.setResourceData(resource);
				list.add(roleres);
			}
		}
		return list;
	}

	@Override
	public void deleteRoleResByRoleId(String roleid) {
		String sql = " delete from TB_SYS_ROLERES r where r.roleid = '"+roleid+"'";
		this.executeSQL(sql);
	}

	
}
