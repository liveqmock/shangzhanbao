package com.itour.etip.pub.kit.cache;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.xml.XMLDataBean;

public class ParaCache extends ETIPCache{

	class ParaModel extends XMLDataBean {
	
		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();
			if (tag.equals("paradic")) {
				parseChildNodes(node, null);
			} else if (tag.equals("section")) {
				parseChildNodes(node, null);
			}

			else if (tag.equals("item")) {
				String name = node.getAttribute("name");
				String value = node.getAttribute("value");
				keyFileMapping.put(name, curCacheFile);
				cacheInstance.put(name, value);
			}
		}
		public void expandAttributeNode(Attr attr) {
		}
	}
	
	public ParaCache() {
		super();
	}
	
	public void loadFromFile() throws ETIPException {
		ParaModel model = new ParaModel();
		model.setXMLFile(curCacheFile);
		model.parseFromXML();
		fileDomMapping.put(curCacheFile, model);
		CacheUtil.paraCache = this;
//		LogUtil.info("ETIP", "load  para file success:" + curCacheFile);
	}
	
	public void updateCache(String key, Object value, String fileName) {
		if (key == null) {
//			LogUtil.warn("DB", "");
			return;
		}

		if (fileName == null || fileName.trim().length() == 0) {
			fileName = keyFileMapping.get(key);
		}
		if (fileName == null || fileName.trim().length() == 0) {
//			LogUtil.error("DB", "" + key + ""
//					+ fileName);
			return;
		}

		XMLDataBean bean = fileDomMapping.get(fileName);
		Document dom = bean.getDom();
		NodeList nodes = dom.getElementsByTagName("item");
		boolean isNew = true;
		int nodeNumber = nodes.getLength();
		for (int i = 0; i < nodeNumber; i++) {
			Element node = (Element) nodes.item(i);
			String targetKey = node.getAttribute("name");
			if (targetKey.equals(key)) {
				if (value != null) {
					node.setAttribute(key, (String) value);
				} else {
					try {
						node.getParentNode().removeChild(node);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				isNew = false;
				break;
			}

		}
		if (isNew) {
			Element newNode = dom.createElement("item");
			newNode.setAttribute("name", key);
			newNode.setAttribute("value", (String) value);
			dom.getDocumentElement().appendChild(newNode);
		}
		try {
			bean.saveToXML();
			super.updateCache(key, value);
		} catch (ETIPException ex) {
//			LogUtil.warn("FILE", "" + bean.getXMLFile() + "");
			ex.printStackTrace();
		}

	}
	
	public void saveCache() throws ETIPException {

	}
	
	public String getParaValue(String index) {
		String rv = (String) cacheInstance.get(index);
		if (rv == null) {
//			LogUtil.error("ETIP", "can not find para cofig for:" + index);
		}
		return rv;

	}
}
