package com.itour.etip.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.util.ResetPassWord;
import com.itour.etip.pub.util.UuidUtil;

public class AddMemberUtil {
	private static ApplicationContext ctx;
	private static JdbcDao dao;
	@BeforeClass
	public static void prepareTestData() throws Exception {		
		try{
			if(ctx == null) {
				ctx = new FileSystemXmlApplicationContext(
						new String[]{"WebContent/WEB-INF/configuration/spring/applicationContext-datasource.xml",
							"WebContent/WEB-INF/configuration/spring/applicationContext-connect.xml"
						});
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		dao = (JdbcDao) ctx.getBean("jdbc");
		//初始化数据
	}
	
	/**
	 * 在类级别上的tearDown方法，在测试用例执行后仅执行一次，用于销毁、
	 * 恢复测试环境。
	 *
	 */
	@AfterClass
	public static void clearUpTestData() {
		System.out.println("================");
	}
	
	@Test
	public void add(){
//		add(708099,1000000,"test");
		addUser("3da883fc-bf6a-48b4-ba24-44c145f236c6","彭先生","13922213523","","6601024248","888888","广州市黄埔海员路97号外运大楼1102室","2009-08-11","aaa");
	}
	
	private void add(int startNum,int endNum, String loginName){
		addUser(startNum, endNum,loginName);
	}
	
	/**
	 * 清理个体会员数据
	 * @param userBaseIds
	 */
	private void addUser(int startNum,int endNum,String loginName){
		for(int i = startNum;i < endNum;i++){
			String etipUserId = UuidUtil.getUUIDfor32();
			String etipAccountId = UuidUtil.getUUIDfor32();
			String etipCertificateId = UuidUtil.getUUIDfor32();
			String userBaseId = UuidUtil.getUUIDfor32();
			String userBaseExtId = UuidUtil.getUUIDfor32();
			String userBizRoleId = UuidUtil.getUUIDfor32();
			String userCustomerId = UuidUtil.getUUIDfor32();
			
			List<String> addSqls = new ArrayList<String>();
			addSqls.add("insert into etipuser(id,memberid,usertype,status) values('" + etipUserId + "','" + userBaseId + "',1,1)");
			addSqls.add("insert into etipaccount(id,accounttype,account,etipuserid) values('" + etipAccountId + "',2,'" + (loginName + i) + "','" + etipUserId + "')");
			addSqls.add("insert into etipcertificate(id,CERTTYPE,certvalue,etipuserid) values('" + etipCertificateId + "',1,'1234','" + etipUserId + "')");
			addSqls.add("insert into userbaseext(id,datachannel,political,married,degree,religion,prefession,yearincome,isreceivesmsinfo,isreceiveemailinfo) values('" + userBaseExtId + "',0,0,0,0,0,0,0,0,1)");
			addSqls.add("insert into userbase(id,userid,etipuserid,gender) values('" + userBaseId + "','" + userBaseExtId + "','" + etipUserId + "','1')");
			addSqls.add("insert into userbizrole(id,roletype,rank,status,userbaseid,creditlevel,creditlimit) values('" + userBizRoleId + "',1,21,2,'" + userBaseId + "',30,0)");
			addSqls.add("insert into usercustomer(id,roleid) values('" + userCustomerId + "','" + userBizRoleId + "')");
			
			if(i % 500 == 0){
				System.err.println(new Date() + "\t" + i);
			}
			for(String sql : addSqls){
//				System.err.println(sql);
				dao.executeSQL(sql);
			}
		}
	}
	
	private void addUser(String userBaseId,String loginName,String mobile,String email,String card,String passWord,String paymentInfo,String time,String wordNo){
		if(loginName != null && !loginName.equals("") && mobile != null && !mobile.equals("") && email != null && !email.equals("")){
			return;
		}
		String operatorSql = "select id from etipuser where usertype=3 and memberid in (select etipoperator_id from groupuser where workerno='" + wordNo + "')";
		List<ETIPResultSet> result = dao.queryForList(operatorSql, null);
		String createId = "";
		if(result.size() > 0){
			createId = result.get(0).getString("ID");
		}
		String etipUserId = UuidUtil.getUUIDfor32();
		String etipAccountId = UuidUtil.getUUIDfor32();
		String etipCertificateId = UuidUtil.getUUIDfor32();
		if(userBaseId != null && !userBaseId.equals("")){
			if(userBaseId.length() >32){
				userBaseId = UuidUtil.formatUUID36to32(userBaseId);
			}
		}else{
			userBaseId = UuidUtil.getUUIDfor32();
		}
		String userBaseExtId = UuidUtil.getUUIDfor32();
		String userBizRoleId = UuidUtil.getUUIDfor32();
		String userRoleCardId = UuidUtil.getUUIDfor32();
		String userCustomerId = UuidUtil.getUUIDfor32();
		String userVoucherAddressId = UuidUtil.getUUIDfor32();
		
		List<String> addSqls = new ArrayList<String>();
		addSqls.add("insert into etipuser(id,memberid,usertype,status,createdate,lastuptdate,creator,lastuptuser) values('" + etipUserId + "','" + userBaseId + "',1,1,to_date('" + time + "','yyyy-MM-dd'),to_date('" + time + "','yyyy-MM-dd'),'" + createId + "','" + createId + "')");
		if(loginName != null && !loginName.equals("")){
			addSqls.add("insert into etipaccount(id,accounttype,account,etipuserid) values('" + etipAccountId + "',2,'" + loginName + "','" + etipUserId + "')");
		}
		if(mobile != null && !mobile.equals("")){
			etipAccountId = UuidUtil.getUUIDfor32();
			addSqls.add("insert into etipaccount(id,accounttype,account,etipuserid) values('" + etipAccountId + "',3,'" + mobile + "','" + etipUserId + "')");
		}
		if(card != null && !card.equals("")){
			etipAccountId = UuidUtil.getUUIDfor32();
			addSqls.add("insert into etipaccount(id,accounttype,account,etipuserid) values('" + etipAccountId + "',1,'" + card + "','" + etipUserId + "')");
		}
		if(email != null && !email.equals("")){
			etipAccountId = UuidUtil.getUUIDfor32();
			addSqls.add("insert into etipaccount(id,accounttype,account,etipuserid) values('" + etipAccountId + "',4,'" + email + "','" + etipUserId + "')");
		}
		if(passWord == null || passWord.equals("")){
			passWord = ResetPassWord.resetPassWord();
		}
		addSqls.add("insert into etipcertificate(id,CERTTYPE,certvalue,etipuserid,createdate) values('" + etipCertificateId + "',1,'" + passWord + "','" + etipUserId + "',to_date('" + time + "','yyyy-MM-dd'))");
		addSqls.add("insert into userbaseext(id,datachannel,political,married,degree,religion,prefession,yearincome,isreceivesmsinfo,isreceiveemailinfo) values('" + userBaseExtId + "',0,0,0,0,0,0,0,0,1)");
		addSqls.add("insert into userbase(id,userid,etipuserid,gender,mobile,email,createdate,lastuptdate,creator,lastuptuser) values('" + userBaseId + "','" + userBaseExtId + "','" + etipUserId + "','99','" + (mobile==null?"":mobile) + "','" + (email==null?"":email) + "',to_date('" + time + "','yyyy-MM-dd'),to_date('" + time + "','yyyy-MM-dd'),'" + createId + "','" + createId + "')");
		addSqls.add("insert into userbizrole(id,roletype,rank,status,userbaseid,creditlevel,creditlimit,createdate,lastuptdate,creator,lastuptuser) values('" + userBizRoleId + "',1,21,2,'" + userBaseId + "',30,0,to_date('" + time + "','yyyy-MM-dd'),to_date('" + time + "','yyyy-MM-dd'),'" + createId + "','" + createId + "')");
		addSqls.add("insert into userrolecard(id,bizroleid,cardsign,membercardrank,hostcardno,status,createdate,lastuptdate,creator,lastuptuser) values('" + userRoleCardId + "','" + userBizRoleId + "',1,21,'" + card + "',1,to_date('" + time + "','yyyy-MM-dd'),to_date('" + time + "','yyyy-MM-dd'),'" + createId + "','" + createId + "')");
		addSqls.add("insert into usercustomer(id,roleid) values('" + userCustomerId + "','" + userBizRoleId + "')");
		if(paymentInfo != null && !paymentInfo.equals("")){
			addSqls.add("insert into uservoucheraddress(id,consumerid,address,province,city,vouchertype) values('" + userVoucherAddressId + "','" + userCustomerId + "','" + paymentInfo + "','0','0',1)");
		}
		for(String sql : addSqls){
			System.err.println(sql);
			dao.executeSQL(sql);
		}
	}
	
}
