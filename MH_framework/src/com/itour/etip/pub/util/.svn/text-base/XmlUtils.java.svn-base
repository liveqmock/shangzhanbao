/**
 *<p>
 *类描述：
 *</p>
 * @author lzh
 * 创建时间2010-2-5 上午10:32:02 
 */
package com.itour.etip.pub.util;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.kit.exception.SysException;
import com.itour.etip.pub.kit.tool.DateTool;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author lzh
 *
 */
public class XmlUtils {
	public static Map<String, Object> Dom2Map(Document doc){
		Map<String, Object> map = new HashMap<String, Object>();
		if(doc == null)
			return map;
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			//System.out.println(e.getName());
			List list = e.elements();
			if(list.size() > 0){
				map.put(e.getName(), Dom2Map(e));
			}else{
				String text=e.getText();
				if(text==null || "null".equals(text)){
					text="";
				}
				map.put(e.getName(), text);
			}
		}
		return map;
	}
	

	public static Map Dom2Map(Element e){
		Map	map = new HashMap();
		List list = e.elements();
		if(list.size() > 0){
			for (int i = 0;i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();
				
				if(iter.elements().size() > 0){
					Map m = Dom2Map(iter);
					if(map.get(iter.getName()) != null){
						Object obj = map.get(iter.getName());
						if(!obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if(obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					}else{
						
						mapList.add(m);//i add
						map.put(iter.getName(), mapList);//i add
//						map.put(iter.getName(), m);
					}
				}
				else{
					if(map.get(iter.getName()) != null){
						Object obj = map.get(iter.getName());
						if(!obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if(obj.getClass().getName().equals("java.util.ArrayList")){
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					}else
						map.put(iter.getName(), iter.getText());
				}
			}
		}else
			map.put(e.getName(), e.getText());
		return map;
	}

	public static List readXML(InputStream in) throws Exception {
		List<Map<String, String>> results = new ArrayList<Map<String, String>>();
		List<Object> result = new ArrayList();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		Map map = XmlUtils.Dom2Map(doc);
		results.add(map);
		return results;
	}
	
	/**
	 * 将字符串转成xml文档
	 * @param xmlStr
	 * @return
	 */
	public static Document parseTextToXml(String xmlStr){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xmlStr);
		} catch (DocumentException e) {
			System.err.println("XmlUtils.parseTextToXml() parse error");
			//e.printStackTrace();
		}
		return doc;
	}
	
	public static String getTextFromSingleNode(Document doc, String nodeName){
		Node node = doc.getRootElement().selectSingleNode(nodeName);
		if(node!=null){
			return node.getText();
		}
		return null;
	}
	
	public static String dataToXml(Object obj){
		String head = CommonUtil.STR_XML_HEAD;
		StringBuilder sb = new StringBuilder("");
		String root = obj.getClass().getSimpleName();
		sb.append("<" + root.toUpperCase() + ">\n");
		try{
			Class superClass1 = obj.getClass().getSuperclass();
			Class ssClass = superClass1.getSuperclass();
			if(ssClass.getName().equals("java.lang.Object")){
				Field fid1 = superClass1.getDeclaredField("id");
				fid1.setAccessible(true);
				sb.append("<ID>" + fid1.get(obj) + "</ID>\n");
				Field version = superClass1.getDeclaredField("version");
				version.setAccessible(true);
				sb.append("<VERSION>" + version.get(obj) + "</VERSION>\n");
			}else{
				Field fid1 = ssClass.getDeclaredField("id");
				fid1.setAccessible(true);
				sb.append("<ID>" + fid1.get(obj) + "</ID>\n");
				Field version = ssClass.getDeclaredField("version");
				version.setAccessible(true);
				sb.append("<VERSION>" + version.get(obj) + "</VERSION>\n");
			}
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields){
				field.setAccessible(true);
				if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
					try {
						Class superClass = obj.getClass().getSuperclass();  
						Class ssClass2 = superClass1.getSuperclass();
						if(ssClass2.getName().equals("java.lang.Object")){
							Field fid = superClass.getDeclaredField("id");
							fid.setAccessible(true);
							sb.append("<ID>" + fid.get(obj) + "</ID>\n");
						}
						else{
							Field fid = ssClass2.getDeclaredField("id");
							fid.setAccessible(true);
							sb.append("<ID>" + fid.get(obj) + "</ID>\n");
						}
					} catch (SecurityException e) {
						
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						
						e.printStackTrace();
					}
				}else if(field.getType().getName().equals("java.lang.Double")){
					//将科学计数法转为大数据
					String val = "";
					if(field.get(obj) != null){
						val = getNumStr(Double.valueOf(field.get(obj).toString()));
					}
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+val+"]]>":"");
					sb.append("</" + field.getName().toUpperCase() + ">\n");	
				}else {
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+field.get(obj).toString().trim()+"]]>":"");
					sb.append("</" + field.getName().toUpperCase() + ">\n");	
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}catch (SecurityException e1) {
			
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			e.printStackTrace();
		}
		String strhead = "<QUERYINFO totalpages=\"" + 1 + "\" records=\"" + 1 + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	public static String dataFileToXml(Object obj){
		String head = CommonUtil.STR_XML_HEAD;
		StringBuilder sb = new StringBuilder("");
		String root = obj.getClass().getSimpleName();
		sb.append("<" + root.toUpperCase() + ">\n");
		try{
			Class superClass1 = obj.getClass().getSuperclass();
			Class ssClass = superClass1.getSuperclass();
			if(ssClass.getName().equals("java.lang.Object")){
				Field fid1 = superClass1.getDeclaredField("id");
				fid1.setAccessible(true);
				Field version = superClass1.getDeclaredField("version");
				version.setAccessible(true);
				
				sb.append("<" + fid1.getName() + ">");
				sb.append(fid1.get(obj)!=null?"<![CDATA["+fid1.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + fid1.getName() + ">\n");
				sb.append("<" + version.getName() + ">");
				sb.append(version.get(obj)!=null?"<![CDATA["+version.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + version.getName() + ">\n");
			}else{
				Field fid1 = ssClass.getDeclaredField("id");
				fid1.setAccessible(true);
				Field version = ssClass.getDeclaredField("version");
				version.setAccessible(true);
				
				sb.append("<" + fid1.getName() + ">");
				sb.append(fid1.get(obj)!=null?"<![CDATA["+fid1.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + fid1.getName() + ">\n");
				sb.append("<" + version.getName() + ">");
				sb.append(version.get(obj)!=null?"<![CDATA["+version.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + version.getName() + ">\n");
			}
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields){
				field.setAccessible(true);
				if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
					
				}else if(field.getType().getName().equals("java.lang.Double")){
					//将科学计数法转为大数据
					String val = "";
					if(field.get(obj) != null){
						val = getNumStr(Double.valueOf(field.get(obj).toString()));
					}
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+val+"]]>":"");
					sb.append("</" + field.getName().toUpperCase() + ">\n");	
				}else {
					sb.append("<" + field.getName() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+field.get(obj).toString().trim()+"]]>":"");
					sb.append("</" + field.getName() + ">\n");	
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		String strhead = "<QUERYINFO totalpages=\"" + 1 + "\" records=\"" + 1 + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	/**
	 * 根据多对象生成xml，不区分data
	 * @author gaoxs
	 * @date 2012-1-31
	 * @param obj
	 * 		对象数组
	 * @return
	 */
	public static String dataFieldToXml(Object... obj){
		String head = CommonUtil.STR_XML_HEAD;
		StringBuilder sb = new StringBuilder("");
		try{
			Class superClass1 = obj.getClass().getSuperclass();
			Class ssClass = superClass1.getSuperclass();
			if(ssClass.getName().equals("java.lang.Object")){
				Field fid1 = superClass1.getDeclaredField("id");
				fid1.setAccessible(true);
				Field version = superClass1.getDeclaredField("version");
				version.setAccessible(true);
				
				sb.append("<" + fid1.getName() + ">");
				sb.append(fid1.get(obj)!=null?"<![CDATA["+fid1.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + fid1.getName() + ">\n");
				sb.append("<" + version.getName() + ">");
				sb.append(version.get(obj)!=null?"<![CDATA["+version.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + version.getName() + ">\n");
			}else{
				Field fid1 = ssClass.getDeclaredField("id");
				fid1.setAccessible(true);
				Field version = ssClass.getDeclaredField("version");
				version.setAccessible(true);
				
				sb.append("<" + fid1.getName() + ">");
				sb.append(fid1.get(obj)!=null?"<![CDATA["+fid1.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + fid1.getName() + ">\n");
				sb.append("<" + version.getName() + ">");
				sb.append(version.get(obj)!=null?"<![CDATA["+version.get(obj).toString().trim()+"]]>":"");
				sb.append("</" + version.getName() + ">\n");
			}
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields){
				field.setAccessible(true);
				if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
					
				}else if(field.getType().getName().equals("java.lang.Double")){
					//将科学计数法转为大数据
					String val = "";
					if(field.get(obj) != null){
						val = getNumStr(Double.valueOf(field.get(obj).toString()));
					}
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+val+"]]>":"");
					sb.append("</" + field.getName().toUpperCase() + ">\n");	
				}else {
					sb.append("<" + field.getName() + ">");
					sb.append(field.get(obj)!=null?"<![CDATA["+field.get(obj).toString().trim()+"]]>":"");
					sb.append("</" + field.getName() + ">\n");	
				}
			}
		}catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		String strhead = "<QUERYINFO totalpages=\"" + 1 + "\" records=\"" + 1 + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	
	/**
	 * 将javabean转为xml格式
	 * 
	 * @param list
	 *            bean集合
	 * @param record
	 *            记录条数
	 * @param showlist
	 *            JSP页面需要展示的节点
	 * return String 
	 * add by smh
	 */
	public static String beanListToXml(List list, String record) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		for(Object bean : list) {
			String root = bean.getClass().getSimpleName();
			sb.append("<" + root.toUpperCase() + ">\n");
			try {
				Class superClass1 = bean.getClass().getSuperclass();
				Class ssClass = superClass1.getSuperclass();
				if(ssClass.getName().equals("java.lang.Object")){
					Field fid1 = superClass1.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
					Field version = superClass1.getDeclaredField("version");
					version.setAccessible(true);
					sb.append("<VERSION>" + version.get(bean) + "</VERSION>\n");
				}else{
					Field fid1 = ssClass.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
					Field version = ssClass.getDeclaredField("version");
					version.setAccessible(true);
					sb.append("<VERSION>" + version.get(bean) + "</VERSION>\n");
				}
			} catch (SecurityException e1) {
				
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				
				e1.printStackTrace();
			}
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
						try {
							Class superClass1 = bean.getClass().getSuperclass();
							Class ssClass = superClass1.getSuperclass();
							if(ssClass.getName().equals("java.lang.Object")){
								Field fid1 = superClass1.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
							}else{
								Field fid1 = ssClass.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
							}
						} catch (SecurityException e) {
							
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							
							e.printStackTrace();
						}
					}else if(field.getType().getName().equals("java.lang.Double")){
						//将科学计数法转为大数据
						String val = "";
						if(field.get(bean) != null)
							val = getNumStr(Double.valueOf(field.get(bean).toString()));
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+val+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}else {
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+field.get(bean).toString().trim()+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					
					e.printStackTrace();
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}

		// 记录总页数
		int recordnum = Integer.parseInt(record);
		int totalpages = recordnum / 10;
		if(totalpages == 0) {
			totalpages = 1;
		}
		String strhead = "<QUERYINFO totalpages=\"" + totalpages
				+ "\" records=\"" + Integer.parseInt(record) + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb)
				.append(strfoot).toString();
	}
	
	
	public static String getFullXml(String strXml){
		String strHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n<QUERYINFO>\n";
		String strFoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return strHead + strXml + strFoot;
	}
	
	
	
	
	public static String beanListToXml(List list,int total) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		for(Object bean : list) {
			String root = bean.getClass().getSimpleName();
			sb.append("<" + root.toUpperCase() + ">\n");
			try {
				Class superClass1 = bean.getClass().getSuperclass();
				Class ssClass = superClass1.getSuperclass();
				if(ssClass.getName().equals("java.lang.Object")){
					Field fid1 = superClass1.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
					Field fid2 = superClass1.getDeclaredField("version");
					fid2.setAccessible(true);
					sb.append("<VERSION>" + fid2.get(bean) + "</VERSION>\n");
				}else{
					Field fid1 = ssClass.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
					Field fid2 = ssClass.getDeclaredField("version");
					fid2.setAccessible(true);
					sb.append("<VERSION>" + fid2.get(bean) + "</VERSION>\n");
				}
				//if(superClass1.getSuperclass()!=null)
				
			} catch (SecurityException e1) {
				
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				
				e1.printStackTrace();
			}
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
						try {
							Class superClass = bean.getClass().getSuperclass();
							Class ssClass1 = superClass.getSuperclass();
							if(ssClass1.getName().equals("java.lang.Object")){
								Field fid1 = superClass.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
								Field fid2 = superClass.getDeclaredField("version");
								fid2.setAccessible(true);
								sb.append("<VERSION>" + fid2.get(bean) + "</VERSION>\n");
							}else{
								Field fid1 = ssClass1.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
								Field fid2 = ssClass1.getDeclaredField("version");
								fid2.setAccessible(true);
								sb.append("<VERSION>" + fid2.get(bean) + "</VERSION>\n");
							}
							
						} catch (SecurityException e) {
							
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							
							e.printStackTrace();
						}
					}else if(field.getType().getName().equals("java.lang.Double")){
						//将科学计数法转为大数据
						String val = "";
						if(field.get(bean) != null){
							val = getNumStr(Double.valueOf(field.get(bean).toString()));
						}
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+val+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}else if(!field.getType().getName().equals("java.util.Set")){
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+field.get(bean).toString().trim()+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					
					e.printStackTrace();
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}

		// 记录总页数
		int recordnum = Integer.parseInt(list.size()+"");
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages
				+ "\" records=\"" + total + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb)
				.append(strfoot).toString();
	}

	
	
	/**
	 * 将javabean转为xml格式
	 * 
	 * @param list
	 *            ETIPResultSet集合
	 * @param record
	 *            记录条数 
	 * return String 
	 * add by smh
	 */
	public static String ersListToXml(List<ETIPResultSet> list, String record) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		for(ETIPResultSet ers : list) {
			sb.append("<ROW>\n");
			//Iterator<ETIPResultSet> ite = ers.mapIterator();
			List<ETIPResultSet> erslist = ers.asList();
			for(int i=0;i<erslist.size();i++) {
				sb.append("<" + erslist.get(i) + ">");
				sb.append(ers.get(erslist.get(i))!=null?"<![CDATA["+ers.get(erslist.get(i)).toString().trim()+"]]>":"");
				sb.append("</" + erslist.get(i) + ">\n");
			}
			sb.append("</ROW>\n");
		}
		// 记录总页数
		int recordnum = Integer.parseInt(record);
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages
				+ "\" records=\"" + Integer.parseInt(record) + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	
	
	
	
    /**
     * 将XML转换为Bean
     *
     * @param clazzMap 别名-类名映射Map(clazzMap中类名必须和xml中根节点名称相同)
     * @param xml      要转换为bean对象的xml字符串
     * @return Java Bean对象
     * add by smh
     */
    public static Object xml2Bean(Map<String, Class> clazzMap, String xml) {
        XStream xstream = new XStream(new DomDriver());
        for (Iterator it = clazzMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, Class> m = (Map.Entry<String, Class>) it.next();
            xstream.alias(m.getKey(), m.getValue());
        }
        Object bean = xstream.fromXML(xml);
        return bean;
    } 
    
   
    
    /**
     * 将XML转换为Bean
     *
     * @param data 别名 ,xml中根节点
     * @param obj Bean的class
     * @param xml 要转换为bean对象的xml字符串
     * @return Java Bean对象
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     */
    public static Object xml2Bean(String data,Class obj,String xml) throws SecurityException{
    	xml = changeXml(xml);
    	Field[] fields = obj.getDeclaredFields();
        XStream xstream = new XStream(new DomDriver());
        xstream.alias(data, obj);
    	xstream.aliasField("ID", obj, "id");
    	xstream.aliasField("VERSION", obj, "version");
        for(Field f:fields){
        	xstream.aliasField(f.getName().toUpperCase(), obj, f.getName());
        }
        Object bean = xstream.fromXML(xml);
        for(Field f : fields){
        	try {
				if(f.getType().getName().equals("java.util.Date")){
					try {
						Method n = obj.getMethod("get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1, f.getName().length()));
						Object getValue = n.invoke(bean);
						if( getValue !=null && (StringUtil.getStrValue(getValue).equals("1900-01-01 12:00:00"))){
							try {
								Method m = obj.getMethod("set"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1, f.getName().length()),new Class[]{new Date().getClass()});
								m.invoke(bean, new Object[]{null});
								/*Method n = obj.getMethod("get"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1, f.getName().length()));
								System.out.println(n.invoke(bean));*/
							} catch (SecurityException e) {
								
								throw new SysException("19001",null, e);
							} 
						}
					} catch (NoSuchMethodException e1) {
						
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						
						e1.printStackTrace();
					}
				}
			} catch (IllegalArgumentException e) {
				
				throw new SysException("19001",null, e);
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
				throw new SysException("19001",null, e);
			}
        }
        return bean;
    } 
    
    public static String changeXml(String xml){
    	String strS = xml;
    	xml = xml.replaceAll("<DATAINFO>", "").replaceAll("</DATAINFO>", "");
    	/*boolean flag = true;
    	int i = 0;
    	int j = 0;
    	while(flag){
    		if(strS.indexOf("datatype=\"3\"")>0){
    			i = strS.indexOf("datatype=\"3\"",i);
    			int begin = strS.indexOf(">",i);
    			int end = strS.indexOf("</", i);
    			String timeStr = strS.substring(begin+1, end);
    			xml = xml.replaceAll(timeStr, getDateStr(timeStr));
    			strS = strS.substring(begin ,strS.length());
    		}else if(strS.indexOf("datatype=\"4\"")>0){
    			j = strS.indexOf("datatype=\"4\"",j);
    			int begin = strS.indexOf(">",j);
    			int end = strS.indexOf("</", j);
    			String timeStr = strS.substring(begin+1, end);
    			xml = xml.replaceAll(timeStr, getDatatimeStr(timeStr));
    			strS = strS.substring(begin ,strS.length());
    		}else{
    			flag = false;
    		}
    	}*/
    	return xml;
    }
    
    public static String getDateStr(String str){
    	return str.substring(0,4)+"-"+str.substring(4, 6)+"-"+str.substring(6, str.length())+" 00:00:00AM";
    }
    

    public static String getDatatimeStr(String str){
    	return str.substring(0,4)+"-"+str.substring(4, 6)+"-"+str.substring(6, 8)+" "+str.substring(8, 10)+":"+str.substring(10, 12)+":00AM";
    }
    

    public String getId(Object bean){
    	Class superClass = bean.getClass().getSuperclass();
		if(superClass.getName().equals("java.lang.Object")){
			return "";
		}
    	return "";
    }
    

    /**
	 * 数据对象list转换成xml
	 * @author gaoxs
	 * @date 2012-1-4
	 * @param list
	 * @return
	 */
	public static String ListToXml(List<Object> list) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		for (Object bean : list) {
			String root = bean.getClass().getSimpleName();
			sb.append("<" + root.toUpperCase() + ">\n");
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append(field.get(bean) != null ? field.get(bean).toString().trim() : "");
					sb.append("</" + field.getName().toUpperCase() + ">\n");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}
		// 记录总页数
		int recordnum = Integer.parseInt(list.size() + "");
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages + "\" records=\"" + Integer.parseInt(list.size() + "") + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	/**
	 * 对象转换成xml
	 * @author gaoxs
	 * @date 2012-1-4
	 * @param list
	 * @return
	 */
	public static String ObjectToXml(Object bean) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		String root = bean.getClass().getSimpleName();
		sb.append("<" + root.toUpperCase() + ">\n");
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				sb.append("<" + field.getName().toUpperCase() + ">");
				sb.append(field.get(bean) != null ? field.get(bean).toString().trim() : "");
				sb.append("</" + field.getName().toUpperCase() + ">\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.append("</" + root.toUpperCase() + ">\n");
		// 记录总页数
		int recordnum = Integer.parseInt(1 + "");
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages + "\" records=\"" + Integer.parseInt(1 + "") + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	/**
	 * 对象转换成xml
	 * @author gaoxs
	 * @date 2012-1-4
	 * @param list
	 * @return
	 */
	public static String ObjectBeanToXml(Object bean) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		String root = bean.getClass().getSimpleName();
		sb.append("<" + root.toUpperCase() + ">\n");
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				field.setAccessible(true);
				Object value = field.get(bean)!=null?field.get(bean):"";
				if (!value.equals("") && field.getType().getName().equals("java.util.Date")) {
					value = DateTool.format((Date)value, null);
				}else if(field.getType().getName().equals("java.lang.Double") && field.get(bean) != null){
					//将科学计数法转为大数据
					value = getNumStr(Double.valueOf(field.get(bean).toString()));
				}
				sb.append("<" + field.getName() + ">");
				sb.append("<![CDATA["+value+"]]>");
				sb.append("</" + field.getName() + ">\n");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		sb.append("</" + root.toUpperCase() + ">\n");
		// 记录总页数
		int recordnum = Integer.parseInt(1 + "");
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages + "\" records=\"" + Integer.parseInt(1 + "") + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
    
	/**
	 * 系统配置xml
	 * @param ls
	 * @return
	 */
	public static String getConfigXml(List<ETIPResultSet> ls){
		if(ls==null && ls.size()==0)return "";
		StringBuffer sbXmlHead = new StringBuffer();
		StringBuffer sbXmlBody = new StringBuffer();
		StringBuffer sbXmlFoot = new StringBuffer();
		
		for(int i=0; i<ls.size(); i++){
			ETIPResultSet re = (ETIPResultSet)ls.get(i);
			sbXmlBody.append("<SYSCONFIG>");
			sbXmlBody.append("<CONFID>").append(re.getString("ID".toUpperCase())).append("</CONFID>");
			sbXmlBody.append("<PARENTID>").append(re.getString("PARENTID".toUpperCase())).append("</PARENTID>");
			sbXmlBody.append("<CONFTYPE>").append(re.getString("CONFTYPE".toUpperCase())).append("</CONFTYPE>");
			sbXmlBody.append("<CONFCODE>").append(re.getString("CONFCODE".toUpperCase())).append("</CONFCODE>");
			sbXmlBody.append("<CONFNAME>").append(re.getString("CONFNAME".toUpperCase())).append("</CONFNAME>");
			sbXmlBody.append("<CONFVALUE>").append(re.getString("CONFVALUE".toUpperCase())).append("</CONFVALUE>");
			sbXmlBody.append("<CONFSTATUS>").append(re.getString("CONFSTATUS".toUpperCase())).append("</CONFSTATUS>");
			sbXmlBody.append("<CONFISEDIT>").append(re.getString("CONFISEDIT".toUpperCase())).append("</CONFISEDIT>");
			sbXmlBody.append("<CONFISLOOK>").append(re.getString("CONFISLOOK".toUpperCase())).append("</CONFISLOOK>");
			sbXmlBody.append("<CONFREMARK>").append(re.getString("CONFREMARK".toUpperCase())).append("</CONFREMARK>");
			sbXmlBody.append("</SYSCONFIG>");
		}
		sbXmlHead.append("<QUERYINFO totalpages=\"1\" records=\"1\">");
		sbXmlFoot.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
		return new StringBuffer().append(EfsConstants.STR_XML_HEAD).append(sbXmlHead).append(sbXmlBody).append(EfsConstants.STR_XML_FOOT).toString();
	}
	/**
	 * 数据字典主表(tb_sys_dic)xml
	 * @param ls
	 * @return
	 */
	public static String getDicXml(List<ETIPResultSet> ls){
		if(ls==null && ls.size()==0)return "";
		StringBuffer sbXmlHead = new StringBuffer();
		StringBuffer sbXmlBody = new StringBuffer();
		StringBuffer sbXmlFoot = new StringBuffer();
		
		for(int i=0; i<ls.size(); i++){
			ETIPResultSet re = (ETIPResultSet)ls.get(i);
			//从第四个字符串截取,省略前边的SYS_或者BIZ_
			String code = re.getString("DICCODE");
			if(re.getString("DICCODE").length() > 4){
				code = code.substring(4, code.length());
			}
			sbXmlBody.append("<DICTIONARY>");
			sbXmlBody.append("<ID>").append(re.getString("ID".toUpperCase())).append("</ID>");
			sbXmlBody.append("<PARENTID>").append(re.getString("PARENTID".toUpperCase())).append("</PARENTID>");
			sbXmlBody.append("<DICCODE>").append(code.toUpperCase()).append("</DICCODE>");
			sbXmlBody.append("<DICNAME>").append(re.getString("DICNAME".toUpperCase())).append("</DICNAME>");
			sbXmlBody.append("<DICTYPE>").append(re.getString("DICTYPE".toUpperCase())).append("</DICTYPE>");
			sbXmlBody.append("<DICRANGE>").append(re.getString("DICRANGE".toUpperCase())).append("</DICRANGE>");
			sbXmlBody.append("<DICMODULE>").append(re.getString("DICMODULE".toUpperCase())).append("</DICMODULE>");
			sbXmlBody.append("<DICSTATUS>").append(re.getString("DICSTATUS".toUpperCase())).append("</DICSTATUS>");
			sbXmlBody.append("<DICISEDIT>").append(re.getString("DICISEDIT".toUpperCase())).append("</DICISEDIT>");
			sbXmlBody.append("<DICISLOOK>").append(re.getString("DICISLOOK".toUpperCase())).append("</DICISLOOK>");
			sbXmlBody.append("<DICREMARK>").append(re.getString("DICREMARK".toUpperCase())).append("</DICREMARK>");
			sbXmlBody.append("<MANDATORY>").append(re.getString("MANDATORY".toUpperCase())).append("</MANDATORY>");
			sbXmlBody.append("</DICTIONARY>");
		}
		sbXmlHead.append("<QUERYINFO totalpages=\"1\" records=\"1\">");
		sbXmlFoot.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
		return new StringBuffer().append(EfsConstants.STR_XML_HEAD).append(sbXmlHead).append(sbXmlBody).append(EfsConstants.STR_XML_FOOT).toString();
	}
    

	public static String getDdItemList2Xml(List ls){
		if(ls==null)return "";
		StringBuffer sbXmlHead = new StringBuffer();
		StringBuffer sbXmlBody = new StringBuffer();
		StringBuffer sbXmlFoot = new StringBuffer();
		ETIPResultSet dd = null;
		int i = 0;
		for(;i<ls.size();i++){
			dd = (ETIPResultSet)ls.get(i);
			sbXmlBody.append("<ROW>");
				//sbXmlBody.append("<CODE>").append(dd.getString("id")).append("</CODE>");
				sbXmlBody.append("<CODE>").append(dd.getString("DICITEMCODE".toUpperCase())).append("</CODE>");
				sbXmlBody.append("<NAME>").append(dd.getString("DICITEMCODE".toUpperCase())  + " " + dd.getString("DICITEMNAME")).append("</NAME>");
			sbXmlBody.append("</ROW>");
		}
		sbXmlHead.append("<QUERYINFO totalpages=\"1\" records=\"1\">");
		sbXmlFoot.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
		return new StringBuffer().append(EfsConstants.STR_XML_HEAD).append(sbXmlHead).append(sbXmlBody).append(EfsConstants.STR_XML_FOOT).toString();
	}
	
	
	public static String getDdItemList4Xml(List ls){
		if(ls==null)return "";
		StringBuffer sbXmlHead = new StringBuffer();
		StringBuffer sbXmlBody = new StringBuffer();
		StringBuffer sbXmlFoot = new StringBuffer();
		ETIPResultSet dd = null;
		int i = 0;
		for(;i<ls.size();i++){
			dd = (ETIPResultSet)ls.get(i);
			sbXmlBody.append("<ROW>");
				//sbXmlBody.append("<CODE>").append(dd.getString("id")).append("</CODE>");
				sbXmlBody.append("<CODE>").append(dd.getString("DICITEMCODE")).append("</CODE>");
				sbXmlBody.append("<NAME>").append(dd.getString("DICITEMNAME")).append("</NAME>");
			sbXmlBody.append("</ROW>");
		}
		sbXmlHead.append("<QUERYINFO totalpages=\"1\" records=\"1\">");
		sbXmlFoot.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
		return new StringBuffer().append(EfsConstants.STR_XML_HEAD).append(sbXmlHead).append(sbXmlBody).append(EfsConstants.STR_XML_FOOT).toString();
	}
	
	
	public static String beanListToXml(List list) {
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		StringBuilder sb = new StringBuilder("");
		for(Object bean : list) {
			String root = bean.getClass().getSimpleName();
			sb.append("<" + root.toUpperCase() + ">\n");
			try {
				Class superClass1 = bean.getClass().getSuperclass();
				Class ssClass = superClass1.getSuperclass();
				if(ssClass.getName().equals("java.lang.Object")){
					Field fid1 = superClass1.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
				}else{
					Field fid1 = ssClass.getDeclaredField("id");
					fid1.setAccessible(true);
					sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
				}
				//if(superClass1.getSuperclass()!=null)
				
			} catch (SecurityException e1) {
				
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				
				e1.printStackTrace();
			} catch (NoSuchFieldException e1) {
				
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				
				e1.printStackTrace();
			}
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					if("SERIALVERSIONUID".equals(field.getName().toUpperCase())) {
						try {
							Class superClass = bean.getClass().getSuperclass();
							Class ssClass1 = superClass.getSuperclass();
							if(ssClass1.getName().equals("java.lang.Object")){
								Field fid1 = superClass.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
							}else{
								Field fid1 = ssClass1.getDeclaredField("id");
								fid1.setAccessible(true);
								sb.append("<ID>" + fid1.get(bean) + "</ID>\n");
							}
							
						} catch (SecurityException e) {
							
							e.printStackTrace();
						} catch (NoSuchFieldException e) {
							
							e.printStackTrace();
						}
					}else if(field.getType().getName().equals("java.lang.Double")){
						//将科学计数法转为大数据
						String val = "";
						if(field.get(bean)!=null){
							val = getNumStr(Double.valueOf(field.get(bean).toString()));
						}
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+val+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}else {
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+field.get(bean).toString().trim()+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");	
					}
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					
					e.printStackTrace();
				}
			}
			sb.append("</" + root.toUpperCase() + ">\n");
		}

		// 记录总页数
		int recordnum = Integer.parseInt(list.size()+"");
		int totalpages = recordnum / 10;
		String strhead = "<QUERYINFO totalpages=\"" + totalpages
				+ "\" records=\"" + Integer.parseInt(list.size()+"") + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb)
				.append(strfoot).toString();
	}
	
	public static String getXml4Dic(List ls){
		StringBuffer sb = new StringBuffer();
		try{
			if(ls!=null && ls.size()>0){
				//sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\"><QUERYINFO totalpages=\"1\" records=\"1\">");
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				sb.append("<data>");
				sb.append("<row DIC_CODE=\"").append("").append("\" DIC_TEXT=\"请选择...").append("").append("\"/>");
				for(Object bean : ls) {
					Field[] fields = bean.getClass().getDeclaredFields();
					String dicItemCode = "";
					String dicItemName = "";
					for(Field field : fields){
						field.setAccessible(true);
						if("dicItemCode".toUpperCase().equals(field.getName().toUpperCase()))
							dicItemCode = field.get(bean).toString();
						if("dicItemName".toUpperCase().equals(field.getName().toUpperCase()))
							dicItemName = field.get(bean).toString();
							
					}
					sb.append("<row DIC_CODE=\"").append(getSpecialCharacter(dicItemCode)).append("\" DIC_TEXT=\"").append(dicItemName).append("\"/>");
				}
				sb.append("</data>");
				//sb.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static String getDicItemDataList2Json(List ls){
		if(ls==null)return "";
		StringBuffer sb = new StringBuffer();
		String tmp = "[]";
		try{
			int i = 0;
			sb.append("[\n");
			for(Object bean : ls) {
				Field[] fields = bean.getClass().getDeclaredFields();
				String dicItemCode = "";
				String dicItemName = "";
				for(Field field : fields){
					field.setAccessible(true);
					if("dicItemCode".toUpperCase().equals(field.getName().toUpperCase()))
						dicItemCode = field.get(bean).toString();
					if("dicItemName".toUpperCase().equals(field.getName().toUpperCase()))
						dicItemName = field.get(bean).toString();
				}
				sb.append("['").append(dicItemCode).append("', ").append("'").append(dicItemName).append("'],\n");
			}
			
			tmp = sb.substring(0, sb.toString().trim().length()-1) + "\n]";
		}catch(Exception e){
			e.printStackTrace();
		}
		return tmp;
	}
	
	
	
	public static String getXml4Select(List ls){
		StringBuffer sb = new StringBuffer();
		try{
			if(ls!=null && ls.size()>0){
				sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\"><QUERYINFO totalpages=\"1\" records=\"1\">");
				for(Object bean : ls) {
					sb.append("<ROW>");
					Field[] fields = bean.getClass().getDeclaredFields();
					String dicItemCode = "";
					String dicItemName = "";
					for(Field field : fields){
						field.setAccessible(true);
						if("dicItemCode".toUpperCase().equals(field.getName().toUpperCase()))
							dicItemCode = field.get(bean).toString();
						if("dicItemName".toUpperCase().equals(field.getName().toUpperCase()))
							dicItemName = field.get(bean).toString();
							
					}
					sb.append("<CODE>").append("<![CDATA["+dicItemCode+"]]").append("</CODE><NAME>").append("<![CDATA["+dicItemName+"]]").append("</NAME>");
					sb.append("</ROW>");
				}
				sb.append("</QUERYINFO><ERRORINFO><ERRORRESULT>00</ERRORRESULT></ERRORINFO></RDFFRAME>");
			}
		}catch(Exception e){
			
		}
		return sb.toString();
	}
	
	
	
	@SuppressWarnings("unused")
	public static String getTTxml(List list){
		if(list==null || list.size()==0)return "";
		StringBuffer sb = new StringBuffer();
		try{
			String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
			//BigDecimal bigResult = new BigDecimal();
			double debitamount = 0;
			double creditamount = 0;
			for(Object bean : list) {
				Field[] fields = bean.getClass().getDeclaredFields();
				String rootName = bean.getClass().getSimpleName();
				sb.append("<" + rootName.toUpperCase() + ">\n");
				for(Field field : fields){
					field.setAccessible(true);
					if("SERIALVERSIONUID".equals(field.getName().toUpperCase())){
						sb.append("<ID>");
						sb.append(!"".equals(getID(bean))?getID(bean):"");
						sb.append("</ID>\n");
					}
					else if("id".toUpperCase().equals(field.getName().toUpperCase())){
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+getID(bean)+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");
					}else if("debitamount".toUpperCase().equals(field.getName().toUpperCase())){
						//将科学计数法转为大数据
						String val = "";
						if(field.get(bean)!=null){
							val = getNumStr(Double.valueOf(field.get(bean).toString()));
						}
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+val+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");
						debitamount += Double.parseDouble(field.get(bean)!=null?field.get(bean).toString():"0.00");
					}else if("creditamount".toUpperCase().equals(field.getName().toUpperCase())){
						//将科学计数法转为大数据
						String val = "";
						if(field.get(bean)!=null){
							val = getNumStr(Double.valueOf(field.get(bean).toString()));
						}
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+val+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");
						creditamount += Double.parseDouble(field.get(bean)!=null?field.get(bean).toString():"0.00");
					}else{
						sb.append("<" + field.getName().toUpperCase() + ">");
						sb.append(field.get(bean)!=null?"<![CDATA["+field.get(bean)+"]]>":"");
						sb.append("</" + field.getName().toUpperCase() + ">\n");
					}
				}
				sb.append("</" + rootName.toUpperCase() + ">\n");
			}
			
			//合计
			Object tmpObj = list.get(0);
			String rootName = tmpObj.getClass().getSimpleName();
			sb.append("<" + rootName.toUpperCase() + ">\n");
			Field[] fields = tmpObj.getClass().getDeclaredFields();
			String pheng = "";
			if(debitamount-creditamount==0)
				pheng="借贷平衡";
			else
				pheng="借贷不平衡";
			for(Field field : fields){
				if("subjectname".toUpperCase().equals(field.getName().toUpperCase())){
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append("<![CDATA[合计"+":   "+pheng+"]]>");
					sb.append("</" + field.getName().toUpperCase() + ">\n");
				}else if("debitamount".toUpperCase().equals(field.getName().toUpperCase())){
					//将科学计数法转为大数据
					String val = getNumStr(debitamount);
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append("<![CDATA["+val+"]]>");
					sb.append("</" + field.getName().toUpperCase() + ">\n");
				}else if("creditamount".toUpperCase().equals(field.getName().toUpperCase())){
					//将科学计数法转为大数据
					String val = getNumStr(creditamount);
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append("<![CDATA["+val+"]]>");
					sb.append("</" + field.getName().toUpperCase() + ">\n");
				}else{
					sb.append("<" + field.getName().toUpperCase() + ">");
					sb.append("<![CDATA[]]>");
					sb.append("</" + field.getName().toUpperCase() + ">\n");
				}
			}
			sb.append("</" + rootName.toUpperCase() + ">\n");
			
			// 记录总页数
			//int recordnum = Integer.parseInt(list.size()+"");
			//int totalpages = recordnum / 10;
			
			//return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		String head = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<RDFFRAME rdfframae=\"urn=www-rdfframe-cn\" version=\"1.0\">\n";
		String strhead = "<QUERYINFO totalpages=\"" + 1 + "\" records=\"" + Integer.parseInt(list.size()+"") + "\">\n";
		String strfoot = "</QUERYINFO>\n<ERRORINFO>\n<ERRORRESULT>00</ERRORRESULT>\n</ERRORINFO>\n</RDFFRAME>";
		return new StringBuilder().append(head).append(strhead).append(sb).append(strfoot).toString();
	}
	
	public static String getID(Object obj) throws Exception{
		String id = "";
		Class superClass = obj.getClass().getSuperclass();
		if(superClass.getName().equals("java.lang.Object")){
			Field field = obj.getClass().getDeclaredField("id");
			field.setAccessible(true);
			id = field.get(obj).toString();
		}else{
			id = getNextID(superClass, obj);
		}
		return id;
	}
	private static String id = "";
	public static String getNextID(Class cla, Object obj) throws Exception{
		//String id = "";
		try{
			Class superClass = cla.getSuperclass();
			if(superClass.getName().equals("java.lang.Object")){
				Field field = cla.getDeclaredField("id");
				field.setAccessible(true);
				id = field.get(obj).toString();
				//return id;
			}else{
				getNextID(superClass, obj);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	public String getSum(){
		return "";
	}
	
	/**
	 * 将科学计数法转为正常数字
	 * @return 数字串
	 */
	public static String getNumStr(double num){
		DataComputeUtil datac = new DataComputeUtil();
		String val = datac.dataUnEncrypt(Double.valueOf(num));
		return val;
	}
	
	private static String getSpecialCharacter(String str){
		if(str==null && "".equals(str))return "";
		String retStr = "";
		if("<".equals(str.trim())){
			retStr = "&lt;"; 
		}
		else if(">".equals(str.trim())){
			retStr = "&gt;"; 
		}
		else if(">=".equals(str.trim())){
			retStr = "&lt;="; 
		}
		else if("<=".equals(str.trim())){
			retStr = "&gt;="; 
		}
		else if("&".equals(str.trim())){
			retStr = "&amp;"; 
		}
		else if("&&".equals(str.trim())){
			retStr = "&amp;&amp;"; 
		}
		else if("'".equals(str.trim())){
			retStr = "&apos;"; 
		}
		else if("\"".equals(str.trim())){
			retStr = "&quot;";
		}
		else{
			return str;
		}
		return retStr;
	}
    
	public static void main(String[]args) throws Exception{
//		String aa="<xmlStr><orderId>adf</orderId><channel>adsf</channel></xmlStr>";
//		Document doc = parseTextToXml(aa);
//		Node node = doc.getRootElement().selectSingleNode("orderId");
//		System.out.println(node.getText());
		
	}
}
