package com.itour.etip.support.updatepassword.facade;

import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmFacade;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.exception.ETIPException;

public class UpdatePasswordFacade extends FrmFacade {

	public boolean validatePassword(String password) {

		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");

		String etipUserID = FrmUser.getUser().etipUserID;

		String sql = "select e.certvalue from etipcertificate e where e.etipuserid ='"
				+ etipUserID + "'";

		List<ETIPResultSet> list = jdbc.queryForList(sql, null);

		if (list.size() == 0 || list.size() > 1) {
			throw new ETIPException("系统数据错误");
		}
		String value = list.get(0).getString("CERTVALUE");

		if (password.equals(value)) {
			return true;
		} else {
			return false;
		}

	}

	public void updatePassword(String password) {
		JdbcDao jdbc = (JdbcDao) SpringContextHelper.getBean("jdbc");
		String etipUserID = FrmUser.getUser().etipUserID;
		String sql = "update etipcertificate e set e.certvalue='" + password
				+ "' where e.etipuserid='" + etipUserID + "' and e.certtype=1";
		jdbc.executeSQL(sql);
		String sql2 = "update etipoperator e set e.password='"+password+"' where e.id =(select a.memberid from etipuser a where a.id = '"+etipUserID+"')";
		jdbc.executeSQL(sql2);
	}

}
