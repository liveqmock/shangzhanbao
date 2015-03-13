package com.itour.etip.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.list.TreeList;

import com.itour.etip.common.util.ProductTool;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.exception.ETIPException;
import com.itour.etip.pub.kit.tool.DateTool;

/**
 * 酒店动态信息维护时的，公共模型，用于下列两种情况
 * 
 * @在添加酒店动态信息草稿模型时使用。
 * @在审批通过酒店动态信息时使用。
 * @author lishan
 * 
 */
public class SplitModelTool {

	// 持久化对象
	ISplitablePersistence splitableDataPersistence;

	public ISplitablePersistence getSplitableDataPersistence() {
		return splitableDataPersistence;
	}

	public void setSplitableDataPersistence(
			ISplitablePersistence splitableDataPersistence) {
		this.splitableDataPersistence = splitableDataPersistence;
	}

	/**
	 * 保存或更新sourceList数据，检查与targetList是否存在交叉，如果存在交叉那么拆分target数据
	 * 
	 * @param sourceList
	 *            保存或更新的sourceList数据
	 * @param targetList
	 *            已经存在的数据
	 */
	public void split(List<SplitableData> sourceList, String extendWhere) {
		// 检查，此处有问题。
		for (SplitableData source : sourceList) {
			split(source, extendWhere);
		}
		//
	}

	/**
	 * 添加一条记录。
	 * 
	 * @param source
	 */
	public void split(SplitableData source, String extendWhereConditions) {
		
		String startDateStr = DateTool.format(source.getEffectBeginTime(),
				"yyyyMMdd");
		String endDateStr = DateTool.format(source.getEffectEndTime(),
				"yyyyMMdd");
		String className = source.getClass().getCanonicalName();
		String hql = "from " + className
				+ " where effectBeginTime <= to_date('" + endDateStr
				+ "','yyyyMMdd') and effectEndTime>=to_date('" + startDateStr
				+ "','yyyyMMdd') and PROVIDERID='"+source.getProviderId()+"' " + extendWhereConditions;
		List<SplitableData> targetList = splitableDataPersistence.search(hql);
		split(source, targetList);
	}

	/**
	 * 保存或更新source数据，检查与targetList是否存在交叉，如果存在交叉那么拆分target数据
	 * 
	 * @param source
	 *            保存或更新的source数据
	 * @param targetList
	 *            已经存在的数据
	 */
	public void split(SplitableData source, List<SplitableData> targetList) {
		List<SplitableData> newList = new TreeList();
		if (targetList != null && targetList.size() > 0) {
			for (SplitableData target : targetList) {
				List<SplitableData> rv = split(source, target);
				for (SplitableData newItem : rv) {
					newList.add(newItem);
				}
			}
		} else {
			splitableDataPersistence.add(source);
			newList.add(source);
		}

		// 后置处理targetList,如果targetList中有被删除的数据，那么需要去掉；然后将newList中数据添加到targetList中。
		for (SplitableData item : targetList) {
			if (!item.isDeleted()) {
				newList.add(item);
			}
		}
		// 清空targetList
		targetList.clear();
		// 以下将newList中内容替换到targetList中
		for (SplitableData item : newList) {
			targetList.add(item);
		}

	}

	/**
	 * 保存或更新source数据，检查与target是否存在交叉，如果存在交叉那么拆分target数据
	 * 
	 * @param source
	 *            保存或更新的source数据
	 * @param target
	 *            已经存在的数据
	 * @return 新产生单记录，需要添加targetList中继续处理，
	 */
	private List<SplitableData> split(SplitableData source, SplitableData target) {
		if (target == null)
			throw new ETIPException("SplitableDataCanNotCompareToNull");
		if (source.getEffectBeginTime() == null
				|| source.getEffectEndTime() == null
				|| target.getEffectBeginTime() == null
				|| target.getEffectEndTime() == null)
			throw new ETIPException("TheSplitDataCanNotBeNull");
		// 以下要精确到日期，不能直接取time
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		long xd1 = 0l;
		long xd2 = 0l;
		long yd1 = 0l;
		long yd2 = 0l;
		try {
			xd1 = format.parse(format.format(source.getEffectBeginTime()))
					.getTime();
			xd2 = format.parse(format.format(source.getEffectEndTime()))
					.getTime();
			yd1 = format.parse(format.format(target.getEffectBeginTime()))
					.getTime();
			yd2 = format.parse(format.format(target.getEffectEndTime()))
					.getTime();
		} catch (Exception ex) {
			// 此例外不可能发生
			throw new ETIPException("PeriodCompareFoundDateFormatException");
		}
		List<SplitableData> newList = new TreeList();
		HashMap<Long, List<SplitableData>> rvMap = new HashMap<Long, List<SplitableData>>();
		if (xd1 == yd1 && xd2 == yd2) {
			sourceEqualsTarget(source, target, newList);
		} else if (xd1 < yd1 && xd2 >= yd1 && xd2 < yd2) {
			sourceInterBeforeTarget(source, target, newList);
		} else if (xd1 > yd1 && xd1 <= yd2 && xd2 > yd2) {
			// split(target)={target1,target2};delete(target);add(target1);add(source);
			sourceInterAfterTarget(source, target, newList);
		} else if (xd1 <= yd1 && xd2 >= yd2) {// 此处条件其实有冗余
			sourceIncludeTarget(source, target, newList);
		} else if (xd1 >= yd1 && xd2 <= yd2) {
			targetIncludeSource(source, target, newList);
		} else
			throw new ETIPException("FoundOtherPeriodCompareType");
		return newList;
	}

