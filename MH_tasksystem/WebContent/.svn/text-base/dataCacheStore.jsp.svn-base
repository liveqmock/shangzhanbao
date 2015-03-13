<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
	 /*
	  * 特殊方法，用于获取数据库中数据字典的函数，不过此处参数是dicCode,而不是dicName
	  */
	public String getTreeDicJsonString(String dicCode) {
//	 System.out.println("dicCode:"+dicCode+);
		//java.util.Map dicMap = com.itour.etip.pub.kit.cache.CacheUtil.getInstance().dbCache.getDBCache("GeneralDic");
		java.util.Map dicMap = new java.util.HashMap();
	   
		Object[] keys = dicMap.keySet().toArray();
		String jsonStr = "";
		for (int i = 0; i < keys.length; i++) {
			String key = (String) keys[i];

			if (key.indexOf(dicCode) >= 0) {
				java.util.Map record = (java.util.Map) dicMap.get(key);
				jsonStr = jsonStr + ",{dicCode:'" + record.get("DICCODE") + "',attrCode:'" + record.get("ATTRCODE")
						+ "',attrName:'" + record.get("ATTRNAME") + "'}";
			}
		}
		if (jsonStr.length() > 0) {
			jsonStr = "[" + jsonStr.substring(1) + "]";

		}
		return jsonStr;
	}
	
	/**
	 * 获取dataName对应的cache实例，并且将cache值转换为json格式
	 * 
	 * @param dataName
	 * @return String JSON格式的字符串数组
	 */
	public String getDicJsonString(String myAttrCode) {
		//java.util.Map dicMap = com.itour.etip.pub.kit.cache.CacheUtil.getInstance().dbCache.getDBCache("GeneralDic");
		java.util.Map dicMap = new java.util.HashMap();;
		Object[] keyObjs = dicMap.keySet().toArray();

		if (keyObjs.length == 0) {
			return "[]";
		}
		String dicCode = null;
		// String entry;
		StringBuffer data = new StringBuffer();
		for (Object keyObj : keyObjs) {
			String key = (String) keyObj;
			java.util.Map record = (java.util.Map) dicMap.get(key);
			String attrCode = (String) record.get("ATTRCODE");
			String attrName = (String) record.get("ATTRNAME");
			if (myAttrCode.equals(attrCode)) {
				dicCode = key;
			}
			// 如果未找到字典记录，继续找下一个。
			if (dicCode == null)
				continue;

			// 如果key==dicCode,那么说明是当前节点不要
			// 如果key.indexOf(dicCode)>=0,说明key是dicCode的子节点。
			// 如果key.length()-dicCode.length()=2,说明key是dicCode的一级子节点

			if (key.equals(dicCode))
				continue;
			if (key.indexOf(dicCode) < 0)
				continue;
			if ((key.length() - dicCode.length()) != 2)
				continue;
			if (key.indexOf(dicCode) != 0) {
				continue;
			}
			// 此处只是取dicCode的一级子节点
			if (data.toString().length() > 0) {
				data.append(",").append("['").append(attrCode).append("'").append(",").append("'").append(attrName)
						.append("']");
			} else {
				data.append("[").append("['").append(attrCode).append("'").append(",").append("'").append(attrName)
						.append("']");
			}
		}

		if (data.toString().length() == 0) {
			return "[]";
		} else {
			data.append("]");
			return data.toString();
		}
	}
%>
<%
	/** 
	 * 以下代码初始化数据库字典
	 */
