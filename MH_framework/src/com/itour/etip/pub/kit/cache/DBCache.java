package com.itour.etip.pub.kit.cache;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Vector;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import com.itour.etip.pub.frame.DaoFactory;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.xml.XMLDataBean;

/**
 * 数据库缓冲区基础类，子类有DBMemCache---有分布式支持,DBLocalCache---无分布式支持
 * 
 * @author lishan
 * 
 */
public abstract class DBCache extends ETIPCache {

	private DaoFactory daoFactory = null;

	class DBDicModel extends XMLDataBean {

		private static final long serialVersionUID = 1L;

		TreeMap<Object, Object> currentObject = null;

		Vector<Object> items = new Vector<Object>();

		public void expandAttributeNode(Attr attr) {
		}

		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();

			if (tag.equals("dbdic")) {
				parseChildNodes(node, null);
			} else if (tag.equals("section")) {
				parseChildNodes(node, null);
			} else if (tag.equals("object")) {
				currentObject = new TreeMap<Object, Object>();
				items.clear();
				String currentTable = node.getAttribute("Table");
				currentObject.put("Name", node.getAttribute("Name"));
				currentObject.put("Table", currentTable);
				currentObject.put("Where", node.getAttribute("Where"));
				parseChildNodes(node, null);
				if (currentTable.equalsIgnoreCase("/MULTI/"))
					multiTableConfig();
				else
					singleTableConfig();
			} else if (tag.equals("item")) {
				TreeMap<Object, Object> item = new TreeMap<Object, Object>();
				items.addElement(item);
				String type = node.getAttribute("Type");
				item.put("Type", type);
				item.put("Name", node.getAttribute("Name"));
				item.put("Column", node.getAttribute("Column"));
				item.put("Table", node.getAttribute("Table"));
			}
		}

