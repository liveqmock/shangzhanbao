package com.itour.etip.common.util;

import java.util.HashMap;
import java.util.Map;

import com.itour.etip.contract.JMSService;


public class DroolTest {
	
	
	
	
	public void testDroolsScore() throws Exception{
		
		for(int i=0;i<100000;i++){
			
			
			try {
//				System.out.println("=giveScore start=");
				/* 构造Drools队列的机票送积分消息 开始 */
				Map<String, String> contentMap = new HashMap<String, String>();
				/* drools的配置文件名 */
				contentMap.put("propertyName", "/ruleagent.properties");
				/* drools规则名称 */
				contentMap.put("factType", "ScoreForOrders.GiveScoreAction");
				/* 通过webservice传递过来的参数 */
				contentMap.put("orderNumber", "0909082027495994");
				contentMap.put("orderType", "01");
				contentMap.put("bookingPersonID", "0E10F686E80E488B9F66B2199DC7E518");
				contentMap.put("scoreSum", "1000");
				contentMap.put("orderDate", "2010-06-07");
				contentMap.put("operatorNumber", "admin");
				contentMap.put("operationType", "01");
				contentMap.put("orderChannel", "02");
							/* 发送机票送积分消息 开始 */
				String queueName = "scoreForAirOrders";
				JMSService jmsService = new JMSService();
				jmsService.sendQueueMessageTwo(queueName, contentMap);
				/* 发送机票送积分消息 结束 */
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Thread.sleep(1500);
			
			
			
		}
		
		
	}
	
}
