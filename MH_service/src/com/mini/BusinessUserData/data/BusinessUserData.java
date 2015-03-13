package com.mini.BusinessUserData.data;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.itour.etip.pub.frame.FrmData;


/**
 * 〈实名认证信息表〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name = "MINI_BUSINESSUSER")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//TABLE_PER_CLASS 是为每一个类创建一个表，这些表是相互独立的。
public class BusinessUserData extends FrmData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8148107054128527467L;
	/**
	 * ICP备案号
	 */
	@Column(name = "ICP",nullable = true)
	private String Icp;
	/**
	 * 公司电话总机
	 */
	@Column(name = "COMPANYPHONE",nullable = true)
	private String companyPhone;
	/**
	 * 联系人手机号
	 */
	@Column(name = "LINKMANMOBLE",nullable = true)
	private String linkManMoble;
	/**
	 * 联系人邮箱
	 */
	@Column(name = "LINKMANMAIL",nullable = true)
	private String linkManMail;
	/**
	 * 联系人职务
	 */
	@Column(name = "LINKMANJOB",nullable = true)
	private String linkManJob;
	/**
	 * 企业联系人
	 */
	@Column(name = "LINKMANNAME",nullable = true)
	private String linkManName;
	/**
	 * 企业中文全称
	 */
	@Column(name = "COMPANYCHNAME",nullable = true)
	private String companyChName;
	/**
	 * 企业全称（英文）
	 */
	@Column(name = "COMPANYENNAME",nullable = true)
	private String companyEnName;
	/**
	 * 企业现地址
	 */
	@Column(name = "NOWADDRESS",nullable = true)
	private String nowAddress;
	/**
	 * 企业注册地址（营业执照上的地址）
	 */
	@Column(name = "BLADDRESS",nullable = true)
	private String blAddress;
	/**
	 * 人事部电话
	 */
	@Column(name = "HRPHONE",nullable = true)
	private String hrPhone;
	/**
	 * 网站域名
	 */
	@Column(name = "DOMAINNAME",nullable = true)
	private String domainName;
	/**
	 * 网站名称
	 */
	@Column(name = "WEBNAME",nullable = true)
	private String webName;
	/**
	 * 业务申请部门
	 */
	@Column(name = "DEPCHNAME",nullable = true)
	private String depChName;
	/**
	 * 业务申请部门（英文）
	 */
	@Column(name = "DEPENNAME",nullable = true)
	private String depEnName;
	/**
	 * 邮政编码
	 */
	@Column(name = "POSTALCODE",nullable = true)
	private String postalCode;
	/**
	 * 域名注册信息
	 */
	@Column(name = "REGISTERINFO",nullable = true)
	private String registerInfo;
	/**
	 * 营业执照电子版
	 */
	@Column(name = "BLIMG",nullable = true)
	private String blImg;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATETIME",nullable = true)
	public Date createTime;
	/**
	 * 修改时间
	 */
	@Column(name = "MODIFYTIME",nullable = true)
	public Date modifyTime;
	/**
	 * 注销时间
	 */
	@Column(name = "CANCELTIME",nullable = true)
	public Date cancelTime;
	/**
	 * 系统用户表主键
	 */
	@Column(name = "SYSUSERID")
	private String sysUserId;
	/**
	 * 企业用户状态({1:未认证}、{2:已经认证}、{3:变更中}、{4：注销})
	 */
	@Column(name="STATE")
	private Integer state;
	/**
	 * 真删假删({0：已删除}、{1：未删除})
	 */
	@Column(name = "ISDELETE")
	private Integer isDelete = 1;
	/**
	 * 原因字段
	 */
	@Column(name = "RESON")
	private String reson;
	/**
	 * 是否购买过服务
	 */
	private Integer whether;
    
	
	
	/**
	 * 备案时间
	 */
	private Date  icpTime;
	
	/**
	 * ip地址
	 */
	private String ipAddr;
	
	

	private String saveState;//业务中心账户信息部分用于传递表单提交参数

	
	
	
	@Transient
	public String getSaveState() {
		return saveState;
	}
	

	public void setSaveState(String saveState) {
		this.saveState = saveState;
	}
	
	@Transient
	public Integer getWhether() {
		return whether;
	}

	public void setWhether(Integer whether) {
		this.whether = whether;
	}

	
	
	public String getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}
	public String getIcp() {
		return Icp;
	}
	public void setIcp(String icp) {
		this.Icp = icp;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getLinkManMoble() {
		return linkManMoble;
	}
	public void setLinkManMoble(String linkManMoble) {
		this.linkManMoble = linkManMoble;
	}
	public String getLinkManMail() {
		return linkManMail;
	}
	public void setLinkManMail(String linkManMail) {
		this.linkManMail = linkManMail;
	}
	public String getLinkManJob() {
		return linkManJob;
	}
	public void setLinkManJob(String linkManJob) {
		this.linkManJob = linkManJob;
	}
	public String getLinkManName() {
		return linkManName;
	}
	public void setLinkManName(String linkManName) {
		this.linkManName = linkManName;
	}
	public String getCompanyChName() {
		return companyChName;
	}
	public void setCompanyChName(String companyChName) {
		this.companyChName = companyChName;
	}
	public String getCompanyEnName() {
		return companyEnName;
	}
	public void setCompanyEnName(String companyEnName) {
		this.companyEnName = companyEnName;
	}
	public String getNowAddress() {
		return nowAddress;
	}
	public void setNowAddress(String nowAddress) {
		this.nowAddress = nowAddress;
	}
	public String getBlAddress() {
		return blAddress;
	}
	public void setBlAddress(String blAddress) {
		this.blAddress = blAddress;
	}
	public String getHrPhone() {
		return hrPhone;
	}
	public void setHrPhone(String hrPhone) {
		this.hrPhone = hrPhone;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getWebName() {
		return webName;
	}
	public void setWebName(String webName) {
		this.webName = webName;
	}
	public String getDepChName() {
		return depChName;
	}
	public void setDepChName(String depChName) {
		this.depChName = depChName;
	}
	public String getDepEnName() {
		return depEnName;
	}
	public void setDepEnName(String depEnName) {
		this.depEnName = depEnName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getRegisterInfo() {
		return registerInfo;
	}
	public void setRegisterInfo(String registerInfo) {
		this.registerInfo = registerInfo;
	}
	public String getBlImg() {
		return blImg;
	}
	public void setBlImg(String blImg) {
		this.blImg = blImg;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Date getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	@Column(name = "ICPTIME",nullable = true)
	public Date getIcpTime() {
		return icpTime;
	}
	public void setIcpTime(Date icpTime) {
		this.icpTime = icpTime;
	}
	@Column(name = "IPADDR",nullable = true)
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	private String orderProductId;

	@Transient
	public String getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(String orderProductId) {
		this.orderProductId = orderProductId;
	}
	
	
	
	
	
	@Column(name = "GSZCH",nullable = true)
	private String gszch;//工商注册号
	@Column(name = "ADDR",nullable = true)
	private String addr;//住所
	@Column(name = "FDDBR",nullable = true)
	private String fddbr;//法定代表人
	@Column(name = "ZCZB",nullable = true)
	private String zczb;//注册资本
	@Column(name = "GSLX",nullable = true)
	private String gslx;//公司类型
	@Column(name = "YYQXBEGIN",nullable = true)
	private Date yyqxBegin;//营业期限开始
	@Column(name = "YYQXEND",nullable = true)
	private Date yyqxEnd;//营业期限 结束
	@Column(name = "JYFW",nullable = true)
	private String jyfw;//经营范围
	@Column(name = "YMSQS",nullable = true)
	private String ymsqsRath;//域名授权书图片路径	
	private String pageParoductId;  //服务中间表id
	
	private String pageId;  //pageId
	
	private String orderId;//订单id
	private String order_product_id;//订单服务id

	public String getGszch() {
		return gszch;
	}
	public void setGszch(String gszch) {
		this.gszch = gszch;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getZczb() {
		return zczb;
	}
	public void setZczb(String zczb) {
		this.zczb = zczb;
	}
	public String getGslx() {
		return gslx;
	}
	public void setGslx(String gslx) {
		this.gslx = gslx;
	}
	 
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}
	@Column(name = "ORDERID",nullable = true)
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Column(name = "ORDERPRODUCTID",nullable = true)
	public String getOrder_product_id() {
		return order_product_id;
	}
	public void setOrder_product_id(String order_product_id) {
		this.order_product_id = order_product_id;
	}
	public Date getYyqxBegin() {
		return yyqxBegin;
	}
	public void setYyqxBegin(Date yyqxBegin) {
		this.yyqxBegin = yyqxBegin;
	}
	public Date getYyqxEnd() {
		return yyqxEnd;
	}
	public void setYyqxEnd(Date yyqxEnd) {
		this.yyqxEnd = yyqxEnd;
	}
	/*域名授权书图片路径*/
	@Column(name = "YMSQS")
	public String getYmsqsRath() {
		return ymsqsRath;
	}
	public void setYmsqsRath(String ymsqsRath) {
		this.ymsqsRath = ymsqsRath;
	}

	@Column(name="PAGEPRODUCTID")
	public String getPageParoductId() {
		return pageParoductId;
	}
	public void setPageParoductId(String pageParoductId) {
		this.pageParoductId = pageParoductId;
	}

	@Transient
	public String getPageId() {
		return pageId;
	}


	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	 
	

}