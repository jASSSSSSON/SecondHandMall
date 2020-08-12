package com.secondshop.services;

import com.secondshop.mappers.UserMapper;
import com.secondshop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

	private final UserMapper userMapper;//引入UserMapper

	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Transactional
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}//查询用户信息

	@Transactional
	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}//根据id查询用户信息

	@Transactional
	public User getUserByEmail(String email) {
		return userMapper.getUserByEmail(email);
	}//根据邮箱查询用户信息

	@Transactional
	public User getUserByMobile(String mobile) {
		return userMapper.getUserByMobile(mobile);
	}//根据手机查询用户信息

	@Transactional
	public Boolean registerUser(User user) {
		return userMapper.insertUser(user) > 0;
	}//用于用户注册，往user_table中插入用户信息

	@Transactional
	public Boolean updateUser(User user) {
		return userMapper.updateUser(user) > 0;
	}//修改用户个人信息

	@Transactional
	public Boolean deleteUser(Integer userId) {
		return userMapper.deleteUser(userId) > 0;
	}//根据id删除用户

	@Transactional
	public Boolean updateUserStatus(Integer statusId, Integer userId) {//根据id修改用户账号的status_id（状态编号）
		return userMapper.updateUserStatus(statusId, userId) > 0;
	}

	@Transactional
	public Boolean updatePassword(String newPassword, String code,//根据id修改用户账号密码
			Integer userId) {
		return userMapper.updatePassword(newPassword, code, userId) > 0;
	}
}
