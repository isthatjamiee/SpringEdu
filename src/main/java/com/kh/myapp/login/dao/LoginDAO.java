package com.kh.myapp.login.dao;

import java.util.Map;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginDAO {
	  // 회원정보 가져오기
	MemberVO getMember(LoginVO loginVO);
	
	public Map<String, Object> selectUser(String username);
}
