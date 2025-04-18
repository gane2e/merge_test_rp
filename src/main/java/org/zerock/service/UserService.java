package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.domain.LoginVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserService {
	
	private final BCryptPasswordEncoder 
	B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	@Autowired
	UserMapper userMapper;

	public void userRegister(UserVO userVO) {
		
		userMapper.insertUser(userVO);
	}
	
	public LoginVO userLogin(UserVO userVO) {
		
		LoginVO loginVO = userMapper.selectUser(userVO.getLoginId());
		
		if(loginVO != null && B_CRYPT_PASSWORD_ENCODER.matches(userVO.getPassword(), loginVO.getPass())) {
			return loginVO;
		} else
			return null;
		
	}
}