	private void targetIncludeSource(SplitableData source,
			SplitableData target, List newList) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long xd1 = 0l;
		long xd2 = 0l;
		long yd1 = 0l;
		long yd2 = 0l;
		try {
			xd1 = format.parse(format.format(source.getEffectBeginTime()))
					.getTime();
			xd2 = format.parse(format.format(source.getEffectEndTime()))
					.getTime();
			yd1 = format.parse(format.format(target.getEffectBeginTime()))
					.getTime();
			yd2 = format.parse(format.format(target.getEffectEndTime()))
					.getTime();
		} catch (Exception ex) {
			// 此例外不可能发生
			throw new ETIPException("PeriodCompareFoundDateFormatException");
		}
		int releaseState = source.getReleaseState();
		if (releaseState == 1 || releaseState == 2) {
			// split(target)={target1,source,target2},delete(target),add(target1),add(source),add(target2);
			SplitableData target1, target2;
			target1 = target.clone();
			target2 = target.clone();
			if (xd1 != yd1) {
				target1.setEffectEndTime(new Date(xd1 - 24 * 60 * 60 * 1000));// -1tian
				splitableDataPersistence.add(target1);
				newList.add(target1);
			}
			if (xd2 != yd2) {
				target2.setEffectBeginTime(new Date(xd2 + 24 * 60 * 60 * 1000));// +1tian
				splitableDataPersistence.add(target2);
				newList.add(target2);
			}
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			if (!source.isSaved()) {
				splitableDataPersistence.add(source);
				source.setSaved(true);
				newList.add(source);
			}
			return;
		}
		if(releaseState==3 || releaseState==4){
			// split(target)={target1,target3,target2},delete(target),add(target1),add(source),add(target2);
			SplitableData target1, target2,target3;
			target1 = target.clone();
			target2 = target.clone();
			if (xd1 != yd1) {
				target1.setEffectEndTime(new Date(xd1 - 24 * 60 * 60 * 1000));// -1tian
				splitableDataPersistence.add(target1);
				newList.add(target1);
			}
			if (xd2 != yd2) {
				target2.setEffectBeginTime(new Date(xd2 + 24 * 60 * 60 * 1000));// +1tian
				splitableDataPersistence.add(target2);
				newList.add(target2);
			}
			target3 = target.clone();
			target3.setEffectBeginTime(new Date(xd1));
			target3.setEffectEndTime(new Date(xd2));
			target3.setReleaseState(releaseState);
			splitableDataPersistence.add(target3);
			newList.add(target3);
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
		}
	}

	private void sourceIncludeTarget(SplitableData source,
			SplitableData target, List newList) {
		// delete(target);add(source);
		int releaseState = source.getReleaseState();
		if (releaseState==1 || releaseState==2) {
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			if (!source.isSaved()) {
				splitableDataPersistence.add(source);
				source.setSaved(true);
				newList.add(source);
			}
			return;
		}
		if (releaseState==3 || releaseState==4) {
			target.setReleaseState(releaseState);
			splitableDataPersistence.update(target);
		}
	}

	// source后交叉
	private void sourceInterAfterTarget(SplitableData source,
			SplitableData target, List newList) {
		// split(target,sd2)={target1,target2};delete(target);add(target2);add(source);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long xd1 = 0l;
		long xd2 = 0l;
		long yd1 = 0l;
		long yd2 = 0l;
		try {
			xd1 = format.parse(format.format(source.getEffectBeginTime()))
					.getTime();
			xd2 = format.parse(format.format(source.getEffectEndTime()))
					.getTime();
			yd1 = format.parse(format.format(target.getEffectBeginTime()))
					.getTime();
			yd2 = format.parse(format.format(target.getEffectEndTime()))
					.getTime();
		} catch (Exception ex) {
			// 此例外不可能发生
			throw new ETIPException("PeriodCompareFoundDateFormatException");
		}

		int releaseState = source.getReleaseState();
		if (releaseState==1 || releaseState==2) {
			// 此处需要支持clone.
			SplitableData target1;
			target1 = target.clone();
			target1.setEffectEndTime(new Date(xd1 - 24 * 60 * 60 * 1000));// -1tian
			splitableDataPersistence.add(target1);
			newList.add(target1);
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			if (!source.isSaved()) {
				splitableDataPersistence.add(source);
				source.setSaved(true);
				newList.add(source);
			}
			return;
		}
		if (releaseState==3 || releaseState==4) {
			SplitableData target1, target2;
			target1 = target.clone();
			target2 = target.clone();
			target1.setEffectEndTime(new Date(xd1 - 24 * 60 * 60 * 1000));// -1tian
			target2.setEffectBeginTime(new Date(xd1));// +1tian//失效
			target2.setReleaseState(releaseState);
			splitableDataPersistence.add(target1);
			splitableDataPersistence.add(target2);

			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			newList.add(target1);
			newList.add(target2);
			return;
		}
	}

	// source前交叉
	private void sourceInterBeforeTarget(SplitableData source,
			SplitableData target, List newList) {
		// split(target,sd2)={target1,target2};delete(target);add(target2);add(source);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long xd1 = 0l;
		long xd2 = 0l;
		long yd1 = 0l;
		long yd2 = 0l;
		try {
			xd1 = format.parse(format.format(source.getEffectBeginTime()))
					.getTime();
			xd2 = format.parse(format.format(source.getEffectEndTime()))
					.getTime();
			yd1 = format.parse(format.format(target.getEffectBeginTime()))
					.getTime();
			yd2 = format.parse(format.format(target.getEffectEndTime()))
					.getTime();
		} catch (Exception ex) {
			// 此例外不可能发生
			throw new ETIPException("PeriodCompareFoundDateFormatException");
		}

		int releaseState = source.getReleaseState();
		if (releaseState==1 || releaseState==2) {
			// 此处需要支持clone.
			SplitableData target2;
			target2 = target.clone();
			// target2=target.clone();
			target2.setEffectBeginTime(new Date(xd2 + 24 * 60 * 60 * 1000));// +1tian
			splitableDataPersistence.add(target2);
			newList.add(target2);
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			if (!source.isSaved()) {
				splitableDataPersistence.add(source);
				source.setSaved(true);
				newList.add(source);
			}
			return;
		}
		if (releaseState==3 || releaseState==4) {
			SplitableData target1, target2;
			target1 = target.clone();
			target2 = target.clone();
			target1.setEffectEndTime(new Date(xd2));// 无效
			target1.setReleaseState(releaseState);
			target2.setEffectBeginTime(new Date(xd2 + 24 * 60 * 60 * 1000));// +1tian
			splitableDataPersistence.add(target1);
			splitableDataPersistence.add(target2);
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			newList.add(target1);
			newList.add(target2);
			return;
		}
	}

	/**
	 * 中航信和本地的有效期相等，状态为未发布1和已发布2的删除后保存新数据，状态为冻结3和失效4的则更新
	 * @LZH 根据自己的理解加的注释
	 * @param source
	 * @param target
	 * @param newList
	 */
	private void sourceEqualsTarget(SplitableData source, SplitableData target,
			List newList) {
		// 以下target删除,添加source.
		int releaseState = source.getReleaseState();
		if (releaseState==1 || releaseState==2) {
			splitableDataPersistence.delete(target);
			target.setDeleted(true);
			// 此处需要判断source是否已经添加，如果已经添加，那么不做任何处理
			if (!source.isSaved()) {
				splitableDataPersistence.add(source);
				source.setSaved(true);
				newList.add(source);
			}
			return;
		}
		if (releaseState==3 || releaseState==4) {
			target.setReleaseState(releaseState);
			splitableDataPersistence.update(target);
			return;
		}

	}

	/**
	 * 房型价格信息录入并保存
	 * 
	 * @param jsonRoomPrice
	 *            房型价格信息
	 * 
	 */
	public void saveSplitableDataByJson(JSONObject json, Class splitableClass, String resourceType) {
		resourceType = resourceType.toUpperCase();
		SplitableData data = null;
		String taskID="";
		
		if(json.containsKey("taskID")){
			taskID = json.getString("taskID");
		}
		
		try {
			data = (SplitableData) splitableClass.newInstance();
			data.setTaskID(taskID);
		} catch (Exception ex) {
			// 以下错误不能发生
			throw new ETIPException("cann't create instance of "
					+ splitableClass.toString());
		}

		Date[][] dateList = createDateList(json);
		String[] items = createItems(json, resourceType);

		List<SplitableData> splitables = new ArrayList<SplitableData>();

		data.setJson(json);
		
		for (String id : items) {
			for (Date[] date : dateList) {
				if(date[0] == null)break;
				SplitableData newItem = (SplitableData) data.clone();
				newItem.setEffectBeginTime(date[0]);
				newItem.setEffectEndTime(date[1]);
				if("HS".equals(resourceType) || "HT".equals(resourceType)){
					newItem.setHotelId(id);
				}else if("RS".equals(resourceType) || "RT".equals(resourceType)){
					newItem.setRoomId(id);
				}
				
				splitables.add(newItem);
			}
			StringBuffer extendWhereConditions = new StringBuffer();
			extendWhereConditions.append(" and approvalState = ").append(
					data.getApprovalState());
			if(data.getReleaseState() == 3 || data.getReleaseState() == 4){
				extendWhereConditions.append(" and releaseState = 2");//只有发布状态的可以失效
			}else{
				extendWhereConditions.append(" and releaseState = ").append(
						data.getReleaseState());
			}

			if("HS".equals(resourceType) || "HT".equals(resourceType)){
				extendWhereConditions.append(" and hotelbaseinfoID = '").append(id).append("'");
			}else if("RS".equals(resourceType) || "RT".equals(resourceType)){
				extendWhereConditions.append(" and hotelRoomInfoID = '").append(id).append("'");
			}


			split(splitables, extendWhereConditions.toString());
		}

	}

	private SplitModelTool() {
		splitableDataPersistence = (ISplitablePersistence)SpringContextHelper.getBean("splitableDataPersistence");

//		测试时打开
//		ApplicationContext ctx = null;
//		try{
//			if(ctx == null) {
//				ctx = new FileSystemXmlApplicationContext(
//						new String[]{
//							"WebContent/WEB-INF/configuration/spring/applicationContext-productbeans.xml"
//						});
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		splitableDataPersistence = (ISplitablePersistence)ctx.getBean("splitableDataPersistence");
	}

	private static SplitModelTool instance = null;

	public static SplitModelTool getInstance() {
		if (instance == null) {
			instance = new SplitModelTool();
		}
		return instance;
	}

	/**
	 * 根据参数构造房型
	 * 
	 * @param json
	 * @return
	 */
	private String[] createItems(JSONObject json, String resourceType) {
		if("HS".equals(resourceType) || "HT".equals(resourceType))return createHotels(json);
		if("RT".equals(resourceType))return createRoomsFromTree(json);
		if("RS".equals(resourceType))return createRooms(json);
		return new String[0];
	}
	
	private String[] createRoomsFromTree(JSONObject json) {
		JSONObject formValues = JSONObject.fromObject(json.get("formValues"));
		/*session或默认项*/
		/*房型*/
		Object roomIdObj=json.get("roomId");
		if(roomIdObj==null){
			roomIdObj=formValues.get("roomId");
		}
		String[] roomId=null;
		if(roomIdObj instanceof String){
			roomId=new String[1];
			roomId[0]=(String) roomIdObj;
		}else if(roomIdObj instanceof JSONArray){
			JSONArray jsonArray = JSONArray.fromObject(roomIdObj);
			roomId = new String[jsonArray.size()];
	        for( int i = 0 ; i<jsonArray.size() ; i++ ){
	        	roomId[i] = jsonArray.getString(i);   
	        } 
		}
		/*配额信息维护特殊获取id方式(酒店没有前缀，房型有前缀"_")*/
		if(roomIdObj==null){
			Object idsObj=json.get("ids");
			if(idsObj==null){
				idsObj=formValues.get("ids");
			}
			if(idsObj instanceof String){
				roomId=new String[1];
				roomId[0]=(String) idsObj;
			}else if(idsObj instanceof JSONArray){
				JSONArray jsonArray = JSONArray.fromObject(idsObj);
				List<String> idList=new ArrayList<String>();
				for(int i = 0 ; i<jsonArray.size() ; i++){
		        	String id = jsonArray.getString(i);
		        	/*(酒店没有前缀，房型有前缀"_")*/
		        	if(id.indexOf("_")>=0){
		        		idList.add(id.substring(id.indexOf("_")+1));
		        	}
		        } 
				roomId = new String[idList.size()];
		        for(int j = 0 ; j<idList.size() ; j++ ){
		        	roomId[j]=idList.get(j);
		        }
			}
		}
		return roomId;
	}
	
	private String[] createHotels(JSONObject json) {
		/*session或默认项*/
		/*酒店基本信息外键*/
		JSONObject formValues = JSONObject.fromObject(json.get("formValues"));
		
		Object hotelIdObj=json.get("hotelId");
		if(hotelIdObj==null){
			hotelIdObj=formValues.get("hotelId");
		}
		String[] hotelId=null;
		if(hotelIdObj instanceof String){
			hotelId=new String[1];
			hotelId[0]=(String) hotelIdObj;
		}else if(hotelIdObj instanceof JSONArray){
			JSONArray jsonArray = JSONArray.fromObject(hotelIdObj);
			hotelId = new String[jsonArray.size()];   
	        for( int i = 0 ; i<jsonArray.size() ; i++ ){   
	        	hotelId[i] = jsonArray.getString(i);   
	        } 
		}
		/*配额信息维护特殊获取id方式(酒店没有前缀，房型有前缀"_")*/
		if(hotelIdObj==null){
			Object idsObj=json.get("ids");
			if(idsObj==null){
				idsObj=formValues.get("ids");
			}
			if(idsObj instanceof String){
				hotelId=new String[1];
				hotelId[0]=(String) idsObj;
			}else if(idsObj instanceof JSONArray){
				JSONArray jsonArray = JSONArray.fromObject(idsObj);
				List<String> idList=new ArrayList<String>();
				for(int i = 0 ; i<jsonArray.size() ; i++){
		        	String id = jsonArray.getString(i);
		        	/*(酒店没有前缀，房型有前缀"_")*/
		        	if(id.indexOf("_")<0){
		        		idList.add(id);
		        	}
		        } 
				hotelId = new String[idList.size()];
		        for(int j = 0 ; j<idList.size() ; j++ ){
		        	hotelId[j]=idList.get(j);
		        }
			}
		}
		return hotelId;
	}
	private String[] createRooms(JSONObject json) {
		/* 页面输入项 */
		/* 批量操作公共信息 */
		JSONObject formValues = JSONObject.fromObject(json.get("formValues"));

		/* session或默认项 */
		/*--酒店房型信息外键*/
		Object roomIdObj = json.get("roomId");
		if (roomIdObj == null) {
			roomIdObj = formValues.get("roomId");
		}
		String[] roomId = null;
		if (roomIdObj instanceof String) {
			roomId = new String[1];
			roomId[0] = (String) roomIdObj;
		} else if (roomIdObj instanceof JSONArray) {
			JSONArray jsonArray = JSONArray.fromObject(roomIdObj);
			roomId = new String[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				roomId[i] = jsonArray.getString(i);
			}
		}
		return roomId;
	}
	/**
	 * 根据起始日期和星期创建时间段
	 * 
	 * @return
	 */
	private Date[][] createDateList(JSONObject json) {
		JSONObject formValues = JSONObject.fromObject(json.get("formValues"));
		String beginDateStr = (String) formValues.get("effectBeginTime");
		String endDateStr = (String) formValues.get("effectEndTime");
		Object week = formValues.get("week");
		Date beginDate = ProductTool.stringToDate(beginDateStr,
				"yyyy-MM-dd HH:mm:ss");
		beginDate.setHours(0);
		beginDate.setMinutes(0);
		beginDate.setSeconds(0);
		Date endDate = ProductTool.stringToDate(endDateStr,
				"yyyy-MM-dd HH:mm:ss");
		endDate.setHours(0);
		endDate.setMinutes(0);
		endDate.setSeconds(0);
		String[] weekdays = null;
		if (week instanceof String) {
			weekdays = new String[1];
			weekdays[0] = (String) week;
		} else if (week instanceof JSONArray) {
			JSONArray jsonArray = JSONArray.fromObject(week);
			weekdays = new String[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				weekdays[i] = jsonArray.getString(i);
			}
		}
		Date[][] dateList = ProductTool.getDayList_Unite(beginDate, endDate,
				weekdays);
		return dateList;

	}

}
