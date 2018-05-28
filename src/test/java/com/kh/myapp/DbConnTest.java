package com.kh.myapp;

/*import static org.junit.jupiter.api.Assertions.*;
*/
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class DbConnTest {

	private static final Logger logger = LoggerFactory.getLogger(DbConnTest.class);
	@Autowired //root-context에 등록된 빈을 가져다 쓸 때(참조) 사용 의존자동주입
	private DataSource ds;

	@Test
	public void testConnection() throws SQLException {
		//DataSource 접속 여부 확인 테스트
		try (Connection conn = ds.getConnection()) {
			logger.info("연결성공");
		} catch (Exception e) {
			logger.info("연결오류");
			e.printStackTrace();
		}
	}

	@Autowired 
	private SqlSessionFactory sqlfactory;
	
	@Test
	public void testSqlSessionFactory() {
		//SqlSessionFactory 접속여부 테스트
		logger.info("SqlSessionFactory 성공" + sqlfactory.toString());

	}

	@Test
	 public void testSqlSessionTemplete() {
		try(SqlSession session = sqlfactory.openSession()){
			logger.info("SqlSession" + session.toString());
		} catch (Exception e) {
			logger.info("Failed at bring SqlSession");
			e.printStackTrace();
		}
	}
	
}
