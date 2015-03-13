package com.mini.foreign.goodsOrder.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.foreign.goodsOrder.facade.GoodsOrderFacade;

/**
 * 
 * 对微信接口关于商品订单数据提供的action方法<br> 
 *
 * @author 左香勇
 * @see [相关类/方法]
 * @since vmaque2.0
 */
@Results(value = { 
})
public class GoodsOrderAction extends FrmAction {
   
    @Resource(name="goodsOrderFacade")
    private GoodsOrderFacade goodsOrderFacade;
    
    private PageRoll pageRoll = new PageRoll();

    /**
     * 
     * 根据订单id删除商品订单信息<br>
     * 
     * @author 左香勇 <br> 
     *		   2015年1月22日
     * @see   GoodsOrderAction#deleteGoodsOrder()
     * @since vmaque2.0
     */
    public void deleteGoodsOrder(){
        String callback = request.getParameter("jsoncallback");
        String returnJsonStr = "";
        try{
            //获取订单id
            String orderid = request.getParameter("orderid");
            
            goodsOrderFacade.deleteGoodsOrder(orderid);
            returnJsonStr = "{\"SUCCESS\": true}";
            printTopage(response, returnJsonStr, callback);
        } catch (Exception e) {
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"删除订单信息失败！\"}";
            printTopage(response, returnJsonStr, callback);
        }
    }
    
    /**
     * 
     * 根据条件查询商品订单相关信息
     * 
     * @author 左香勇 <br> 
     *		   2014年12月8日
     * @param openid     微信用户的openid
     *        type       type=1，表示查询的是全部订单;type=2，表示查询的是待付款订单;type=3，表示查询的是待收货订单;type=4,表示查询的是已完成订单。
              pageSize   每页显示数据条数
              currentPage当前显示页数
     * @return  [返回类型说明]
     * @since vmaque2.0
     */
    public void queryGoodsOrder(){
        
        String returnJsonStr = "";
        //获取微信用户的openid
        String openid = request.getParameter("openid");
        
        String callback = request.getParameter("jsoncallback");
        
        if(openid == null || "".equals(openid)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"微信用户的openid为空！获取数据失败！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        }
        
        //获取订单类型，type=1，表示查询的是全部订单;type=2，表示查询的是待付款订单;type=3，表示查询的是待收货订单;type=4,表示查询的是已完成订单。
        String type = request.getParameter("type");
        
        if(type == null || "".equals(type)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"商品订单类型为空！获取数据失败！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        } else {
            int typeInt = Integer.parseInt(type);
            if(typeInt < -1 || typeInt > 4){
                returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"非法商品订单类型！获取数据失败！\"}";
                printTopage(response, returnJsonStr, callback);
                return;
            }
        }

        //获取每页显示数据条数
        String pageSize = request.getParameter("pageSize");
        
        if(pageSize == null || "".equals(pageSize)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"每页显示数据条数为空！获取数据失败！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        } else {
            int pageSizeInt = Integer.parseInt(pageSize);
            if(pageSizeInt < 0 || pageSizeInt > 50){
                returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"每页显示数据不能小于0条大于50条！获取数据失败！\"}";
                printTopage(response, returnJsonStr, callback);
                return;
            }
        }
        
        //获取当前页
        String currentPage = request.getParameter("currentPage");
        
        if(currentPage == null || "".equals(currentPage)){
            returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"当前第几页为空！获取数据失败！\"}";
            printTopage(response, returnJsonStr, callback);
            return;
        } else {
            int pageSizeInt = Integer.parseInt(pageSize);
            if(pageSizeInt < 0){
                returnJsonStr = "{\"SUCCESS\": false, \"MESSAGE\": \"当前页不能小于0！获取数据失败！\"}";
                printTopage(response, returnJsonStr, callback);
                return;
            }
        }
        
        pageRoll.setPageSize(Integer.parseInt(pageSize));
        pageRoll.setCurrentPage(Integer.parseInt(currentPage));
        
        String rejson = goodsOrderFacade.queryGoodsOrder(pageRoll, Integer.parseInt(type), openid);
        
        StringBuffer reStrBuff = new StringBuffer("{\"SUCCESS\": true,\"DATA\":");
        reStrBuff.append(rejson);
        reStrBuff.append(",\"PAGESIZE\":");
        reStrBuff.append(pageRoll.getPageSize());
        reStrBuff.append(",\"CURRENTPAGE\":");
        reStrBuff.append(pageRoll.getCurrentPage());
        reStrBuff.append(",\"TOTALROWS\":");
        reStrBuff.append(pageRoll.getTotalRows());
        
        
        reStrBuff.append("}");
        printTopage(response, reStrBuff.toString(), callback);
        
    }
    
    private void printTopage(HttpServletResponse response, String msg, String callback){
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(callback + "(" +msg+ ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
