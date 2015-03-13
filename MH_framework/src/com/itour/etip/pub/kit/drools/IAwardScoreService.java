package com.itour.etip.pub.kit.drools;


/**
 * 奖赏积分的接口。
 * @author lishan
 */
public interface IAwardScoreService {
	/**
	 * 奖赏积分
	 * 系统自动响应积分事件，添加积分记录，在奖赏积分后，自动计算会员上的总分。
	 * @param item
	 */
	public void awardScore(AwardScoreData item); 
}
