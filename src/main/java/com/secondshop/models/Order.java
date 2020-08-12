package com.secondshop.models;

import java.text.SimpleDateFormat;

/**
 * 订单表
 * 
 * @author WEN
 *
 */
public class Order {
	//订单编号
	private int id;
	//物品名
	private String goodName;
	//卖家
	private String seller;
	//卖家id
	private int sellerId;
	//买家
	private String customer;
	//买家id
	private int customerId;
	//物品id
	private int goodId;
	//价格
	private int money;
	//订单提交时间
	private String submitDate;
	//订单结束时间
	private String endDate;
	//订单状态
	private int statusId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(java.sql.Timestamp submitDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.submitDate = sdf.format(submitDate);
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Timestamp endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.endDate = sdf.format(endDate);
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}
