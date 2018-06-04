package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.vo.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/test.xml"})
class JunitTest {

	Logger logger = LoggerFactory.getLogger(JunitTest.class);
	
	@Autowired //클래스
	@Qualifier("memVO") //인자로 구분
	MemberVO memberVO;
	
/*	@Autowired
	MemberVO memVO;*/
	
	@Test
	void test() {
		logger.info(memberVO.toString());
	}
}
