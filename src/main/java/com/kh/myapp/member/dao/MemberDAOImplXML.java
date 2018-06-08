package com.kh.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository
public class MemberDAOImplXML implements MemberDAO {
	
	@Autowired //자동주입
	private SqlSession sqlSession; //sqlsession으로 접근

	@Override
	public void insert(MemberVO memberVO) {
		System.out.println("또 테스트");
		sqlSession.insert("memberInsert", memberVO);
		System.out.println("또 테스트 ㅠㅠㅠ");
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO memberVO = sqlSession.selectOne("getByMemberID", id);
		return memberVO;
	}

	@Override
	public List<MemberVO> getMemberList() {
	  List<MemberVO> list = sqlSession.selectList("getMemberAll");
			return list;
	}

	@Override
	public void update(MemberVO memberVO) {
		 sqlSession.update("memberUpdate", memberVO);
		
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("memberDelete", id);
	}

	@Override
	public String findId(String name, String phone) {
		return sqlSession.getMapper(MemberDAO.class).findId(name, phone);
	}

	@Override
	public String findPasswd(String id, String name, String phone) {
		return sqlSession.getMapper(MemberDAO.class).findPasswd(id, name, phone);
	}



}
