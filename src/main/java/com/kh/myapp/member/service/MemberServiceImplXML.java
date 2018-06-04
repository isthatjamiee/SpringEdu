package com.kh.myapp.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class MemberServiceImplXML implements MemberService {

	@Autowired
	@Qualifier("memberDAOImplXML")
	MemberDAO memberDAO;
	
	@Override
	public void memberInsert(MemberVO memberVO) {
		System.out.println("테스트");
		memberDAO.insert(memberVO);

	}

	@Override
	public MemberVO getByMemberID(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> getMemberAll() {
		return memberDAO.getMemberList();
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		memberDAO.update(memberVO);

	}

	@Override
	public void memberDelete(String id) {
		memberDAO.delete(id);

	}

}
