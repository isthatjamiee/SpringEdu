package com.kh.myapp;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.service.MemberServiceImplXML;
import com.kh.myapp.member.vo.MemberVO;

import jdk.nashorn.internal.ir.annotations.Ignore;

//@RunWith(SpringJUnit4ClassRunner.class) junit 4버전 사용
@ExtendWith(SpringExtension.class) //junit5 버전 사용 SpringExtension -> 스프링에서 테스트를 하겠다는 말...
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

class MybatisTest {

	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	 
/*	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService xml;

	@Test @Ignore
	public void test() {
		MemberVO memberVO = 
		xml.getByMemberID("emfkfk@hanmail.com");
    logger.info(memberVO.toString());	
		
	}*/
	

	@Autowired
	@Qualifier("loginServiceImplXML")
	LoginService loginService;

	@Test
	public void test1() {
		LoginVO loginVO = new LoginVO();
		loginVO.setId("kitkat@kh.com");
		loginVO.setPasswd("4567");
		logger.info(loginService.getMember(loginVO).toString());
	}

}
