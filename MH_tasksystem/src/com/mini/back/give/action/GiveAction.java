package com.mini.back.give.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import net.sf.json.JSONObject;

import com.common.util.ReadWriteFile;
import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.PageRoll;
import com.mini.back.give.facade.GiveFacade;
import com.mini.back.give.facade.UserInfoDataFacade;
import com.mini.back.product.facade.ProductFacade;
import com.mini.give.data.GiveData;
import com.mini.give.data.GiveTimeData;
import com.mini.give.data.GiveUserInfoData;
import com.mini.give.data.UserInfoData;
import com.mini.product.data.ProductData;

@ResultPath("/")
@Results({ @Result(name = "givePrivilege", location = "/view/pages/mini/back/give/givePrivilege.jsp"),
        @Result(name = "findGiveList", location = "/view/pages/mini/back/give/giveList.jsp") })
public class GiveAction extends FrmAction {
    @Resource(name = "giveFacade")
    private GiveFacade giveFacade;// 赠送表facade表
    @Resource(name = "userInfoDataFacade")
    private UserInfoDataFacade userInfoDataFacade;// 发布权权限管理facade类
    @Resource(name = "productFacade")
    private ProductFacade productFacade;
    private String giveSign;
    private GiveData gData = new GiveData();
    private PageRoll pageRoll = new PageRoll(); // 分页
    private String realpath = ServletActionContext.getServletContext().getRealPath("/configure");
    private List<GiveData> privilegeList;// 赠送记录
    private List<ProductData> list_product = new ArrayList<ProductData>(); // 服务集合
    private GiveUserInfoData giveUserInfoData;// 赠送帮助类
    private List<GiveUserInfoData> giveUserInfolist;// 赠送帮助类集合
    private GiveTimeData giveTimeData;// 赠送时间帮助类

    /**
     * 
     * 查询符合赠送权限的客户<br>
     * 
     * @author 李海鹏 <br>
     *         2014-4-18
     * @update 冯鑫 
     *         2014-05-20 修改方法体，修改方法的参数传递
     * @param
     * @return String 返回前端页面
     * @exception/throws
     * @see GiveAction#givePrivilege()
     * @since
     */
    public String givePrivilege() {
        List<GiveUserInfoData> list = giveFacade.getUserInfo(pageRoll, giveTimeData,giveUserInfoData);
        list_product = productFacade.getAllProduct(new ProductData());
        if (list.size() > 0) {
            giveUserInfolist = new ArrayList<GiveUserInfoData>();
            for (int i = 0; i < list.size(); i++) {
                GiveUserInfoData gData = list.get(i);
                giveUserInfolist.add(gData);
            }
        }
        return "givePrivilege";
    }

    
    /**
     * 过滤数据
     * 
     * @param param
     * @return
     */
    public String changeDate(String param) {
        return param.equals("") ? null : param;
    }

