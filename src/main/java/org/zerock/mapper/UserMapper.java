package org.zerock.mapper;

import org.zerock.domain.LoginVO;
import org.zerock.domain.UserVO;

public interface UserMapper {
	
	public void insertUser(UserVO userVO);
	
	public LoginVO selectUser(String loginId);

}
