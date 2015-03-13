package com.itour.etip.pub.kit.cache;

import java.util.Map;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.xml.XMLDataBean;

public class ExceptionCache extends ETIPCache {

	ErrorDicModel errorDic = null;

	class ErrorDicModel extends XMLDataBean {

		private static final long serialVersionUID = 1L;

		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();
			if (tag.equals("errordic")) {
				parseChildNodes(node, null);
			} else if (tag.equals("section")) {
				parseChildNodes(node, null);
			} else if (tag.equals("item")) {
				String code = node.getAttribute("code");
				keyFileMapping.put(code, curCacheFile);
				//System.out.println(code+":"+curCacheFile);
				String name = node.getAttribute("name");
				String cause = node.getAttribute("cause");
				String solution = node.getAttribute("solution");
				java.util.Map<String, String> map = new java.util.TreeMap<String, String>();
				map.put("code", code);
				map.put("name", name);
				map.put("cause", cause);
				map.put("solution", solution);
				cacheInstance.put(code, map);

			}
		}

		public void expandAttributeNode(Attr attr) {
		}
	}

	public ExceptionCache() {
		super();
		//System.out.println("load exception cache:"+curCacheFile);
		//此处应该遍历文件夹，逐个解析文件。
		//File tempFile = new File("test.xml");
		//System.out.println("load exception:"+this.getClass().getR);
	}

	public void loadFromFile() throws ETIPException {
		
		errorDic = new ErrorDicModel();
		errorDic.setXMLFile(curCacheFile);
		errorDic.parseFromXML();
		fileDomMapping.put(curCacheFile, errorDic);
		CacheUtil.errorCache = this;
		// LogUtil.info("ETIP", "Error cache init[" + curCacheFile +
		// "],success");
	}

	public void saveCache() throws ETIPException {
		errorDic.saveToXML();
	}

	/**
	 * 更新缓冲区到指定文件名
	 * 
	 * @param errorCode
	 */
	public void refreshErrorConfig(Map errorMap) {
		String errorCode = (String) errorMap.get("code");
		// 首先检查errorCode是否已经配置到指定文件中，如果已经配置，需要更新
		// 如果未配置，则是添加新配置项目
		String fileName = keyFileMapping.get(errorCode);
		//System.out.println("fileName:"+errorCode+":"+fileName);
		
		boolean isNew = false;// 默认情况下不是新节点
		if (fileName == null || fileName.trim().length() == 0) {
			fileName = InitCacheListener.fullCacheLocation+"/exception/exception-unconfiguration.xml";
			isNew = true;// 未搜索到对应配置文件，该节点是新节点
		}
		XMLDataBean bean = fileDomMapping.get(fileName);
		//Object[] vs = keyFileMapping.keySet().toArray();
		
		Object[] values = keyFileMapping.values().toArray();
		
		System.out.println(fileName+":"+bean);
		
		Document dom = bean.getDom();
		//添加新节点
		if (isNew) {
			Element newNode = dom.createElement("item");
			newNode.setAttribute("code",(String) errorMap.get("code"));
			newNode.setAttribute("name", (String) errorMap.get("name"));
			newNode.setAttribute("cause", (String) errorMap.get("cause"));
			newNode.setAttribute("solution", (String) errorMap
					.get("solution"));
			dom.getDocumentElement().appendChild(newNode);
			
		} else { //修改旧节点
			NodeList nodes = dom.getElementsByTagName("item");
			int nodeNumber = nodes.getLength();
			for (int i = 0; i < nodeNumber; i++) {
				Element node = (Element) nodes.item(i);
				String targetKey = node.getAttribute("code");
				// 找到已经存在的node
				if (targetKey.equals(errorCode)) {
					// node.setAttribute("code", ex.getErrorCode());
					node.setAttribute("name", (String) errorMap.get("name"));
					node.setAttribute("cause", (String) errorMap.get("cause"));
					node.setAttribute("solution", (String) errorMap
							.get("solution"));
					
					break;
				}

			}
		}
		/**
		 * 以下刷新到文件中
		 */
		try {
			cacheInstance.put(errorCode,errorMap);
			bean.saveToXML();
			//super.updateCache(key, value);
		} catch (ETIPException ex) {
			// LogUtil.warn("FILE", "" + bean.getXMLFile() + "");
			ex.printStackTrace();
		}

	}

	public java.util.Map getException(String errorCode) {
		Object error = cacheInstance.get(errorCode);
		if (error != null){
			return (java.util.Map) error;
		}
		else {
			Map<String,String> errorMap = new java.util.HashMap<String,String>();
			errorMap.put("code",errorCode);
			errorMap.put("name","*");
			errorMap.put("cause","*");
			errorMap.put("solution","*");
			refreshErrorConfig(errorMap);
			return errorMap;
		}
		// 此处说明在缓冲区中没有配置，最好临时添加一个配置

	}

}