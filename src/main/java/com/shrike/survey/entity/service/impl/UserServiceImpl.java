package com.shrike.survey.entity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrike.survey.entity.User;
import com.shrike.survey.entity.repository.UserRepository;
import com.shrike.survey.entity.service.UserService;
import com.shrike.survey.model.LoginUserRequestResponse.LoginUserRequest;
import com.shrike.survey.model.LoginUserRequestResponse.LoginUserResponse;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserRequest;
import com.shrike.survey.model.SignupUserRequestResponse.SignupUserResponse;
import com.shrike.survey.util.EncryptionUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public SignupUserResponse createUser(SignupUserRequest signupUserRequest) {
		SignupUserResponse registerUserResponse = new SignupUserResponse();

		User existingUserByEmail = userRepository.findByEmail(signupUserRequest.getEmail());

		if (null != existingUserByEmail) {
			registerUserResponse.setCode("1001");
			registerUserResponse.setMessage("There exists a user already with the given email/mobile");
		} else {
			User user = new User();
			user.setEmail(signupUserRequest.getEmail());
			user.setFirstName(signupUserRequest.getFirstName());
			user.setLastName(signupUserRequest.getLastName());
			try {
				if (null != signupUserRequest.getPassword() && !signupUserRequest.getPassword().isEmpty()) {
					user.setPassword(EncryptionUtil.encrpyt(signupUserRequest.getPassword()));
				}
			} catch (Exception e) {
				log.debug("Password Encryption Error");
			}

			try {
				userRepository.save(user);
				registerUserResponse.setCode("200");
				registerUserResponse.setMessage("You have been successfully registered");
				registerUserResponse.setEmail(user.getEmail());
			} catch (Exception ex) {
				registerUserResponse.setCode("1002");
				registerUserResponse
						.setMessage("It seems that there is an issue while " + "registering. Please try again");
			}
		}
		return registerUserResponse;

	}

	@Override
	public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {

		LoginUserResponse loginUserResponse = new LoginUserResponse();

		String email = loginUserRequest.getEmail();
		String password = loginUserRequest.getPassword();
		User user = userRepository.findByEmail(email);
		if (null != user) {
			try {
				String encryptLoginPassword = EncryptionUtil.encrpyt(password);
				if (user.getPassword().equals(encryptLoginPassword)) {
					loginUserResponse.setEmail(email);
					loginUserResponse.setCode("200");
					loginUserResponse.setMessage("Successfully logged in!!");
				} else {
					loginUserResponse.setCode("1003");
					loginUserResponse.setMessage("Invalid Username or Password");
				}

			} catch (Exception e) {
				log.debug("{}", e.getLocalizedMessage());
			}
		} else {
			loginUserResponse.setCode("1004");
			loginUserResponse
					.setMessage("There exists no user registered with the given email account. Please Sign up first!!");
		}

		return loginUserResponse;
	}
}
