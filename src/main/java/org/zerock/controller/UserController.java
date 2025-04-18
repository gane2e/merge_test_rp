package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.LoginVO;
import org.zerock.domain.UserVO;
import org.zerock.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/user/**")
@RequiredArgsConstructor
public class UserController {
	
	private final BCryptPasswordEncoder 
	B_CRYPT_PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	private final UserService userService;
	
	
	@GetMapping(value = "/login")
	public String login() {
		log.info("login");
		return "user/login";
	}
	
	@GetMapping(value = "/register")
	public String getRegister() {
		log.info("register");
		return "user/register";
	}
	
	
	@PostMapping(value = "/register")
	public String requestRegister(UserVO userVO, RedirectAttributes redirectAttributes) {
		
		userVO.setPassword(B_CRYPT_PASSWORD_ENCODER.encode(userVO.getPassword()));
		userService.userRegister(userVO);
		
		redirectAttributes.addFlashAttribute("successMsg", "회원가입이 완료되었습니다.");
		return "redirect:user/login";
		
	}
	
	@PostMapping(value = "/login")
	public String requestLogin(UserVO userVO, RedirectAttributes redirectAttributes, HttpSession session, Model model) {
		
		LoginVO loginVO = userService.userLogin(userVO);
		
		if(loginVO != null) {
			redirectAttributes.addFlashAttribute("loginSuccessMsg", "로그인 되었습니다.");
			session.setAttribute("loginId", loginVO.getMember_id());
			session.setAttribute("username", loginVO.getName());
			log.info(loginVO.getName());
			return "home";
		}
			
		else {
			redirectAttributes.addFlashAttribute("loginFailMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:user/login";
		}
			
		
	}

}
