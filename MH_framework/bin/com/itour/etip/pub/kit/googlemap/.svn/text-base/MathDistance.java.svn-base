package com.itour.etip.pub.kit.googlemap;


/**
 * 计算距离
 * 
 * @author Leo
 * 
 */
public class MathDistance {

	private static double EARTH_RADIUS = 6378.137;//单位公里km
	
	private static String POINT_ANGLE = "°";//度
	private static String POINT_CENT = "'";//分
	private static String POINT_SECOND = "\"";//秒

	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}
	
	/**
	 * 根据经纬度计算两点距离，参数需要换算成度，1度=60分=3600秒
	 * @param _Longitude1经度1
	 * @param _Latidute1纬度1
	 * @param _Longitude2经度2
	 * @param _Latidute2纬度2
	 * @return 公里
	 */
	public static double getDistance(double lat1, double lng1, double lat2, double lng2){
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;
	   double b = rad(lng1) - rad(lng2);
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
	    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	   s = s * EARTH_RADIUS;
	   s = Math.round(s * 10000) * 0.0001;
	   return s;
	}
	
	/**
	 * 经纬度字符串转换成度数的double类型，例如： 40°15'26.35" 转换后为 40.2573194444
	 * @param pointStr
	 * @return
	 */
	public static double pointStr2Double(String pointStr){
		
		String angleStr,centStr,secondStr;
		double angleD = 0,centD = 0,secondD = 0;
		
		try{
			if(pointStr.indexOf(POINT_ANGLE)>=0){
				angleStr = pointStr.substring(0,pointStr.indexOf(POINT_ANGLE));
				pointStr = pointStr.substring(pointStr.indexOf(POINT_ANGLE)+1);
				if(angleStr!=null && !"".equals(angleStr))angleD = Double.parseDouble(angleStr);
			}

			if(pointStr.indexOf(POINT_CENT)>=0){
				centStr = pointStr.substring(0,pointStr.indexOf(POINT_CENT));
				pointStr = pointStr.substring(pointStr.indexOf(POINT_CENT)+1);
				if(centStr!=null && !"".equals(centStr))centD = Double.parseDouble(centStr);
			}

			if(pointStr.indexOf(POINT_SECOND)>=0){
				secondStr = pointStr.substring(0,pointStr.indexOf(POINT_SECOND));
				pointStr = pointStr.substring(pointStr.indexOf(POINT_SECOND)+1);
				if(secondStr!=null && !"".equals(secondStr))secondD = Double.parseDouble(secondStr);
			}
		}catch(Exception e){}

		return angleD + centD/60 + secondD/3600;
	}
	
	public static void main(String[] args) {
		String point = "'20'N";
		double pointD = pointStr2Double(point);
		
		
		double lat1 = pointStr2Double("40°16'56.28\"N");
		double lng1 = pointStr2Double("116°14'08.69\"E");
		double lat2 = pointStr2Double("40°16'35.54\"N");
		double lng2 = pointStr2Double("116°14'07.17\"E");
		double distanceD = getDistance(lat1, lng1, lat2, lng2);
		System.out.println(lat1);
		System.out.println(lng1);
		System.out.println(lat2);
		System.out.println(lng2);
		
		System.out.println(distanceD);
	}
}
