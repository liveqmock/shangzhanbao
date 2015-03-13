package test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.itour.etip.pub.kit.jms.JMSUtil;

public class DroolTest {
	
	
	
	public void testDrools() throws Exception{
		
		
		for(int i=0;i<100000;i++){
			
			
			// drools规则
			Map<String,Object> factValues = new HashMap<String,Object>();
			
			boolean sy = false;
			
			String rules = "/ruleagent.properties,Rules.RegisterAction";
			
			// 以下把user参数添加进去
			factValues.put("userBaseID", "D4C301EED25D40E496F70AFF18651E58");
			factValues.put("etipUserCardNO", "0000602558");
			factValues.put("etipUserID", "222524");
			factValues.put("userBizRoleID", "1514379");
			factValues.put("isPassivity", 2);
			// 获取指定的drools规则，如果没有指定规则，那么记录一个系统日志，直接返回。
			if (rules != null && rules.trim().length() > 0) {
				rules = rules.trim();
				
				/*
				 * 从事件配置文件中获取规则包，以及事实名称。在配置项中的格式是：[规则包名:事实名]。
				 */
				StringTokenizer tokens = new StringTokenizer(rules, ",");
				if (tokens.countTokens() >= 2){
					JMSUtil.sendToDrools(tokens.nextToken(), tokens.nextToken(),
							sy, factValues);
				}
			}
			
			Thread.sleep(3000);
		}
		
		
		
	}
	
}
