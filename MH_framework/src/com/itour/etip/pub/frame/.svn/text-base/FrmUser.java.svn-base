package com.itour.etip.pub.frame;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;

import com.itour.etip.pub.kit.exception.ETIPError;
import com.itour.etip.pub.kit.security.UrlObjectDefinitionSource;

/**
 * 继承了acegi的用户，其目的是支持acegi登录。
 * 
 * @author lishan
 */
public class FrmUser extends User {
	private static final long serialVersionUID = -8239970624243626633L;

	/** *********************所有会员的公共信息************************************** */
	/**
	 * 账号表记录ID
	 */
	public String etipUserID;

	/**
	 * 会员类型，区分组织和个体
	 */
	public Integer userType;

	/**
	 * 中文名字
	 */
	public String chinseName;

	/**
	 * 用户登录日期
	 */
	public Date loginDate = new Date();

	/**
	 * 当前登录用户角色。
	 */
	public String roles = "";

	public String functions = "";

	public String brandCode = "";

	/** *********************个体会员信息******************************************** */
	/**
	 * 用户手机
	 */
	public String etipUserMobile;

	/**
	 * 用户邮箱
	 */
	public String etipUserEmail;

	/**
	 * 用户登陆名称
	 */
	public String etipUserLoginName;

	/**
	 * 当前登陆名称
	 */
	public String etipNowLoginName;

	/**
	 * 用户卡号
	 */
	public String etipUserCardNO;

	/**
	 * 会员基础信息表ID;
	 */
	public String userBaseID;

	/**
	 * 用户作为个体消费者的ID号。
	 */
	public String userCustomerID;

	/**
	 * 个体业务角色ID
	 */
	public String userBizRoleID;

	/** **********************************组织成员登录*************************************** */
	/**
	 * 后台用户登陆时的账号
	 */
	public String etipOperatorId;

	/**
	 * 后台用户所属机构账号的账号
	 */
	public String etipOperatorOrgId;

	/**
	 * 后台用户所属机构的GroupBaseID
	 */
	public String etipOperatorGroupBaseId;

	/**
	 * 员工工号
	 */
	public String workID;
	
	/**
	 * 组织用户的id
	 */
	public String groupUserID;

	/** *************************组织会员登录信息************************************* */

	/**
	 * 组织会员基础信息ID
	 */
	public String groupBaseID;

	/**
	 * 当前组织会员的当前业务角色ID
	 */
	public String groupBizRoleID;

	/**
	 * 当前组织会员的当前角色类型
	 */
	public Integer roleType;
	
	public String password;

	/**
	 * 临时组织业务角色ID这个ID随着组织会员选择不同的角色 相应的变化
	 */
	// public String tempGroupBizRoleID;
	/**
	 * 临时组织角色类型，根据角色类型判断是否显示菜单
	 */
	// public String tempRoleType;
	/**
	 * 空参数构造函数
	 */
	public FrmUser() {
		super("anonymous", "", true, true, true, true,
				new GrantedAuthority[] {});
		// 此处需要获取默认机构。
		// etipOperatorGroupBaseId = "402881e42265bc33012265c12d7e0002";
	}

	/**
	 * 在acegi登录成功，调用此方法。
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public FrmUser(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, GrantedAuthority[] authorities,
			String brandCode){
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.etipNowLoginName = username;
		//查询用户
		String sql = "select id,password from ctn_sysuser where loginmail=? or loginmoble = ?";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, new Object[]{username,username});
		if (rs.size() == 0 || rs.size() > 1) {
			throw new ETIPError("WrongEtipUser", "userName:" + username);
		}
		String etipUserId = rs.get(0).getString("ID");
		this.etipUserID = etipUserId;
		this.etipOperatorId = etipUserId;
		this.password = rs.get(0).getString("PASSWORD");
		initUser(etipUserId,username);
	}

	/**
	 * 初始化个体会员
	 */
	private void initUser(String etipUserId,String username) {
		String sql = "select username,loginmoble,loginmail,usertype from ctn_sysuser where id=?";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, new Object[]{etipUserId});
		if (rs.size() == 0 || rs.size() > 1) {
			throw new ETIPError("WrongGroupUser", "userName:" + username);
		}
		this.chinseName = rs.get(0).getString("LOGINMAIL");
		this.etipUserMobile = rs.get(0).getString("LOGINMOBLE");
		this.etipUserEmail = rs.get(0).getString("LOGINMAIL");
		this.roleType = rs.get(0).getInt("USERTYPE");
		this.etipUserLoginName = username;
		this.userBaseID = etipUserId;

		sql = "select r.rolename from tb_sys_role r ,tb_sys_userrole ur where r.id = ur.role_id and ur.user_id=?";
		rs = dao.queryForList(sql, new Object[]{etipUserId});

