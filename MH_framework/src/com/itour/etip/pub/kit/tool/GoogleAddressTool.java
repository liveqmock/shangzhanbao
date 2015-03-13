package com.itour.etip.pub.kit.tool;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.URIUtil;

public class GoogleAddressTool {

	public static JSONObject setAddressToHotel(String address){
		
		JSONObject myObj = new JSONObject();
		
		HttpClient client = new HttpClient();
		
		GetMethod method = new GetMethod("http://ditu.google.cn/maps/geo");
		try {
			method.setQueryString(URIUtil.encodeQuery("q="+address));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			myObj.put("success", false);
			return myObj;
		}
		
		String response = null;
		try {
			client.executeMethod(method);
			response = method.getResponseBodyAsString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			method.releaseConnection();
			myObj.put("success", false);
			return myObj;
		} 
		method.releaseConnection();
		if(response == null || "".equals(response.trim())){
			myObj.put("success", false);
			return myObj;
		}
		
		JSONArray array;
		try {
			JSONObject obj = JSONObject.fromObject(response);

			array = (obj.getJSONArray("Placemark").getJSONObject(0)).getJSONObject("Point").getJSONArray("coordinates");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myObj.put("success", false);
			return myObj;
		}
		//经度
		String longitude = array.getString(1);
		//纬度
		String dimensionality = array.getString(0);
		
		System.out.println("返回字符串：经度："+longitude+"  纬度："+dimensionality);
		
		myObj.put("success", true);
		myObj.put("longitude", longitude);
		myObj.put("dimensionality", dimensionality);
		return myObj;
			
	}
	
}
