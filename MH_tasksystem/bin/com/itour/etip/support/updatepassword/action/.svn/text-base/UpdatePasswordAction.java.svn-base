package com.itour.etip.support.updatepassword.action;

import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.support.updatepassword.facade.UpdatePasswordFacade;

public class UpdatePasswordAction extends FrmAction{
	
	private UpdatePasswordFacade updatePasswordFacade;

	public UpdatePasswordFacade getUpdatePasswordFacade() {
		return updatePasswordFacade;
	}

	public void setUpdatePasswordFacade(UpdatePasswordFacade updatePasswordFacade) {
		this.updatePasswordFacade = updatePasswordFacade;
	}

	public String validatePassword(){
	
		String password = request.getParameter("password");
		if(password!=null && !("".equals(password))){
			boolean flag = updatePasswordFacade.validatePassword(password);
			if(flag){
				setJson("{success:true}");
			}else{
				setJson("{success:false}");
			}
		}
		return null;
	}
	
	public String updatePassword(){
		JSONObject obj = (JSONObject)getJson();
		String password = obj.getString("newPassword");
		updatePasswordFacade.updatePassword(password);
		setJson("{success:true}");
		return null;
	}
	
}
