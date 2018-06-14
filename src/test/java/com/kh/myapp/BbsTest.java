package com.kh.myapp;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
class BbsTest {

	private static final Logger logger = LoggerFactory.getLogger(BbsTest.class);

	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;

	@Disabled
	@Test
	void insert_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBTitle("Mybatis 테스트11");
		bbsdto.setBName("mybatis11");
		bbsdto.setBHit(1);
		bbsdto.setBContent("게시글 생성11");
		bbsdto.setBGroup(2000);
		bbsdto.setBStep(1);
		bbsdto.setBIndent(1);
		bbsdao.write(bbsdto);
	}
	
	@Disabled
	@Test
	void list_test() {
		 
		List<BbsDTO> list;
		 
		list = bbsdao.list();
		
		logger.info("목록 수 :" + list.size());
	}
	
	@Disabled
	@Test
	void view_test() {
		BbsDTO bbsdto = bbsdao.view("1802");
		logger.info(bbsdto.toString());
	}
	
	@Disabled
	@Test
	void update_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBNum(129);
		bbsdto.setBTitle("수정본");
		bbsdto.setBContent("수정수정");
		bbsdao.modify(bbsdto);
	}
	
	@Disabled
	@Test
	void delete_test() {
		bbsdao.delete(134);
	}
	
	@Disabled
	@Test
	void reply_test(){
	BbsDTO bbsdto = new BbsDTO();
	bbsdto.setBTitle("Mybatis댓글");
	bbsdto.setBName("mybatis댓글1");
	bbsdto.setBHit(1);
	bbsdto.setBContent("답글생성");
	bbsdto.setBGroup(129);
	bbsdto.setBStep(1);
	bbsdto.setBIndent(1);
	bbsdao.reply(bbsdto);
	}
  
  
	@Test
	void replyView_test() {
		logger.info(bbsdao.replyView(1804).toString());
	}
}