package com.secondshop.models;

/**
 * 权限表
 * 
 * @author WEN
 *
 */
public class Role {
	//角色ID
	private int id;
	//角色代码
	private String code;
	//角色
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
