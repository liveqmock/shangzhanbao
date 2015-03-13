package com.itour.etip.security.menu.action;

import java.util.StringTokenizer;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import com.itour.etip.pub.frame.FrmAction;
import com.itour.etip.pub.frame.FrmUser;
import com.itour.etip.pub.frame.SpringContextHelper;
import com.itour.etip.pub.kit.cache.CacheUtil;
import com.itour.etip.pub.kit.security.UrlObjectDefinitionSource;
import com.itour.etip.pub.kit.xml.XMLDataBean;

/**
 * 菜单文件，可以是树形菜单，也可以是级联菜单
 * 
 * @author lishan
 */
public class IndexTreeAction extends FrmAction {
	StringBuffer menuHtml = new StringBuffer(
			"<style>div{font-size:12px;color:red; background-color: #EAEAE8; border: 1 solid #1892B5; padding: 1}</style>");

	String projectNamePath = "";
	
	class MenuModel extends XMLDataBean {
		boolean menuAdd = false;

		String menuID = null;

		String menuName = null;

		public void expandElementNode(Element node, Object parent) {
			String tag = node.getTagName();
			if (tag.equals("menubar")) {
				parseChildNodes(node, null);
			} else if (tag.equals("menu")) {
				menuName = node.getAttribute("name");
				menuID = node.getAttribute("id");
				menuAdd = false;
				parseChildNodes(node, null);
				if (menuAdd == true) {
					appendMenuEndTagToHtml();
				}
			} else if (tag.equals("item")) {
				String itemID = node.getAttribute("id");
				String itemName = node.getAttribute("name");
				String itemAction = node.getAttribute("action");
				// 检查用户权限。
				String action = itemAction.substring(projectNamePath.length());
				boolean access = FrmUser.getUser().checkAccess(action);
				if (access) {
					if (menuAdd == false) {
						appendMenuToHtml(menuID, menuName);
						menuAdd = true;
					}
					appendItemToHtml(itemID, itemName, itemAction);
				}
			}
		}

		public void expandAttributeNode(Attr attr) {
		}

		private void appendMenuToHtml(String menuID, String menuName) {
			menuHtml
					.append("<div id='"
							+ menuID
							+ "' style='font-size:14px;font-family:宋体;font-style:bold;cursor:hand;BORDER-RIGHT:1px outset;BORDER-TOP:1px outset;BACKGROUND:#dfe8f6; BORDER-LEFT:1px outset;BORDER-BOTTOM:1px outset;' onclick='menuAction(this);'><img src='"+projectNamePath+"/img/153.gif'/>"
							+ menuName + "</div>" + "<div id='sub_" + menuID
							+ "' style='display:none;color:black;cursor:hand;'>");
		}

		private void appendItemToHtml(String itemID, String itemName, String itemAction) {
			menuHtml
					.append("<span style='font-size:13px;font-family:宋体;font-style:bold;cursor:hand;background:#d6cfef;color:black;border:solid 1px #0000cc;width:102;' id='"
							+ itemID
							+ "' name='"
							+ itemName
							+ "' action='"
							+ itemAction
							+ "' onclick='loadAction(\""
							+ itemName
							+ "\",\""
							+ itemID
							+ "\",\""
							+ itemAction
							+ "\");'>&nbsp;<img src='"+projectNamePath+"/img/91.gif'/>" + itemName + "</span> <br>");
		}

		/**
		 * 添加菜单标识
		 */
		private void appendMenuEndTagToHtml() {
			menuHtml.append("</div>");
		}
	}

