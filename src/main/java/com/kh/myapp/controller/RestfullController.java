package com.kh.myapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@RestController // 리소스(데이터) 자체를 변환하는 데 사용(json, xml, 문자열)
@Controller
@RequestMapping("/rest")
public class RestfullController {

	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService memberservice;

	@RequestMapping("/jello")
	public String jello() {
		return "hello";
	}
	@RequestMapping(value="/member", method = RequestMethod.GET)
	public MemberVO member() {

		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin2@kh.com");
		memberVO.setPasswd("1234");
		memberVO.setName("홍길동2");
		memberVO.setPhone("010-1234-5677");
		return memberVO;
	}
	
	@RequestMapping(value="/member/", method = RequestMethod.GET)
	public MemberVO member(@RequestParam String id) {

		MemberVO memberVO = null;
		memberVO = memberservice.getByMemberID(id);
		return memberVO;
	}

	
//produces = "application/json"(사용자 쪽에서 포맷을 결정하는거면 안붙여도 된다.)
//이걸 붙이면 클라이언트쪽은 정보를 받았을 때 포맷 결정하는 선택권이 없다 
	@RequestMapping(value = "/mem", method = RequestMethod.GET, produces = "application/json") 
	public MemberVO mem(@RequestParam("id") String id) {
		
		MemberVO memberVO = null;
		memberVO = memberservice.getByMemberID(id);
		return memberVO;
	}

	@RequestMapping(value="/memberList", method=RequestMethod.GET)
	public List memberList() {
		
		List<MemberVO> list = new ArrayList<>();

		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin@kj.com");
		memberVO.setPasswd("1234");
		memberVO.setName("홍길동");
		memberVO.setPhone("010-1234-5678");
		list.add(memberVO);
		
		MemberVO memberVO2 = new MemberVO();
		memberVO2.setId("admin2@kh.com");
		memberVO2.setPasswd("1234");
		memberVO2.setName("홍길동2");
		memberVO2.setPhone("010-1234-5677");
		list.add(memberVO2);   

		return list;
		
	}
	
	
	@RequestMapping("/memberMap")
	public Map<Integer, MemberVO> memberMap(){
		Map<Integer, MemberVO> map = new HashMap<>();
		
		for(int i=0; i<10; i++) {
			MemberVO mvo = new MemberVO();
			mvo.setId("admin@kh.com"+i);
			mvo.setPasswd("1234"+i);
			mvo.setName("홍길동"+i);
			mvo.setBirth("01012345678"+i);
			map.put(i+1, mvo);
			
		}
		return map;
	}
	
	@RequestMapping("/array")
	public String[] array() {
		String[] str = new String[]{
				"홍길동","홍길서","홍길남","홍길북"
				};
				return str;
	}
	
	
	
}
