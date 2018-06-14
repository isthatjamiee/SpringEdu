package com.kh.myapp.login.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class LoginTest {

	private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

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