	/**
	 * 通过xml文件构造级联菜单，内容描述采用xml格式
	 * 
	 * @return
	 */
	public String getCascadeMenu() {
//		//String root = request.getContextPath();
//		projectNamePath = ServletActionContext.getRequest().getContextPath();
//		StringBuffer menuXML = new StringBuffer();
//		menuXML.append("<?xml version='1.0' encoding='utf-8'?>");
//		menuXML.append("<menubar name='目录菜单'>");
//		menuXML.append("<menu  name='酒店产品管理' id='all_product_productmanage'>");
//		menuXML
//				.append("<item  id='all_product_static'                            name='酒店信息维护'      action='"+projectNamePath+"/view/pages/product_static_basic_list.jsp'/>");
////		menuXML
////				.append("<item  id='all_product_input_hotel_room'                  name='房型及动态录入(短)'      action='"+projectNamePath+"/view/pages/product_hotel_room_info_list.jsp'/>");
//		menuXML
//				.append("<item  id='hoteldynamic'  name='房型动态录入(长)'  action='"+projectNamePath+"/view/pages/product/hotel_dynamic/hoteldynamic.jsp'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_room'          name='房型维护'    action='"+projectNamePath+"/view/pages/product_hotel_room_maintenance_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_state'         name='房态维护'      action='"+projectNamePath+"/view/pages/product_dynamic_room_state_info_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_price'         name='房价维护'      action='"+projectNamePath+"/view/pages/product_dynamic_room_price_info_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_shareengross'  name='配额维护'      action='"+projectNamePath+"/view/pages/product_dynamic_room_share_quota_info_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_other'  name='加床早餐维护'      action='"+projectNamePath+"/view/pages/product_dynamic_room_dynamic_info_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_hypothecation'  name='担保信息维护'      action='"+projectNamePath+"/view/pages/product_dynamic_hypothecation_info_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_productmanage_hotel_vendorpromotion'  name='酒店促销维护'      action='"+projectNamePath+"/view/pages/product_dynamic_vendor_promotion_sale_info_list.html'/>");
//
//		menuXML.append("</menu>");
//		menuXML.append("<menu  id='all_product_adjust'    name='产品调控'>");
//		menuXML
//				.append("<item  id='all_product_adjust_available'    name='可用可见调控'      action='"+projectNamePath+"/view/pages/product_hotel_control_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_adjust_roomprice'    name='房价调控'      action='"+projectNamePath+"/view/pages/product_room_price_control_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_adjust_share'  name='配额调控'      action='"+projectNamePath+"/view/pages/product_room_quota_control_list.html'/>");
//		menuXML
//				.append("<item  id='all_product_adjust_priority'  name='优先级调控'      action='"+projectNamePath+"/view/pages/product_priority_control_list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  id='all_product_estimate'    name='酒店内外评价'>");
//		menuXML
//				.append("<item  id='all_product_estimate_hotel'    name='内部评价'      action='"+projectNamePath+"/view/pages/product_estimate.html'/>");
//		menuXML
//				.append("<item  id='all_product_estimate_audit'    name='外部评价管理'      action='"+projectNamePath+"/view/pages/product_audit_estimate_list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu id='all_order' name='订单处理'>");
//		menuXML.append("<item  name='查询预订'  id='Task'  action='"+projectNamePath+"/view/pages/barrageFrame.jsp'/>");
//		menuXML.append("<item  id='all_order_search'    name='查询订单' action='"+projectNamePath+"/order/key/list'/>");
//		menuXML
//				.append("<item id='all_order_labor' name='创建手工单' action='"+projectNamePath+"/view/pages/order/process_order_labor_list.jsp'/>");
//		menuXML
//				.append("<item  id='all_order_getorder'    name='处理订单' action='"+projectNamePath+"/view/pages/process_order_access_list.html'/>");
//		menuXML
//				.append("<item  id='all_order_attemper'    name='订单调度' action='"+projectNamePath+"/view/pages/process_order_dispatch_list.html'/>");
//		menuXML
//				.append("<item  id='all_order_audit'    name='日审夜审'      action='"+projectNamePath+"/view/pages/process_order_dayornightauditor_list.html'/>");
//		
//		menuXML.append("<item  id='all_order_export'    name='导出对房表'      action='"+projectNamePath+"/view/pages/export_room.jsp'/>");
//		
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name=  '候选个体管理'  id='all_member_userbasetemp'>");
//		menuXML
//				.append("<item  id='all_member_userbasetemp_userbasetempadmin'  name='维护候选个体'  action='"+projectNamePath+"/view/pages/member/user_base_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_member_userbasetemp_userbasetempimport'  name='导入候选个体'  action='"+projectNamePath+"/view/pages/member/user_base_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_userbasetemp_userbasetempimporthistorysearch'  name='错误候选个体'  action='"+projectNamePath+"/view/pages/member/user_base_error_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_userbasetemp_userbaseinvite'  name='邀请个体注册'  action='"+projectNamePath+"/view/pages/member/user_base_invite/list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='个体会员管理'  id='all_member_userbase'>");
//		menuXML
//				.append("<item  id='all_member_userbase_userbaseadmin'  name='维护个体会员'  action='"+projectNamePath+"/view/pages/member/user_member_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_member_userbase_userbaseimport'  name='批量导入个体'  action='"+projectNamePath+"/view/pages/member/user_member_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_userbase_userbaseimporthistorysearch'  name='错误个体记录'  action='"+projectNamePath+"/view/pages/member/user_member_error_import/introduce.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='候选组织管理'  id='all_member_groupbasetemp'>");
//		menuXML
//				.append("<item  id='all_member_groupbasetemp_groupbasetempadmin'  name='维护候选组织'  action='"+projectNamePath+"/view/pages/member/group_base_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_member_groupbasetemp_groupbasetempimport'  name='导入候选组织'  action='"+projectNamePath+"/view/pages/member/group_base_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_groupbasetemp_groupbasetempimporthistorysearch'  name='错误候选组织'  action='"+projectNamePath+"/view/pages/member/group_base_error_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_groupbasetemp_groupbasetempinvite'  name='邀请组织注册'  action='"+projectNamePath+"/view/pages/member/group_base_invite/list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='组织会员管理'  id='all_member_groupbase'>");
//		menuXML
//				.append("<item  id='all_member_groupbase_groupbaseadmin'  name='维护组织会员'  action='"+projectNamePath+"/view/pages/member/group_member_admin/list.jsp'/>");
//		menuXML
//				.append("<item  id='all_member_groupbase_groupbaseimport'  name='批量导入组织'  action='"+projectNamePath+"/view/pages/member/group_member_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='all_member_groupbase_groupbasetempimporthistorysearch'  name='错误候选组织'  action='"+projectNamePath+"/view/pages/member/group_member_error_import/introduce.html'/>");
//		menuXML
//				.append("<item  id='contract'    name='合同管理'  action='"+projectNamePath+"/view/pages/member/group_biz_contract/contract.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='会员卡管理'  id='member_card'>");
//		menuXML
//				.append("<item  id='cardNo_scope_admin'  name='号段配置'  action='"+projectNamePath+"/view/pages/marketing/member_card_admin/membercardadmin.html'/>");
//		menuXML
//				.append("<item  id='cardNo_link'  name='联名卡制作计划'  action='"+projectNamePath+"/view/pages/marketing/link_card_plan/membercard.html'/>");
//		menuXML
//				.append("<item  id='cardNo_plan'  name='纵横卡制作计划'  action='"+projectNamePath+"/view/pages/marketing/member_card_plan/membercard.html'/>");
//		menuXML
//				.append("<item  id='cardNo_exchange'  name='会员卡出入库'  action='"+projectNamePath+"/view/pages/marketing/member_card_exchange/card.html'/>");
//		menuXML
//				.append("<item  id='cardNo_suitmeal'  name='套餐规则管理'  action='"+projectNamePath+"/view/pages/marketing/suitmeal/suitmeal.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='积分管理'  id='all_member_score'>");
//		menuXML
//				.append("<item  id='score_purchase'  name='购买积分'  action='"+projectNamePath+"/view/pages/marketing/score_purchase/scorePurchase.html'/>");
//		menuXML
//				.append("<item  id='hand_score'  name='奖罚积分'  action='"+projectNamePath+"/view/pages/marketing/hand_score/handScore.html'/>");
//		menuXML
//				.append("<item  id='score_exchange'  name='商家积分交换'  action='"+projectNamePath+"/view/pages/marketing/score_exchange/scoreExchange.html'/>");
//		menuXML
//				.append("<item  id='join_score'  name='合并会员卡积分'  action='"+projectNamePath+"/view/pages/marketing/join_score/joinScore.html'/>");
//		menuXML
//				.append("<item  id='manage_score'  name='积分状态管理'  action='"+projectNamePath+"/view/pages/marketing/manage_score/manageScore.html'/>");
//		menuXML
//				.append("<item  id='edit_score'  name='积分数量修改'  action='"+projectNamePath+"/view/pages/marketing/edit_score/editScore.html'/>");
//		menuXML
//				.append("<item  id='score_record_list'  name='积分明细'  action='"+projectNamePath+"/view/pages/marketing/score_record_list/scoreRecordList.html'/>");
//		menuXML.append("</menu>");
//		// menuXML.append("<menu name='临时功能' id='all_member_colligate'>");
//		// menuXML.append("<item id='all_member_colligate_maintenancemember'
//		// name='个体弹屏'
//		// action='"+projectNamePath+"/view/pages/member/user_member_register/page.jsp'/>");
//		// menuXML.append("<item id='all_member_colligate_audit' name='审批角色申请'
//		// action='list.html'/>");
//
//		// menuXML.append("</menu>");
//		menuXML.append("<menu  name='授权管理'  id='all_support_access'>");
//		menuXML
//				.append("<item  id='all_support_serviceregistry'  name='配置授权服务'  action='"+projectNamePath+"/view/pages/support/service_registry_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_support_roleregistry'  name='配置功能角色'  action='"+projectNamePath+"/view/pages/support/role_registry_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_support_position'  name='配置流程角色'  action='"+projectNamePath+"/view/pages/support/position_manage_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_support_authorization'  name='组织成员授权'  action='"+projectNamePath+"/view/pages/member/user_accredit_admin/list.html'/>");
//		menuXML
//				.append("<item  id='member_role_authority'  name='会员角色授权'  action='"+projectNamePath+"/view/pages/member/member_role_authority/memberrole.html'/>");
//		menuXML
//				.append("<item  id='member_update_password'  name='修改密码'  action='"+projectNamePath+"/view/pages/support/update_password/list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='配置数据字典'  id='all_support_dic'>");
//		menuXML
//				.append("<item  id='all_support_generalDic'        name='维护数据字典'  action='"+projectNamePath+"/view/pages/support/general_dic_admin/list.html'/>");
//		menuXML
//				.append("<item  id='all_base_static_moneytype'  name='维护币种'                  action='"+projectNamePath+"/view/pages/product_crrency_list.html'/>");
//		menuXML
//				.append("<item  id='all_support_calenderEvent'  name='设置会展节日'            action='"+projectNamePath+"/view/pages/support/calender_event_admin/calenderEvent.html'/>");
//
//		menuXML
//				.append("<item  id='distributor'    name='品牌管理'  action='"+projectNamePath+"/view/pages/member/distributor_brand/list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='工作流管理'  id='all_support_process'>");
//		menuXML
//				.append("<item  id='process_registry'  name='流程模板维护'  action='"+projectNamePath+"/view/pages/support/process_registry_admin/processList.html'/>");
//		menuXML
//				.append("<item  name='审批历史记录'  id='plan'  action='"+projectNamePath+"/view/pages/support/process_history_admin/processhistory.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='消息管理'  id='all_support_message'>");
//		menuXML
//				.append("<item  id='all_support_desk'  name='桌面消息'  action='"+projectNamePath+"/view/pages/support_jms_desktop_admin_list.html'/>");
//		menuXML
//				.append("<item  id='all_support_log'    name='日志信息'  action='"+projectNamePath+"/view/pages/support_jms_log_admin_list.html'/>");
//		menuXML
//				.append("<item  id='all_support_registry'  name='消息配置'  action='"+projectNamePath+"/view/pages/support_jms_log_registry_list.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  id='customer_service'    name='客服管理'>");
//		menuXML
//				.append("<item  id='custome_Complaint'    name=  '投诉记录'      action='"+projectNamePath+"/view/pages/customer/customer_complaint_list.html'/>");
//		menuXML
//				.append("<item  id='custome_CallBack'    name=  '回访计划'    action='"+projectNamePath+"/view/pages/customer/customer_callback_list.html'/>");
//		menuXML
//				.append("<item  id='CustomerCare'    name='客户关怀'      action='"+projectNamePath+"/view/pages/customer/customerCare.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='业务规则管理'  id='marketing_score'>");
//		menuXML
//				.append("<item  id='event_award_score_rule'  name='积分奖赏规则'  action='"+projectNamePath+"/view/pages/marketing/event_award_score_rule/eventAwardScoreRule.html'/>");
//		menuXML
//				.append("<item  id='event_reduce_score_rule'  name='积分扣减规则'  action='"+projectNamePath+"/view/pages/marketing/event_reduce_score_rule/eventReduceScoreRule.html'/>");
//		menuXML
//				.append("<item  id='score_exchange_rule'  name='积分汇率规则'  action='"+projectNamePath+"/view/pages/marketing/score_exchange_rule/scoreExchangeRule.html'/>");
//		menuXML
//				.append("<item  id='MemberCreditRule'  name='信用等级规则'  action='"+projectNamePath+"/view/pages/marketing/other_business_rule/member_credit_rule.html'/>");
//		menuXML
//				.append("<item  id='MemberRankRule'  name='会员等级规则'  action='"+projectNamePath+"/view/pages/marketing/other_business_rule/member_rank_rule.html'/>");
//		menuXML
//				.append("<item  id='PreferenceExlueRule'  name='优惠互斥规则'  action='"+projectNamePath+"/view/pages/marketing/other_business_rule/preference_exlue_rule.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='优惠券管理'  id='coupon_admin'>");
//		menuXML
//				.append("<item  id='coupon_no'  name='优惠券号段配置'  action='"+projectNamePath+"/view/pages/marketing/coupon_admin/coupon_no.html'/>");
//		menuXML
//				.append("<item  id='coupon_store_exchange1'  name='电子优惠券计划'  action='"+projectNamePath+"/view/pages/marketing/coupon_plan/couponPlan.html'/>");
//		menuXML
//				.append("<item  id='coupon_store_exchange2'  name='凭证优惠券计划'  action='"+projectNamePath+"/view/pages/marketing/coupon_plan/credencePlan.html'/>");
//		menuXML
//				.append("<item  id='coupon_store_exchange3'  name='网站优惠券计划'  action='"+projectNamePath+"/view/pages/marketing/coupon_plan/electronPlan.html'/>");
//		menuXML
//				.append("<item  id='coupon_store_exchange4'  name='媒体优惠券计划'  action='"+projectNamePath+"/view/pages/marketing/coupon_plan/mediaPlan.html'/>");
//		menuXML
//				.append("<item  id='coupon_store_exchange'  name='优惠券出入库'  action='"+projectNamePath+"/view/pages/marketing/coupon_admin/voucherCoupon.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='礼品管理'  id='good_admin'>");
//		menuXML
//				.append("<item  id='good_category'  name='礼品分类'  action='"+projectNamePath+"/view/pages/marketing/goodCategory/goodCategory.html'/>");
//		menuXML
//				.append("<item  id='good_info'  name='礼品信息'  action='"+projectNamePath+"/view/pages/marketing/good/good_list.html'/>");
//		menuXML
//				.append("<item  id='good_change'  name='礼品兑换处理'  action='"+projectNamePath+"/view/pages/marketing/goodchange/goodchange.html'/>");
////		menuXML.append("<item  id='good_store_item'  name='库存记录'  action='"+projectNamePath+"/view/pages/marketing/goodStoreItem/goodStoreItem.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='促销计划管理'  id='promotion_plan_admin'>");
//		menuXML
//				.append("<item  id='gift_promotion'  name='礼品促销'  action='"+projectNamePath+"/view/pages/marketing/gift_promotion/giftPromotion.html'/>");
//		menuXML
//				.append("<item  id='discount_promotion'  name='折扣促销'  action='"+projectNamePath+"/view/pages/marketing/discount_promotion/discountPromotion.html'/>");
//		menuXML
//				.append("<item  id='bingding_promotion'  name='捆绑促销'  action='"+projectNamePath+"/view/pages/marketing/bingding_promotion/bingdingPromotion.html'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='字典信息管理'  id='dictionary_admin'>");
//		menuXML
//				.append("<item  id='dictionary_manage'  name='字典维护'  action='/etipcc/view/pages/dictionary/manage/diclist.jsp'/>");
//		menuXML
//				.append("<item  id='dictionary_add'  name='字典配置'  action='/etipcc/view/pages/dictionary/config/dictionaryManage.jsp'/>");
//		menuXML.append("</menu>");
//		menuXML.append("<menu  name='产品政策调控'  id='product_policy_admin'>");
//		menuXML
//				.append("<item  id='policy_config'  name='批量调控配置'  action='/etipcc/view/pages/productpolicy/config/productPolicyConfig.jsp'/>");
//		menuXML
//				.append("<item  id='policy_manage'  name='批量调控维护'  action='/etipcc/view/pages/productpolicy/manage/policy_list.jsp'/>");
//		menuXML.append("</menu>");
//		
//		menuXML.append("<menu  name='产品资源配置管理'  id='product_resources_admin'>");
//		menuXML
//				.append("<item  id='product_resources_config'  name='配置产品资源类型'  action='/etipcc/view/pages/productresources/config/productTypeConfig.jsp'/>");
//		menuXML
//				.append("<item  id='product_resources_manage'  name='产品资源维护'  action='/etipcc/view/pages/productresources/manage/product_resource_list.jsp'/>");
//		menuXML.append("</menu>");
//		menuXML.append("</menubar>");
//		MenuModel model = new MenuModel();
//		model.setXmlString(menuXML.toString());
//		model.parseFromXML();
//
//		setJson(menuHtml.toString());
		return null;
	}
	/**
	 * 通过文本内容构造树形菜单，内容描述采用json格式
	 * 
	 * @return
	 */
	public String getSystemTree() {
		projectNamePath = ServletActionContext.getRequest().getContextPath();
		// 我们的大树
		StringBuffer sb1 = new StringBuffer();
		sb1.append("[");
		
		
//		一级系统管理start
//		一级系统管理start
//		一级系统管理start
//		一级系统管理start
		String strHtml1 = "{id:'menu9', text:'系统管理', singleClickExpand:true, children:[";
		StringBuffer sbSysMng = new StringBuffer();
		String strSysMng = getSysHtmlString();
		if(!"".equals(strSysMng) && null!=strSysMng){
			sbSysMng.append(strHtml1);
			sbSysMng.append(strSysMng);
			sbSysMng.append("]},");
		}
		sb1.append(sbSysMng);
		
		
		
		
////		一级预算管理start
////		一级预算管理start
////		一级预算管理start
////		一级预算管理start
//		String strHtml2 = "{id:'menu2', text:'银行账户管理', singleClickExpand:true, children:[";
//		StringBuffer sbBankMng = new StringBuffer();
//		String strBankMng = getYuSuanHtmlString();
//		if(!"".equals(strBankMng) && null!=strBankMng){
//			sbBankMng.append(strHtml2);
//			sbBankMng.append(strBankMng);
//			sbBankMng.append("]},");
//		}
//		sb1.append(sbBankMng);
		
		
		
		

//		一级币种管理start
//		一级币种管理start
//		一级币种管理start
//		一级币种管理start
		StringBuffer sbBussObj = new StringBuffer();
		String strBussObj = getBussinessObjHtmlString();
		if(!"".equals(strBussObj) && null!=strBussObj){
			sbBussObj.append(strBussObj);
		}
		sb1.append(sbBussObj);
		
		
		
//		一级币种管理start
//		一级币种管理start
//		一级币种管理start
//		一级币种管理start
		StringBuffer sbYuSuan = new StringBuffer();
		String strYuSuanMng = getYuSuanMngHtmlString();
		if(!"".equals(strYuSuanMng) && null!=strYuSuanMng){
			sbYuSuan.append(strYuSuanMng);
		}
		sb1.append(sbYuSuan);

		
		
		
		
//		 一级资金计划start
//		 一级资金计划start
//		 一级资金计划start
//		 一级资金计划start
		String strHtml3 = "{id:'menu6', text:'资金计划', singleClickExpand:true, children:[";
		String strHtml3_1 = "{id:'menu6_1',text:'年计划',singleClickExpand:true,children:[";
		String strHtml3_1_1 = "{id:'menu6_1_1',text:'人民币计划',singleClickExpand:true,children:[";
		String strHtml3_1_2 = "{id:'menu6_1_2',text:'美元计划',singleClickExpand:true,children:[";
		
		StringBuffer sbHtmlAll = new StringBuffer();
		StringBuffer sbHtmlAllItem = new StringBuffer();
		
		StringBuffer sbHtmlY = new StringBuffer();
		StringBuffer sbHtmlYItem = new StringBuffer();
		
		/**     年计划     */
		String strYearRMB = getJiJinYearRMBHtmlString();
		StringBuffer sbYearRMB = new StringBuffer();
		
		if(!"".equals(strYearRMB) && null!=strYearRMB){
			sbYearRMB.append(strHtml3_1_1);
			sbYearRMB.append(strYearRMB.toString());
			sbYearRMB.append("]},");
		}
		
		String strYearDorle = getJiJinYearDorleHtmlString();
		StringBuffer sbYearDorle = new StringBuffer();
		if(!"".equals(strYearDorle) && null!=strYearDorle){
			sbYearDorle.append(strHtml3_1_2);
			sbYearDorle.append(strYearDorle.toString());
			sbYearDorle.append("]},");
		}
		sbHtmlYItem.append(sbYearRMB);
		sbHtmlYItem.append(sbYearDorle);
		if(sbHtmlYItem.length()>0){
			sbHtmlY.append(strHtml3_1);
			sbHtmlY.append(sbHtmlYItem.substring(0, sbHtmlYItem.length()-1));
			sbHtmlY.append("]},");
		}
			
		/**     月计划     */
		String strHtml3_2 = "{id:'menu6_2',text:'月计划',singleClickExpand:true,children:[";
		String strHtml3_2_1 = "{id:'menu6_2_1',text:'人民币计划',singleClickExpand:true,children:[";
		String strHtml3_2_2 = "{id:'menu6_2_2',text:'美元计划',singleClickExpand:true,children:[";
		String strHtml3_2_3 = "{id:'menu6_2_3',text:'多币种计划',singleClickExpand:true,children:[";
		
		StringBuffer sbHtmlM = new StringBuffer();
		StringBuffer sbHtmlMItem = new StringBuffer();
		
		StringBuffer sbMethRMB = new StringBuffer();
		String strMethRMB = getJiJinMethRMBHtmlString();
		if(!"".equals(strMethRMB) && null!=strMethRMB){
			sbMethRMB.append(strHtml3_2_1);
			sbMethRMB.append(strMethRMB);
			sbMethRMB.append("]},");
		}

		StringBuffer sbMethDorle = new StringBuffer();
		String strMethDorle = getJiJinMethDorleHtmlString();
		if(!"".equals(strMethDorle) && null!=strMethDorle){
			sbMethDorle.append(strHtml3_2_2);
			sbMethDorle.append(strMethDorle);
			sbMethDorle.append("]},");
		}
		
		StringBuffer sbMethOther = new StringBuffer();
		String strMethOther = getJiJinMethOtherHtmlString();
		if(!"".equals(strMethOther) && null!=strMethOther){
			sbMethDorle.append(strHtml3_2_3);
			sbMethDorle.append(strMethOther);
			sbMethDorle.append("]},");
		}
		sbHtmlMItem.append(sbMethRMB);
		sbHtmlMItem.append(sbMethDorle);
		sbHtmlMItem.append(sbMethOther);
		if(sbHtmlMItem.length()>0){
			sbHtmlM.append(strHtml3_2);
			sbHtmlM.append(sbHtmlMItem.substring(0, sbHtmlMItem.length()-1));
			sbHtmlM.append("]},");
		}
			
		/**     周计划     */
		String strHtml3_3 = "{id:'menu6_3',text:'周计划',singleClickExpand:true,children:[";
		String strHtml3_3_1 = "{id:'menu6_3_1',text:'人民币计划',singleClickExpand:true,children:[";
		String strHtml3_3_2 = "{id:'menu6_3_2',text:'美元计划',singleClickExpand:true,children:[";
		String strHtml3_3_3 = "{id:'menu6_3_3',text:'多币种计划',singleClickExpand:true,children:[";
		
		StringBuffer sbHtmlW = new StringBuffer();
		StringBuffer sbHtmlWItem = new StringBuffer();
		
		StringBuffer sbWeekRMB = new StringBuffer();
		String strWeekRMB = getJiJinWeekRMBHtmlString();
		if(!"".equals(strWeekRMB) && null!=strWeekRMB){
			sbWeekRMB.append(strHtml3_3_1);
			sbWeekRMB.append(strWeekRMB);
			sbWeekRMB.append("]},");
		}
			
		StringBuffer sbWeekDorle = new StringBuffer();
		String strWeekDorle = getJiJinWeekDorleHtmlString();
		if(!"".equals(strWeekDorle) && null!=strWeekDorle){
			sbWeekDorle.append(strHtml3_3_2);
			sbWeekDorle.append(strWeekDorle);
			sbWeekDorle.append("]},");
		}
		
		StringBuffer sbWeekOther = new StringBuffer();
		String strWeekOther = getJiJinWeekOtherHtmlString();
		if(!"".equals(strWeekOther) && null!=strWeekOther){
			sbWeekOther.append(strHtml3_3_3);
			sbWeekOther.append(strWeekOther);
			sbWeekOther.append("]},");
		}
		sbHtmlWItem.append(sbWeekRMB);
		sbHtmlWItem.append(sbWeekDorle);
		sbHtmlWItem.append(sbWeekOther);
		if(sbHtmlWItem.length()>0){
			sbHtmlW.append(strHtml3_3);
			sbHtmlW.append(sbHtmlWItem.substring(0, sbHtmlWItem.length()-1));
			sbHtmlW.append("]},");
		}
		
		sbHtmlAllItem.append(sbHtmlY);
		sbHtmlAllItem.append(sbHtmlM);
		sbHtmlAllItem.append(sbHtmlW);
		if(sbHtmlAllItem.length()>0){
			sbHtmlAll.append(strHtml3);
			sbHtmlAll.append(sbHtmlAllItem.substring(0, sbHtmlAllItem.length()-1));
			sbHtmlAll.append("]},");
		}
		sb1.append(sbHtmlAll);

		
//		一级预算管理start
//		一级预算管理start
//		一级预算管理start
//		一级预算管理start
		String strHtml2 = "{id:'menu2', text:'银行账户管理', singleClickExpand:true, children:[";
		StringBuffer sbBankMng = new StringBuffer();
		String strBankMng = getYuSuanHtmlString();
		if(!"".equals(strBankMng) && null!=strBankMng){
			sbBankMng.append(strHtml2);
			sbBankMng.append(strBankMng);
			sbBankMng.append("]},");
		}
		sb1.append(sbBankMng);
		
		
//		一级资金结算start
//		一级资金结算start
// 		一级资金结算start
//	 	一级资金结算start
		String strHtml7 = "{id:'menu7', text:'资金结算管理', singleClickExpand:true, children:[";
		StringBuffer sbZiJin = new StringBuffer();
		String strZiJin = getZiJinMngHtmlString();
		if(!"".equals(strZiJin) && null!=strZiJin){
			sbZiJin.append(strHtml7);
			sbZiJin.append(strZiJin);
			sbZiJin.append("]},");
		}
		sb1.append(sbZiJin);
		
		
		
		
		
		
//		一级现金流量管理start
//		一级现金流量管理start
//		一级现金流量管理start
//		一级现金流量管理start
		String strHtml8 = "{id:'menu3', text:'资金月报', singleClickExpand:true, children:[";
		StringBuffer sbZiJinReport = new StringBuffer();
		String strZiJinR = getZiJinReportHtmlString();
		if(!"".equals(strZiJinR) && null!=strZiJinR){
			sbZiJinReport.append(strHtml8);
			sbZiJinReport.append(strZiJinR);
			sbZiJinReport.append("]},");
		}
		sb1.append(sbZiJinReport);
		
		
		
		
//		工作流管理start
//		工作流管理start
//		工作流管理start
//		工作流管理start
		String strHtml9 = "{'text':'工作流管理','id':'all_support_process',singleClickExpand:true,'children':[";
		StringBuffer sbWorkFlow = new StringBuffer();
		String strWorkFlow = getWorkFlowHtmlString();
		if(!"".equals(strWorkFlow) && null!=strWorkFlow){
			sbWorkFlow.append(strHtml9);
			sbWorkFlow.append(strWorkFlow);
			sbWorkFlow.append("]},");
		}
		sb1.append(sbWorkFlow);
		sb1.append("{'text':'任务代理','id':'daili','leaf':true,'href':'"
					+projectNamePath+"/view/pages/sys/proxyTask.jsp','hrefTarget':'mainFrame'}");
		sb1.append("]");
		setJson(sb1.toString());
		System.out.println(sb1.toString());
		return null;
	}