/*************************************************************
    try{
    String insertSQL=null;
    String s1 = null;
    String parentID="0101";
	String attrCode1=null;
	String attrName=null;
	String dicType=null;
	com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao)com.itour.etip.pub.frame.SpringContextHelper.getBean("jdbc");
	String sql="select attrName from generaldic where attrcode='Country'";
	java.util.List<com.itour.etip.pub.frame.ETIPResultSet> rv = dao.queryForList(sql,null);
	if(rv.size()==0){
		  
		  insertSQL = "insert into generaldic(id,parentid,dictype,diccode,attrcode,attrname) values('01','','world','01','Country','世界')";
	      dao.executeSQL(insertSQL); 
	      insertSQL = "insert into generaldic(id,parentid,dictype,diccode,attrcode,attrname) values('0101','01','country','0101','China','中国')";
	      dao.executeSQL(insertSQL); 
	      
		  java.io.FileReader reader = new java.io.FileReader("c:/citys.csv");
		  java.io.BufferedReader br = new java.io.BufferedReader(reader);
		 
		  boolean zhixiashixiaqu=false;//直辖市辖区
		  while((s1 = br.readLine()) != null) {
			 java.util.StringTokenizer tokens = new java.util.StringTokenizer(s1,",");
  			 attrCode1 = "0101"+tokens.nextToken();
  			 attrName = tokens.nextToken();
  			 
			 if(attrCode1.length()==6){//北京市
			 	dicType = "province";
			 	parentID = "0101";//中国
			 }
			 if(attrCode1.length()==8){//市辖区
			 	dicType = "city";
			 	if(attrName.equals("市辖区")||attrName.equals("县")){//如果是市辖区，那么就不保存。
			 		//此处不能添加，但是需要设置parentID
			 		zhixiashixiaqu=true;
			 		parentID = attrCode1.substring(0,attrCode1.length()-2);
			 		continue;
			 	}
			 	else {//石家庄市
			 		zhixiashixiaqu=false;
				 	parentID = attrCode1.substring(0,attrCode1.length()-2);//各个省直辖市
			 	}
			 }
  			 if(attrCode1.length()==10){
			 	dicType = "district"; 
			 	if(attrName.equals("市辖区")||attrName.equals("县")){//此处不能添加，但是需要设置parentID
			 		continue;
			 	}
			 	if(zhixiashixiaqu==false){
				 	parentID = attrCode1.substring(0,attrCode1.length()-2);
			 	}
			 }
			 
			 String dicCode1 = attrCode1;
			 String ID=attrCode1;
			  insertSQL = "insert into generaldic(id,parentid,dictype,diccode,attrcode,attrname) values('"+ID+"','"+parentID+"','"+dicType+"','"+dicCode1+"','"+attrCode1+"','"+attrName+"')";
			  dao.executeSQL(insertSQL);	  
		  }
		  
		 br.close();
		 reader.close();
	}
	
}catch(Exception ex){
  ex.printStackTrace();
  return;
}
************************************************/


	
	String data="";
	//检查是错误
	String errorCode = request.getParameter("errorCode");
	if(errorCode!=null&&errorCode.trim().length()>0){
		String errorName = request.getParameter("errorName");
		String errorCause = request.getParameter("errorCause");
		String errorSolution = request.getParameter("errorSolution");
		//此处调用Cache更新函数，更新错误代码
		java.util.Map errorMap = new java.util.HashMap();
		errorMap.put("code",errorCode);
		errorMap.put("name",errorName);
		errorMap.put("cause",errorCause);
		errorMap.put("solution",errorSolution);
		//System.out.println("error:"+errorMap);
		com.itour.etip.pub.kit.cache.CacheUtil.errorCache.refreshErrorConfig(errorMap);
		response.getWriter().write("{success:true}");
		return;
	}
	
	
	
	String dbAttrCode = request.getParameter("dbAttrCode");
	if(dbAttrCode!=null&&dbAttrCode.trim().length()>0){
		data = com.itour.etip.pub.kit.cache.CacheUtil.getInstance().getCacheStringByAttrCode(dbAttrCode);
		response.getWriter().write(data);
		return;
	}
	
	/**
	 * 查询积分购买汇率
	 */
	String buyScoreRate = request.getParameter("BuyScoreRate");
	if(buyScoreRate!=null){
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao)com.itour.etip.pub.frame.SpringContextHelper.getBean("jdbc");
		java.util.List<com.itour.etip.pub.frame.ETIPResultSet> rv = dao.queryForList("select exchangeMoney from ScoreExchangeRule where exchangeType=3",null);//配置工作流后需要添加状态
		double rate=0.2;
		if(rv==null||rv.size()==0){
			rate=0.2;
		}
		else{
			rate = rv.get(0).getDouble("EXCHANGEMONEY")/(double)1000;
		}
		response.getWriter().write("{BuyScoreRate:"+rate+"}");
		return;
	}
	
	
	/**
	 * 此处批量构造dataStore，为了提高效率
	 */
	String cacheNames = request.getParameter("cacheNames");
	if(cacheNames!=null){
		StringBuffer dataBuffer = new StringBuffer();
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(cacheNames,",");
		String cacheName = "";
		String cacheData; 
		dataBuffer.append("[");
		while (tokens.hasMoreTokens()){
			cacheName = tokens.nextToken();
			cacheData=com.itour.etip.pub.kit.cache.CacheUtil.dataCache.getDataString(cacheName);
			if(dataBuffer.toString().trim().length()==1)
				dataBuffer.append("{").append(cacheName).append(":").append(cacheData).append("}");
			else
				dataBuffer.append(",{").append(cacheName).append(":").append(cacheData).append("}");
		}
		dataBuffer.append("]"); //取数据
		response.getWriter().write(dataBuffer.toString());
		return;
	}
	
	/**
	 * 此处构造datadic的缓冲，供下拉框使用
	 */
	String cacheName = request.getParameter("cacheName");
	if(cacheName!=null){
		data=com.itour.etip.pub.kit.cache.CacheUtil.dataCache.getDataString(cacheName);
		//System.out.println("cacheName:"+cacheName+"//data:"+data);
		response.getWriter().write(data);
		return;
	}
	
	/**
	 * 此处构造dbcache的缓冲，供下拉框使用
	 */
	String dbCacheName = request.getParameter("dbCacheName");
	if(dbCacheName!=null){
		data=com.itour.etip.pub.kit.cache.CacheUtil.dbCache.getDBString(dbCacheName);
		//System.out.println("cacheName:"+dbCacheName+"//data:"+data);
		response.getWriter().write(data);
		return;
	}
	
	/**
	 * 从数据库字典中取值构造树
	 */
	String dicCode = request.getParameter("dicCode");
	if(dicCode!=null){
		data = getTreeDicJsonString(dicCode);
		//System.out.println("dicCode:"+dicCode+"//data:"+data);
		//此处需要遍历dicMap，获取docCode对应的节点，转化为json数组
		response.getWriter().write(data);
		return;
	}
	//此处从数据库字典中取值，不构造树
	String attrCode = request.getParameter("attrCode");
	if(attrCode!=null){
		data = getDicJsonString(attrCode);
		//System.out.println("attrCode:"+attrCode+"//data:"+data);
		//此处需要遍历dicMap，获取docCode对应的节点，转化为json数组
		response.getWriter().write(data);
		return;
	}	
	//此处从数据库字典中取下一级节点
	String treeId = request.getParameter("treeId");
	if(treeId!=null){
		data = com.itour.etip.pub.kit.cache.CacheUtil.getInstance().getNextTreeNode(treeId);
		//System.out.println("attrCode:"+attrCode+"//data:"+data);
		//此处需要遍历dicMap，获取docCode对应的节点，转化为json数组
		response.getWriter().write(data);
		return;
	}	
	/**
	 * 此处实时查询cacheSql，返回值供下拉框使用
	 */
	String cacheSql = request.getParameter("cacheSql");
	if(cacheSql!=null){
		try{
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao)com.itour.etip.pub.frame.SpringContextHelper.getBean("jdbc");
		//System.out.println(cacheSql);
		java.util.List<com.itour.etip.pub.frame.ETIPResultSet> rv = dao.queryForList(cacheSql,null);
		StringBuffer dataBuffer = new StringBuffer();
		//txc 添加，解决半个括号的问题
		if(rv.size() == 0){
			dataBuffer.append("[");
		}
		for(com.itour.etip.pub.frame.ETIPResultSet record:rv){
			if(dataBuffer.toString().length()>0){
				dataBuffer.append(",").append("['").append(record.getString("CODE")).append("'").append(",").append("'").append(record.getString("NAME")).append("']");
			}
			else {
				
				dataBuffer.append("[").append("['").append(record.getString("CODE")).append("'").append(",").append("'").append(record.getString("NAME")).append("']");
			}
			
		}
		dataBuffer.append("]");
		//System.out.println(dataBuffer);
		response.getWriter().write(dataBuffer.toString());
		}
		catch(Exception ex){
			response.getWriter().write("{success:false,message:"+ex.getMessage()+"}");
		}
		return;
		
	}
	
	//以下代码判断字段值是否重复，系统采用公共函数统一处理。
	
	String validateField = request.getParameter("validateField");
	if(validateField!=null){
		try{
			String fieldValue = java.net.URLDecoder.decode(request.getParameter("fieldValue"),"UTF-8");
			String tableName = validateField.substring(0,validateField.indexOf("."));
			String fieldName = validateField.substring(validateField.indexOf(".")+1);
			String brandCode = null;
			if(request.getParameter("brandCode") != null){
				brandCode = java.net.URLDecoder.decode(request.getParameter("brandCode"),"UTF-8");
			}
			//检查某个表中的值是否存在，此处需要能够兼容品牌，此处改在工具类中完成，当前品牌是谁，与弹屏有关系？
			
			String result = com.itour.etip.common.util.AccountValidateTool.checkOnly(tableName,fieldName,fieldValue,brandCode);
		
			response.getWriter().write(result);
		}
		catch(Exception ex){
			response.getWriter().write("{success:false,message:"+ex.getMessage()+"}");
		}
		
	}
	
	//txc add
	String showDic = request.getParameter("showDic");
	if(showDic!=null){
	try{
		String sql = "select g.attrcode,g.attrname from generaldic g where g.dictype='"+showDic+"'";
		com.itour.etip.pub.frame.JdbcDao dao = (com.itour.etip.pub.frame.JdbcDao)com.itour.etip.pub.frame.SpringContextHelper.getBean("jdbc");
		java.util.List<com.itour.etip.pub.frame.ETIPResultSet> rv = dao.queryForList(sql,null);
		StringBuffer dataBuffer = new StringBuffer();
		//txc 添加，解决半个括号的问题
		if(rv.size() == 0){
			dataBuffer.append("[");
		}
		for(com.itour.etip.pub.frame.ETIPResultSet record:rv){
			if(dataBuffer.toString().length()>0){
				dataBuffer.append(",").append("['").append(record.getString("ATTRCODE")).append("'").append(",").append("'").append(record.getString("ATTRNAME")).append("']");
			}
			else {
				
				dataBuffer.append("[").append("['").append(record.getString("ATTRCODE")).append("'").append(",").append("'").append(record.getString("ATTRNAME")).append("']");
			}
			
		}
		dataBuffer.append("]");
		//System.out.println(dataBuffer);
		response.getWriter().write(dataBuffer.toString());
		}
		catch(Exception e){
			response.getWriter().write("{success:false,message:"+e.getMessage()+"}");
		}
		return;
	}

	
%>
