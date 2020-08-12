package com.secondshop.models;

/**
 * 密码表
 * 
 * @author WEN
 *
 */
public class Password {
	private int userId;//用户编号
	private String oldPassword;//旧密码
	private String newPassword;//新密码

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
