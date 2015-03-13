package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;

/**
 * 将地域的数据字典导出成xml格式
 * 
 * @author txc
 * 
 */
public class GenerdicExportTool {

	protected static FileSystemXmlApplicationContext webserviceContent;

	@Before
	public void setup() {
		try {
			if (webserviceContent == null) {
				webserviceContent = new FileSystemXmlApplicationContext(
						new String[] {
								"WebContent/WEB-INF/configuration/spring/applicationContext-datasource.xml",
								"WebContent/WEB-INF/configuration/spring/applicationContext-connect.xml" });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStart() {
		long a = System.currentTimeMillis();
		//创建document对象，构造xml格式的数据
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("BaseData");
		Element countrys = root.addElement("countrys");
		//遍历数据字典
		JdbcDao dao = (JdbcDao) webserviceContent.getBean("jdbc");
		
		//对国家进行处理
		dealCountry(dao,countrys);
		
		System.err.println("文档装载完成");
		
		writeToFile(doc);
		
		System.err.println("输出到文件完毕");
		System.err.println("共耗时：  "+((System.currentTimeMillis()-a)/100)+"  秒");
	}
	
	//将document写入文件
	public void writeToFile(Document document){
		try {
			// 创建XMLWriter对象，目标文件users.xml，使用PrettyPrint格式 
			XMLWriter writer = new XMLWriter(new FileWriter("D:\\itourbasedata.xml"), 
			OutputFormat.createPrettyPrint()); 
			// 写文档 
			writer.write(document); 
			// 关闭writer 
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dealCountry(JdbcDao dao,Element countrys){
		//查询国家
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='01'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String countryID = set.getString("ID");
				String countryDicCode = set.getString("DICCODE");
				String countryAttrName = set.getString("ATTRNAME");
				String countryParentID = set.getString("PARENTID");
				String countryAttrCode = set.getString("ATTRCODE");
				String countryDicType = set.getString("DicType");
				Element country = countrys.addElement("country");
				Element id = country.addElement("id");
				id.addText(countryID);
				Element name = country.addElement("name");
				name.addText(countryAttrName);
				Element parentID = country.addElement("parentID");
				parentID.addText(countryParentID);
				Element attrCode = country.addElement("attrCode");
				attrCode.addText(countryAttrCode);
				Element provinces = country.addElement("provinces");
				//处理省
				dealProvince(dao,provinces,countryID);
			}
		}
	}
	
	public void dealProvince(JdbcDao dao,Element provinces,String countryID){
		//查询省
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='"+countryID+"'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String provinceID = set.getString("ID");
				String provinceDicCode = set.getString("DICCODE");
				String provinceAttrName = set.getString("ATTRNAME");
				String provinceParentID = set.getString("PARENTID");
				String provinceAttrCode = set.getString("ATTRCODE");
				String provinceDicType = set.getString("DicType");
				Element province = provinces.addElement("province");
				Element id = province.addElement("id");
				id.addText(provinceID);
				Element name = province.addElement("name");
				name.addText(provinceAttrName);
				Element parentID = province.addElement("parentID");
				parentID.addText(provinceParentID);
				Element attrCode = province.addElement("attrCode");
				attrCode.addText(provinceAttrCode);
				Element citys = province.addElement("citys");
				//处理市
				dealCitys(dao,citys,provinceID);
			}
		}
	}
	
	public void dealCitys(JdbcDao dao,Element citys,String provinceID){
		//查询市
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='"+provinceID+"' and g.dictype='city'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String cityID = set.getString("ID");
				String cityDicCode = set.getString("DICCODE");
				String cityAttrName = set.getString("ATTRNAME");
				String cityParentID = set.getString("PARENTID");
				String cityAttrCode = set.getString("ATTRCODE");
				String cityDicType = set.getString("DicType");
				Element city = citys.addElement("city");
				Element id = city.addElement("id");
				id.addText(cityID);
				Element name = city.addElement("name");
				name.addText(cityAttrName);
				Element parentID = city.addElement("parentID");
				parentID.addText(cityParentID);
				Element attrCode = city.addElement("attrCode");
				attrCode.addText(cityAttrCode);
				Element districts = city.addElement("districts");
				Element pors = city.addElement("pors");
				Element businessareas = city.addElement("businessareas");
				//处理行政区
				dealDistricts(dao,districts,cityID);
				//处理地标
				dealPors(dao,pors,cityID);
				//处理商圈
				dealBusinessAreas(dao,businessareas,cityID);
			}
		}
	
	}
	
	public void dealDistricts(JdbcDao dao,Element districts,String cityID){
		//查询行政区
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='"+cityID+"' and g.dictype='district'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String districtID = set.getString("ID");
				String districtDicCode = set.getString("DICCODE");
				String districtAttrName = set.getString("ATTRNAME");
				String districtParentID = set.getString("PARENTID");
				String districtAttrCode = set.getString("ATTRCODE");
				String districtDicType = set.getString("DicType");
				Element district = districts.addElement("district");
				Element id = district.addElement("id");
				id.addText(districtID);
				Element name = district.addElement("name");
				name.addText(districtAttrName);
				Element parentID = district.addElement("parentID");
				parentID.addText(districtParentID);
				Element attrCode = district.addElement("attrCode");
				attrCode.addText(districtAttrCode);
			}
		}
	
	}
	
	public void dealPors(JdbcDao dao,Element pors,String cityID){
		//查询行政区
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='"+cityID+"' and g.dictype='por'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String porID = set.getString("ID");
				String porDicCode = set.getString("DICCODE");
				String porAttrName = set.getString("ATTRNAME");
				String porParentID = set.getString("PARENTID");
				String porAttrCode = set.getString("ATTRCODE");
				String porDicType = set.getString("DicType");
				Element por = pors.addElement("por");
				Element id = por.addElement("id");
				id.addText(porID);
				Element name = por.addElement("name");
				name.addText(porAttrName);
				Element parentID = por.addElement("parentID");
				parentID.addText(porParentID);
				Element attrCode = por.addElement("attrCode");
				attrCode.addText(porAttrCode);
			}
		}
	
	}
	
	public void dealBusinessAreas(JdbcDao dao,Element businessareas,String cityID){
		//查询行政区
		String sql = "select g.id,g.diccode,g.attrname,g.parentid,g.attrcode,g.dictype from generaldic g where g.parentid='"+cityID+"' and g.dictype='businessarea'";
		List<ETIPResultSet> list = dao.queryForList(sql, null);
		if (list != null && list.size() > 0) {
			for (ETIPResultSet set : list) {
				String businessareaID = set.getString("ID");
				String businessareaDicCode = set.getString("DICCODE");
				String businessareaAttrName = set.getString("ATTRNAME");
				String businessareaParentID = set.getString("PARENTID");
				String businessareaAttrCode = set.getString("ATTRCODE");
				String businessareaDicType = set.getString("DicType");
				Element businessarea = businessareas.addElement("businessarea");
				Element id = businessarea.addElement("id");
				id.addText(businessareaID);
				Element name = businessarea.addElement("name");
				name.addText(businessareaAttrName);
				Element parentID = businessarea.addElement("parentID");
				parentID.addText(businessareaParentID);
				Element attrCode = businessarea.addElement("attrCode");
				attrCode.addText(businessareaAttrCode);
			}
		}
	
	}
}
