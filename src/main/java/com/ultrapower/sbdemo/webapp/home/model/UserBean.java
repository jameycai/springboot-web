package com.ultrapower.sbdemo.webapp.home.model;

import java.io.Serializable;


/**
 * 
 * @ClassName:     用户Pojo类 
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @company        Ultrapower
 * @author         caijinpeng
 * @email          jamey_cai@163.com
 * @version        V1.0
 * @Date           2017年12月14日 下午1:25:05 
 *
 */
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private long userId;
	/**
	 * 用户账号
	 */
	private String userAccount = "";
	/**
	 * 用户姓名
	 */
	private String userName = "";
	/**
	 * 用户密码
	 */
	private String password = "";
	/**
	 * 部门ID
	 */
	private String dept_id = "";
	private String dept_Name = "";
	/**
	 * 所属业务
	 */
	private String business = "";
	/**
	 * 用户状态
	 */
	private int user_status;

	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_Name() {
		return dept_Name;
	}

	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	} 
	
	

	
}
