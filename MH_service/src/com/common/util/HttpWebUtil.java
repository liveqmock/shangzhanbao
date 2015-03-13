package com.common.util;

import java.io.IOException;

public class HttpWebUtil {
    private static final String INTERFACE_PATH = ResouceUtil.getProperty("domain.properties", "ctnPath");
	/**
	 *网页抓取方法
	 * 
	 * @paramurlString要抓取的url地址
	 * @param charset
	 *            网页编码方式
	 * @param timeout
	 *            超时时间
	 * @return 抓取的网页内容
	 * @throws IOException抓取异常
	 */
	public static String GetWebContent(String urlString, final String charset,
			int timeout) throws IOException {
//		if (urlString == null || urlString.length() == 0) {
//			return "";
//		}
//		urlString = (urlString.startsWith("http://") || urlString
//				.startsWith("https://")) ? urlString : ("http://" + urlString)
//				.intern();
//		URL url = new URL(urlString);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setDoOutput(true);
//		conn.setRequestProperty("Pragma", "no-cache");
//		conn.setRequestProperty("Cache-Control", "no-cache");
//
//		int temp = Integer.parseInt(Math.round(Math.random()
//				* (UserAgent.length - 1))
//				+ "");
//		conn.setRequestProperty("User-Agent", UserAgent[temp]); // 模拟手机系统
//		conn
//				.setRequestProperty("Accept",
//						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");// 只接受text/html类型，当然也可以接受图片,pdf,*/*任意，就是tomcat/conf/web里面定义那些
//		conn.setConnectTimeout(timeout);
//		try {
//			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//				return "";
//			}
//		} catch (Exception e) {
//			try {
//				System.out.println(e.getMessage());
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//			return "";
//		}
//		InputStream input = conn.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(input,
//				charset));
//		String line = null;
//		StringBuffer sb = new StringBuffer("");
//		while ((line = reader.readLine()) != null) {
//			sb.append(line).append("\r\n");
//		}
//		if (reader != null) {
//			reader.close();
//		}
//		if (conn != null) {
//			conn.disconnect();
//		}
//		return sb.toString();
	    return null;
	}

	public static String[] UserAgent = {
			"Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.2",
			"Mozilla/5.0 (iPad; U; CPU OS 3_2_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B500 Safari/531.21.11",
			"Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18121",
			"Nokia5700AP23.01/SymbianOS/9.1 Series60/3.0",
			"UCWEB7.0.2.37/28/998", "NOKIA5700/UCWEB7.0.2.37/28/977",
			"Openwave/UCWEB7.0.2.37/28/978",
			"Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/989" };

	
	public static void main(String[] args) throws IOException {
		
		
		String str = HttpWebUtil.GetWebContent("http://10.101.0.101:8080/ws_services/MiniForWS/wsGetAllProduct", "utf-8", 10);
		str = str.replace("&lt;", "<");
		str = str.substring(str.indexOf("<ns1:return>")+12,str.indexOf("</ns1:return>"));
		
		System.out.println(str);
	}
	/**
	 * 
	 * 调用ctn webService获取ctn数据<br>
	 * 
	 * @author 冯鑫 <br> 
	 *		   2014-4-10
	 * @update 
	 * @param String url
	 * @return  String 返回值未json字符换！
	 * @exception/throws IOException
	 */
	public static String getCTNJsonData(String url) throws IOException{
//	    url = INTERFACE_PATH+url;
//	    String str = null;
//	    str = HttpWebUtil.GetWebContent(url, "utf-8", 1000);
//        if(str!=null&&!"".equals(str)){
//            str = str.replace("&lt;", "<");
//            str = str.substring(str.indexOf("<return>")+8,str.indexOf("</return>"));   
//            return str;
//        }
	    return "";
	}
}
