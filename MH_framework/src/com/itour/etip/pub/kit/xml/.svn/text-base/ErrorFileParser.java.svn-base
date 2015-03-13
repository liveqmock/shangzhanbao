package com.itour.etip.pub.kit.xml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Pattern;

public class ErrorFileParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 去掉重复或空账号
		// removeBlankAndDuplicateData();

		// 检查没有密码的账号,慢，很慢
		// checkNotPasswordData();

		// 解决etipuser中账号对应错的问题
		// updateEtipUser();

		// 去掉重复的etipUser
		// checkDuplicateEtipUser();

		// 为组织成员添加密码
		// addPasswordToGroupUser();

		// 清除垃圾数据
		// clearEtipOperators();

		/*
		 * 清除组织会员
		 */
		// clearGroupMember();
		// removeNotExistGroupUser();
		// importUserMember();
		// importCard();
		// importCardScore();
		// updateOldCardScore();
		// removeDuplicateData();
		// formatContactway();
		//reverse2();
		//reverseBrandcode();
		reverseBrandcodeMobil();
	}

	/**
	 * 返回连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.124.20.13:1521:itour", "etipapp",
					"etipapp");
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	/**
	 * 去掉不存在的组织成员账号
	 * 
	 */
	public static void removeNotExistGroupUser() {
		StringBuffer IDs = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			String userSQL = "select etipuserid from etiptemp";
			rs = stmt.executeQuery(userSQL);
			while (rs.next()) {
				String id = rs.getString("ETIPUSERID");
				IDs.append(id);
				IDs.append(",");
			}
			String ID = IDs.toString();
			StringTokenizer tokens = new StringTokenizer(ID, ",");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();

				String delIDSQL1 = "delete from etipaccount where etipuserid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL1);

				String delIDSQL2 = "delete from etipcertificate where etipuserid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL2);

				String delIDSQL = "delete from etipuser where id ='" + token
						+ "'";
				stmt.executeUpdate(delIDSQL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 清除没有用的组织机构
	 */
	public static void clearGroupMember() {
		// select id from groupbase where chinesename not in
		// ('纵横天地','董事局','CEO及执委会','号百事业部','机构事业部','4008平台','资源产品事业部','市场部','连锁事业部','分销事业部','政企事业部')

		StringBuffer IDs = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			String userSQL = "select id from groupbase where chinesename in ('测试合作伙伴08','测试合作伙伴02','测试合作伙伴09', 'hezuo01'," +
					"'hezuo03','hezuo02','测试合作伙伴03','上海测试02','刘春','中青','联通','李东','到底到底','纵横云南','佛山','禅城','惠希峰1'," +
					"'王中俊','闫盟','测试账号1','祖母的厨房','四川分公司','绅士咖啡','168','绿岛西餐酒廊','test','通汇','的士','物业公司A'," +
					"'派卡合作g公司','ds','出租车公司g','辉记','广州','盛荣','大荣','外滩新城','星美影院','溏心','香。圣伽瑜伽','诗丽堂1'," +
					"'自由空间','K歌迷','jkzt','AMD','CCTV','诗丽堂','百货大楼','中影院','ADDM','K哥王','中山街','江南影院','全套服务桑拿'," +
					"'全套按摩','金阳光','解百商场','玖玖鸭','杜莹','熊丹','金焕娜','商旅通','新鹭洲','张甲','电信派卡','贵州测试','高琴'," +
					"'田亮','西安')";
			rs = stmt.executeQuery(userSQL);
			while (rs.next()) {
				String id = rs.getString("ID");
				IDs.append(id);
				IDs.append(",");
			}
			String ID = IDs.toString();
			StringTokenizer tokens = new StringTokenizer(ID, ",");
			// 以下删除
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				System.out.println("groupbaseid:" + token);
				String delIDSQL1 = "delete from groupuser where ownergroupid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL1);
				String delIDSQL11 = "delete from subgroup where parentgroupid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL11);
				String delIDSQL2 = "delete from etipcertificate where etipuserid = (select id from etipuser where usertype=3 and memberid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL2);
				String delIDSQL3 = "delete from etipaccount where etipuserid = (select id from etipuser where usertype=3 and memberid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL3);
				String delIDSQL4 = "delete from etipuser  where usertype=3 and memberid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL4);
				String delIDSQL5 = "delete from groupcontactway  where groupid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL5);

				String delIDSQL51 = "delete from grouprolecard  where bizroleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL51);

				String delIDSQL52 = "delete from hotelsupplier  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL52);

				String delIDSQL521 = "delete from cardpartner  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL521);

				String delIDSQL522 = "delete from cruisesupplier  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL522);

				String delIDSQL523 = "delete from cruisesupplier  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL523);

				String delIDSQL53 = "delete from teamcustomer  where groupbizroleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL53);

				String delIDSQL54 = "delete from merchant  where groupbizroleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL54);

				String delIDSQL55 = "delete from AlliancePartner  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL55);

				String delIDSQL56 = "delete from deliveryPartner  where roleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL56);

				String delIDSQL57 = "delete from orgcustomer  where groupbizroleid in  (select id from groupbizrole where groupbaseid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL57);

				String delIDSQL6 = "delete from groupbizrole  where groupbaseid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL6);
				String delIDSQL7 = "delete from groupbase  where id ='" + token
						+ "'";
				stmt.executeUpdate(delIDSQL7);
			}
			System.out.println("1:清除没有用的组织机构执行完毕");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 清除4008平台外的所有用户，要将admin的机构设置为4008平台
	 */
	public static void clearEtipOperators() {
		StringBuffer IDs = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			String userSQL = "select id from etipoperator where id not in (select etipoperator_id from groupuser where ownergroupid='8a00a29222de5f6f0122df75d28f0040')";
			rs = stmt.executeQuery(userSQL);
			while (rs.next()) {
				String id = rs.getString("ID");
				IDs.append(id);
				IDs.append(",");
			}
			String ID = IDs.toString();
			StringTokenizer tokens = new StringTokenizer(ID, ",");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				String delIDSQL = "delete from etipoperator where id ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL);
				String delIDSQL1 = "delete from groupuser where etipoperator_id ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL1);
				String delIDSQL2 = "delete from etipcertificate where etipuserid = (select id from etipuser where usertype=3 and memberid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL2);
				String delIDSQL3 = "delete from etipaccount where etipuserid = (select id from etipuser where usertype=3 and memberid ='"
						+ token + "')";
				stmt.executeUpdate(delIDSQL3);
				String delIDSQL4 = "delete from etipuser  where usertype=3 and memberid ='"
						+ token + "'";
				stmt.executeUpdate(delIDSQL4);
			}
			System.out.println("2:清除4008平台外的所有用户，要将admin的机构设置为4008平台");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 检查组织成员，是否存在密码，如果没有密码，那么添加密码。
	 */
	public static void addPasswordToGroupUser() {
		String sql = "select c.etipuserid,b.password from etipuser a,etipoperator b ,etipaccount c where a.usertype=3 and a.memberid=b.id and b.loginname=c.account and c.accounttype=2";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Date createDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Statement stmt1 = conn.createStatement();
			while (rs.next()) {
				String etipUserID = rs.getString("ETIPUSERID");
				String password = rs.getString("PASSWORD").trim();
				UUID uuid = UUID.randomUUID();// 设置用户数据
				String uuidStr = uuid.toString().replace("-", "");
				String updateSQL = "insert into etipcertificate (id,createDate,etipuserid,certtype,certvalue) values('"
						+ uuidStr
						+ "',to_date('"
						+ formatter.format(createDate)
						+ "','yyyy-mm-dd'),'"
						+ etipUserID + "',1,'" + password + "')";
				// System.out.println("updateSQL:"+updateSQL);
				stmt1.executeUpdate(updateSQL);
			}
			System.out.println("3:检查组织成员，是否存在密码，如果没有密码，那么添加密码。清除完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// public static void

	/**
	 * 修正etipuser错误数据，主要指的是组织用户导入的错误
	 */
	public static void updateEtipUser() {
		String sql = "select a.etipuserid,b.id  from etipaccount a,etipoperator b where a.accounttype=2 and a.account=b.loginname";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Statement stmt1 = conn.createStatement();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			while (rs.next()) {
				String memberID = rs.getString("ID");
				String id = rs.getString("ETIPUSERID");

				String sql1 = "update etipuser set memberid='" + memberID
						+ "' where id='" + id + "' and usertype=3";
				// System.out.println(sql1);
				stmt1.executeUpdate(sql1);
			}
			System.out.println("4:修正etipuser错误数据，主要指的是组织用户导入的错误。清除完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 去掉重复的etipuser,即一个memberid对应多个etipuser
	 * 
	 */
	public static void checkDuplicateEtipUser() {
		/**
		 * 以下清理会员账号中重复的账号，如果账号相
		 */
		StringBuffer sameIDs = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String userSQL = "select id,memberid from etipuser order by memberid";
			rs = stmt.executeQuery(userSQL);
			String oldAccount = null;
			while (rs.next()) {
				String newAccount = rs.getString("MEMBERID");
				if (newAccount != null && newAccount.equals(oldAccount)) {
					System.out.println("duplicate id:" + newAccount);
					// System.out.println("find the same account:"+newAccount);
					String id = rs.getString("ID");
					sameIDs.append("'");
					sameIDs.append(id);
					sameIDs.append("'");
					sameIDs.append(",");
				}
				oldAccount = newAccount;
			}
			String sameID = sameIDs.toString();
			StringTokenizer tokens = new StringTokenizer(sameID, ",");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				String delSameIDSQL = "delete from etipuser where id =" + token;
				System.out.println("delete ID:" + delSameIDSQL);
				// stmt.executeUpdate(delSameIDSQL);
			}
			System.out.println("5:以下清理会员账号中重复的账号，如果账号相。清除完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 检查没有密码的账号。
	 */
	public static void checkNotPasswordData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		StringBuffer IDs = new StringBuffer();
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select id from etipuser where id not in (select etipuserid from etipcertificate) and rownum<100";
			rs = stmt.executeQuery(sql);
			Date createDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			// 以下设置密码值
			Statement stmt1 = conn.createStatement();
			while (rs.next()) {
				String id = rs.getString("ID");
				UUID uuid = UUID.randomUUID();// 设置用户数据
				String uuidStr = uuid.toString().replace("-", "");
				String updateSQL = "insert into etipcertificate (id,createDate,etipuserid,certtype,certvalue) values('"
						+ uuidStr
						+ "',to_date('"
						+ formatter.format(createDate)
						+ "','yyyy-mm-dd'),'"
						+ id + "',1,'1234')";
				// System.out.println("updateSQL:"+updateSQL);
				stmt1.executeUpdate(updateSQL);
			}
			System.out.println("6:执行完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 解析用户账号，去掉重复数据和空数据
	 * 
	 */
	public static void removeBlankAndDuplicateData() {
		/**
		 * 以下清理会员账号中重复的账号，如果账号相
		 */
		StringBuffer sameIDs = new StringBuffer();
		StringBuffer blankIDs = new StringBuffer();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String userSQL = "select * from etipaccount order by account";
			rs = stmt.executeQuery(userSQL);
			String oldAccount = null;
			while (rs.next()) {
				String newAccount = rs.getString("ACCOUNT");
				// System.out.println("newAccount:"+newAccount);
				if (newAccount == null || newAccount.trim().length() == 0) {
					String id = rs.getString("ID");
					blankIDs.append("'");
					blankIDs.append(id);
					blankIDs.append("'");
					blankIDs.append(",");
					continue;
				}
				if (newAccount.equals(oldAccount)) {
					// System.out.println("find the same account:"+newAccount);
					String id = rs.getString("ID");
					sameIDs.append("'");
					sameIDs.append(id);
					sameIDs.append("'");
					sameIDs.append(",");
				}
				oldAccount = newAccount;
			}
			String sameID = sameIDs.toString();
			StringTokenizer tokens = new StringTokenizer(sameID, ",");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				String delSameIDSQL = "delete from etipaccount where id ="
						+ token;
				// System.out.println("delete ID:"+delSameIDSQL);
				stmt.executeUpdate(delSameIDSQL);
			}
			String blankID = blankIDs.toString();
			tokens = new StringTokenizer(blankID, ",");
			while (tokens.hasMoreTokens()) {
				String token = tokens.nextToken();
				String delSameIDSQL = "delete from etipaccount where id ="
						+ token;
				stmt.executeUpdate(delSameIDSQL);
				// System.out.println("delete ID:"+token);
			}
			System.out.println("7:解析用户账号，去掉重复数据和空数据");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 从临时表导入数据
	 */
	public static void importUserMember() {
		List<String> log = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeQuery("select count(*) from log");
			rs = stmt.executeQuery("select id from etipuser_temp");
			while (rs.next()) {
				Statement account = conn.createStatement();
				ResultSet accountRs = null;
				String loginName = "";
				String mobile = "";
				String email = "";
				try {
					accountRs = account
							.executeQuery("select * from etipaccount_temp where etipuserid='"
									+ rs.getString("ID") + "'");
					while (accountRs.next()) {
						switch (accountRs.getInt("ACCOUNTTYPE")) {
						case 2:
							loginName = accountRs.getString("ACCOUNT");
							break;
						case 3:
							mobile = accountRs.getString("ACCOUNT");
							break;
						case 4:
							email = accountRs.getString("ACCOUNT");
							break;
						}
					}
				} catch (Exception e3) {

					System.err
							.println("select * from etipaccount_temp where etipuserid='"
									+ rs.getString("ID") + "'");
					e3.printStackTrace();
					try {
						if (accountRs != null)
							accountRs.close();
						accountRs = null;
						if (account != null)
							account.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} finally {
					try {
						if (accountRs != null)
							accountRs.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				StringBuffer sb = new StringBuffer();
				sb.append("select * from etipaccount where 1=1 and");
				if (loginName != null && !loginName.equals("")) {
					sb.append(" account='" + loginName + "' or");
				}
				if (mobile != null && !mobile.equals("")) {
					sb.append(" account='" + mobile + "' or");
				}
				if (email != null && !email.equals("")) {
					sb.append(" account='" + email + "' or");
				}
				sb.append(" 1=2");
				if ((loginName == null || loginName.equals(""))
						&& (mobile == null || mobile.equals(""))
						&& (email == null || email.equals(""))) {
					log.add("insert into log (etipuserid,type) values ('"
							+ rs.getString("ID") + "',1)");
					try {
						if (account != null)
							account.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					continue;
				}
				/*
				 * 不能排除同时没有用户名，手机，邮箱的会员
				 */
				boolean isOk = true;
				ResultSet temp = null;
				try {
					temp = account.executeQuery(sb.toString());
					/* 如果有下一个，说明有重复的账号，那么推出该次循环，进入下次循环 */

					isOk = temp.next();
				} catch (Exception e2) {

					System.err.println(sb.toString());
					e2.printStackTrace();
				} finally {
					try {
						if (temp != null)
							temp.close();
						if (account != null)
							account.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

				if (isOk) {
					log
							.add("insert into log(etipuserid,loginname,mobile,email,type) values ('"
									+ rs.getString("ID")
									+ "','"
									+ loginName
									+ "','" + mobile + "','" + email + "',2)");
					continue;
				}
				String etipUserId = rs.getString("id");
				String userBaseId = "";
				String userBaseExtId = "";
				String userBizRoleId = "";
				Statement ids = conn.createStatement();
				ResultSet idRs = null;
				try {
					idRs = ids
							.executeQuery("select b.id as USERBASEID,e.id as USERBASEEXTID,biz.id as USERBIZROLEID from userbase_temp b,userbaseext_temp e,userbizrole_temp biz where b.userid=e.id and b.id=biz.userbaseid and b.etipuserid='"
									+ etipUserId + "'");
					if (idRs.next()) {
						userBaseId = idRs.getString("USERBASEID");
						userBaseExtId = idRs.getString("USERBASEEXTID");
						userBizRoleId = idRs.getString("USERBIZROLEID");
					}
				} catch (Exception e1) {

					System.err
							.println("select b.id as USERBASEID,e.id as USERBASEEXTID,biz.id as USERBIZROLEID from userbase_temp b,userbaseext_temp e,userbizrole_temp biz where b.userid=e.id and b.id=biz.userbaseid and b.etipuserid='"
									+ etipUserId + "'");
					e1.printStackTrace();
				} finally {
					try {
						if (idRs != null)
							idRs.close();
						if (ids != null)
							ids.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				if (userBaseId == null || userBaseId.equals("")) {
					continue;
				}
				List<String> addSql = new ArrayList<String>();
				addSql
						.add("insert into ETIPUSER (ID, VERSION, CREATOR, LASTUPTUSER, CREATEDATE, LASTUPTDATE, MEMBERID, USERTYPE, CANCELREASON, STATUS,AGENTID)(select ID, VERSION, CREATOR, LASTUPTUSER, CREATEDATE, LASTUPTDATE, MEMBERID, USERTYPE, CANCELREASON, STATUS,AGENTID from ETIPUSER_TEMP where id='"
								+ etipUserId + "')");
				addSql
						.add("insert into ETIPACCOUNT (ID, VERSION, ACCOUNTTYPE, ACCOUNT, ETIPUSERID,BRANDCODE)(select ID, VERSION, ACCOUNTTYPE, ACCOUNT, ETIPUSERID,BRANDCODE from ETIPACCOUNT_TEMP where etipuserid='"
								+ etipUserId + "')");
				addSql
						.add("insert into ETIPCERTIFICATE (ID, VERSION, CREATEDATE, ETIPUSERID, CERTTYPE, CERTVALUE)(select ID, VERSION, CREATEDATE, ETIPUSERID, CERTTYPE, CERTVALUE from ETIPCERTIFICATE_TEMP where etipuserid='"
								+ etipUserId + "')");
				addSql
						.add("insert into USERBASEEXT (ID, VERSION, DATACHANNEL, ITOURCHANNEL, ENGLISHFIRSTNAME, ENGLISHSECONDNAME, BIRTHDAY, SOURCEFILE, USEREXTID, POLITICAL, MARRIED, REGISTERADDRESS, CONTRY, DEGREE, GRADUTEINSTITUTE, GRADUATEDATE, RELIGION, DIALECT, PREFESSION, YEARINCOME, ISRECEIVESMSINFO, ISRECEIVEEMAILINFO, SOURCEDESCRIPTION, HOSTADDRESS)(select ID, VERSION, DATACHANNEL, ITOURCHANNEL, ENGLISHFIRSTNAME, ENGLISHSECONDNAME, BIRTHDAY, SOURCEFILE, USEREXTID, POLITICAL, MARRIED, REGISTERADDRESS, CONTRY, DEGREE, GRADUTEINSTITUTE, GRADUATEDATE, RELIGION, DIALECT, PREFESSION, YEARINCOME, ISRECEIVESMSINFO, ISRECEIVEEMAILINFO, SOURCEDESCRIPTION, HOSTADDRESS from USERBASEEXT_TEMP where id='"
								+ userBaseExtId + "')");
				addSql
						.add("insert into USERBASE (ID, VERSION, CHINESENAME, PROVINCE, CITY, CREATOR, MOBILE, LASTUPTUSER, CREATEDATE, LASTUPTDATE, EMAIL, GENDER, MEMO, COUNTRY, ETIPUSERID, USERID, USERBASETYPEID,BRANDCODE)(select ID, VERSION, CHINESENAME, PROVINCE, CITY, CREATOR, MOBILE, LASTUPTUSER, CREATEDATE, LASTUPTDATE, EMAIL, GENDER, MEMO, COUNTRY, ETIPUSERID, USERID, USERBASETYPEID,BRANDCODE from USERBASE_TEMP where id='"
								+ userBaseId + "')");
				addSql
						.add("insert into USERBIZROLE (ID, VERSION, ROLETYPE, CREATOR, LASTUPTUSER, CREATEDATE, LASTUPTDATE, CREDITLEVEL, CREDITLIMIT, ROLEREQUIREMENT, ETIPMANAGER, RANK, STATUS, USERBASEID)(select ID, VERSION, ROLETYPE, CREATOR, LASTUPTUSER, CREATEDATE, LASTUPTDATE, CREDITLEVEL, CREDITLIMIT, ROLEREQUIREMENT, ETIPMANAGER, RANK, STATUS, USERBASEID from USERBIZROLE_TEMP where id='"
								+ userBizRoleId + "')");
				addSql
						.add("insert into USERCERTIFICATE (ID, VERSION, VTYPE, CERTIFICATENAME, USERBASEID, SIGNDATE, VALIDATEYEAR, CODE)(select ID, VERSION, VTYPE, CERTIFICATENAME, USERBASEID, SIGNDATE, VALIDATEYEAR, CODE from USERCERTIFICATE_TEMP where USERBASEID='"
								+ userBaseId + "')");
				addSql
						.add("insert into USERCONTACTWAY (ID, VERSION, VTYPE, USERBASEID, CONTACTWAY, CONTACTDESC, VVALIDATE)(select ID, VERSION, VTYPE, USERBASEID, CONTACTWAY, CONTACTDESC, VVALIDATE from USERCONTACTWAY_TEMP where USERBASEID='"
								+ userBaseId + "')");
				addSql
						.add("insert into USERCUSTOMER (ID, VERSION, CONSUMERTYPE, ROLEID)(select ID, VERSION, CONSUMERTYPE, ROLEID from USERCUSTOMER_TEMP where ROLEID='"
								+ userBizRoleId + "')");
				addSql
						.add("insert into USERRELATION (ID, VERSION, CHINESENAME, MYUSERID, MOBILE, EMAIL, ENGLISHFIRSTNAME, ENGLISHSECONDNAME, PHONE, RELATIONTYPE, RELATIONDUTY, CERTIFICATENAME, CERTIFICATECODE, BIRTHDAY, CONTACTDATE, GENDER, CERTIFICATETYPE, OWNERUSERID)(select ID, VERSION, CHINESENAME, MYUSERID, MOBILE, EMAIL, ENGLISHFIRSTNAME, ENGLISHSECONDNAME, PHONE, RELATIONTYPE, RELATIONDUTY, CERTIFICATENAME, CERTIFICATECODE, BIRTHDAY, CONTACTDATE, GENDER, CERTIFICATETYPE, OWNERUSERID from USERRELATION_TEMP where OWNERUSERID='"
								+ userBaseId + "')");
				Statement add = conn.createStatement();
				String sql = "";
				try {
					for (String item : addSql) {
						sql = item;
						add.executeUpdate(item);
					}
				} catch (Exception e) {

					e.printStackTrace();
					System.err.println(sql);
				} finally {
					try {
						if (add != null)
							add.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			for (String item : log) {
				stmt.executeUpdate(item);
			}
			System.out.println("导入完毕");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void importCard() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet adminrs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String oldCard = "select MEMBERCARDNO,CUSTOMERID from oldcard_temp";
			String adminUser = "select etipuserid from etipaccount where accounttype=2 and account='admin'";
			adminrs = stmt.executeQuery(adminUser);
			String adminEtipUserid = "";
			if (adminrs.next()) {
				adminEtipUserid = adminrs.getString(1);
			} else {
				throw new Exception();
			}
			rs = stmt.executeQuery(oldCard);
			int i = 0;
			while (rs.next()) {
				i++;
				String cardNum = rs.getString(1);
				cardNum = cardNum.replaceAll(" ", "");
				String userBaseId = rs.getString(2);
				String userBaseSql = "select etipuserid from userbase where id='"
						+ userBaseId + "'";
				String bizSql = "select id from userbizrole where userbaseid='"
						+ userBaseId + "'";
				ResultSet ubrs = null;
				ResultSet bizrs = null;
				Statement importCard = null;
				try {
					importCard = conn.createStatement();
					// if(!isNumeric(cardNum)){//判断是否纯数字
					// importCard.executeUpdate("insert into log_card(CARDNUM,USERBASEID,TYPE) values('"
					// + cardNum + "','" + userBaseId + "',2)");
					// continue;
					// }
					// ubrs =
					// importCard.executeQuery("select * from etipaccount a where a.account='"
					// + cardNum + "'");
					// if(ubrs.next()){//判断是否与账号冲突（如果不作为账号那么下面的插入账号也要注释掉）
					// importCard.executeUpdate("insert into log_card(CARDNUM,USERBASEID,TYPE) values('"
					// + cardNum + "','" + userBaseId + "',3)");
					// continue;
					// }
					ubrs = importCard.executeQuery(userBaseSql);
					if (ubrs.next()) {
						String etipUserId = ubrs.getString(1);
						bizrs = importCard.executeQuery(bizSql);
						String bizRoleId = "";
						if (bizrs.next()) {
							bizRoleId = bizrs.getString(1);
						}
						List<String> cards = new ArrayList<String>();
						String etipAccountId = getUUIDfor32();
						String userRoleCardId = getUUIDfor32();
						// cards.add("insert into etipaccount (ID,ACCOUNTTYPE,ACCOUNT,ETIPUSERID) values ('"
						// + etipAccountId + "',5,'" + cardNum + "','" +
						// etipUserId + "')");
						cards
								.add("insert into userrolecard (ID,BIZROLEID,CARDSIGN,HOSTCARDNO,CREATOR,CREATEDATE,LASTUPTUSER,LASTUPTDATE,MEMBERCARDRANK,STATUS)"
										+ " values ('"
										+ userRoleCardId
										+ "','"
										+ bizRoleId
										+ "',4,'"
										+ cardNum
										+ "','"
										+ adminEtipUserid
										+ "', to_date('2009-10-16','yyyy-mm-dd'),'"
										+ adminEtipUserid
										+ "',to_date('2009-10-16','yyyy-mm-dd'),21,1)");
						for (String item : cards) {
							importCard.executeUpdate(item);
						}
					} else {
						importCard
								.executeUpdate("insert into log_card(CARDNUM,USERBASEID,TYPE) values('"
										+ cardNum + "','" + userBaseId + "',1)");
					}
					if (i % 200 == 0) {
						System.err.println("第" + i + "行");
					}
				} catch (Exception e) {

					e.printStackTrace();
				} finally {
					try {
						if (ubrs != null)
							ubrs.close();
						if (importCard != null)
							importCard.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.err.println("完成\t共" + i + "条");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (adminrs != null)
					adminrs.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 判断是否由纯数字组成的字符串
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 获得32位的uuid 如xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 * 
	 * @return
	 */
	private static String getUUIDfor32() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}

	public static void importCardScore() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet adminrs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String card = "select t.totalavaliablepoints,c.id,c.totalscore,c.consumablescore,b.userbaseid,b.id,c.hostcardno from card_score t,userbizrole b,userrolecard c where t.customerid=b.userbaseid and b.id=c.bizroleid and c.cardsign=4";
			String adminUser = "select etipuserid from etipaccount where accounttype=2 and account='admin'";
			adminrs = stmt.executeQuery(adminUser);
			String adminEtipUserid = "";
			if (adminrs.next()) {
				adminEtipUserid = adminrs.getString(1);
			} else {
				throw new Exception();
			}
			rs = stmt.executeQuery(card);
			int i = 0;
			while (rs.next()) {
				i++;
				String scoreNum = rs.getString(1);
				String cardId = rs.getString(2);
				int totalScore = rs.getInt(3) + Integer.valueOf(scoreNum);
				int consumableScore = rs.getInt(4) + Integer.valueOf(scoreNum);
				String userBaseId = rs.getString(5);
				String bizRoleId = rs.getString(6);
				String cardNum = rs.getString(7);

				Statement importCardScore = null;
				try {
					importCardScore = conn.createStatement();

					String[] cards = new String[2];
					String scoreRecordId = getUUIDfor32();
					cards[0] = "insert into ScoreRecord (ID,USERBASE1ID,USERBIZROLE1ID,CARD1TYPE,CARD1NO,OPERATOR,OPERATEDATE,EFFECTIVEDATE,DEFFECTIVEDATE,SCORE,STATUS,RECORDTYPE,CONSUMEAMOUNT) values "
							+ "('"
							+ scoreRecordId
							+ "','"
							+ userBaseId
							+ "','"
							+ bizRoleId
							+ "',4,'"
							+ cardNum
							+ "','"
							+ adminEtipUserid
							+ "',to_date('2009-10-16','yyyy-mm-dd'),to_date('2009-10-16','yyyy-mm-dd'),to_date('2010-12-31','yyyy-mm-dd'),"
							+ scoreNum + ",2,17,0)";
					cards[1] = "update userrolecard set LASTUPTUSER='"
							+ adminEtipUserid
							+ "',LASTUPTDATE=to_date('2009-10-16','yyyy-mm-dd'),TOTALSCORE="
							+ totalScore + ",CONSUMABLESCORE="
							+ consumableScore + " where id='" + cardId + "'";
					for (String item : cards) {
						importCardScore.executeUpdate(item);
					}

					if (i % 200 == 0) {
						System.err.println("第" + i + "行");
					}
				} catch (Exception e) {

					e.printStackTrace();
				} finally {
					try {
						if (importCardScore != null)
							importCardScore.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.err.println("完成\t共" + i + "条");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (adminrs != null)
					adminrs.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void aaa() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String card = "select * from oldcard";
			rs = stmt.executeQuery(card);
			while (rs.next()) {

				String cardnum = rs.getString(1);
				String userbaseid = rs.getString(2);

				Statement importCardScore = null;
				try {
					importCardScore = conn.createStatement();

					importCardScore
							.executeUpdate("insert into oldcard_temp (MEMBERCARDNO,CUSTOMERID) values ('"
									+ cardnum + "','" + userbaseid + "')");
				} catch (Exception e) {

					System.err.println(e.getLocalizedMessage());
				} finally {
					try {
						if (importCardScore != null)
							importCardScore.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void updateOldCardScore() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();

			String adminUser = "select etipuserid from etipaccount where accounttype=2 and account='admin'";
			rs = stmt.executeQuery(adminUser);
			String adminEtipUserid = "";
			if (rs.next()) {
				adminEtipUserid = rs.getString(1);
			} else {
				throw new Exception();
			}

			String card = "select c.hostcardno,c.totalscore,b.userbaseid,b.id from userbizrole b,userrolecard c where b.id=c.bizroleid and c.cardsign=4";// 查询老纵横卡（类型4）的卡号，和积分
			rs = stmt.executeQuery(card);

			while (rs.next()) {

				String cardnum = rs.getString(1);
				int score = rs.getInt(2);

				score += score;

				List<String> sqls = new ArrayList<String>();
				sqls
						.add("update scorerecord set deffectivedate=to_date('2010-04-30','yyyy-mm-dd') where card1no='"
								+ cardnum + "'");
				if (score > 0) {
					String scoreRecordId = getUUIDfor32();
					sqls
							.add("insert into ScoreRecord (ID,USERBASE1ID,USERBIZROLE1ID,CARD1TYPE,CARD1NO,OPERATOR,OPERATEDATE,EFFECTIVEDATE,DEFFECTIVEDATE,SCORE,STATUS,RECORDTYPE,CONSUMEAMOUNT) values "
									+ "('"
									+ scoreRecordId
									+ "','"
									+ rs.getString(3)
									+ "','"
									+ rs.getString(4)
									+ "',4,'"
									+ cardnum
									+ "','"
									+ adminEtipUserid
									+ "',to_date('2009-10-16','yyyy-mm-dd'),to_date('2009-10-16','yyyy-mm-dd'),to_date('2010-04-30','yyyy-mm-dd'),"
									+ score + ",2,17,0)");
				}
				sqls
						.add("update userrolecard set lastuptdate=to_date('2010-10-16','yyyy-mm-dd'),totalScore="
								+ score
								+ ",expireDate=to_date('2010-04-30','yyyy-mm-dd') where hostcardno='"
								+ cardnum + "'");
				Statement importCardScore = null;
				try {
					importCardScore = conn.createStatement();

					for (String item : sqls) {
						importCardScore.executeUpdate(item);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getLocalizedMessage());
				} finally {
					try {
						if (importCardScore != null)
							importCardScore.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 如掉会员多余的账号
	 */
	public static void removeDuplicateData() {
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select a1.etipuserid from etipaccount a1,etipaccount a2 where a1.etipuserid= a2.etipuserid and a1.accounttype = a2.accounttype and a1.id<>a2.id group by a1.etipuserid";
			rs = stmt.executeQuery(card);
			int j = 0;
			while (rs.next()) {
				if (++j % 10 == 0) {
					System.err.println("第" + j + "条");
				}
				for (int i = 1; i <= 5; i++) {
					list = removeDuplicateData(rs.getString(1), i, list);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		for (String item : list) {
			System.err.println(item);
		}
	}

	/**
	 * 根据etipUserId查询出多余的账号
	 */
	private static List<String> removeDuplicateData(String etipUserId,
			int accountType, List<String> list) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select id from etipaccount where etipuserid='"
					+ etipUserId + "' and accounttype = " + accountType;
			rs = stmt.executeQuery(card);
			if (rs.next()) {
				while (rs.next()) {
					list.add("delete from etipaccount where id='"
							+ rs.getString("ID") + "'");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 整理联系方式，主要针对的是手机，固化及小灵通 并且把不符合的联系方式备份到LOG_CONTACTWAY表中
	 */
	public static void formatContactway() {
		List<String> update = new ArrayList<String>();
		List<String> error = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String contactwaysql = "select id,contactway,zonecode from usercontactway where vtype in (1,2,3,9)";
			rs = stmt.executeQuery(contactwaysql);
			int i = 0;
			while (rs.next()) {
				if (++i % 20000 == 0) {
					System.err.println("第" + i + "行");
				}
				String zoneCode = rs.getString(3);
				String contactway = rs.getString(2);
				if (contactway != null) {
					contactway = contactway.replaceAll(" ", "");
				}
				try {
					if (contactway != null && !contactway.equals("")) {
						if (contactway.indexOf("86--") == 0) {
							contactway = contactway.substring(4);
						} else if (contactway.indexOf("86-") == 0) {
							contactway = contactway.substring(3);
						} else if (contactway.indexOf("--") == 0) {
							contactway = contactway.substring(2);
						} else if (contactway.indexOf("-") == 0) {
							contactway = contactway.substring(1);
						}
						contactway = contactway.replaceAll("-", "");
						if (contactway.indexOf("010") == 0) {
							zoneCode = "010";
							contactway = contactway.substring(3);
							if (!isNumeric(contactway)
									|| contactway.length() < 6
									|| contactway.length() > 9) {
								error
										.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
												+ rs.getString(1)
												+ "','"
												+ rs.getString(2) + "')");
							} else {
								if (contactway.indexOf("1") == 0) {
									update
											.add("update usercontactway set contactway='"
													+ contactway
													+ "',vtype=1 where id='"
													+ rs.getString(1) + "'");
								} else {
									update
											.add("update usercontactway set contactway='"
													+ contactway
													+ "',zonecode='"
													+ zoneCode
													+ "',vtype=2 where id='"
													+ rs.getString(1) + "'");
								}
							}
							continue;
						} else if (contactway.indexOf("02") == 0) {
							zoneCode = contactway.substring(0, 3);
							contactway = contactway.substring(3);
							if (!isNumeric(contactway)
									|| contactway.length() < 6
									|| contactway.length() > 9) {
								error
										.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
												+ rs.getString(1)
												+ "','"
												+ rs.getString(2) + "')");
							} else {
								if (contactway.indexOf("1") == 0) {
									update
											.add("update usercontactway set contactway='"
													+ contactway
													+ "',vtype=1 where id='"
													+ rs.getString(1) + "'");
								} else {
									update
											.add("update usercontactway set contactway='"
													+ contactway
													+ "',zonecode='"
													+ zoneCode
													+ "',vtype=2 where id='"
													+ rs.getString(1) + "'");
								}
							}
							continue;
						} else {
							if (contactway.indexOf("1") == 0) {
								if (!isNumeric(contactway)
										|| contactway.length() != 11) {
									error
											.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
													+ rs.getString(1)
													+ "','"
													+ rs.getString(2) + "')");
								} else {
									update
											.add("update usercontactway set contactway='"
													+ contactway
													+ "',vtype=1 where id='"
													+ rs.getString(1) + "'");
								}
							} else if (contactway.indexOf("0") != 0) {
								if (!isNumeric(contactway)
										|| contactway.length() < 6
										|| contactway.length() > 9) {
									error
											.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
													+ rs.getString(1)
													+ "','"
													+ rs.getString(2) + "')");
								} else {
									if (zoneCode == null || zoneCode.equals("")) {
										update
												.add("update usercontactway set contactway='"
														+ contactway
														+ "',zonecode='020',vtype=2 where id='"
														+ rs.getString(1) + "'");
									} else {
										update
												.add("update usercontactway set contactway='"
														+ contactway
														+ "',vtype=2 where id='"
														+ rs.getString(1) + "'");
									}
								}
							} else {
								if (contactway.length() < 8) {
									error
											.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
													+ rs.getString(1)
													+ "','"
													+ rs.getString(2) + "')");
								} else {
									zoneCode = contactway.substring(0, 4);
									contactway = contactway.substring(4);
									if (!isNumeric(contactway)
											|| contactway.length() < 6
											|| contactway.length() > 9) {
										error
												.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
														+ rs.getString(1)
														+ "','"
														+ rs.getString(2)
														+ "')");
									} else {
										if (contactway.indexOf("1") == 0) {
											update
													.add("update usercontactway set contactway='"
															+ contactway
															+ "',vtype=1 where id='"
															+ rs.getString(1)
															+ "'");
										} else {
											update
													.add("update usercontactway set contactway='"
															+ contactway
															+ "',zonecode='"
															+ zoneCode
															+ "',vtype=2 where id='"
															+ rs.getString(1)
															+ "'");
										}
									}
								}
							}
						}
					}
				} catch (RuntimeException e) {

					e.printStackTrace();
					error
							.add("insert into LOG_CONTACTWAY(contactwayid,contactway) values ('"
									+ rs.getString(1)
									+ "','"
									+ rs.getString(2)
									+ "')");
				}
			}

			i = 0;
			System.err.println("总共更新的有：" + update.size());
			for (String item : update) {
				if (++i % 200 == 0) {
					System.err.println("第" + i + "行");
				}
				if (i % 2000 == 0) {
					System.err.println("总共更新的有：" + update.size());
				}
				try {
					stmt.executeUpdate(item);
				} catch (Exception e) {

					e.printStackTrace();
					System.err.println(item);
				}
			}
			i = 0;
			System.err.println("总共错误的有：" + error.size());
			for (String item : error) {
				if (++i % 200 == 0) {
					System.err.println("第" + i + "行");
				}
				if (i % 2000 == 0) {
					System.err.println("总共错误的有：" + update.size());
				}
				try {
					stmt.executeUpdate(item);
				} catch (Exception e) {

					e.printStackTrace();
					System.err.println(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void reverse() {
		String temp = "河北邯郸市 0310 河北省石家庄 0311 河北省保定市 0312 河北省张家口 0313 河北省承德市 0314 河北省唐山市 0315 河北省廊坊市 0316 河北省衡水市 0318 浙江省衢州市 0570 浙江省杭州市 0571 浙江省湖州市 0572 浙江省嘉兴市 0573 浙江省宁波市 0574 浙江省绍兴市 0575 浙江省台州市 0576 浙江省温州市 0577 浙江省丽水市 0578 浙江省金华市 0579 浙江省舟山市 0580 辽宁省沈阳市 024 辽宁省铁岭市 0410 辽宁省大连市 0411 辽宁省鞍山市 0412 辽宁省抚顺市 0413 辽宁省本溪市 0414 辽宁省丹东市 0415 辽宁省锦州市 0416 辽宁省营口市 0417 辽宁省阜新市 0418 辽宁省辽阳市 0419 辽宁省朝阳市 0421 辽宁省盘锦市 0427 辽宁省葫芦岛 0429 湖北省武汉市 027 湖北省襄城市 0710 湖北省鄂州市 0711 湖北省孝感市 0712 湖北省黄州市 0713 湖北省黄石市 0714 湖北省咸宁市 0715 湖北省荆沙市 0716 湖北省宜昌市 0717 湖北省恩施市 0718 湖北省十堰市 0719 湖北省随枣市 0722 湖北省荆门市 0724 湖北省江汉市 0728 江苏省南京市 025 江苏省无锡市 0510 江苏省镇江市 0511 江苏省苏州市 0512 江苏省南通市 0513 江苏省扬州市 0514 江苏省盐城市 0515 江苏省徐州市 0516 江苏省淮阴市 0517 江苏省淮安市 0517 江苏省连云港 0518 江苏省常州市 0519 江苏省泰州市 0523 内蒙古海拉尔 0470 内蒙古呼和浩特 0471 内蒙古包头市 0472 内蒙古乌海市 0473 内蒙古集宁市 0474 内蒙古通辽市 0475 内蒙古赤峰市 0476 内蒙古东胜市 0477 内蒙古临河市 0478 内蒙古锡林浩特 0479 内蒙古乌兰浩特 0482 内蒙古阿拉善左旗 0483 江西省新余市 0790 江西省南昌市 0791 江西省九江市 0792 江西省上饶市 0793 江西省临川市 0794 江西省宜春市 0795 江西省吉安市 0796 江西省赣州市 0797 江西省景德镇 0798 江西省萍乡市 0799 江西省鹰潭市 0701 山西省忻州市 0350 山西省太原市 0351 山西省大同市 0352 山西省阳泉市 0353 山西省榆次市 0354 山西省长治市 0355 山西省晋城市 0356 山西省临汾市 0357 山西省离石市 0358 山西省运城市 0359 甘肃省临夏市 0930 甘肃省兰州市 0931 甘肃省定西市 0932 甘肃省平凉市 0933 甘肃省西峰市 0934 甘肃省武威市 0935 甘肃省张掖市 0936 甘肃省酒泉市 0937 甘肃省天水市 0938 甘肃省甘南州 0941 甘肃省白银市 0943 山东省菏泽市 0530 山东省济南市 0531 山东省青岛市 0532 山东省淄博市 0533 山东省德州市 0534 山东省烟台市 0535 山东省淮坊市 0536 山东省济宁市 0537 山东省泰安市 0538 山东省临沂市 0539 黑龙江阿城市 0450 黑龙江哈尔滨 0451 黑龙江齐齐哈尔 0452 黑龙江牡丹江 0453 黑龙江佳木斯 0454 黑龙江绥化市 0455 黑龙江黑河市 0456 黑龙江加格达奇 0457 黑龙江伊春市 0458 黑龙江大庆市 0459 福建省福州市 0591 福建省厦门市 0592 福建省宁德市 0593 福建省莆田市 0594 福建省泉州市 0595 福建省晋江市 0595 福建省漳州市 0596 福建省龙岩市 0597 福建省三明市 0598 福建省南平市 0599 广东省广州市 020 广东省韶关市 0751 广东省惠州市 0752 广东省梅州市 0753 广东省汕头市 0754 广东省深圳市 0755 广东省珠海市 0756 广东省佛山市 0757 广东省肇庆市 0758 广东省湛江市 0759 广东省中山市 0760 广东省河源市 0762 广东省清远市 0763 广东省顺德市 0765 广东省云浮市 0766 广东省潮州市 0768 广东省东莞市 0769 广东省汕尾市 0660 广东省潮阳市 0661 广东省阳江市 0662 广东省揭西市 0663 四川省成都市 028 四川省涪陵市 0810 四川省重庆市 0811 四川省攀枝花 0812 四川省自贡市 0813 四川省永川市 0814 四川省绵阳市 0816 四川省南充市 0817 四川省达县市 0818 四川省万县市 0819 四川省遂宁市 0825 四川省广安市 0826 四川省巴中市 0827 四川省泸州市 0830 四川省宜宾市 0831 四川省内江市 0832 四川省乐山市 0833 四川省西昌市 0834 四川省雅安市 0835 四川省康定市 0836 四川省马尔康 0837 四川省德阳市 0838 四川省广元市 0839 四川省泸州市 0840 湖南省岳阳市 0730 湖南省长沙市 0731 湖南省湘潭市 0732 湖南省株州市 0733 湖南省衡阳市 0734 湖南省郴州市 0735 湖南省常德市 0736 湖南省益阳市 0737 湖南省娄底市 0738 湖南省邵阳市 0739 湖南省吉首市 0743 湖南省张家界 0744 湖南省怀化市 0745 湖南省永州冷 0746 河南省商丘市 0370 河南省郑州市 0371 河南省安阳市 0372 河南省新乡市 0373 河南省许昌市 0374 河南省平顶山 0375 河南省信阳市 0376 河南省南阳市 0377 河南省开封市 0378 河南省洛阳市 0379 河南省焦作市 0391 河南省鹤壁市 0392 河南省濮阳市 0393 河南省周口市 0394 河南省漯河市 0395 河南省驻马店 0396 河南省三门峡 0398 云南省昭通市 0870 云南省昆明市 0871 云南省大理市 0872 云南省个旧市 0873 云南省曲靖市 0874 云南省保山市 0875 云南省文山市 0876 云南省玉溪市 0877 云南省楚雄市 0878 云南省思茅市 0879 云南省景洪市 0691 云南省潞西市 0692 云南省东川市 0881 云南省临沧市 0883 云南省六库市 0886 云南省中甸市 0887 云南省丽江市 0888 安徽省滁州市 0550 安徽省合肥市 0551 安徽省蚌埠市 0552 安徽省芜湖市 0553 安徽省淮南市 0554 安徽省马鞍山 0555 安徽省安庆市 0556 安徽省宿州市 0557 安徽省阜阳市 0558 安徽省黄山市 0559 安徽省淮北市 0561 安徽省铜陵市 0562 安徽省宣城市 0563 安徽省六安市 0564 安徽省巢湖市 0565 安徽省贵池市 0566 宁夏银川市 0951 宁夏石嘴山 0952 宁夏吴忠市 0953 宁夏固原市 0954 吉林省长春市 0431 吉林省吉林市 0432 吉林省延吉市 0433 吉林省四平市 0434 吉林省通化市 0435 吉林省白城市 0436 吉林省辽源市 0437 吉林省松原市 0438 吉林省浑江市 0439 吉林省珲春市 0440 广西省防城港 0770 广西省南宁市 0771 广西省柳州市 0772 广西省桂林市 0773 广西省梧州市 0774 广西省玉林市 0775 广西省百色市 0776 广西省钦州市 0777 广西省河池市 0778 广西省北海市 0779 贵州省贵阳市 0851 贵州省遵义市 0852 贵州省安顺市 0853 贵州省都均市 0854 贵州省凯里市 0855 贵州省铜仁市 0856 贵州省毕节市 0857 贵州省六盘水 0858 贵州省兴义市 0859 陕西省西安市 029 陕西省咸阳市 0910 陕西省延安市 0911 陕西省榆林市 0912 陕西省渭南市 0913 陕西省商洛市 0914 陕西省安康市 0915 陕西省汉中市 0916 陕西省宝鸡市 0917 陕西省铜川市 0919 青海省西宁市 0971 青海省海东市 0972 青海省同仁市 0973 青海省共和市 0974 青海省玛沁市 0975 青海省玉树市 0976 青海省德令哈 0977 海南省儋州市 0890 海南省海口市 0898 海南省三亚市 0899 西藏拉萨市 0891 西藏日喀则 0892 西藏山南市 0893";
		StringTokenizer tokens = new StringTokenizer(temp, " ");
		while (tokens.hasMoreTokens()) {
			String token1 = tokens.nextToken();
			String token2 = tokens.nextToken();
			if (token1.indexOf("省") > 0) {
				String provice = token1.substring(0, token1.indexOf("省"));
				String fcity = token1.substring(token1.indexOf("省") + 1);
				System.out
						.println("insert into mobile_cityname(FSIMSG,CITY,FPROVINCE,FCITY,type) values ('"
								+ token2
								+ "','"
								+ token1
								+ "','"
								+ provice
								+ "','" + fcity + "','2');");
			} else {
				System.err
						.println("insert into mobile_cityname(FSIMSG,CITY,FCITY,type) values ('"
								+ token2
								+ "','"
								+ token1
								+ "','"
								+ token1
								+ "','2');");
			}

			// System.out.println("<item code=\""+token2+"\" name=\""+token1+"\"/>");
		}
	}

	// 将没有市的补全
	public static void reverse3() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select m.fcity,m.fsimsg from MOBILE_CITYNAME m where length(m.fsimsg)=4";
			rs = stmt.executeQuery(card);
			while (rs.next()) {
				List<String> sqls = new ArrayList<String>();
				String sql = "";
				String sfsiyString = rs.getString("FCITY");
				String fsimsg = rs.getString("FSIMSG");
				if (sfsiyString.indexOf("省") > 0) {
					String provice = sfsiyString.substring(0, sfsiyString
							.indexOf("省"));
					String fcity = sfsiyString.substring(sfsiyString
							.indexOf("省") + 1);
					sql = "update MOBILE_CITYNAME m set m.FCITY='" + fcity
							+ "',m.FPROVINCE='" + provice
							+ "' where m.FSIMSG='" + fsimsg + "'";
					sqls.add(sql);
					System.out.println(sql);
					// stmt.executeUpdate(sql);
				}
				if (sqls.size() > 0) {
					Statement importCardScore = null;
					try {
						importCardScore = conn.createStatement();

						for (String item : sqls) {
							importCardScore.executeUpdate(item);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.err.println(e.getLocalizedMessage());
					} finally {
						try {
							if (importCardScore != null)
								importCardScore.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// 将字段拆分成省市数据导入到电话区号表中
	public static void reverse2() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select m.fcity,m.fsimsg from MOBILE_CITYNAME m where length(m.fsimsg)=4";
			rs = stmt.executeQuery(card);
			while (rs.next()) {
				List<String> sqls = new ArrayList<String>();
				String sql = "";
				String sfsiyString = rs.getString("FCITY");
				String fsimsg = rs.getString("FSIMSG");
				if (sfsiyString.indexOf("省") > 0) {
					String provice = sfsiyString.substring(0, sfsiyString
							.indexOf("省"));
					String fcity = sfsiyString.substring(sfsiyString
							.indexOf("省") + 1);
					sql = "update MOBILE_CITYNAME m set m.FCITY='" + fcity
							+ "',m.FPROVINCE='" + provice
							+ "' where m.FSIMSG='" + fsimsg + "'";
					sqls.add(sql);
					System.out.println(sql);
					// stmt.executeUpdate(sql);
				}
				if (sqls.size() > 0) {
					Statement importCardScore = null;
					try {
						importCardScore = conn.createStatement();

						for (String item : sqls) {
							importCardScore.executeUpdate(item);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.err.println(e.getLocalizedMessage());
					} finally {
						try {
							if (importCardScore != null)
								importCardScore.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	// 将品牌表中的主被叫号拆分出来放到品牌主被叫号表中
	public static void reverseBrandcode() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select t.sourcephone,t.targetphone,t.brandcode from distributorbrand t where t.status='1'";
			rs = stmt.executeQuery(card);
			while (rs.next()) {
				List<String> sqls = new ArrayList<String>();
				String sql = "";
				String targetphone = rs.getString("TARGETPHONE");
				String sourcephone = rs.getString("SOURCEPHONE");
				String brandcode = rs.getString("BRANDCODE");
				if (targetphone!=null && !targetphone.equals("")) {
					String []strings=targetphone.split(",");
					for (int i = 0; i < strings.length; i++) {
						if(strings[i]!=null && !strings[i].equals("")){
							System.out.println("insert into brandcode_phone (ID,BRANDCODE,PHONE,PTYPE) values (hibernate_sequence.nextval,'"+brandcode+"','"+strings[i]+"','1');");
							//stmt.executeUpdate(sql);
						}
					}
				}
				if (sourcephone!=null && !sourcephone.equals("")) {
					String []strings=sourcephone.split(",");
					for (int j = 0; j < strings.length; j++) {
						if(strings[j]!=null && !strings[j].equals("")){
							System.out.println("insert into brandcode_phone (ID,BRANDCODE,PHONE,PTYPE) values (hibernate_sequence.nextval,'"+brandcode+"','"+strings[j]+"','2');");
							//stmt.executeUpdate(sql);
						}
						
					}
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	//将手机区号表数据导入品牌电话表中
	public static void reverseBrandcodeMobil() {
		List<String> sqls = new ArrayList<String>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 注册数据库驱动程序为oracle驱动
			conn = getConnection();
			stmt = conn.createStatement();
			// 分组查询出重复的etipuserid
			String card = "select replace(t.name, '纵横', '') as name,t.brandcode from distributorbrand t where t.parentid = '0ea1971826854388895efe7b6503232e' and t.name like '纵横%' and t.name <> '纵横天地网站'";
			rs = stmt.executeQuery(card);
			Statement stmt1 = conn.createStatement();
			while (rs.next()) {
				
				String sql = "";
				String name = rs.getString("NAME");
				String brandcode = rs.getString("BRANDCODE");
				if (name!=null && !name.equals("")) {
					//被叫号导入
					//System.out.println("insert into brandcode_phone (ID,BRANDCODE,PHONE,PTYPE) values (hibernate_sequence.nextval,'"+brandcode+"','','2');");
					sql="insert into brandcode_phone (ID,BRANDCODE,PHONE,PTYPE) values (hibernate_sequence.nextval,'"+brandcode+"','83936168','1')";
					//stmt.executeUpdate(sql);
					sqls.add(sql);
					String sql2 = "select m.fsimsg from mobile_cityname m where m.fprovince='"+name+"' or m.fcity like '"+name+"%'";// 查询手机区号表
					ResultSet rs2 = stmt1.executeQuery(sql2);
					String fsimsg="";
					String sql3="";
					while (rs2.next()){
						fsimsg=rs2.getString("FSIMSG");
						if (fsimsg!=null && !fsimsg.equals("")) {
							//主教号导入
							sql3="insert into brandcode_phone (ID,BRANDCODE,PHONE,PTYPE) values (hibernate_sequence.nextval,'"+brandcode+"','"+fsimsg+"','2')";
							//stmt.executeUpdate(sql3);
							sqls.add(sql3);
						}
					}
					
				}
				

			}
			
			int i = 0;
			System.err.println("总共有：" + sqls.size());
			if (sqls.size() > 0) {
				Statement importCardScore = null;
				try {
					importCardScore = conn.createStatement();

					for (String item : sqls) {
						importCardScore.executeUpdate(item);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println(e.getLocalizedMessage());
				} finally {
					try {
						if (importCardScore != null)
							importCardScore.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