		private void multiTableConfig() {
			StringBuffer whereClause = new StringBuffer();
			StringBuffer selectStr = new StringBuffer();
			selectStr.append("select ");
			TreeMap<Object, Object> tableMap = new TreeMap<Object, Object>();
			String joinKey = null;
			String tableName = null;
			String colType = null;
			for (int i = 0; i < items.size(); i++) {
				if (i > 0) {
					selectStr.append(",");
				}
				tableName = (String) ((TreeMap) items.elementAt(i)).get("Table");
				colType = (String) ((TreeMap) items.elementAt(i)).get("Type");
				if (colType.equalsIgnoreCase("KEY")) {
					joinKey = (String) ((TreeMap) items.elementAt(i)).get("Column");
					selectStr.append(tableName);
					selectStr.append(".");
					selectStr.append(joinKey);
					selectStr.append(" , ");
					selectStr.append("");
					selectStr.append(joinKey);
				} else {
					selectStr.append(tableName);
					selectStr.append(".");
					selectStr.append((String) ((TreeMap) items.elementAt(i)).get("Column"));
				}
				tableMap.put(tableName, null);
			}

			Set set = tableMap.keySet();
			Iterator iterator = set.iterator();
			String firstTableName = null;
			whereClause.append(" where ");
			int j = 0;
			while (iterator.hasNext()) {
				String tempString = iterator.next().toString();
				if (j == 0) {
					firstTableName = tempString;
					selectStr.append(" from ");
				} else if (j == 1) {
					whereClause.append(firstTableName);
					whereClause.append(".");
					whereClause.append(joinKey);
					whereClause.append("=");
					whereClause.append(tempString);
					whereClause.append(".");
					whereClause.append(joinKey);
				} else {
					whereClause.append(" and ");
					whereClause.append(firstTableName);
					whereClause.append(".");
					whereClause.append(joinKey);
					whereClause.append("=");
					whereClause.append(tempString);
					whereClause.append(".");
					whereClause.append(joinKey);
				}
				if (j > 0) {
					selectStr.append(",");
				}
				selectStr.append(tempString);
				j++;
			}
			String configWhere = (String) currentObject.get("Where");
			if (whereClause.length() > 7 && configWhere != null && configWhere.length() > 0) {
				whereClause.append(" and ");
				whereClause.append(configWhere);
			} else if (whereClause.length() == 7 && configWhere != null && configWhere.length() > 0) {
				whereClause.append(configWhere);
			}
			if (whereClause.length() > 7)
				selectStr.append(whereClause);

			List<ETIPResultSet> rs = null;
			try {
				rs = ((JdbcDao) daoFactory.getDao("jdbc")).queryForList(selectStr.toString().trim(), null);
			} catch (ETIPException Ex) {
				Ex.printStackTrace();
				System.exit(0);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(0);
			}
			for (int i = 0; i < rs.size(); i++) {
				if (items.size() == 2) {
					String key = null;
					String value = null;
					String combinekey = null;
					int mvalue = 0;
					int mcombinekey = 0;
					int mkey = 0;
					for (int k = 0; k < items.size(); k++) {
						String type = (String) ((TreeMap) items.elementAt(k)).get("Type");
						String name = (String) ((TreeMap) items.elementAt(k)).get("Column");
						if (type.equalsIgnoreCase("KEY")) {

							key = rs.get(i).getString(name);
							combinekey = rs.get(i).getString(name);
						} else
							value = rs.get(i).getString(name);
						if (value != null) {
							mcombinekey = Integer.parseInt(combinekey);
							mvalue = Integer.parseInt(value);
							mkey = mcombinekey - mvalue;
							key = Integer.toString(mkey) + "/" + Integer.toString(mvalue);
						}
					}
					tableMap.put(key, value);
				} else {
					String key = null;
					Vector record = new Vector();
					for (int k = 0; k < items.size(); k++) {
						String type = (String) ((TreeMap) items.elementAt(k)).get("Type");
						String name = (String) ((TreeMap) items.elementAt(k)).get("Column");
						if (type.equalsIgnoreCase("KEY")) {
							key = rs.get(i).getString(name);
						} else {
							String value = rs.get(i).getString(name);
							record.addElement(value);
						}
					}
					tableMap.put(key, record);
				}
			}
			String mapName = (String) currentObject.get("Name");
			addDBCache(mapName, tableMap);
		}

		private void singleTableConfig() {
			StringBuffer selectStr = new StringBuffer();
			StringBuffer whereClause = new StringBuffer();
			selectStr.append("select ");
			for (int i = 0; i < items.size(); i++) {
				if (i > 0) {
					selectStr.append(",");
				}
				String colName1 = (String) ((TreeMap) items.elementAt(i)).get("Column");
				colName1 = getKeysSql(colName1, "//");
				selectStr.append(colName1);
			}
			selectStr.append(" from ");
			String tableName1 = (String) currentObject.get("Table");
			int index = tableName1.lastIndexOf("/");
			if (index != -1) {
				tableName1 = tableName1.substring(index + 1);
			}
			selectStr.append(tableName1);
			whereClause.append(" where ");
			String configWhere = (String) currentObject.get("Where");
			if (configWhere != null && configWhere.length() > 0) {
				whereClause.append(configWhere);
			}
			if (whereClause.length() > 7)
				selectStr.append(whereClause);
			TreeMap tableMap = new TreeMap();

			String tempSQL = selectStr.toString().trim();
			List<ETIPResultSet> rs = null;
			try {
				rs = ((JdbcDao) daoFactory.getDao("jdbc")).queryForList(tempSQL, null);
			} catch (ETIPException Ex) {
				Ex.printStackTrace();
				System.exit(0);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.exit(0);
			}
			for (int i = 0; i < rs.size(); i++) {

				String key = null;
				TreeMap map = new TreeMap();
				for (int j = 0; j < items.size(); j++) {
					String type = (String) ((TreeMap) items.elementAt(j)).get("Type");
					String name = (String) ((TreeMap) items.elementAt(j)).get("Column");
					if (type.equalsIgnoreCase("KEY")) {
						key = rs.get(i).getString(name);

					} else {
						String value = rs.get(i).getString(name);

						map.put(name, value);
					}
				}
				tableMap.put(key, map);
			}
			String tableName = (String) currentObject.get("Table");
			String cacheName = (String) currentObject.get("Name");
			addDBCache(cacheName, tableMap);
		}

