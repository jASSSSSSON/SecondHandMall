package com.secondshop.models;

/**
 * 物品照片表
 * 
 * @author WEN
 *
 */
public class Image {
	//图片id
	private int id;
	//物品图片
	private int goodId;
	//物品名
	private String name;
	//图片地址
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
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
