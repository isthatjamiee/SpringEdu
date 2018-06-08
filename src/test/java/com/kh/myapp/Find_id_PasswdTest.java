package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.dao.MemberDAOImplJDBC;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
class Find_id_PasswdTest {

	private static final Logger logger = LoggerFactory.getLogger(Find_id_PasswdTest.class);
	
	@Autowired
	MemberDAOImplJDBC memberdao;	
	
	@Test
	void findIdtest() {
		String id = memberdao.findId("킷캣", "01098465124");
		logger.info("찾은 아이디" + id);
	}
	
	@Test
	void findPasswdtest() {
	  String passwd = memberdao.findPasswd("emfkfk@hanmail.com", "헤헤헤", "01028943234");
	  logger.info("찾은 비밀번호" + passwd);
	}
	
	@Autowired
	@Qualifier("memberDAOImplXML")
	MemberDAO memberdaoxml;
	
	@Test
	void xmlTest() {
		String id = memberdaoxml.findId("킷캣", "01098465124");
		logger.info("xml찾은 아이디" + id);
		
		String passwd = memberdaoxml.findPasswd("emfkfk@hanmail.com", "헤헤헤", "01028943234");
		logger.info("xml찾은 비밀번호" + passwd);
	}
	

}
