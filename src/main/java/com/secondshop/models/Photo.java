package com.secondshop.models;

/**
 * 头像表
 * 
 * @author WEN
 *
 */
public class Photo {
	private int id;//编号
	private int userId;//用户编号
	private String name;//用户昵称
	private String url;//头像路径

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
