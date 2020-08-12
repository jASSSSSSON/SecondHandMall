package com.secondshop.models;

/**
 * 收藏表
 * 
 * @author WEN
 *
 */
public class Collect {
	//收藏id
	private int id;
    //物品id
	private int goodId;
	//物品名
	private String goodName;
	//用户id
	private int userId;
	private Good good;

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

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

}
