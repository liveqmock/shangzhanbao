/********************************************************
  Copyright (C), 2009-2010, eTIP.
  File name:    com/itour/etip/kit/rule/ruleBaseFactory.java
  Description:  规则库代理工厂类，根据给定参数，创建规则库的代理。
  Author: LiuShuwei      Version:  1.0.0  Date: 2009.4.7
  History:     
    1. Date:
       Author:
       Modification:
    2. ...
********************************************************/

package com.itour.etip.pub.kit.rule;

import org.drools.RuleBase;
import org.drools.agent.RuleAgent;

public class ruleBaseFactory {

	/**
	 * 规则引擎的配置文件类路径，
	 **/
	private String confPath = null;
	private static RuleAgent agent = null;

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String confPath) {
		this.confPath = confPath;
	}

	/**
	 * 
	 * @return
	 */
	public RuleBase getRuleBase(){
		/**
		 * 避免重复加载
		 */
		if ( agent == null ){
			agent = RuleAgent.newRuleAgent(confPath);
		}
		return agent.getRuleBase();
		
	}
}
