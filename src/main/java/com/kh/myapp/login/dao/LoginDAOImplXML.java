package com.kh.myapp.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplXML implements LoginDAO{

	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		MemberVO memVO = sqlSession.selectOne("getByMemID", memberVO);
		return memVO;
	}

}
