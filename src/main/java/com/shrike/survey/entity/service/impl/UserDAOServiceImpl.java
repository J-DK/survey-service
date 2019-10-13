package com.shrike.survey.entity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrike.survey.entity.User;
import com.shrike.survey.entity.repository.UserRepository;
import com.shrike.survey.entity.service.IUserDAOService;

@Service
public class UserDAOServiceImpl implements IUserDAOService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
