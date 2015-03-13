/**
 * com.itour.etip.pub.frame
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-1-14 		何大勇
 *
 * Copyright (c) 2013, gomai.
*/

package com.itour.etip.pub.frame;

import java.util.List;

/**
 *
 * @author   何大勇
 * @version  
 * @date	 2013-1-14 下午04:28:23
 */
public class JsonWithPageRoll {

	public static String toList(PageRoll pageRoll,List<?> list){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"pageRoll\":");
		stringBuffer.append(Json.beanToJsonWithoutField(pageRoll, new String[]{"list","parameters","searchSQL","countSQL"}));
		stringBuffer.append(",\"list\":");
		stringBuffer.append(Json.listToJson(list));
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
}

