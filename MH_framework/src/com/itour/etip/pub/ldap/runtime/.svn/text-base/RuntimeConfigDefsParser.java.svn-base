package com.itour.etip.pub.ldap.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 为runtimeConfigDefs.xml文件分析器。 这个类使用JDOM的以和解组成一系列Java对象的XML。
 */
@SuppressWarnings("unchecked")
public class RuntimeConfigDefsParser {

	/* Creates a new instance of RuntimeConfigDefsParser */
	public RuntimeConfigDefsParser() {
	}

	private ConfigDef elementToConfigDef(Element element) {

		ConfigDef configdef = new ConfigDef();

		configdef.setName(element.getAttributeValue("name"));

		List displaygroups = element.getChildren("display-group");
		Iterator iter = displaygroups.iterator();
		while (iter.hasNext()) {
			Element e = (Element) iter.next();
			configdef.addDisplayGroup(this.elementToDisplayGroup(e));
		}

		return configdef;
	}

	private DisplayGroup elementToDisplayGroup(Element element) {

		DisplayGroup displaygroup = new DisplayGroup();

		displaygroup.setName(element.getAttributeValue("name"));
		displaygroup.setKey(element.getAttributeValue("key"));

		List displaygroups = element.getChildren("property-def");
		Iterator iter = displaygroups.iterator();
		while (iter.hasNext()) {
			Element e = (Element) iter.next();
			displaygroup.addPropertyDef(this.elementToPropertyDef(e));
		}

		return displaygroup;
	}

	private PropertyDef elementToPropertyDef(Element element) {

		PropertyDef prop = new PropertyDef();

		prop.setName(element.getAttributeValue("name"));
		prop.setKey(element.getAttributeValue("key"));
		prop.setType(element.getChildText("type"));
		prop.setDefaultValue(element.getChildText("default-value"));
		prop.setEvent(element.getChildText("event"));

		// optional elements
		if (element.getChild("rows") != null)
			prop.setRows(element.getChildText("rows"));

		if (element.getChild("cols") != null)
			prop.setCols(element.getChildText("cols"));

		return prop;
	}

	/*
	 * Unmarshall the given input stream into our defined set of Java objects.
	 */
	public RuntimeConfigDefs unmarshall(InputStream instream) throws IOException, JDOMException {

		if (instream == null)
			throw new IOException("InputStream is null!");

		RuntimeConfigDefs configs = new RuntimeConfigDefs();

		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(instream);

		Element root = doc.getRootElement();
		List configdefs = root.getChildren("config-def");
		Iterator iter = configdefs.iterator();
		while (iter.hasNext()) {
			Element e = (Element) iter.next();
			configs.addConfigDef(this.elementToConfigDef(e));
		}

		return configs;
	}

}