		if (rs.size() != 0) {
			initRoles(rs);
		}
	}


	/**
	 * 
	 * 设置当前用户授权
	 */
	private void initRoles(List<ETIPResultSet> rs) {
		roles = "";
		GrantedAuthority[] grantedRoles = new GrantedAuthority[rs.size()];
		for (int i = 0; i < rs.size(); i++) {
			String roleName = rs.get(i).getString("ROLENAME");
			grantedRoles[i] = new GrantedAuthorityImpl(roleName);
			roles += "," + roleName;
		}
		this.setAuthorities(grantedRoles);
		if (roles.length() > 0) {
			roles = roles.substring(1);
		}
	}

	/**
	 * 获取登录用户，如果未登录，则抛出例外
	 * @return
	 */
	public static FrmUser getUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		// 将当前用户权限保存到FrmUser中。
		if (authentication != null) {
			Object object = authentication.getPrincipal();
			if(object instanceof String){
				throw new ETIPError("UnLoginedUser");
			}
			FrmUser frmUser = (FrmUser) authentication.getPrincipal();
			GrantedAuthority[] auths = authentication.getAuthorities();
			String roleStr = "";
			for (GrantedAuthority auth : auths) {
				roleStr = roleStr + "," + auth.getAuthority().toString();
			}
			if (roleStr.length() > 0) {
				frmUser.roles = roleStr.substring(1);
			}
			return frmUser;
		} 
		//System.out.println("no logined User");
		throw new ETIPError("UnLoginedUser");
		
	}

	/**
	 * 根据会员id获得用户信息
	 * 
	 * @param memberID
	 * @return
	 */
	public static FrmUser getUser(String memberID) {

		String sql = "select ETIPUSERID,CHINESENAME,MOBILE,EMAIL,ID,BRANDCODE from UserBase where ID=upper('"
				+ memberID + "') or ID=LOWER('"+memberID+"')";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if (rs.size() != 0) {
			FrmUser frmUser = new FrmUser();
			frmUser.userBaseID = rs.get(0).getString("ID");
			frmUser.etipUserID = rs.get(0).getString("ETIPUSERID");
			frmUser.chinseName = rs.get(0).getString("CHINESENAME");
			frmUser.etipUserEmail = rs.get(0).getString("EMAIL");
			frmUser.etipUserMobile = rs.get(0).getString("MOBILE");
			frmUser.userType = 1;
			frmUser.brandCode = rs.get(0).getString("BRANDCODE");
			frmUser = initUser(frmUser);
			return frmUser;
		} else {
			sql = "select USERID,CHINESENAME,PHONE,EMAIL,ID,BRANDCODE from GroupBase where ID=upper('"
					+ memberID + "') or ID=LOWER('"+memberID+"')";
			rs = dao.queryForList(sql, null);
			if (rs.size() != 0) {
				FrmUser frmUser = new FrmUser();
				frmUser.groupBaseID = rs.get(0).getString("ID");
				frmUser.etipUserID = rs.get(0).getString("USERID");
				frmUser.chinseName = rs.get(0).getString("CHINESENAME");
				frmUser.etipUserEmail = rs.get(0).getString("EMAIL");
				frmUser.etipUserMobile = rs.get(0).getString("PHONE");
				frmUser.brandCode = rs.get(0).getString("BRANDCODE");
				frmUser.userType = 2;
				frmUser = initGroup(frmUser);
				return frmUser;
			}
			return null;
		}
	}

	private static FrmUser initUser(FrmUser frmUser) {
		String sql = "select ID from UserBizRole where USERBASEID='"
				+ frmUser.userBaseID + "'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if (rs.size() != 0) {
			frmUser.userBizRoleID = rs.get(0).getString("ID");
		} else {
			return null;
		}
		sql = "select ID from UserCustomer where ROLEID='"
				+ frmUser.userBizRoleID + "'";
		rs = dao.queryForList(sql, null);
		if (rs.size() == 0) {
			return null;
		}
		frmUser.userCustomerID = rs.get(0).getString("ID");
		sql = "select account,accounttype from EtipAccount where etipuserid='"
				+ frmUser.etipUserID + "'";
		rs = dao.queryForList(sql, null);
		if (rs.size() == 0) {
			return null;
		}
		for (ETIPResultSet item : rs) {
			switch (item.getInt("ACCOUNTTYPE")) {
			case 1:
				frmUser.etipUserCardNO = item.getString("ACCOUNT");
				break;
			case 2:
				frmUser.etipUserLoginName = item.getString("ACCOUNT");
			}
		}
		sql = "select hostcardno from userrolecard where bizroleid='"
			+ frmUser.userBizRoleID + "' and cardsign=1 and status=1";
		rs = dao.queryForList(sql, null);
		if (rs.size() != 0) {
			frmUser.etipUserCardNO = rs.get(0).getString("HOSTCARDNO");
		}
		return frmUser;
	}

	private static FrmUser initGroup(FrmUser frmUser) {
		String sql = "select ID from GroupBizRole where GROUPBASEID='"
				+ frmUser.groupBaseID + "'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if (rs.size() != 0) {
			frmUser.groupBizRoleID = rs.get(0).getString("ID");
		} else {
			return null;
		}
		sql = "select account,accounttype from EtipAccount where etipuserid='"
				+ frmUser.etipUserID + "'";
		rs = dao.queryForList(sql, null);
		if (rs.size() == 0) {
			return null;
		}
		for (ETIPResultSet item : rs) {
			if (item.getInt("ACCOUNTTYPE") == 2) {
				frmUser.etipUserLoginName = item.getString("ACCOUNT");
			}
		}
		return frmUser;
	}
	/**
	 * 根据etipOperatorId取得etipUserId
	 * 
	 * @param etipOperatorId
	 * @return
	 */
	public static String getEtipUserIdByOperatorID(String etipOperatorId) {
		String sql = "select id from etipuser where usertype=3 and memberid='"
				+ etipOperatorId + "'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if (rs.size() > 0) {
			return rs.get(0).getString("ID");
		}
		return "";
	}

	/**
	 * 根据etipUserId和userType取得userBaseId或groupBaseID
	 * 
	 * @param etipUserId
	 * @param userType
	 * @return
	 */
	public static String getMemberIDByEtipUserID(String etipUserId,
			String userType) {
		String sql = "select memberid from etipuser where usertype=" + userType
				+ " and id='" + etipUserId + "'";
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> rs = dao.queryForList(sql, null);
		if (rs.size() > 0) {
			return rs.get(0).getString("MEMBERID");
		}
		return "";
	}

	/**
	 * 获取当前会员可消费积分
	 * 
	 * @return
	 */
	public int getMemberConsumableScore() {
		IFrameScoreService business = (IFrameScoreService) SpringContextHelper
				.getBean("frameScoreService");
		String memberID = null;
		if(userType != null){
			if (userType == 1) {
				memberID = userBaseID;
			} else if (userType != null && userType == 2) {
				memberID = groupBaseID;
			}
			return business.getMemberConsumableScore(userType, memberID);
		}else{
			return 0;
		}
	}
	
	/**
	 * 检查当前用户是否具有某个url权限，
	 * @param url 指定检查权限的url
	 * @return true 有权限，false无权限。
	 */
	public boolean checkAccess(String url){
		//首先取得url对应的角色授权，从UrlObjectDefinitionSource中取
		UrlObjectDefinitionSource urlService = (UrlObjectDefinitionSource) SpringContextHelper
				.getBean("UrlObjectDefinitionSource");
		String urlRoles = urlService.getURLRoles(url);
		
		// 如果此url没有被授给角色，那么将被显示出来
		if (urlRoles == null || "".equals(urlRoles)) {
			System.out.println("no control:"+url);
			return true;
		}

		// 以下判断当前用是否具有对应角色授权。
		String userRoles = this.roles;

		// 以下判断userRoles中是否有角色包含到urlRoles中。
		boolean access = false;
		StringTokenizer tokens = new StringTokenizer(userRoles, ",");
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (urlRoles.indexOf(token) >= 0) {
				access = true;
				break;
			}
		}
		//System.out.println("has contorl:"+url+":"+access);
		return access;
	}

	/**
	 * 获取当前会员总积分
	 * 
	 * @return
	 */
	public int getMemberTotalScore() {
		IFrameScoreService business = (IFrameScoreService) SpringContextHelper
				.getBean("frameScoreService");
		String memberID = null;
		if(userType != null){
			if (userType == 1) {
				memberID = userBaseID;
			} else if (userType != null && userType == 2) {
				memberID = groupBaseID;
			}
			return business.getMemberTotalScore(userType, memberID);
		}else{
			return 0;
		}
	}

	
	//////////////////////////////////////////
	//getter and setter 
	//何大勇  2013-9-3
	public String getEtipUserID() {
		return etipUserID;
	}

	public void setEtipUserID(String etipUserID) {
		this.etipUserID = etipUserID;
	}

	public String getChinseName() {
		return chinseName;
	}

	public void setChinseName(String chinseName) {
		this.chinseName = chinseName;
	}

	public String getEtipUserMobile() {
		return etipUserMobile;
	}

	public void setEtipUserMobile(String etipUserMobile) {
		this.etipUserMobile = etipUserMobile;
	}

	public String getEtipUserEmail() {
		return etipUserEmail;
	}

	public void setEtipUserEmail(String etipUserEmail) {
		this.etipUserEmail = etipUserEmail;
	}

	public String getEtipNowLoginName() {
		return etipNowLoginName;
	}

	public void setEtipNowLoginName(String etipNowLoginName) {
		this.etipNowLoginName = etipNowLoginName;
	}
	
	
}
