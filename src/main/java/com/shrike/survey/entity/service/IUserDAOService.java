package com.shrike.survey.entity.service;

import com.shrike.survey.entity.User;

public interface IUserDAOService {
	
	User findByEmail(String email);

}
