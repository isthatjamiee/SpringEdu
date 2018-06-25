package com.kh.myapp.test.bbs;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jca.cci.core.RecordCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dao.RbbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.dto.RbbsDTO;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
class RbbsTest {

	private static final Logger logger = LoggerFactory.getLogger(RbbsTest.class);
	
	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rbbsdao;
	
	//원글 테스트
	@Test @Disabled
	void write_test() throws Exception {
		RbbsDTO rbbsdto = new RbbsDTO();
		rbbsdto.setBnum(1801);
		rbbsdto.setRid("2000");
		rbbsdto.setRname("삐약삐약");
		rbbsdto.setRcontent("삐약삐약삐약");
		rbbsdao.write(rbbsdto);
		
/*		try {
			rbbsdao.reply(rbbsdto);
			} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	@Test @Disabled
	void list_page() throws Exception {
		System.out.println(rbbsdao.replyTotalRec(1801));
	}
	
	@Test @Disabled
	void goodtest() throws Exception{
		rbbsdao.goodOrBad(1681, "good");
	}
	
/*	@Test @Disabled
	void oriInform_test() throws Exception {
		RbbsDTO dto = rbbsdao.oriInform(1804);
		System.out.println(dto.toString());
	}
	
	@Test @Disabled
	void replytest()throws Exception {
		RbbsDTO rbbsdto = new RbbsDTO();
		rbbsdto.setRnum(1804);
		rbbsdto.setRid("오리");
		rbbsdto.setRname("음..");
		rbbsdto.setRcontent("??");
    rbbsdao.reReply(rbbsdto);
    
	}*/
	
	@Test
	void page() throws Exception {
		RecordCriteria rc = new RecordCriteria(1, 10);
		PageCriteria pc = new PageCriteria(rc, rbbsdao.replyTotalRec(1801), 5);
		List<RbbsDTO> list = rbbsdao.list(1801, rc);
		System.out.println(list.toString());
		System.out.println(pc.toString());
	}
}