    /**
     * 发布权限管理默认读取file.txt文件 获取赠送天数
     */
    public void changeTryDays() {
        try {
            String text = ReadWriteFile.readTxtFile(realpath + "/file.txt");
            response.getWriter().print(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更改并读取文件内容
     */
    public void changefileContect() {
        String num = request.getParameter("num");// 试用天数
        String dpath = realpath.replace("\\", "/");// 将路径 \ ,,改成 / 方式
        try {
            File file = new File(dpath + "/file.txt");// 获取带盘符的标准文件路径
            if (file.isFile()) {
                file.delete();// 删除该文件
            }
            ReadWriteFile.creatTxtFile(dpath + "/file.txt");// 创建.txt文件
            ReadWriteFile.writeTxtFile(num, dpath + "/file.txt");// 写入txt
            String text = ReadWriteFile.readTxtFile(dpath + "/file.txt");// 读取文件内容
            response.getWriter().print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     *添加赠送的权限 客户目前设置为一年<br>
     * 
     * @author <br> 
     *		   2014-5-20
     * @update 冯鑫 修改方法体 修改参数传递 
     * @param [参数1]     [参数1说明]
     * @return  [返回类型说明]
     * @exception/throws [异常类型] [异常说明]
     * @see   [类、类#方法、类#成员]
     * @since [起始版本]
     */
    public void addGivePrivilege() throws ParseException, IOException {
        String id = request.getParameter("ids");
        String[] ids = id.split(",");
        String creatorId = FrmUser.getUser().etipUserID;// 创建者的id
        String creatorName = FrmUser.getUser().getUsername();// 创建者名称
        String json = request.getParameter("json");
        JSONObject obj = JSONObject.fromObject(json);

        StringBuffer sb = getCondition();
        Date date = new Date();// 创建时间
        String condition = sb.toString();// 此参数前台获取
        for (int j = 0; j < ids.length; j++) {
            GiveData giveData = new GiveData();
            giveData.setMessage(obj.getString("messages") == "" ? "" : obj.getString("messages"));// 赠送消息
            giveData.setCreateTime(date);// 创建时间
            giveData.setGive(obj.getString("ifgive"));// 属于赠送
            giveData.setCondition(condition);// 查询条件
            giveData.setUserid(ids[j]);// 受益 用户的id
            giveData.setGiveNum(obj.getInt("giveNum"));// 赠送个数
            giveData.setCreatorName(creatorName);// 创建者的名称
            giveData.setCreatorId(creatorId);// 创建的id
            
            giveFacade.addPrivilege(giveData);
            
            List<UserInfoData> list = userInfoDataFacade.getUserInfo(JSONObject.fromObject("{'userid':'" + ids[j] + "'}"));// 查看赠送权限是否存在
            UserInfoData userInfoData = new UserInfoData();
            if ("1".equals(obj.getString("ifgive"))) {
                if (null == list || list.size() == 0) {// 没有存在就添加
                    
                    userInfoData.setUserId(ids[j]);
                    userInfoData.setGiveNum(obj.getInt("giveNum"));
                    userInfoData.setPayPrivilege(obj.getInt("giveNum"));
                    userInfoData.setAlreadyPayPrivilege(0);
                    userInfoData.setAlreadyTryPrivilege(0);
                    userInfoData.setOverduePrivilege(0);
                    userInfoData.setRenew(0);
                    userInfoData.setTryPrivilege(0);
                    userInfoData.setAlreadyUpgrade(0);
                    userInfoData.setTempPrivilege(0);
                } else { // 存在即更新
                    userInfoData = list.get(0);
                    userInfoData.setUserId(ids[j]);
                    userInfoData.setGiveNum(userInfoData.getGiveNum()+obj.getInt("giveNum"));
                }
            } else {
                if (null == list || list.size() == 0) {// 没有存在就添加
                    userInfoData.setUserId(ids[j]);
                    userInfoData.setGiveNum(0);
                    userInfoData.setPayPrivilege(0);
                    userInfoData.setAlreadyPayPrivilege(0);
                    userInfoData.setAlreadyTryPrivilege(0);
                    userInfoData.setOverduePrivilege(0);
                    userInfoData.setRenew(0);
                    userInfoData.setTryPrivilege(0);
                    userInfoData.setAlreadyUpgrade(0);
                    userInfoData.setTempPrivilege(obj.getInt("giveNum"));
                } else { // 存在即更新
                    userInfoData = list.get(0);
                    userInfoData.setUserId(ids[j]);
                    userInfoData.setTempPrivilege(userInfoData.getTempPrivilege()+obj.getInt("giveNum"));
                }
            }
            userInfoDataFacade.editUserInfo(userInfoData);
        }
        response.getWriter().print("success");
    }

    /**
     * 获取查询条件,将场景入库
     * 
     * @return
     */
    private StringBuffer getCondition() {
        StringBuffer sb = new StringBuffer();
        String starttime = request.getParameter("starttime");// 注册开始时间
        String endtime = request.getParameter("endtime");// 注册结束时间
        String startUseTime = request.getParameter("startUseTime");// 模板使用开始时间
        String endUseTime = request.getParameter("endUseTime");// 模板使用结束时间
        String startpaytime = request.getParameter("startpaytime");// 服务购买开始时间
        String endpaytime = request.getParameter("endpaytime");// 服务购买结束时间
        String isHave = request.getParameter("isHave");
        if (null!=giveUserInfoData.getLoginmail()&&!"".equals(giveUserInfoData.getLoginmail())) {
            if (emailFormat(giveUserInfoData.getLoginmail())) {
                sb.append("邮箱：").append(giveUserInfoData.getLoginmail());
            } else {
                sb.append("手机：").append(giveUserInfoData.getLoginmail());
            }
        }
        if (null!=starttime&&!"".equals(starttime) && null!=endtime&& !"".equals(endtime)) {
            sb.append("注册时间:").append(starttime).append("~").append(endtime);
        }
        if (null != isHave && !"".equals(isHave)) {
            if ("1".equals(isHave)) {
                sb.append("购买发布权限:").append("有");
            }
            if ("0".equals(isHave)) {
                sb.append("购买发布权限:").append("没有");
            }
        }
        if (null!=giveUserInfoData.getDomain()&&!"".equals(giveUserInfoData.getDomain())) {
            sb.append("Page域名：").append(giveUserInfoData.getDomain());
        }
        if (null!=giveUserInfoData.getUsername()&&!"".equals(giveUserInfoData.getUsername())) {
            sb.append("公司名称：").append(giveUserInfoData.getDomain());
        }
        if (null!=giveUserInfoData.getPersoname()&&!"".equals(giveUserInfoData.getPersoname())) {
            sb.append("联系人姓名：").append(giveUserInfoData.getPersoname());
        }
        if (null!=giveUserInfoData.getSn()&&!"".equals(giveUserInfoData.getSn())) {
            sb.append("模板名称：").append(giveUserInfoData.getSn());
            sb.append("模板编号：").append(giveUserInfoData.getSn());
        }
        if (null!=startUseTime&&!"".equals(startUseTime) &&null!=endUseTime&& !"".equals(endUseTime)) {
            sb.append("使用该模板时间：").append(startUseTime).append("~").append(endUseTime);
        }
        if (null!=startpaytime&&!"".equals(startpaytime) &&null!=endpaytime&& !"".equals(endpaytime)) {
            sb.append("购买时间：").append(startpaytime).append("~").append(endpaytime);
        }
        return sb;
    }

    /**
     * 查看赠送记录 默认是查看确认赠送的记录
     */
    public String findGiveList() {
        String json = request.getParameter("give");
        String give = json == null ? "1" : json;// give是对象在数据库的字段 y属于赠送 n属于暂存
        json = "{\"give\":\"" + give + "\"}";
        JSONObject jObject = JSONObject.fromObject(json);
        privilegeList = giveFacade.getAllPrivilegeInfo(pageRoll, jObject);
        if (null != privilegeList && privilegeList.size() > 0) {
            giveSign = privilegeList.get(0).getGive();
        }
        request.setAttribute("give", give);
        return "findGiveList";
    }

    /**
     * 发送暂存赠送信息，其实就是将暂存的改成赠送
     * 
     * @throws IOException
     */
    public void sendGive() throws IOException {
        String json = request.getParameter("json");// 获取符合赠送权限的客户 这里是从暂存的赠送数据读取
        JSONObject obj = JSONObject.fromObject(json);
        List<GiveData> list = giveFacade.getPrivilegeData(obj);
        Date date = new Date();
        if (null != list && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {// 将暂存的用户 状态进行改变
                GiveData giveData = new GiveData();
                giveData.setId(list.get(i).getId());
                giveData.setCreateTime(date);// 确认更改时间 必须重新记录
                giveData.setGive("1");
                giveFacade.editPrivilege(giveData);
            }
            obj.put("payprivilege", list.get(0).getGiveNum());
            obj.put("givenum", list.get(0).getGiveNum());
            userInfoDataFacade.updateUserInfo(obj);
        }
        response.getWriter().print("success");
    }

    /**
     * 删除暂存权限
     * 
     * @throws IOException
     */
    public void deleteGive() throws IOException {
        String json = request.getParameter("json");// json中获取的内容 时间 条件 还有创建者id 通过这里几个条件来删除 在暂存的一批赠送记录
        JSONObject jObject = JSONObject.fromObject(json);
        giveFacade.delectGive(jObject);
        response.getWriter().print("success");
    }

    /**
     * 验证输入的邮箱格式是否符合
     * 
     * @param email
     * @return 是否合法
     */
    private static boolean emailFormat(String email) {
        boolean tag = true;
        final String pattern1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        final Pattern pattern = Pattern.compile(pattern1);
        final Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }

    public GiveFacade getGiveFacade() {
        return giveFacade;
    }

    public void setGiveFacade(GiveFacade giveFacade) {
        this.giveFacade = giveFacade;
    }

    public List<GiveData> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<GiveData> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public String getGiveSign() {
        return giveSign;
    }

    public void setGiveSign(String giveSign) {
        this.giveSign = giveSign;
    }

    public PageRoll getPageRoll() {
        return pageRoll;
    }

    public void setPageRoll(PageRoll pageRoll) {
        this.pageRoll = pageRoll;
    }

    public GiveData getGData() {
        return gData;
    }

    public void setGData(GiveData data) {
        gData = data;
    }

    public UserInfoDataFacade getUserInfoDataFacade() {
        return userInfoDataFacade;
    }

    public void setUserInfoDataFacade(UserInfoDataFacade userInfoDataFacade) {
        this.userInfoDataFacade = userInfoDataFacade;
    }

    public GiveUserInfoData getGiveUserInfoData() {
        return giveUserInfoData;
    }

    public void setGiveUserInfoData(GiveUserInfoData giveUserInfoData) {
        this.giveUserInfoData = giveUserInfoData;
    }

    public List<GiveUserInfoData> getGiveUserInfolist() {
        return giveUserInfolist;
    }

    public void setGiveUserInfolist(List<GiveUserInfoData> giveUserInfolist) {
        this.giveUserInfolist = giveUserInfolist;
    }

    public GiveTimeData getGiveTimeData() {
        return giveTimeData;
    }

    public void setGiveTimeData(GiveTimeData giveTimeData) {
        this.giveTimeData = giveTimeData;
    }

    public List<ProductData> getList_product() {
        return list_product;
    }

    public void setList_product(List<ProductData> list_product) {
        this.list_product = list_product;
    }

}
