package com.mini.purchase.goods.action;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Results;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.commodityConfig.facade.CommodityConfigFacade;
import com.mini.purchase.goods.data.GoodsInfoData;
import com.mini.purchase.goods.facade.GoodsInfoFacade;
import com.mini.purchase.pagegoodsinfo.data.PageGoodsInfoData;
import com.mini.purchase.pagegoodsinfo.facade.PageGoodsInfoFacade;
import com.sys.user.data.UserData;
import com.sys.user.facade.UserFacade;

/**
 * 
 * 商品信息action层<br> 
 *       2014-9-9
 *
 * @author 侯杨
 * @see GoodsInfoFacade
 * @since vmaque1.5
 */
@Results(value = { 
})
public class GoodsInfoAction extends FrmAction{
    @Resource(name="goodsInfoFacade")
    private GoodsInfoFacade goodsInfoFacade;
    @Resource(name="commodityConfigFacade")
    private CommodityConfigFacade commodityConfigFacade;
    @Resource(name="pageGoodsInfoFacade")
    private PageGoodsInfoFacade pageGoodsInfoFacade;
    @Resource(name = "userFacade")
    private UserFacade userFacade;
    //商品信息实体对象
    private GoodsInfoData goodsInfoData=new GoodsInfoData();
    //商品信息规格实体对象
    private CommodityConfigData commodityConfigData=new CommodityConfigData();
    //page和商品信息实体对象
    private PageGoodsInfoData pageGoodsInfoData=new PageGoodsInfoData();
    //规格集合
    private List<CommodityConfigData> list=new ArrayList<CommodityConfigData>();
    //商品图片
    private File filePC;
    private String filePCFileName;
    /**
     * 
     *添加商品新 和商品规格信息  商品和page中间表信息<br>
     * 
     * @author 侯杨<br> 
     *		   2014-9-11
     * @throws IOException 
     * @update 
     * @see   GoodsInfoAction#addGoodsInfo
     * @since vmaque1.5
     */
    public void addGoodsInfo() throws IOException{
            //转码
              if(goodsInfoData.getGoodsName()!=null && !"".equals(goodsInfoData.getGoodsName())){
                  goodsInfoData.setGoodsName(URLDecoder.decode(goodsInfoData.getGoodsName(),"UTF-8"));
              }
              if(goodsInfoData.getGoodsDes()!=null && !"".equals(goodsInfoData.getGoodsDes())){
                  goodsInfoData.setGoodsDes(URLDecoder.decode(goodsInfoData.getGoodsDes(),"UTF-8"));
              }
              if(goodsInfoData.getPromotion()!=null && !"".equals(goodsInfoData.getPromotion())){
                  goodsInfoData.setPromotion(URLDecoder.decode(goodsInfoData.getPromotion(),"UTF-8"));
              }
              if(goodsInfoData.getGoodsExpress()!=null && !"".equals(goodsInfoData.getGoodsExpress())){
                  goodsInfoData.setGoodsExpress(URLDecoder.decode(goodsInfoData.getGoodsExpress(),"UTF-8"));
              }
           
          if(goodsInfoData.getId()!=null && !"".equals(goodsInfoData.getId())){
              //执行修改
              //修改商品信息
              goodsInfoFacade.updateGoodsInfoData(goodsInfoData);
          }else{
              //执行添加
              //添加商品信息
              goodsInfoFacade.addGoodsInfoData(goodsInfoData);
              //添加page商品信息中间表信息
              pageGoodsInfoData.setGoodsInfoId(goodsInfoData.getId());
              pageGoodsInfoFacade.addPageGoodsInfoData(pageGoodsInfoData);
          }
            //添加商品信息规格
              //当页面添加的规格名称不为空的时候执行添加
            if(list.size()>0){
                if(list.get(0).getConfigName()!=null && !"".equals(list.get(0).getConfigName())){
                        commodityConfigData= commodityConfigFacade.addCommodityConfigData(list,goodsInfoData);
                }
            }
            commodityConfigData.setGoodsInfoId(goodsInfoData.getId());
              if(commodityConfigData!=null){
                  JSONObject object = JSONObject.fromObject(commodityConfigData);
                      response.getWriter().print(object);
              }else{
                  response.getWriter().print("1");
              }
    }
    /**
     * 
     *根据pageid查询商品信息 和商品规格信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-11
     * @update 
     * @exception IOException
     * @see   GoodsInfoAction#getGoodsInfo
     * @since vmaque1.5
     */
    public void getGoodsInfo(){
        //查询中间表信息
        List<PageGoodsInfoData> list=pageGoodsInfoFacade.getAllByPageId(pageGoodsInfoData);
        if(list!=null && list.size()>0){
            //商品id
            goodsInfoData.setId(list.get(0).getGoodsInfoId());
            goodsInfoData=goodsInfoFacade.getGoodsInfoData(goodsInfoData);
            //商品id
            commodityConfigData.setGoodsInfoId(list.get(0).getGoodsInfoId());
            List<CommodityConfigData> list1=commodityConfigFacade.getAllByGoodsId(commodityConfigData);
            if(list1!=null && list1.size()>0){
                goodsInfoData.setConfigDatas(list1);
            }
        }
        JSONObject object = JSONObject.fromObject(goodsInfoData);
        try {
            response.getWriter().print(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     *根据pageid删掉所有相关的数据<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-12
     * @update 
     * @see   GoodsInfoAction#deletepageGoods
     * @since vmaque1.5
     */
    public void deletepageGoods(){
        //查询中间表信息
        List<PageGoodsInfoData> list=pageGoodsInfoFacade.getAllByPageId(pageGoodsInfoData);
        if(list!=null && list.size()>0){
            //商品id
            goodsInfoData.setId(list.get(0).getGoodsInfoId());
            //删除商品信息
            goodsInfoFacade.deleteGoodsInfoData(goodsInfoData);
            //商品id
            commodityConfigData.setGoodsInfoId(list.get(0).getGoodsInfoId());
            //删除规格信息
            commodityConfigFacade.deleteCommodityConfigData(commodityConfigData);
            //商品id
            pageGoodsInfoData.setPageId(list.get(0).getPageId());
            //删除page和商品规格中间表信息
            pageGoodsInfoFacade.deletePageGoodsInfoData(pageGoodsInfoData);
        }
       
    }
    /**
     * 
     *根据pageid查询用户信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-13
     * @update 
     * @see   GoodsInfoAction#deletepageGoods
     * @since vmaque1.5
     */
    public void getUserDataPageId(){
       UserData data=userFacade.getUserDataByPageId(pageGoodsInfoData.getPageId());
       if(data!=null){
           json=data.getReceivableAccount();
       }
    }
/************************************************************************************************************************************/
    public GoodsInfoData getGoodsInfoData() {
        return goodsInfoData;
    }

    public void setGoodsInfoData(GoodsInfoData goodsInfoData) {
        this.goodsInfoData = goodsInfoData;
    }

    public CommodityConfigData getCommodityConfigData() {
        return commodityConfigData;
    }

    public void setCommodityConfigData(CommodityConfigData commodityConfigData) {
        this.commodityConfigData = commodityConfigData;
    }

    public File getFilePC() {
        return filePC;
    }

    public void setFilePC(File filePC) {
        this.filePC = filePC;
    }

    public String getFilePCFileName() {
        return filePCFileName;
    }

    public void setFilePCFileName(String filePCFileName) {
        this.filePCFileName = filePCFileName;
    }

    public PageGoodsInfoData getPageGoodsInfoData() {
        return pageGoodsInfoData;
    }

    public void setPageGoodsInfoData(PageGoodsInfoData pageGoodsInfoData) {
        this.pageGoodsInfoData = pageGoodsInfoData;
    }
    public List<CommodityConfigData> getList() {
        return list;
    }
    public void setList(List<CommodityConfigData> list) {
        this.list=list;
    }

    
    
   
}
