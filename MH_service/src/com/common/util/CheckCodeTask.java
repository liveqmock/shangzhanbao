/**
 * com.gomai.common.util
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-8-1 		大勇
 *
 * Copyright (c) 2013, gomai.
*/

package com.common.util;

import java.util.TimerTask;

import com.itour.etip.pub.frame.SpringContextHelper;

/**
 *
 * @author   大勇
 * @version  
 * @Date	 2013-8-1 上午9:56:26
 */
public class CheckCodeTask extends TimerTask {

	
	@Override
	public void run() {
		OrderCodeSetter.setDay();
	}

}

