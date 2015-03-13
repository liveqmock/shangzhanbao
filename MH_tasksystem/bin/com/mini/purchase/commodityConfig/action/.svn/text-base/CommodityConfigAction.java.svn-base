package com.mini.purchase.commodityConfig.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.itour.etip.pub.frame.FrmAction;
import com.mini.purchase.commodityConfig.data.CommodityConfigData;
import com.mini.purchase.commodityConfig.facade.CommodityConfigFacade;

/**
 * 
 * 商品规格action<br> 
 *       2014-9-11
 *
 * @author 侯杨
 * @see   CommodityConfigAction
* @since vmaque1.5
 */
public class CommodityConfigAction extends FrmAction{
    @Resource(name="commodityConfigFacade")
    private CommodityConfigFacade commodityConfigFacade;
  //商品信息规格实体对象
    private CommodityConfigData commodityConfigData;
    //规格集合
    private List<CommodityConfigData> list=new ArrayList<CommodityConfigData>();
    /**
     * 
     *删除商品规格信息<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-11
     * @update 
     * @see   CommodityConfigAction#deletecommod
     * @since vmaque1.5
     */
    public void deletecommod(){
        commodityConfigFacade.deleteCommod(commodityConfigData);
    }
    
    /**
     * 
     *查询商品规格信息 根据id<br>
     * 
     * @author 侯杨<br> 
     *         2014-9-11
     * @throws IOException 
     * @update 
     * @see   CommodityConfigAction#getCommodityById
     * @since vmaque1.5
     */
    
    public void getCommodityById() throws IOException{
        commodityConfigData=commodityConfigFacade.getCommodityConfigData(commodityConfigData);
        if(commodityConfigData!=null){
            JSONObject object = JSONObject.fromObject(commodityConfigData);
            try {
                response.getWriter().print(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            response.getWriter().print("1");
        }
    }
    
    
    
    /**
     * 
     *根据父亲id查询规格信息 <br>
     * @author 侯杨 <br> 
     *         2014-12-11
     * @update 
     * @param  data         商品规格信息实体
     * @return 商品规格信息list集合
     * @throws IOException 
     * @see CommodityConfigAction#getAllByParentId(CommodityConfigData)
     * @since vmaque2.0
     */
    public void getAllByParentId() throws IOException{
        list= commodityConfigFacade.getAllByParentId(commodityConfigData);
        if(list.size()>0){
            JSONArray data = JSONArray.fromObject(list);
                response.getWriter().print(data);
        }else{
            response.getWriter().print("1");
        }
    }
    
    
    
    
    
    
    /********************************************************************************/
    public CommodityConfigData getCommodityConfigData() {
        return commodityConfigData;
    }
    public void setCommodityConfigData(CommodityConfigData commodityConfigData) {
        this.commodityConfigData = commodityConfigData;
    }
    
}
