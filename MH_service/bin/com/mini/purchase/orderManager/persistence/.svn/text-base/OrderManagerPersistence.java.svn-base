package com.mini.purchase.orderManager.persistence;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Component;

import com.itour.etip.pub.frame.BasePersistence;
import com.itour.etip.pub.frame.ETIPResultSet;
import com.itour.etip.pub.frame.JdbcDao;
import com.itour.etip.pub.frame.PageRoll;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.mini.domain.data.PageInfoExtraData;
import com.mini.page.data.PageData;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.customerInfo.data.ConSumerUserData;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.orderManager.data.ConSumerOrderData;
import com.mini.purchase.orderManager.data.ConsumerOrderGoodsinfoData;
import com.sys.user.data.UserData;
/**
*
* 消费者订单信息<br> 
*
* @author 冯鑫
* @see OrderManagerPersistence
* @since vmaque1.5
*/
@Component("orderManagerPersistence")
public class OrderManagerPersistence extends BasePersistence<ConSumerOrderData> implements IOrderManagerPersistence {
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        
     * @return List<ConSumerOrderData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConSumerOrderData> getConSumerOrderDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        return null;
    }
    
    /**
     * 
     * 修改订单信息
     * 
     * @author 左香勇 <br> 
     *		   2014-9-12
     * @update 
     * @param [conSumerOrderData]     [修改的订单实体对象]
     * @since vmaque 1.5
     */
    public void updateConsumerOrder(ConSumerOrderData conSumerOrderData){
        this.update(conSumerOrderData);
    }
    
    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息
     * 
     * @author 左香勇 
     *         2014-9-9
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataList(PageRoll pageRoll,ConSumerOrderData conSumerOrderData){
        //定义查询语句
        StringBuffer querySql = new StringBuffer("SELECT ");
        querySql.append("MCG.ID AS ID,MCG.GOODSNUM AS GOODSNUM,");
        querySql.append("MCO.ID AS CONSUMERORDERID,MCO.PRICE AS PRICE,MCO.STATE AS STATE,MCO.CREATETIME AS CREATETIME,MCO.LOGISTICSCOMPANY AS LOGISTICSCOMPANY,MCO.LOGISTICSNUMBER AS LOGISTICSNUMBER,MCO.DELIVERTIME AS DELIVERTIME,");
        querySql.append("MCC.CONFIGNAME AS CONFIGNAME,");
        querySql.append("MGI.GOODSNAME AS GOODSNAME,");
        querySql.append("MCU.USERNAME AS USERNAME,MCU.USERADDRESS AS USERADDRESS,MCU.USERMOBILE AS USERMOBILE ");
        querySql.append("FROM MINI_CONSUMERORDER_GOODSINFO MCG ");
        querySql.append("JOIN MINI_CONSUMERORDER MCO ON MCG.CONSUMERORDERID = MCO.ID ");
        querySql.append("JOIN MINI_COMMODITYCONFIG MCC ON MCG.COMMODITYCONFIGID = MCC.ID ");
        querySql.append("JOIN MINI_GOODSINFO MGI ON MCG.GOODSINFID = MGI.ID ");
        querySql.append("JOIN MINI_CONSUMERUSER MCU ON MCO.CONSUMERUSERID = MCU.ID ");
        querySql.append("JOIN MINI_PAGE_GOODSINFO MPG ON MPG.PAGEID = MCO.PAGEID ");
        querySql.append("WHERE MCG.ISDELETE = 1 AND MCO.ISDELETE = 1 AND MCC.ISDELETE = 1 AND MGI.ISDELETE = 1 AND MCU.ISDELETE = 1 AND MCO.STATE <> 4 ");
        
        //定义查询条件
        StringBuffer where = new StringBuffer("");

        List<Object> objects=new ArrayList<Object>();
        
        //添加查询条件
        if(conSumerOrderData != null){
            
            if(conSumerOrderData.getState() != null){
                where.append(" AND MCO.STATE=?");
                objects.add(conSumerOrderData.getState());
            }
            
            if(conSumerOrderData.getPageId() != null && !conSumerOrderData.getPageId().equals("")){
                where.append("AND MCO.PAGEID=? ");
                objects.add(conSumerOrderData.getPageId());
            }
            querySql.append(where.toString());
        }
        
        
        if(conSumerOrderData.getState() != null){
            querySql.append("ORDER BY MCO.CREATETIME,MCO.PAYTYPE DESC");
        } else {
            querySql.append("ORDER BY MCO.CREATETIME DESC");
        }
        
        //分页查询
        pageRoll.setCountSQL("SELECT COUNT(1) FROM (" + querySql.toString()+")");
        pageRoll.setSearchSQL(querySql.toString());
        
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.search(pageRoll, objects);
        
        List<ConsumerOrderGoodsinfoData> consumerOrderGoodsinfoDatas = new ArrayList<ConsumerOrderGoodsinfoData>();
        
        for (int i = 0; i < rsList.size(); i++) {
            ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = new ConsumerOrderGoodsinfoData();
            ConSumerOrderData  sumerOrderData= new ConSumerOrderData();
            GoodsInfoData goodsInfoData = new GoodsInfoData();
            CommodityConfigData commodityConfigData = new CommodityConfigData();
            ConSumerUserData conSumerUserData = new ConSumerUserData();
            
            conSumerUserData.setUserName(rsList.get(i).getString("USERNAME"));
            conSumerUserData.setUserAddress(rsList.get(i).getString("USERADDRESS"));
            conSumerUserData.setUserMobile(rsList.get(i).getString("USERMOBILE"));
            
            sumerOrderData.setConSumerUserData(conSumerUserData); 
            sumerOrderData.setId(rsList.get(i).getString("CONSUMERORDERID"));
            sumerOrderData.setCreateTime(rsList.get(i).getDate("CREATETIME"));
            sumerOrderData.setPrice(rsList.get(i).getDouble("PRICE"));
            sumerOrderData.setState(rsList.get(i).getInt("STATE"));
            sumerOrderData.setLogisticsCompany(rsList.get(i).getString("LOGISTICSCOMPANY"));
            sumerOrderData.setLogisticsNumber(rsList.get(i).getString("LOGISTICSNUMBER"));
            sumerOrderData.setDeliverTime(rsList.get(i).getDate("DELIVERTIME"));
            
            
            commodityConfigData.setConfigName(rsList.get(i).getString("CONFIGNAME"));
            
            goodsInfoData.setGoodsName(rsList.get(i).getString("GOODSNAME"));
            
            consumerOrderGoodsinfoData.setCommodityConfigData(commodityConfigData);
            consumerOrderGoodsinfoData.setGoodsInfoData(goodsInfoData);
            consumerOrderGoodsinfoData.setConSumerOrderData(sumerOrderData);
            consumerOrderGoodsinfoData.setGoodsNum(rsList.get(i).getInt("GOODSNUM"));
            consumerOrderGoodsinfoData.setId(rsList.get(i).getString("ID"));
            
            consumerOrderGoodsinfoDatas.add(consumerOrderGoodsinfoData);
        }

        return consumerOrderGoodsinfoDatas;
        
    }
    
    /**
     * 
     * 根据处理状态查询计费信息
     * 
     * @author 左香勇 
     *         2014-9-25
     * @update 
     * 
     * @param state     处理状态
     *        pageRoll 分页查询对象
     *        
     * @return List<ConsumerOrderGoodsinfoData> 计费信息
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getAccountList(PageRoll pageRoll,Integer state){
        //定义查询语句
        StringBuffer querySql = new StringBuffer("select * from(SELECT ");
        querySql.append("MCG.ID AS ID,");
        querySql.append("MCO.PAYTYPE AS PAYTYPE,MCO.PRICE AS PRICE,");
        querySql.append("MCO.STATE AS STATE,MCO.PAYTIME AS PAYTIME,");
        querySql.append("MCO.ID AS MCOID,MCO.TRANSFERTIME AS TRANSFERTIME,");
        querySql.append("MCO.TRANSFERPRICE AS TRANSFERPRICE,");
        querySql.append("MCO.TRANSFERPEOPLE AS TRANSFERPEOPLE,");
        querySql.append("ac.receivableaccount AS RECEIVABLEACCOUNT, ");
        querySql.append("ac.accounttype as acctype ");
        querySql.append("FROM MINI_CONSUMERORDER_GOODSINFO MCG ");
        querySql.append("JOIN MINI_CONSUMERORDER MCO ON MCG.CONSUMERORDERID = MCO.ID ");
        querySql.append("JOIN MINI_PAGE MPG ON MCO.PAGEID = MPG.ID ");
        querySql.append("JOIN CTN_SYSUSER CSU ON MPG.USER_ID = CSU.ID ");
        querySql.append("join MINI_ACCOUNTNUMBER ac on ac.userid=csu.id ");
        querySql.append("WHERE MCO.STATE = ? ) ");
        querySql.append("where PAYTYPE=acctype");
        
        List<Object> objects=new ArrayList<Object>();
        objects.add(state);
        
        //分页查询
        pageRoll.setCountSQL("SELECT COUNT(1) FROM (" + querySql.toString()+")");
        pageRoll.setSearchSQL(querySql.toString());
        
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.search(pageRoll, objects);
        
        List<ConsumerOrderGoodsinfoData> consumerOrderGoodsinfoDatas = new ArrayList<ConsumerOrderGoodsinfoData>();
        
        for (int i = 0; i < rsList.size(); i++) {
            ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = new ConsumerOrderGoodsinfoData();
            ConSumerOrderData  sumerOrderData= new ConSumerOrderData();
            UserData userData = new UserData();
            PageData pageData = new PageData();
            
            userData.setReceivableAccount(rsList.get(i).getString("RECEIVABLEACCOUNT"));
            
            pageData.setUserData(userData);
            
            sumerOrderData.setPageData(pageData);
            sumerOrderData.setId(rsList.get(i).getString("MCOID"));
            sumerOrderData.setPrice(rsList.get(i).getDouble("PRICE"));
            sumerOrderData.setState(rsList.get(i).getInt("STATE"));
            sumerOrderData.setPayType(rsList.get(i).getInt("PAYTYPE"));
            sumerOrderData.setPayTime(rsList.get(i).getDate("PAYTIME"));
            sumerOrderData.setTransferPeople(rsList.get(i).getString("TRANSFERPEOPLE"));
            sumerOrderData.setTransferPrice(rsList.get(i).getDouble("TRANSFERPRICE"));
            sumerOrderData.setTransferTime(rsList.get(i).getDate("TRANSFERTIME"));
            
            consumerOrderGoodsinfoData.setConSumerOrderData(sumerOrderData);
            consumerOrderGoodsinfoData.setId(rsList.get(i).getString("ID"));
            
            consumerOrderGoodsinfoDatas.add(consumerOrderGoodsinfoData);
        }

        return consumerOrderGoodsinfoDatas;
        
    }

    /**
     * 
     * 根据查询条件分页查询出符合条件的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-13
     * @update 
     * 
     * @param conSumerOrderData     查询条件实体信息
     *        pageRoll 分页查询对象
     *        userData 用户信息
     *        
     * @return List<ConsumerOrderGoodsinfoData> 符合查询条件商品订单信息集合
     * 
     * @since vmaque 1.5
     * 
     */
    public List<ConsumerOrderGoodsinfoData> getConSumerOrderGoodsInfoDataListBack(PageRoll pageRoll,ConSumerOrderData conSumerOrderData,UserData userData){
        //定义查询语句
        StringBuffer querySql = new StringBuffer("SELECT ");
        querySql.append("MCG.ID AS ID,MCG.GOODSNUM AS GOODSNUM,");
        querySql.append("MCO.ID AS CONSUMERORDERID,MCO.PRICE AS PRICE,MCO.STATE AS STATE,MCO.CREATETIME AS CREATETIME,MCO.LOGISTICSCOMPANY AS LOGISTICSCOMPANY,MCO.LOGISTICSNUMBER AS LOGISTICSNUMBER,MCO.DELIVERTIME AS DELIVERTIME,");
        querySql.append("MCC.CONFIGNAME AS CONFIGNAME,");
        querySql.append("MGI.GOODSNAME AS GOODSNAME,");
        querySql.append("MCU.USERNAME AS USERNAME,MCU.USERADDRESS AS USERADDRESS,MCU.USERMOBILE AS USERMOBILE ");
        querySql.append("FROM MINI_CONSUMERORDER_GOODSINFO MCG ");
        querySql.append("JOIN MINI_CONSUMERORDER MCO ON MCG.CONSUMERORDERID = MCO.ID ");
        querySql.append("JOIN MINI_COMMODITYCONFIG MCC ON MCG.COMMODITYCONFIGID = MCC.ID ");
        querySql.append("JOIN MINI_GOODSINFO MGI ON MCG.GOODSINFID = MGI.ID ");
        querySql.append("JOIN MINI_CONSUMERUSER MCU ON MCO.CONSUMERUSERID = MCU.ID ");
        querySql.append("JOIN MINI_PAGE MPG ON MCO.PAGEID=MPG.ID ");
        querySql.append("JOIN CTN_SYSUSER CSU ON MPG.USER_ID=CSU.ID ");
        querySql.append("WHERE MCG.ISDELETE = 1 AND MCO.ISDELETE = 1 AND MCC.ISDELETE = 1 AND MGI.ISDELETE = 1 AND MCU.ISDELETE = 1 ");
        
        //定义查询条件
        StringBuffer where = new StringBuffer("");

        List<Object> objects=new ArrayList<Object>();
        
        //判断订单对象是否为空，不为空添加查询条件
        if(conSumerOrderData != null){
            
            //判断订单状态是否为空，添加订单状态条件
            if(conSumerOrderData.getState() != null){
                where.append(" AND MCO.STATE=?");
                objects.add(conSumerOrderData.getState());
            }
            
            //判断客户对象是否为空
            if(conSumerOrderData.getConSumerUserData()!=null){
                //判断客户姓名是否为空，添加客户姓名条件
                if(conSumerOrderData.getConSumerUserData().getUserName() != null && !conSumerOrderData.getConSumerUserData().getUserName().equals("")){
                    where.append("AND MCU.USERNAME LIKE '%").append(conSumerOrderData.getConSumerUserData().getUserName()).append("%' ");
                }
                
                //判断客户电话是否为空，添加客户电话条件
                if(conSumerOrderData.getConSumerUserData().getUserMobile() != null && !conSumerOrderData.getConSumerUserData().getUserMobile().equals("")){
                    where.append("AND MCU.USERMOBILE LIKE '%").append(conSumerOrderData.getConSumerUserData().getUserMobile()).append("%' ");
                }
            }
            
        }

        //判断用户对象是否为空，不为空添加查询条件
        if(userData!=null){
            if(userData.getLoginMail()!=null && !userData.getLoginMail().equals("")){
                where.append("AND CSU.LOGINMAIL LIKE '%").append(userData.getLoginMail()).append("%' ");
            }
            
            if(userData.getLoginMoble()!=null && !userData.getLoginMoble().equals("")){
                where.append("OR CSU.LOGINMOBLE LIKE '%").append(userData.getLoginMoble()).append("%' ");
            }
        }

        querySql.append(where.toString());
        //分页查询
        pageRoll.setCountSQL("SELECT COUNT(1) FROM (" + querySql.toString()+")");
        pageRoll.setSearchSQL(querySql.toString());
        
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.search(pageRoll, objects);
        
        List<ConsumerOrderGoodsinfoData> consumerOrderGoodsinfoDatas = new ArrayList<ConsumerOrderGoodsinfoData>();
        
        for (int i = 0; i < rsList.size(); i++) {
            ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = new ConsumerOrderGoodsinfoData();
            ConSumerOrderData  sumerOrderData= new ConSumerOrderData();
            GoodsInfoData goodsInfoData = new GoodsInfoData();
            CommodityConfigData commodityConfigData = new CommodityConfigData();
            ConSumerUserData conSumerUserData = new ConSumerUserData();
            
            conSumerUserData.setUserName(rsList.get(i).getString("USERNAME"));
            conSumerUserData.setUserAddress(rsList.get(i).getString("USERADDRESS"));
            conSumerUserData.setUserMobile(rsList.get(i).getString("USERMOBILE"));
            
            sumerOrderData.setConSumerUserData(conSumerUserData); 
            sumerOrderData.setId(rsList.get(i).getString("CONSUMERORDERID"));
            sumerOrderData.setCreateTime(rsList.get(i).getDate("CREATETIME"));
            sumerOrderData.setPrice(rsList.get(i).getDouble("PRICE"));
            sumerOrderData.setState(rsList.get(i).getInt("STATE"));
            sumerOrderData.setLogisticsCompany(rsList.get(i).getString("LOGISTICSCOMPANY"));
            sumerOrderData.setLogisticsNumber(rsList.get(i).getString("LOGISTICSNUMBER"));
            sumerOrderData.setDeliverTime(rsList.get(i).getDate("DELIVERTIME"));
            
            
            commodityConfigData.setConfigName(rsList.get(i).getString("CONFIGNAME"));
            
            goodsInfoData.setGoodsName(rsList.get(i).getString("GOODSNAME"));
            
            consumerOrderGoodsinfoData.setCommodityConfigData(commodityConfigData);
            consumerOrderGoodsinfoData.setGoodsInfoData(goodsInfoData);
            consumerOrderGoodsinfoData.setConSumerOrderData(sumerOrderData);
            consumerOrderGoodsinfoData.setGoodsNum(rsList.get(i).getInt("GOODSNUM"));
            consumerOrderGoodsinfoData.setId(rsList.get(i).getString("ID"));
            
            consumerOrderGoodsinfoDatas.add(consumerOrderGoodsinfoData);
        }

        return consumerOrderGoodsinfoDatas;
        
    }
    
    /**
     * 
     * 根据订单商品信息中间表Id查询的商品订单信息（后台）
     * 
     * @author 左香勇 
     *         2014-9-15
     * @update 
     * 
     * @param consumerOrderGoodsinfoDataId  订单商品信息中间表id
     *        
     * @return ConsumerOrderGoodsinfoData 订单商品信息中间实体
     * 
     * @since vmaque 1.5
     * 
     */
    public ConsumerOrderGoodsinfoData getConSumerOrderGoodsInfoDataById(String consumerOrderGoodsinfoDataId){
        //定义查询语句
        StringBuffer querySql = new StringBuffer("SELECT ");
        querySql.append("MCG.ID AS ID,MCG.GOODSNUM AS GOODSNUM,");
        querySql.append("MCO.ID AS CONSUMERORDERID,MCO.PRICE AS PRICE,MCO.STATE AS STATE,");
        querySql.append("MCO.CREATETIME AS CREATETIME,MCO.LOGISTICSCOMPANY AS LOGISTICSCOMPANY,");
        querySql.append("MCO.LOGISTICSNUMBER AS LOGISTICSNUMBER,MCO.DELIVERTIME AS DELIVERTIME,");
        querySql.append("MCC.CONFIGNAME AS CONFIGNAME,");
        querySql.append("MGI.GOODSNAME AS GOODSNAME,");
        querySql.append("MCU.USERNAME AS USERNAME,MCU.USERADDRESS AS USERADDRESS,MCU.USERMOBILE AS USERMOBILE,");
        querySql.append("MPE.DOMAIN AS DOMAIN,MPG.NAME AS PAGENAME,");
        querySql.append("CSU.RECEIVABLEACCOUNT AS RECEIVABLEACCOUNT,CSU.ACCOUNTTYPE AS ACCOUNTTYPE,");
        querySql.append("CSU.LOGINMAIL AS LOGINMAIL,CSU.LOGINMOBLE AS LOGINMOBLE ");
        querySql.append("FROM MINI_CONSUMERORDER_GOODSINFO MCG ");
        querySql.append("JOIN MINI_CONSUMERORDER MCO ON MCG.CONSUMERORDERID = MCO.ID ");
        querySql.append("JOIN MINI_COMMODITYCONFIG MCC ON MCG.COMMODITYCONFIGID = MCC.ID ");
        querySql.append("JOIN MINI_GOODSINFO MGI ON MCG.GOODSINFID = MGI.ID ");
        querySql.append("JOIN MINI_CONSUMERUSER MCU ON MCO.CONSUMERUSERID = MCU.ID ");
        querySql.append("JOIN MINI_PAGE MPG ON MCO.PAGEID=MPG.ID ");
        querySql.append("JOIN CTN_SYSUSER CSU ON MPG.USER_ID=CSU.ID ");
        querySql.append("RIGHT JOIN MINI_PAGE_INFO_EXTRA MPE ON MPG.ID=MPE.PAGE_ID ");
        querySql.append("WHERE MCG.ISDELETE = 1 AND MCO.ISDELETE = 1 ");
        querySql.append("AND MCC.ISDELETE = 1 AND MGI.ISDELETE = 1 AND MCU.ISDELETE = 1 ");
        querySql.append("AND MCG.ID = ?");
        
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.queryForList(querySql.toString(), new Object[]{consumerOrderGoodsinfoDataId});
        
        if(rsList.size()>0){
            ConsumerOrderGoodsinfoData consumerOrderGoodsinfoData = new ConsumerOrderGoodsinfoData();
            ConSumerOrderData  sumerOrderData= new ConSumerOrderData();
            GoodsInfoData goodsInfoData = new GoodsInfoData();
            CommodityConfigData commodityConfigData = new CommodityConfigData();
            ConSumerUserData conSumerUserData = new ConSumerUserData();
            PageData pageData = new PageData();
            PageInfoExtraData pageInfoExtraData = new PageInfoExtraData();
            UserData userData = new UserData();
            
            //给登录用户表添加数据
            userData.setAccountType(rsList.get(0).getInt("ACCOUNTTYPE"));
            userData.setReceivableAccount(rsList.get(0).getString("RECEIVABLEACCOUNT"));
            userData.setLoginMail(rsList.get(0).getString("LOGINMAIL"));
            userData.setLoginMoble(rsList.get(0).getString("LOGINMOBLE"));
            
            //给Page信息表添加数据
            pageInfoExtraData.setDomain(rsList.get(0).getString("DOMAIN"));
            
            //给page表添加数据
            pageData.setName(rsList.get(0).getString("PAGENAME"));
            pageData.setUserData(userData);
            pageData.setPageInfoExtra(pageInfoExtraData);
            
            //给订单用户信息表添加数据
            conSumerUserData.setUserName(rsList.get(0).getString("USERNAME"));
            conSumerUserData.setUserAddress(rsList.get(0).getString("USERADDRESS"));
            conSumerUserData.setUserMobile(rsList.get(0).getString("USERMOBILE"));
            
            //给订单表添加数据
            sumerOrderData.setConSumerUserData(conSumerUserData); 
            sumerOrderData.setPageData(pageData);
            sumerOrderData.setId(rsList.get(0).getString("CONSUMERORDERID"));
            sumerOrderData.setCreateTime(rsList.get(0).getDate("CREATETIME"));
            sumerOrderData.setPrice(rsList.get(0).getDouble("PRICE"));
            sumerOrderData.setState(rsList.get(0).getInt("STATE"));
            sumerOrderData.setLogisticsCompany(rsList.get(0).getString("LOGISTICSCOMPANY"));
            sumerOrderData.setLogisticsNumber(rsList.get(0).getString("LOGISTICSNUMBER"));
            sumerOrderData.setDeliverTime(rsList.get(0).getDate("DELIVERTIME"));
            
            //给规格表添加数据
            commodityConfigData.setConfigName(rsList.get(0).getString("CONFIGNAME"));
            
            //给商品表添加数据
            goodsInfoData.setGoodsName(rsList.get(0).getString("GOODSNAME"));
            
            //给订单商品中间表添加数据
            consumerOrderGoodsinfoData.setCommodityConfigData(commodityConfigData);
            consumerOrderGoodsinfoData.setGoodsInfoData(goodsInfoData);
            consumerOrderGoodsinfoData.setConSumerOrderData(sumerOrderData);
            consumerOrderGoodsinfoData.setGoodsNum(rsList.get(0).getInt("GOODSNUM"));
            consumerOrderGoodsinfoData.setId(rsList.get(0).getString("ID"));
            
            
            return consumerOrderGoodsinfoData;
        }

        return null;
        
    }
    
    @Override
    public Integer serachNotProcessOrderNum(String id) {
        // 统计查询待处理订单的订单数量
        StringBuffer stringBuffer = new StringBuffer(
                "SELECT COUNT(1) AS COUNT FROM MINI_CONSUMERORDER MC WHERE MC.PAGEID=? AND MC.STATE = 1 AND MC.ISDELETE = 1");
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> resultSets = jdbcDao.queryForList(stringBuffer.toString(), new Object[]{id});
        if(resultSets.size()>0){
             return resultSets.get(0).getInt("COUNT");
        }
        return 0;
    }
    
    /**
     * 
     * 根据pageid订单状态统计订单数量
     * 
     * @author 左香勇 
     *		   2014-9-12
     * @update 
     * @param [pageId]     [pageid]
     *        [state]   [订单状态]
     * @return  int 订单数量
     * @since vmaque 1.5
     */
    public int serachOrderNum(String pageId,int state){
        StringBuffer querySql = new StringBuffer("SELECT COUNT(1) AS ORDERNUM");
        querySql.append(" FROM MINI_CONSUMERORDER_GOODSINFO MCG ");
        querySql.append("JOIN MINI_CONSUMERORDER MCO ON MCG.CONSUMERORDERID = MCO.ID ");
        querySql.append("JOIN MINI_COMMODITYCONFIG MCC ON MCG.COMMODITYCONFIGID = MCC.ID ");
        querySql.append("JOIN MINI_GOODSINFO MGI ON MCG.GOODSINFID = MGI.ID ");
        querySql.append("JOIN MINI_CONSUMERUSER MCU ON MCO.CONSUMERUSERID = MCU.ID ");
        querySql.append("JOIN MINI_PAGE_GOODSINFO MPG ON MPG.PAGEID = MCO.PAGEID ");
        querySql.append("WHERE MCG.ISDELETE = 1 AND MCO.ISDELETE = 1 AND MCC.ISDELETE = 1 AND MGI.ISDELETE = 1 AND MCU.ISDELETE = 1 AND MCO.STATE =? and mco.pageid = ? ");
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.queryForList(querySql.toString(), new Object[]{state,pageId});
        
        if(rsList.size()>0){        
            return rsList.get(0).getInt("ORDERNUM");
        }
        
        return 0;
        
    }
    
    /**
     * 
     * 计算订单总金额
     * 
     * @author 左香勇 <br> 
     *         2014-9-25
     * @update ［更改人，更改时间，更改内容描述，更改位置 n行－m行］
     * @return  double 订单总金额
     * @since vmaque2.0
     */
    public double getSumAccount(){
        String sql = "SELECT SUM(PRICE) AS ALLPRICE FROM MINI_CONSUMERORDER WHERE STATE = 2";
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.queryForList(sql,null);
        
        if(rsList.size()>0){        
            return rsList.get(0).getInt("ALLPRICE");
        }
        
        return 0;
    }
    
    /**
     * 
     * 微信接口查询商品订单数据信息（只提供给微信使用）
     * 
     * @author 左香勇
     *         2014年12月8日
     * @update 
     * @param state    订单状态
     *        pageRoll 分页查询对象
     *        
     * @return  String 符合查询条件商品订单信息json字符串
     * @see   OrderManagerPersistence#queryGoodsOrder(PageRoll, int, String)
     * @since vmaque2.0
     */
    public String queryGoodsOrder(PageRoll pageRoll, int state, String openId){
        
        StringBuffer querySql = new StringBuffer("select distinct ida,ordercode,state,price,createtime,goodsname,configname from (");
        querySql.append("   select conorder.id as ida,conorder.ordercode as ordercode,"
                            + "conorder.state as state,conorder.price as price,conorder.createtime as createtime,"
                            + "good.goodsname as goodsname,comm.configname as configname");
        querySql.append("   from mini_consumeruser conuser,mini_consumerorder  conorder,mini_consumerorder_goodsinfo congood,"
                            + "mini_goodsinfo  good,mini_commodityconfig  comm ");
        querySql.append("  where conuser.id = conorder.consumeruserid and conorder.id = congood.consumerorderid "
                            + "and congood.commodityconfigid = comm.id and comm.goodsinfoid = good.id");
        querySql.append("  and conorder.isdelete = 1 and congood.isdelete = 1 and conorder.weixinopenid = ? ");
        querySql.append("  union all");
        querySql.append("  select conorder.id,conorder.ordercode,conorder.state,conorder.price,conorder.createtime as createtime,"
                            + "good.goodsname,comm.configname ");
        querySql.append("   from mini_consumeruser conuser,mini_consumerorder  conorder,mini_consumerorder_goodsinfo congood,"
                            + "mini_goodsinfo  good,mini_commodityconfig  comm ");
        querySql.append("  where conuser.id = conorder.consumeruserid and conorder.id = congood.consumerorderid "
                            + "and congood.commodityconfigid = comm.id and comm.goodsinfoid = good.id");
        querySql.append("  and conorder.isdelete = 1 and congood.isdelete = 1 and   conorder.consumeruserid in ");
        querySql.append("  (select conusernew.id from mini_consumeruser conusernew where conusernew.usermobile in ");
        querySql.append("  (select bind.phone from mini_bindwechatphone bind where bind.openid = ? )");
        querySql.append(")"); 
        querySql.append(")");
        List<Object> objects=new ArrayList<Object>();
        objects.add(openId);
        objects.add(openId);
        
        if(state != -1){
            querySql.append(" where state = ?");
            objects.add(state);
        }
        querySql.append(" order by createtime desc");
        
        //分页查询
        pageRoll.setCountSQL("SELECT COUNT(1) FROM (" + querySql.toString()+")");
        pageRoll.setSearchSQL(querySql.toString());
        
        JdbcDao jdbcDao = (JdbcDao) SpringContextHelper.getBean("jdbc");// 获取jdbc
        List<ETIPResultSet> rsList = jdbcDao.search(pageRoll, objects);

        JSONArray js = JSONArray.fromObject(rsList);
        
        return js.toString();
    }
    
    /**
     * 
     * 根据订单id查询订单信息
     * 
     * @author 左香勇 <br> 
     *         2014年12月10日
     * @update 
     * @param id     订单id
     * @return  订单实体对象
     * @see   OrderManagerPersistence#queryConSumerOrderDataById(String)
     * @since vmaque2.0
     */
    public ConSumerOrderData queryConSumerOrderDataById(String id){
        return this.retrieve(id);
    }
}
