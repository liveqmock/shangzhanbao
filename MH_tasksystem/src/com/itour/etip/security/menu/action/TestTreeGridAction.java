package com.itour.etip.security.menu.action;

import com.itour.etip.pub.frame.FrmAction;


public class TestTreeGridAction extends FrmAction{
	
	public String getTreeGridList(){
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("[{'company':'纵横天地','price':64.72,'change':0.06,'pct_change':0.09,'last_change':'91 12:00am','_id':1,'_parent':null,'_level':1,'_lft':1,'_rgt':98,'_is_leaf':false}]");
		
		setJson(sb.toString());
		return null;
	}

}
