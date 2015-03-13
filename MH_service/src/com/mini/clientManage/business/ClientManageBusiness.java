package com.mini.clientManage.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.common.util.Encrypt;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.FrmBusiness;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.sys.user.data.UserData;
import com.sys.user.persistence.IUserPersistence;

/**
 * 客户管理业务接口实现类
 * 
 * @author 文东
 * @see ClientManageBusiness
 * @since
 */
@Component("clientManageBusiness")
public class ClientManageBusiness extends FrmBusiness implements IClientManageBusiness {

    // 客户管理持久化层接口
    @Resource(name = "userPersistence")
    private IUserPersistence userPersistence;

    @Override
    public void addClient(UserData userData) {
        userData.setCreateTime(new Date());
        userData.setUserState(1);
        userData.setPasswordtext(userData.getPassWord());
        // 将用户密码md5加密
        userData.setPassWord(Encrypt.getMD5Str(userData.getPassWord(), null));
        userPersistence.add(userData);
    }

    @Override
    public List<UserData> searchAllClient(PageRoll pageRoll, UserData userData,String type,Integer sort) {
        List<Object> objects = new ArrayList<Object>();// 定义一个Object类型的数据用以存放参数
        // 定义查询的sql
        StringBuffer sql = new StringBuffer(
                "select *from (select u.*," +
                " coalesce(i.payprivilege, 0) as buyPubNum," +
                " coalesce(i.ALREADYPAYPRIVILEGE, 0) as yiPubNum," +
                " coalesce(i.pcount, 0) as pcount," +
                " coalesce(o.scount, 0) as scount" +
                " from ctn_sysuser u" +
                " left join (select u.id as pid, count(u.id) as pcount" +
                " from ctn_sysuser u, mini_page mp  where u.id = mp.user_id   group by u.id) i on u.id = i.pid" +
                " left join (select u.id as sid, count(u.id) as scount from ctn_sysuser u, mini_page mp  where u.id = mp.user_id  and mp.status = 1 group by u.id) o on u.id = o.sid" +
                " left join mini_user_info i on i.USERID = u.id   where u.usertype = 2) k  where 1 = 1");
       
        
        // 根据登录邮箱进行模糊查询
        if (userData.getLoginMail() != null && !"".equals(userData.getLoginMail())) {
            sql.append(" and k.loginmail like ?");
            objects.add("%" + userData.getLoginMail() + "%");
        }
        // 根据注册时间进行模糊查询
        if (userData.getCreateTime() != null) {
            sql.append(" and k.createtime > ?");
            objects.add(userData.getCreateTime());
        }
        if (userData.getModifyTime() != null) {
            sql.append(" and k.createtime < ?");
            objects.add(userData.getModifyTime());
        }
        // 查询用户是否购买过发布权限
        if (userData.getBuyPubNum()!= null) {
            if(userData.getBuyPubNum()==0){
                sql.append("  and( k.buyPubNum  = 0  and k.yiPubNum = 0 )");
            }else if(userData.getBuyPubNum()==1){
                sql.append("  and (k.buyPubNum  <> 0  or k.yiPubNum <> 0)");
            }
        }
        if(null!=userData.getIsprivilege()){
            if(userData.getIsprivilege()==1){
                sql.append(" and isprivilege="+userData.getIsprivilege());
            }else{
                sql.append(" and isprivilege <> 1");
            }
            
        }
        if(type!=null && !"".equals(type)){
        	if(type.equals("createTime")){
        		 sql.append(" order by k.createtime ");
        	}
        	if(type.equals("pcount")){
       		 sql.append(" order by pcount ");
       	}
        	if(type.equals("scount")){
          		 sql.append(" order by scount ");
          	}
        	if(sort==0){
        	    sql.append("desc");
            }
        }
        pageRoll.setSearchSQL(sql.toString());
        pageRoll.setCountSQL("select count(*) from (" + sql.toString() + ")");
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> resultSet = jdbcDao.search(pageRoll, objects);// 查询到的结果
        // 用户集合
        List<UserData> datas = new ArrayList<UserData>();
        for (int i = 0; i < resultSet.size(); i++) {
            UserData data = new UserData();
            data.setId(resultSet.get(i).getString("ID"));
            data.setAddType(resultSet.get(i).getInt("ADDTYPE"));
            data.setCreateTime(resultSet.get(i).getDate("CREATETIME"));
            data.setLoginMail(resultSet.get(i).getString("LOGINMAIL"));
            data.setLoginMoble(resultSet.get(i).getString("LOGINMOBLE"));
            data.setUserState(resultSet.get(i).getInt("USERSTATE"));
            data.setPageNum(resultSet.get(i).getString("PCOUNT"));
            data.setPubPageNum(resultSet.get(i).getString("SCOUNT"));
            data.setBuyPubNum(resultSet.get(i).getInt("BUYPUBNUM") +resultSet.get(i).getInt("YIPUBNUM") );
            datas.add(data);
        }
        return datas;
    }

