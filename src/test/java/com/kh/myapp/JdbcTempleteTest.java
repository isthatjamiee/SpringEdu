package com.kh.myapp;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*import com.kh.myapp.member.dao.MemberDAO;*/
import com.kh.myapp.member.dao.MemberDAOImplJDBC;
import com.kh.myapp.member.vo.MemberVO;

//import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class JdbcTempleteTest {

	private static final Logger logger = LoggerFactory.getLogger(DbConnTest.class);

	@Autowired
	DataSource datasource;

	/*@Autowired
	private MemberDAO memberDAO;*/
	
	private MemberDAOImplJDBC memberDAO = new MemberDAOImplJDBC();

	@Test 
	//@Ignore
	public void test() {
		memberDAO.setDataSource(datasource);
		logger.info(memberDAO.toString());

		MemberVO memberVO = new MemberVO();
		memberVO.setId("kitkat@kh.com");
		memberVO.setPasswd("4567");
		memberVO.setName("킷캣");
		memberVO.setBirth("19985124");
		memberVO.setPhone("01098465124");
		memberVO.setGender("F");
		memberDAO.insert(memberVO);
	}

	//빈 등록정보 확인하기
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for (String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t" + df.getBean(name).getClass().getName());
		}
	}

}
