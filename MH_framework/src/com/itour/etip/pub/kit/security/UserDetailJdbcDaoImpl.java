package com.itour.etip.pub.kit.security;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

public class UserDetailJdbcDaoImpl implements UserDetailsService {

	/**
	 * 根据用户编码查找对应的角色
	 */

	public UserDetailJdbcDaoImpl() {
	}

	/**
	 * 返回授权用户定义对象。
	 */
	//txc 修改乱码问题，将cas传回来的乱码重新编码
	public UserDetails loadUserByUsername(String username) {
		String myUserName = null;
		String brandCode = null;
		try {
			myUserName = new String(username.getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String password = "";
		try{
			String sql = " select password from ctn_sysuser where loginmail=? or loginmoble=? ";
			JdbcDao dao = (JdbcDao)SpringContextHelper.getBean("jdbc");
			List resultSet = dao.queryForList(sql, new Object[]{myUserName,myUserName});
			if(resultSet!=null && resultSet.size()!=0){
				ETIPResultSet passowrd = (ETIPResultSet)resultSet.get(0);
				password = (String) passowrd.get("PASSWORD");
			}
		}catch( Exception e){
			e.printStackTrace();
		}
		GrantedAuthority[] grantedRoles = new GrantedAuthority[] {};
		return new FrmUser(myUserName, password, true, true, true, true, grantedRoles, brandCode);
	}
}
