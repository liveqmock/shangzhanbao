package com.itour.etip.common.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;

public class CleanHotelUtil {
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
	public void clean(){
		List<String> id = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append("select o.id from hotelbaseinfo o where o.creator<>'HBESYNC' and o.creator<>'Import'");
		List<ETIPResultSet> rs = dao.queryForList(sb.toString(), null);
		if(rs.size() == 0){
			return;
		}else{
			for(ETIPResultSet item : rs){
				id.add(item.getString("ID"));
			}
		}
		Object[] objs = id.toArray();
		String[] ids = new String[objs.length];
		int i = 0;
		for(Object item : objs){
			ids[i++] = item.toString();
		}
		cleanHotel(ids);
	}
	
	/**
	 * 清理酒店数据
	 * @param userBaseIds
	 */
	private void cleanHotel(String[] hotelBaseIds){
		int i = 0;
		for(String hotelBaseId : hotelBaseIds){
			
			List<String> deleteSqls = new ArrayList<String>();
			
			deleteSqls.add("delete serviceitem s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete creditcardsupported s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete language s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			
			List<ETIPResultSet> rs = dao.queryForList("select s.crrencyid from pricecurrency s where s.hotelbaseinfoid='" + hotelBaseId + "'", null);
			StringBuffer crrencyids = new StringBuffer();
			for(ETIPResultSet item : rs){
				crrencyids.append(",");
				crrencyids.append("'");
				crrencyids.append(item.getString("CRRENCYID"));
				crrencyids.append("'");
			}
			String crrencyid = "";
			if(crrencyids.length() > 0){
				crrencyid = crrencyids.substring(1);
			}
			deleteSqls.add("delete pricecurrency s where s.hotelbaseinfoid='" + hotelBaseId + "'");

			if(crrencyid.length() > 0){
				deleteSqls.add("delete crrency c where c.id in (" + crrencyid + ")");
			}
			
			deleteSqls.add("delete hotelimageinfo s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete hotelestimatelevel s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete hoteltrafficinfo s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete hotelkeyword s where s.hotelbaseinfoid='" + hotelBaseId + "'");
			
			StringBuffer hotelroominfoIds = new StringBuffer();
			StringBuffer productBaseInfoIds = new StringBuffer();
			rs = dao.queryForList("select s.id,s.PRODUCTBASEINFOID from hotelroominfo s where s.hotelbaseinfoid='" + hotelBaseId + "'",null);
			for(ETIPResultSet item : rs){
				hotelroominfoIds.append(",");
				hotelroominfoIds.append("'");
				hotelroominfoIds.append(item.getString("CRRENCYID"));
				hotelroominfoIds.append("'");
				productBaseInfoIds.append(",");
				productBaseInfoIds.append("'");
				productBaseInfoIds.append(item.getString("PRODUCTBASEINFOID"));
				productBaseInfoIds.append("'");
			}
			String hotelroominfoId = "";
			if(hotelroominfoIds.length() > 0){
				hotelroominfoId = hotelroominfoIds.substring(1);
			}
			String productBaseInfoId = "";
			if(productBaseInfoIds.length() > 0){
				productBaseInfoId = productBaseInfoIds.substring(1);
			}
			if(hotelroominfoId.length() > 0){
				deleteSqls.add("delete roomstateinfo r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete roomquota r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete otherserviceprice r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete roomquotacontrol r where r.hotelroominfoid in (" + hotelroominfoId + ")");
			}

			deleteSqls.add("delete prioritycontrol r where r.hotelbaseinfoid='" + hotelBaseId + "'");
			
			rs = dao.queryForList("select r.productcontrolid from hotelcontrol r where r.hotelbaseinfoid='" + hotelBaseId + "'",null);
			StringBuffer productControlIds = new StringBuffer();
			for(ETIPResultSet item : rs){
				productControlIds.append(",");
				productControlIds.append("'");
				productControlIds.append(item.getString("PRODUCTCONTROLID"));
				productControlIds.append("'");
			}
			String productControlId = "";
			if(productControlIds.length() > 0){
				productControlId = productControlIds.substring(1);
			}
			if(productControlId.length() > 0){
				deleteSqls.add("delete membertype m where m.productcontrolid in (" + productControlId + ")");
				deleteSqls.add("delete markingchannel m where m.productcontrolid in (" + productControlId + ")");
			}
			
			deleteSqls.add("delete hotelcontrol r where r.hotelbaseinfoid='" + hotelBaseId + "'");
			
			if(productControlId.length() > 0){
				deleteSqls.add("delete productcontrol p where p.id in (" + productControlId + ")");
			}
			
			if(hotelroominfoId.length() > 0){
				deleteSqls.add("delete roomprice r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete roomdynamicinfo r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete vendorpromotionsale r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete hypothecationinfo r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete roompricecontrol r where r.hotelroominfoid in (" + hotelroominfoId + ")");
				deleteSqls.add("delete roomestablishment r where r.hotelroominfoid in (" + hotelroominfoId + ")");
			}
			
			if(productBaseInfoId.length() > 0){
				deleteSqls.add("delete combinedproductinfo c where c.productbaseinfoid in (" + productBaseInfoId + ")");
			}
			
			if(hotelroominfoId.length() > 0){
				deleteSqls.add("delete hotelroominfo r where r.id in (" + hotelroominfoId + ")");
			}

			if(productBaseInfoId.length() > 0){
				deleteSqls.add("delete productbaseinfo r where r.id in (" + productBaseInfoId + ")");
			}
			
			deleteSqls.add("delete hotelestablishment e where e.hotelbaseinfoid='" + hotelBaseId + "'");
			deleteSqls.add("delete countrydonotadmit e where e.hotelbaseinfoid='" + hotelBaseId + "'");
			
			rs = dao.queryForList("select h.hoteladdressinfoid from hotelbaseinfo h where h.id='" + hotelBaseId + "'",null);
			StringBuffer hotelAddressInfoIds = new StringBuffer();
			for(ETIPResultSet item : rs){
				hotelAddressInfoIds.append(",");
				hotelAddressInfoIds.append("'");
				hotelAddressInfoIds.append(item.getString("HOTELADDRESSINFOID"));
				hotelAddressInfoIds.append("'");
			}
			String hotelAddressInfoId = "";
			if(hotelAddressInfoIds.length() > 0){
				hotelAddressInfoId = hotelAddressInfoIds.substring(1);
			}
			
			deleteSqls.add("delete hotelbaseinfo e where e.id='" + hotelBaseId + "'");
			
			if(hotelAddressInfoId.length() > 0){
				deleteSqls.add("delete hoteladdressinfo e where e.id in (" + hotelAddressInfoId + ")");
			}
			
			try {
				for(String item : deleteSqls){
					System.err.println(item);
					dao.executeSQL(item);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			if(++i % 200 == 0){
				System.out.println(++i);
//			}
		}
		dao.executeSQL("delete HotelSychInfo");
		dao.executeSQL("delete HBEBatchLog");
		dao.executeSQL("delete HOTELCLICKRATE");
	}
}