	/**
	 * 根据权限配置菜单
	 * 
	 * @param sb1
	 *            菜单缓冲区对象
	 * @param id
	 *            菜单唯一id,用于tab唯一标识
	 * @param title
	 *            菜单标题
	 * @param isLeaf
	 *            是否叶节点
	 * @param url
	 *            菜单对应的url地址
	 */
	private String appendMenuItem(StringBuffer sb1, String menuStr) {
		StringBuffer menuHtml = new StringBuffer();
		// String menuStr =
		// "{id:'bingding_promotion',text:'捆绑促销','leaf':true,'href':'"+projectNamePath+"/view/pages/marketing/bingding_promotion/bingdingPromotion.html','hrefTarget':'mainFrame'}";
		String beginToken = "'href':'";
		int urlBeginIndex = menuStr.indexOf(beginToken);
		String endToken = "','hrefTarget'";
		int urlEndIndex = menuStr.indexOf(endToken);
		String url = menuStr.substring(urlBeginIndex + beginToken.length(), urlEndIndex);
		int paramIndex = url.indexOf("?");
		if(paramIndex>0){
			url = url.substring(0, paramIndex);
		}

		// 由于树节点的href上比权限url多一级目录，在此去掉
		if(url.startsWith(projectNamePath)){
			url = url.substring(7);
		}

		// 首先取得url对应的角色授权，从UrlObjectDefinitionSource中取
		UrlObjectDefinitionSource urlService = (UrlObjectDefinitionSource) SpringContextHelper
				.getBean("UrlObjectDefinitionSource");
		String urlRoles = urlService.getURLRoles(url);

//		// 如果此url没有被授给角色，那么将被显示出来
//		if (urlRoles == null || "".equals(urlRoles)) {
//			sb1.append(menuStr);
//			return;
//		}
		
		// 如果此url没有被授给角色，那么将被显示出来
		if (urlRoles == null || "".equals(urlRoles)) {
			sb1.append(menuStr);
			return "";
		}

		// 以下判断当前用是否具有对应角色授权。
		String userRoles = this.getFrmUser().roles;

		// 以下判断userRoles中是否有角色包含到urlRoles中。
		boolean access = false;
		StringTokenizer tokens = new StringTokenizer(userRoles, ",");
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (urlRoles.indexOf(token) >= 0) {
				access = true;
				break;
			}
		}
		// 沒有授權，不用顯示菜單
		if (access == false) {
			// 如果当前菜单是最后一个菜单，那么检查sb1是否存在“},”，如果存在，那么去掉,
			if (menuStr.endsWith("}")) {
				int lastIndex = sb1.lastIndexOf("},");
				if (lastIndex == (sb1.length() - 2)) {
					sb1.setCharAt(lastIndex + 1, ' ');
				}

			}
			return "";
		}
		return menuHtml.append(menuStr).toString();

	}
	
	public String getSysHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'业务主体管理','id':'menu9_5','leaf':true,'href':'"
					+projectNamePath+"/view/pages/sys/org.jsp?id=8a00a25e22963bfe01229640db010001','hrefTarget':'mainFrame'},"));
		
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'菜单管理','id':'menu9_2','leaf':true,'href':'"
					+ projectNamePath+"/view/pages/sys/competence/competenceList.html','hrefTarget':'mainFrame'},"));
		
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'用户管理','id':'menu9_3','leaf':true,'href':'"
					+projectNamePath+"/view/pages/sys/userManage.jsp','hrefTarget':'mainFrame'},"));
		
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'岗位管理','id':'menu9_4','leaf':true,'href':'"
					+projectNamePath+"/view/pages/sys/postManage.jsp','hrefTarget':'mainFrame'},"));
		
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'数据字典管理','id':'menu9_6','leaf':true,'href':'"
					+projectNamePath+"/view/pages/sys/data_dictionary/dictionaryList.html','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	
	public String getYuSuanHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{text:'银行账户维护',id:'menu2_1',  leaf:true, 'href':'"+projectNamePath+"/view/pages/core/account/bankaccounts.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'账户信息查询','id':'menu2_2','leaf':true,'href':'"+projectNamePath+"/view/pages/core/queryAccount/queryAccount.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	
	public String getJiJinYearRMBHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_1_1_1', text:'人民币年度计划','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
					new StringBuffer(),"{id:'menu6_1_1_2', text:'人民币年度资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_one.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
					new StringBuffer(),"{id:'menu6_1_1_3', text:'人民币年度计划完成情况表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_finish.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
					new StringBuffer(),"{id:'menu6_1_1_4', text:'人民币资金收支年计划完成情况','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_rp.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinYearDorleHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_1_2_1', text:'境外年度资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_us.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_1_2_2', text:'境外年度计划完成情况表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_us_finish.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_1_2_3', text:'境外资金收支年计划完成情况','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/yearplan_us_io.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinMethRMBHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_1_1', text:'人民币月度计划','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_1_2', text:'人民币月度资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan23.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_1_3', text:'人民币月度计划完成情况表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_finish.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_1_4', text:'人民币资金收支月计划完成情况','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_rp.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinMethDorleHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_2_1', text:'境外月度资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_us.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_2_2', text:'境外月度计划完成情况表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_us_finish.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_2_3', text:'境外资金收支月计划完成情况','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_us_rp.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_2_4', text:'外汇资金月计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_wz_two.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinMethOtherHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_2_3_1', text:'月外资计划','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/monthplan_wz_one.jsp','hrefTarget':'mainFrame'}"));
		return itemHtml.toString();
	}
	public String getJiJinWeekRMBHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_3_1_1', text:'人民币周计划','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/rmbweekplan.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_3_1_2', text:'人民币周资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/rmbweekplan_4.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinWeekDorleHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_3_2_1', text:'境外周资金计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/rmbweekplan_1.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(  
				new StringBuffer(),"{id:'menu6_3_2_2', text:'外汇资金周计划表','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/rmbweekplan_2.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getJiJinWeekOtherHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu6_3_3_1', text:'周外资计划','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/rmbweekplan_3.jsp','hrefTarget':'mainFrame'}"));
		return itemHtml.toString();
	}
	public String getZiJinMngHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'收款结算','id':'menu7_1','leaf':true,'href':'"+projectNamePath+"/view/pages/core/receipt/receiptAccount.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'对外付款','id':'menu7_3','leaf':true,'href':'"+projectNamePath+"/view/pages/core/payment/payment.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'内部付款','id':'menu7_7','leaf':true,'href':'"+projectNamePath+"/view/pages/core/transfer/transfer.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'其它付款','id':'menu7_4','leaf':true,'href':'"+projectNamePath+"/view/pages/core/otherPay/otherPayAccount.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'交易明细查询','id':'menu7_8','leaf':true,'href':'"+projectNamePath+"/view/pages/core/querySettlement/querySettlement.jsp','hrefTarget':'mainFrame'},"));
		
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getZiJinReportHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'现金流入信息汇总','id':'menu3_1','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/cashin.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{'text':'现金流出信息汇总','id':'menu3_2','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/capital/cashout.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{text  :'现金流入流出信息汇总',id:'menu3_3',  leaf:true, 'href':'"+projectNamePath+"/view/pages/sys/capital/cashio.jsp','hrefTarget':'mainFrame'},"));
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{text  :'系统外现金流补录',id:'menu3_4',  leaf:true, 'href':'"+projectNamePath+"/view/pages/core/deletion/deletionManage.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.length()>0?itemHtml.toString().substring(0, itemHtml.length()-1):"";
	}
	public String getWorkFlowHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),
				"{'id':'process_registry','leaf':true,'text':'流程模板维护','href':'"+projectNamePath+"/view/pages/support/process_registry_admin/processList.html','hrefTarget':'mainFrame'},"));
		return itemHtml.toString();
	}
	public String getBussinessObjHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu5', text:'交易对象管理','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/settlement/settlementManage.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.toString();
	}
	public String getYuSuanMngHtmlString(){
		StringBuffer itemHtml = new StringBuffer();
		itemHtml.append(appendMenuItem(
				new StringBuffer(),"{id:'menu4', text:'预算管理','leaf':true,'href':'"+projectNamePath+"/view/pages/sys/budget/budgetManage.jsp','hrefTarget':'mainFrame'},"));
		return itemHtml.toString();
	}
	public static void main(String[] args){
		String s1 = "";
		String s2 = "";
		
		if((!"".equals(s1) || "".equals(s2)) && ("".equals(s1) || !"".equals(s2))){
			System.out.println("---------------");
		}
	}
}
