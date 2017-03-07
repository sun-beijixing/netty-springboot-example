package com.anyikang.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.mapper.UserMapper;
import com.anyikang.model.User;
import com.anyikang.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.UserService#getUserInfo()
	 */
	@Override
	public User getUserInfo() {
		User user = userMapper.findUserInfo();
		return user;
	}

}
