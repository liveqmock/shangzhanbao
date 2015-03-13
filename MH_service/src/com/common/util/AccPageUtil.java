package com.common.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.SpringContextHelper;

public class AccPageUtil {

    /**
     * 判断该页面是否可以访问，首先查看页面是否有未付款的服务，如果有，再对比当前访问页面的用户是否和页面的用户id匹配 匹配可以访问，不匹配则无法访问
     * 
     * @param userid
     * @param url
     * @return
     * @throws IOException
     */
    public static String checkPage(String userid, String url) throws IOException {

        /**
         * 第一步根据域名查询出当前访问的page的ID，然后根据pageid查询该page是否发布
         */
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        /* 通过域名查询出pageid 存入到数据库 */
        String sql = "select t.status as STATUS,t.endTime as endTime from mini_page t where t.id in(select p.page_id from MINI_PAGE_INFO_EXTRA p where  p.domain = '"
                + url + "') and t.isDelete=1";
        List<ETIPResultSet> list = jdbcDao.queryForList(sql, null);
        String status = "";
        Date endTime = new Date();
        if (list != null && list.size() > 0) {
            status = list.get(0).getString("STATUS"); // 获取到状态值
            endTime = list.get(0).getDate("ENDTIME");//获取过期时间
        }
        String mes = "";
        if (status != null && !"".equals(status)) {
            if (!"1".equals(status)) {// 如果不是发布状态
                /**
                 * 第三步，如果page没有发布就对比用户的id，如果匹配则让访问
                 */
                String pagesql = "select p.user_id as USERID from mini_Page p where p.id  in(select p.page_id from MINI_PAGE_INFO_EXTRA p where  p.domain = '"
                        + url + "'  and p.status='OPEN') and p.isDelete=1";
                List<ETIPResultSet> pagelist = jdbcDao.queryForList(pagesql, null);
                if (pagelist != null && pagelist.size() > 0 && pagelist.get(0).getString("USERID").equals(userid)) {// 如果未登陆则匹配不上，不让访问
                    if ("2".equals(status)) {
                        mes = "2";
                    } else {
                        mes = "1";
                    }
                } else {
                    mes = "0";
                }
            } else {// 如果发布了则让访问
                if(endTime.getTime() > (new Date()).getTime()){//没有过期
                    mes = "1";
                } else {
                    /*mes = "2";*/
                    mes = "3";
                }
            }
        }
        return mes;
    }

    public static String checkLocal(String local) {

        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");
        /* 通过域名查询出pageid 存入到数据库 */
        String sql = "select a.domain as DOMAIN from mini_page_info_extra a where a.type=2 and a.page_id in(select t.page_id from mini_page_info_extra t where t.domain like '%"
                + local + "%' and t.type=1 and t.status='OPEN')";
        List<ETIPResultSet> list = jdbcDao.queryForList(sql, null);
        if (list != null && list.size() > 0) {
            return "/pagehtml/" + list.get(0).getString("DOMAIN");
        } else {
            return "";
        }
    }

}
