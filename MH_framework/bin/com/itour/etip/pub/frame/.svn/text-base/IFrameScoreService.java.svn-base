package com.itour.etip.pub.frame;

import com.itour.etip.pub.base.IService;

/**
 * 积分支付兑换记录bo接口
 * 
 * @author Administrator
 * 
 */

public interface IFrameScoreService extends IService {
	/**
	 * 获取总积分
	 * 
	 * @param memberType
	 * 			会员类型：1.个体会员。2.组织会员。3.组织成员
	 * @param memberID
	 * 			会员编号：etipsuerid
	 * @return int
	 */
	public int getMemberTotalScore(int memberType, String memberID);

	/**
	 * 获取会员可消费积分
	 * @param memberType
	 * 			会员类型：1.个体会员。2.组织会员。3.组织成员
	 * @param memberID
	 * 			会员编号：etipsuerid
	 * @return int
	 */
	public int getMemberConsumableScore(int memberType, String memberID);
}