    @Override
    public void delClient(String[] clientIds) {
        // 删除主键id在clientIds数组中的所有客户信息
        userPersistence.delete(clientIds);
    }

    @Override
    public UserData searchClient(UserData userData) {
        // 定义查询的sql
        StringBuffer sql = new StringBuffer(
                "select * from  (select u.*,coalesce(i.pcount,0) as pcount,coalesce(o.scount,0) as scount,coalesce(p.ycount,0) as ycount from ctn_sysuser u left join "
                        + "(select u.id as pid, count(u.id) as pcount from ctn_sysuser u,mini_page mp where u.id = mp.user_id group by u.id) i on u.id = i.pid "
                        + "left join "
                        + "(select u.id as sid, count(u.id) as scount from ctn_sysuser u,mini_page mp where u.id = mp.user_id and mp.status = 1 group by u.id) o on u.id=o.sid"
                        + " left join "
                        + "(select u.id as yid, count(u.id) as ycount from mini_privilege e,ctn_sysuser u where u.id = e.userid and e.type = '1' and e.give is null group by u.id) p on u.id = p.yid "
                        + "where u.usertype = 2) k where 1=1");
        // 判断id是否有值
        if(userData.getId()!=null && !"".equals(userData.getId())){
            sql.append(" and k.id = ?");
        }
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> resultSet = jdbcDao.queryForList(sql.toString(), new Object[]{userData.getId()});// 查询到的结果
        // 用户集合
        List<UserData> datas = new ArrayList<UserData>();
        for (int i = 0; i < resultSet.size(); i++) {
            UserData data = new UserData();
            data.setPassWord(resultSet.get(i).getString("PASSWORD"));
            data.setId(resultSet.get(i).getString("ID"));
            data.setAddType(resultSet.get(i).getInt("ADDTYPE"));
            data.setBuyPubNum(resultSet.get(i).getInt("YCOUNT"));
            data.setCreateTime(resultSet.get(i).getDate("CREATETIME"));
            data.setLoginMail(resultSet.get(i).getString("LOGINMAIL"));
            data.setLoginMoble(resultSet.get(i).getString("LOGINMOBLE"));
            data.setUserState(resultSet.get(i).getInt("USERSTATE"));
            data.setPageNum(resultSet.get(i).getString("PCOUNT"));
            data.setPubPageNum(resultSet.get(i).getString("SCOUNT"));
            datas.add(data);
        }
        if(datas.size() > 0){
            return datas.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void editClient(UserData userData) {
        JSONObject obj = new JSONObject();
        obj.put("userID", userData.getId());
        // 根据ID 查询客户信息
        List<UserData> datas = userPersistence.getAllUserInfo(obj);
        if(datas.size() == 1){
            userData.setPasswordtext(userData.getPassWord());
            // 判断传进来的密码是否是已经加密的密码
            if(userData.getPassWord() != null && !"".equals(userData.getPassWord()) && !userData.getPassWord().equals(datas.get(0).getPassWord())){
                String passWord = Encrypt.getMD5Str(userData.getPassWord(), null);
                datas.get(0).setPassWord(passWord);
            }
            datas.get(0).setLoginMail(userData.getLoginMail());
        }
        userPersistence.update(datas.get(0));
    }
    /**
     * 
     * 根据用户id查询用户对象实体<br>
     * 
     * @author 冯鑫 <br> 
     *         2014-5-23
     * @update 
     * @param UserData userData
     * @return  UserData
     */
    public UserData findUserDataById(UserData userData){
        return userPersistence.retrieve(userData.getId());
    }

}
