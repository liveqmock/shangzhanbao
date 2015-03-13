package com.mini.give.persistence;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.give.data.UserInfoData;
/**
 * 发布权管理久化层接口实现类
 * 
 * @author     林海鹏
 * @see        UserInfoDataPersistence
 * @since      
 */
@SuppressWarnings("unchecked")
@Component("userInfoDataPersistence")
public class UserInfoDataPersistence extends BasePersistence<UserInfoData> implements IUserInfoDataPersistence {

	@Override
	public void addUserInfo(UserInfoData data) {
		add(data);
	}

	@Override
	public void deleteUserInfo(String[] ids) {
		delete(ids);
	}

	@Override
	public void editUserInfo(UserInfoData data) {
	    update(data);
	}

	@Override
	public List<UserInfoData> getUserInfoData(JSONObject json) {
		StringBuffer querySQL = new StringBuffer("select nvl((tryprivilege-alreadytryprivilege),0)expiretry,nvl((payprivilege+alreadyupgrade),0)payment,nvl(tryprivilege,0)tryprivilege,nvl(payprivilege,0)payprivilege, nvl(alreadytryprivilege,0)alreadytryprivilege,nvl(alreadypayprivilege,0)alreadypayprivilege,nvl(overdueprivilege,0)overdueprivilege,nvl(alreadyupgrade,0)alreadyupgrade,nvl(renew,0)renew,nvl(givenum,0)givenum from(select nvl(sum(bd. tryprivilege) ,0)tryprivilege, nvl(sum(bd.payprivilege),0) payprivilege, nvl(sum(bd.alreadytryprivilege),0) alreadytryprivilege,  nvl(sum(bd.alreadypayprivilege),0) alreadypayprivilege, nvl(sum(bd.overdueprivilege),0) overdueprivilege,nvl(sum(bd.alreadyupgrade),0) alreadyupgrade,  nvl(sum(bd.renew),0) renew,  nvl(sum(bd.givenum),0) givenum from mini_user_info bd)");
		querySQL.append(this.getInquiresTheConditions(json));
		JdbcDao dao = (JdbcDao) SpringContextHelper.getBean("jdbc");
		List<ETIPResultSet> list =dao.queryForList(querySQL.toString(), null);
		List<UserInfoData> userInfolist = new ArrayList<UserInfoData>();
		for (int i = 0; i < list.size(); i++) {
			UserInfoData userInfoData = new UserInfoData();
			//已使用的付费权限
			userInfoData.setAlreadyPayPrivilege(list.get(i).getInt("ALREADYPAYPRIVILEGE"));
			//已使用的试用期权限
			userInfoData.setAlreadyTryPrivilege(list.get(i).getInt("ALREADYTRYPRIVILEGE"));
			//已升级的试用权限数量
			userInfoData.setAlreadyUpgrade(list.get(i).getInt("ALREADYUPGRADE"));
			//已过期的使用权限数量
			userInfoData.setOverduePrivilege(list.get(i).getInt("OVERDUEPRIVILEGE"));
			//付费权限总数
			userInfoData.setPayment(list.get(i).getInt("PAYMENT"));
			//付费的权限数量
			userInfoData.setPayPrivilege(list.get(i).getInt("PAYPRIVILEGE"));
			//续费数
			userInfoData.setRenew(list.get(i).getInt("RENEW"));
			//试用期权限数总量
			userInfoData.setTryPrivilege(list.get(i).getInt("TRYPRIVILEGE"));
			//到期数权限总数
			userInfoData.setExpiretry(list.get(i).getInt("EXPIRETRY"));
			//赠送数
			userInfoData.setGiveNum(list.get(i).getInt("GIVENUM"));
			userInfolist.add(userInfoData);
		}
		return userInfolist;
	}

	private Object getInquiresTheConditions(JSONObject json) {
		StringBuffer whereSQL = new StringBuffer();
		if (json != null && !json.isNullObject()) {
			if (null != json.get("id")) {
				String id = json.getString("id");
				if (id != null && !"".equals(id))
					whereSQL.append(" AND bd.id = '").append(id).append("'");
			}
			if (null != json.get("give")) { //是否是赠送
				String id = json.getString("give");
				if (id != null && !"".equals(id))
					whereSQL.append(" AND bd.give = '").append(id).append("'");
			}
			if (null != json.get("condition")) { //条件
				String condition = json.getString("condition");
				if (condition != null && !"".equals(condition))
					whereSQL.append(" AND bd.condition = '").append(condition).append("'");
			}
			if (null != json.get("creatorId")) { //创建者id
				String creatorId = json.getString("creatorId");
				if (creatorId != null && !"".equals(creatorId))
					whereSQL.append(" AND bd.creatorId = '").append(creatorId).append("'");
			}
			if (null != json.get("createTime")) { //创建时间
				String createTime = json.getString("createTime");
				if (createTime != null && !"".equals(createTime))
					whereSQL.append(" AND bd.createTime = to_date('").append(createTime.substring(0, createTime.lastIndexOf("."))).append("','yyyy-mm-dd hh24:mi:ss')");
			}
			if (null != json.get("userid")) { //用户id
				String userid = json.getString("userid");
				if (userid != null && !"".equals(userid))
					whereSQL.append(" AND bd.userId = '").append(userid).append("'");	
			}

			
		}
		
		return whereSQL.toString();
	}

	@Override
	public List<UserInfoData> getUserInfo(JSONObject json) {
		StringBuffer querySQL = new StringBuffer(" From  UserInfoData bd where 1=1");
		querySQL.append(this.getInquiresTheConditions(json));
		return search(querySQL.toString());
	}

	@Override
	public void updateUserInfo(JSONObject json) {
		StringBuffer querySQL = new StringBuffer(" update mini_user_info a set");
		if (null != json.get("payprivilege")) { //用户id
			int payprivilege = json.getInt("givenum");
			if (payprivilege != 0 && !"".equals(payprivilege))
				querySQL.append("  a.payprivilege =nvl(a.payprivilege,0)+ '").append(payprivilege).append("'");	
		}
		if (null != json.get("givenum")) { //用户id
			int givenum = json.getInt("givenum");
			if (givenum != 0)
				querySQL.append(" , a.givenum =nvl(a.givenum,0)+ '").append(givenum).append("'");	
		}
		querySQL.append("where a.userid in(select bd.userid from mini_give bd where 1=1 ");
		querySQL.append(this.getInquiresTheConditions(json)).append(")");
		executeSQL(querySQL.toString());
	}

    @Override
    public List<UserInfoData> getUserInfoData(UserInfoData userInfoData) {
        //定义查询的hql语句
        StringBuffer hql = new StringBuffer("from UserInfoData where 1=1");
        //定义存放参数的集合
        List<Object> list = new ArrayList<Object>();
        if(userInfoData.getUserId()!=null && !"".equals(userInfoData.getUserId())){
            hql.append(" and userId = ?");
            list.add(userInfoData.getUserId());
        }
        List<UserInfoData> datas = this.search(hql.toString(), list);
        return datas;
    }

    @Override
    public void updateUserInfo(UserInfoData userInfoData) {
        this.update(userInfoData);
    }

	
	
}
