package com.itour.etip.pub.kit.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itour.etip.pub.kit.exception.ETIPError;

public abstract class XMLDataBean implements Serializable {

	/**
	 * xml文件路径，优先解析
	 */
	private String filePath = null;

	/**
	 * xml字符串
	 */
	private String xmlString = null;

	/**
	 * 解析后形成的dom对象
	 */
	private Document dom;

	public XMLDataBean() {
	}

	public String getXmlString() {
		return xmlString;
	}

	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}

	public String getXMLFile() {
		return filePath;
	}

	public String getContent() {
		return null;
	}

	public Document getDom() {
		return this.dom;
	}

	protected abstract void expandAttributeNode(org.w3c.dom.Attr node);

	protected abstract void expandElementNode(org.w3c.dom.Element node,
			Object parent);

	protected void parseChildNodes(org.w3c.dom.Node node, Object parent) {
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {

			Node nodei = children.item(i);
			parseFromNode(nodei, parent);
		}
	}

	protected void parseFromNode(org.w3c.dom.Node node, Object parent) {
		if (node == null)
			return;
		int nodeType = node.getNodeType();
		switch (nodeType) {
		case Node.ATTRIBUTE_NODE:
			expandAttributeNode((Attr) node);
			break;
		case Node.ELEMENT_NODE:
			// System.out.println("nodei:"+((Element)node).getNodeName());
			expandElementNode((Element) node, parent);
			break;
		default:
			break;
		}
	}

	public void parseFromXML() {
		try {
			if (filePath != null && filePath.trim().length() != 0)
				dom = getDomByFile(filePath, false);
			else 
				dom = getDomByXml(xmlString,false);
		} catch (java.io.IOException ex1) {
			// LogUtil.error("ETIP", "load xml file failure:" + filePath);
			ex1.printStackTrace();
			throw new ETIPError("XMLDataBean_parseFromXML_io", ex1);
		} catch (org.xml.sax.SAXException ex2) {
			ex2.printStackTrace();
			// LogUtil.error("ETIP", "parse xml file failure:" + filePath);
			throw new ETIPError("XMLDataBean_parseFromXML_sax", ex2);
		} catch (ParserConfigurationException ex3) {
			// LogUtil.error("ETIP", "parse xml file failure:" + filePath);
			throw new ETIPError("XMLDataBean_parseFromXML_config", ex3);
		}

		parseFromNode(dom.getFirstChild(), null);
	}

	public void saveToXML() {
		FileOutputStream writer = null;
		try {
			writer = new FileOutputStream(filePath);
			Element root = dom.getDocumentElement();
			String rv = null;
			// 此处经常错误，是包冲突引起的。
			if (dom instanceof com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl) {
				((com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl) dom)
						.setXmlEncoding("UTF-8");
				((com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl) dom)
						.setXmlVersion("1.0");
				rv = ((com.sun.org.apache.xerces.internal.dom.DeferredDocumentImpl) dom)
						.saveXML(root);
			} else if (dom instanceof org.apache.xerces.dom.DeferredDocumentImpl) {
				((org.apache.xerces.dom.DeferredDocumentImpl) dom)
						.setXmlEncoding("UTF-8");
				((org.apache.xerces.dom.DeferredDocumentImpl) dom)
						.setXmlVersion("1.0");
				rv = ((org.apache.xerces.dom.DeferredDocumentImpl) dom)
						.saveXML(root);
			}
			;
			int index = rv.indexOf("<paradic>");
			if (index < 0) {
				index = rv.indexOf("<errordic>");
			}
			if (index < 0) {
				index = rv.indexOf("<vos>");
			}
			if (index < 0) {
				index = rv.indexOf("<datadic>");
			}
			if (index < 0) {
				index = rv.indexOf("<dbdic>");
			}
			if (index < 0) {
				index = rv.indexOf("<web-app>");
			}
			if (index < 0) {
				index = rv.indexOf("<decorators");
			}
			String content = rv.substring(index);
			rv = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + content;
			writer.write(rv.getBytes("UTF-8"));
		} catch (java.io.IOException ex) {
			// LogUtil.error("ETIP", "save xml file failure:" + filePath);
			// throw new ETIPError(""ex);
			throw new ETIPError("XMLDataBean_saveXML_io", ex);
		}

		try {
			writer.close();
		} catch (java.io.IOException ex2) {
			// LogUtil.error("ETIP", "close xml file failure" + filePath);
			throw new ETIPError("XMLDataBean_saveXML_close", ex2);
		}
	}

	public void setXMLFile(String xmlFile) {
		this.filePath = xmlFile;
	}

	private Document getDomByFile(String filename, boolean validating)
			throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validating);
		Document doc = factory.newDocumentBuilder().parse(new File(filename));

		return doc;
	}
	
	//
	private Document getDomByXml(String xml, boolean validating)
			throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(validating);
		Document doc = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
		return doc;
	}
}
