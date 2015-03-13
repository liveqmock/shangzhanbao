package com.sys.user.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.common.util.PasswordUtil;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.sys.user.facade.UserFacade;
import com.util.HttpWebUtil;

/**
 * 用户登陆修改密码
 * @author WangShengWei LiuLei 
 */
public class UserLoginAction extends FrmAction {
	@Resource(name="userFacade")
	private UserFacade userFacade;
	
	/**
	 * 登陆
	 * 2:此邮箱未注册
	 * 0：邮箱正确 密码错误
	 * 1：登录成功
	 */
	public void userLogin(){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String resultCode = "0";//用户名或者密码不正确
		String str = "";
		resultCode = userFacade.checkLogin(account, password);
		if("2".equals(resultCode)){
            try {
               //调用ctn借口完成账户信息同步
                str = HttpWebUtil.getCTNJsonData("wsGetUserDate?loginMail="+account);
                if(null!=str&&!"".equals(str)){
                    //如果当前需要登陆的用户 在ctn库中存在且在minipage库中不存在  则将此用户同步到minipage库中
                    if(!"0".equals(str)){
                        JSONObject jsonStr = JSONObject.fromObject(str);
                        userFacade.addUserBySQL(jsonStr);
                        if(PasswordUtil.encodePassword(password).equals(jsonStr.getString("passWord"))){
                           
                            resultCode="1";
                        }else{
                        
                            resultCode="0";
                        }
                        
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		JSONObject returnObj = new JSONObject();
		returnObj.accumulate("resultCode", resultCode);
		setJson(returnObj.toString());
	}
	
	/**
	 * 修改密码
	 */
	public void changePassword(){
		String userID = request.getParameter("userID");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");

		String resultCode = "";
		try{
			//根据用户ID获取用户密码
			StringBuffer querySQL = new StringBuffer("SELECT PASSWORD FROM TB_SYS_USER");
			querySQL.append("WHERE ID = '").append(userID).append("'");
				
			JdbcDao dao = (JdbcDao)SpringContextHelper.getBean("jdbc");
			List<ETIPResultSet> resultSet = dao.queryForList(querySQL.toString(), null);
			if(resultSet!=null && resultSet.size()!=0){
				ETIPResultSet pass = resultSet.get(0);
				String password = (String) pass.get("PASSWORD");
				//对比原密码是否正确
				if(password!=null && password.equals(PasswordUtil.encodePassword(oldPass))){
					//修改密码
					StringBuffer updateSQL = new StringBuffer("UPDATE TB_SYS_USER");
					updateSQL.append(" SET PASSWORD= '").append(PasswordUtil.encodePassword(newPass))
						.append("' WHERE ID = '").append(userID).append("'");
					dao.executeSQL(updateSQL.toString());
					resultCode = "0";//正常,已修改
				}else{
					resultCode = "1";//原密码不正确
				}
			}else{
				resultCode = "2";//用户信息异常
			}
		}catch( Exception e){
			resultCode = "3";//系统异常
		}
		JSONObject returnObj = new JSONObject();
		returnObj.accumulate("resultCode", resultCode);
		setJson(returnObj.toString());
	}

}
