package com.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mini.product.data.ProductData;

public class CTNProductUtil {
    /**
     * 根据接口传过来的服务id查询服务数据
     * 
     * @param str1
     * @param productId
     * @return
     * @throws IOException
     */
    public static List<ProductData> getCtnJSON(String str1) throws IOException {
        List<ProductData> list = new ArrayList<ProductData>();
        if (str1 != "" && !"".equals(str1) && !"[]".equals(str1)) {
            String str2 = HttpWebUtil.getCTNJsonData("wsGetProductDate?productId=" + str1);
            if (!"0".equals(str2)) {
                if (!"".equals(str2)) {
                    JSONArray jsonArr = JSONArray.fromObject(str2);
                    for (int k = 0; k < jsonArr.size(); k++) {
                        if (null != jsonArr.getJSONObject(k)) {
                            ProductData productData = new ProductData();
                            productData.setName(jsonArr.getJSONObject(k).getString("productName"));
                            productData.setId(jsonArr.getJSONObject(k).getString("id"));
                            productData.setCtnProductStatus(jsonArr.getJSONObject(k).getString("productstate"));
                            productData.setProductConfig(jsonArr.getJSONObject(k).getJSONObject("productConfigData").getString("configName"));
                            productData.setPrice(Double.valueOf(Double.valueOf(jsonArr.getJSONObject(k)
                                    .getJSONObject("productConfigData").getString("configPrice"))));
                            list.add(productData);
                        }

                    }
                }
            }
        }
        return list;
    }
}
