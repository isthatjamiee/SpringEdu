/*package com.kh.myapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.member.vo.MemberVO;

//@Controller //컨트롤러임을 나타낸다.
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController_OLD {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController_OLD.class);

	@Autowired
	@Qualifier("loginServiceImplJDBC")
	LoginService loginService;
	
	//로그인 화면 보여주기
	@RequestMapping("/loginIn")
	public String logIn(Model model){
		model.addAttribute("user", new MemberVO());
	  return "login/login";
	}

	// 로그인 처리 부분
	@RequestMapping("/memLoginOK")
  //MemberVO 에서 유효성 검사하고 결과는 BindingResult 으로
	public String memLoginOK(@Valid @ModelAttribute("user") MemberVO user, BindingResult result, Model model){
    if(result.hasErrors()) {
  	  return "login/login";
    }
    
    //회원정보 가져오기
    MemberVO memberVO = loginService.getMember(user);
    if(memberVO != null) {
    	//회원정보 세션에 담기
    	model.addAttribute("user", memberVO);
    	return "redirect:/";
    }else {
    	return "login/login";
    }
	}

	//로그아웃 처리부분
  @RequestMapping("/logout")
  public String logout(@ModelAttribute("user") MemberVO user, SessionStatus sessionStatus) {
  	sessionStatus.setComplete();
  	
  	
  	return "redirect:/";
  }

}
*/