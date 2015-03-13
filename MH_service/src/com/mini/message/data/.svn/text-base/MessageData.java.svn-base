package com.mini.message.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.itour.etip.pub.frame.FrmData;
import com.sys.user.data.UserData;

/**
 * 〈留言表〉 〈功能详细描述〉
 * 
 * @author [作者]（侯杨）
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Entity
@Table(name="MINI_MESSAGE")
public class MessageData extends FrmData{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private  String userId;   //用户主键
	
	
	private  String title;    //留言标题
	
	
	private  String contenu;  //留言内容
	
	
	private  String status;   //状态  是否查看 1 未查看 0 已查看
	
	
	private  String isdelete; //是否删除   1未假删  0删除
	
	
	private  Date createTime; //创建时间
	
	
	private Date examinerTime; //查看时间
	
	private String  signeContenu;  //标记内容
	
	private String  userName;  //留言人账号（邮箱或者手机号码）
	
	private String uName;  //留言人用户名
	private UserData userData;  //用户实体
	
	@Column(name="USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="CONTENU")
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name="ISDELETE")
	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	@Column(name="CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="EXAMINETIME")
	public Date getExaminerTime() {
		return examinerTime;
	}

	public void setExaminerTime(Date examinerTime) {
		this.examinerTime = examinerTime;
	}
	
	@Column(name="SIGNECONTENU")
	public String getSigneContenu() {
		return signeContenu;
	}

	public void setSigneContenu(String signeContenu) {
		this.signeContenu = signeContenu;
	}

	@Transient
	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	@Column(name="USERNAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name="UNAME")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
	
	
	/*************************************************************************************/
	

}