		private String getKeysSql(String colNames, String splitChars) {
			StringTokenizer tok = new StringTokenizer(colNames, splitChars);
			String colName = tok.nextToken();
			int size = tok.countTokens();
			if (size == 0)
				return colName;
			StringBuffer buf = new StringBuffer(colName);
			for (int i = 0; i < size; i++)
				buf.insert(0, "concat(concat(").append(",'").append(splitChars).append("'),").append(tok.nextToken())
						.append(")");
			buf.append(" ").append(colNames);
			return buf.toString();
		}

	}

	public DBCache() {
		super();
	}

	public void loadFromFile() throws ETIPException {
		DBDicModel model = new DBDicModel();
		model.setXMLFile(curCacheFile);
		model.parseFromXML();
		fileDomMapping.put(curCacheFile, model);
	}

	public void saveCache() throws ETIPException {
		DBDicModel model = new DBDicModel();
		model.setXMLFile(curCacheFile);
		model.saveToXML();
	}

	/**
	 * 获取数据库缓冲区
	 * 
	 * @param cacheName
	 *            缓冲区名称
	 * @return 缓冲区对象
	 */
	public abstract TreeMap getDBCache(String cacheName);

	/**
	 * 添加一个完整的缓冲区
	 */
	public abstract void addDBCache(String cacheName, TreeMap map);

	/**
	 * 新增到数据库缓冲区，如果关键已经存在，那么就是替换缓冲区内容。
	 * 
	 * @param cacheName
	 *            缓冲区名称
	 * @param key
	 *            主键
	 * @param dbData
	 *            缓冲区值
	 */
	public abstract void addRecordToDBCache(String cacheName, String key, TreeMap dbData);

	/**
	 * 从缓冲区中删除
	 * 
	 * @param cacheName
	 *            缓冲区名称
	 * @param key
	 *            关键字
	 */
	public abstract void removeRecordFromDBCache(String cacheName, String key);

	/**
	 * 更新数据到DBCache
	 * 
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void addToCache(String cacheName, String key, TreeMap value) {
		if (cacheName == null || key == null || value == null)
			return;

		TreeMap cacheMap = CacheUtil.getInstance().dbCache.getDBCache(cacheName);
		if (cacheMap == null) {
			return;
		}

		synchronized (cacheMap) {
			cacheMap.put(key, value);
		}
	}

	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/**
	 * 获取dataName对应的cache实例，并且将cache值转换为json格式
	 * 
	 * @param dataName
	 * @return String JSON格式的字符串数组
	 */
	public String getDBString(String cacheName) {
		TreeMap<Object, Object> map = this.getDBCache(cacheName);

		Object[] keys = map.keySet().toArray();
		Map entry = null;
		String value = null;

		// String entry;
		StringBuffer data = new StringBuffer();
		for (Object key : keys) {
			entry = (Map) map.get(key);
			// 此处entry仍然是一个map,如果有多个属性值，需要拼接成为一个字符串。
			value = "";
			Object[] values = entry.values().toArray();
			for (Object valueItem : values) {
				value = value + "" + valueItem;
			}

			if (data.toString().length() > 0) {
				data.append(",").append("['").append(key).append("'").append(",").append("'").append(value)
						.append("']");
			} else {

				data.append("[").append("['").append(key).append("'").append(",").append("'").append(value)
						.append("']");
			}
		}
		data.append("]");
		return data.toString();
	}
}
