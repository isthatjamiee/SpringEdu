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
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
class BbsTest {

	private static final Logger logger = LoggerFactory.getLogger(BbsTest.class);

	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;

/*	//@Ignore //Junit 4버전
	@Disabled //Junit 5 버전
	@Test
	void insert_test() throws Exception {
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
	*/
/*	@Disabled
	@Test
	void list_test() {
		 
		List<BbsDTO> list;
		 
		list = bbsdao.list();
		
		logger.info("목록 수 :" + list.size());
	}*/
	
/*	@Disabled
	@Test
	void view_test() throws Exception {
		BbsDTO bbsdto = bbsdao.view(1802);
		logger.info(bbsdto.toString());
	}
	
	@Disabled
	@Test
	void update_test() throws Exception {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBNum(129);
		bbsdto.setBTitle("수정본");
		bbsdto.setBContent("수정수정");
		bbsdao.modify(bbsdto);
	}
	
	@Disabled
	@Test
	void delete_test() throws Exception {
		bbsdao.delete(134);
	}
	
	@Disabled
	@Test
	void reply_test() throws Exception{
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
  
	@Disabled
	@Test
	void replyView_test() throws Exception {
		logger.info(bbsdao.replyView(1804).toString());
	}
	
	@Disabled
	@Test
	void totalRec() throws Exception {
		logger.info("totalRec :" + bbsdao.totalRec());
	}
	
	@Disabled
	@Test
	void arrayList_test() throws Exception {
		List<BbsDTO> list = null;  
		RecordCriteria recordCriteria = new RecordCriteria(1);
	  list = bbsdao.list(recordCriteria);
	  logger.info("검색목록리스트" + list);
	}
	
	@Disabled
	@Test
	void searchTotalRec_test() throws Exception {
		FindCriteria findCriteria = new FindCriteria();
		findCriteria.setSearchType("TC");
		findCriteria.setKeyword("TEST");
    logger.info("검색 건수" + bbsdao.searchTotalRec(findCriteria));
 	}*/
	
	@Test @Disabled
	void view_test() throws Exception {
		logger.info(bbsdao.view(1822).toString());
	}
	
	@Test @Disabled
	void list_test() throws Exception {
		RecordCriteria rc = new RecordCriteria(1, 10);
		List<BbsDTO> list = bbsdao.list(rc);
		logger.info(list.toString());
	}
	@Test @Disabled
	void posttest() throws Exception{
	BbsDTO bbsdto = new BbsDTO();
	bbsdto.setBtitle("제목");
	bbsdto.setBname("작성자");
	bbsdto.setBcontent("내용");
	bbsdao.write(bbsdto);
	}
	
	@Test
	void listfind_test() throws Exception{
		RecordCriteria rc = new FindCriteria(1, 10, "Title", "제목");
		
		List<BbsDTO> list = bbsdao.list((FindCriteria)rc);
		logger.info(list.toString());
	}
}